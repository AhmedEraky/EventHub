/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import java.util.Date;
import java.util.List;
import org.eventhub.dal.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.EventCoordinator;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.SystemUser;

import static org.junit.Assert.*;

/**
 * Test Class for {@link org.eventhub.dal.dao.EventCoordinatorRepository}
 *
 * @author Aya Taha
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class EventCoordinatorRepositoryTest {

    @Autowired
    EventCoordinatorRepository eventCoordinatorRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    OrganizationRepository organizationRepository;

    /**
     * test count Method {@link org.eventhub.dal.dao.EventCoordinatorRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testCount() {
        long bCount = eventCoordinatorRepository.count();
        EventCoordinator eventCoordinator = insertEventCooridnator();
        eventCoordinatorRepository.save(eventCoordinator);
        long aCount = eventCoordinatorRepository.count();
        assertEquals(bCount + 1, aCount);
    }

    /**
     * test Soft Delete Using Method delete
     * {@link org.eventhub.dal.dao.EventCoordinatorRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testDelete() {
        EventCoordinator eventCoordinator = insertEventCooridnator();
        eventCoordinatorRepository.save(eventCoordinator);
        EventCoordinator eventCoordinator1 = eventCoordinatorRepository.getOne(eventCoordinator.getUuid());
        assertEquals(eventCoordinator.getEvent().getName(), eventCoordinator1.getEvent().getName());
        Long count = eventCoordinatorRepository.count();
        eventCoordinatorRepository.delete(eventCoordinator);
        assertNull(eventCoordinatorRepository.getOne(eventCoordinator.getUuid()));
        assertEquals(count, (Long) eventCoordinatorRepository.count());
    }

    /**
     * test Soft Delete Using Method deleteByID
     * {@link org.eventhub.dal.dao.EventCoordinatorRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testDeleteByID() {

        EventCoordinator eventCoordinator = insertEventCooridnator();
        eventCoordinatorRepository.save(eventCoordinator);
        EventCoordinator eventCoordinator1 = eventCoordinatorRepository.getOne(eventCoordinator.getUuid());
        assertEquals(eventCoordinator.getEvent().getName(), eventCoordinator1.getEvent().getName());
        UUID id = eventCoordinator.getUuid();
        Long count = eventCoordinatorRepository.count();
        eventCoordinatorRepository.deleteById(id);
        assertNull(eventCoordinatorRepository.getOne(id));
        assertEquals(count, (Long) eventCoordinatorRepository.count());

    }

    /**
     * test save Method {@link org.eventhub.dal.dao.EventCoordinatorRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testSave() {
        EventCoordinator eventCoordinator = insertEventCooridnator();
        eventCoordinatorRepository.save(eventCoordinator);

        EventCoordinator eventCoordinator1 = eventCoordinatorRepository.findById(eventCoordinator.getUuid()).get();
        assertEquals(eventCoordinator1.getEvent().getName(), eventCoordinator.getEvent().getName());
    }

    /**
     * test Soft Delete Using Method update
     * {@link org.eventhub.dal.dao.EventCoordinatorRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testUpdate() {
        Pageable pageable = PageRequest.of(0, 555555);
        EventCoordinator eventCoordinator = insertEventCooridnator();
        eventCoordinatorRepository.save(eventCoordinator);
        EventCoordinator eventCoordinator1 = eventCoordinatorRepository.getOne(eventCoordinator.getUuid());
        //add new event
        List<SystemUser> systemUsers = systemUserRepository.findAllByFirstName("firstName", pageable);
        Organization organization = new Organization(null, "orgn");
        organizationRepository.save(organization);
        Event eventn = new Event(null, "name2", "shortDescription", "address", new Date(), new Date(), "style");
        eventn.setOrganization(organization);
        eventn.setSystemUser(systemUsers.get(0));
        eventRepository.save(eventn);
        //update
        List<Event> events = eventRepository.findAllByName("name2", pageable);
        eventCoordinator1.setEvent(events.get(0));
        eventCoordinatorRepository.save(eventCoordinator1);
        EventCoordinator eventCoordinator2 = eventCoordinatorRepository.getOne(eventCoordinator.getUuid());
        System.out.println(eventCoordinator2.getEvent().getName());
        assertEquals(eventCoordinator1.getEvent().getName(), eventCoordinator2.getEvent().getName());

    }

    /**
     * test findAllBySystemUser Method
     * {@link org.eventhub.dal.dao.EventCoordinatorRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllBySystemUser() {
        Pageable pageable = PageRequest.of(0, 555555);
        EventCoordinator eventCoordinator = insertEventCooridnator();
        eventCoordinatorRepository.save(eventCoordinator);
        List<SystemUser> systemUsers = systemUserRepository.findAllByFirstName("firstName", pageable);
        List<EventCoordinator> eventCoordinators = eventCoordinatorRepository.findAllBySystemUser(systemUsers.get(0), pageable);
        assertEquals(eventCoordinators.get(0).getSystemUser().getFirstName(), eventCoordinator.getSystemUser().getFirstName());

    }

    /**
     * test findAllByEvent Method
     * {@link org.eventhub.dal.dao.EventCoordinatorRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByEvent() {
        Pageable pageable = PageRequest.of(0, 555555);
        EventCoordinator eventCoordinator = insertEventCooridnator();
        eventCoordinatorRepository.save(eventCoordinator);
        List<Event> events = eventRepository.findAllByName("name", pageable);
        List<EventCoordinator> eventCoordinators = eventCoordinatorRepository.findAllByEvent(events.get(0), pageable);
        assertEquals(eventCoordinators.get(0).getSystemUser().getFirstName(), eventCoordinator.getSystemUser().getFirstName());

    }

    private EventCoordinator insertEventCooridnator() {
        SystemUser systemUser = new SystemUser(null, "username", "firstName", "password", "email");

        systemUserRepository.save(systemUser);
        Organization organization = new Organization(null, "org");
        organizationRepository.save(organization);
        Event event = new Event(null, "name", "shortDescription", "address", new Date(), new Date(), "style");
        event.setOrganization(organization);
        event.setSystemUser(systemUser);
        eventRepository.save(event);
        EventCoordinator eventCoordinator = new EventCoordinator(null);
        eventCoordinator.setEvent(event);
        eventCoordinator.setSystemUser(systemUser);

        return eventCoordinator;
    }

}
