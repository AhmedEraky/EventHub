/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.EventGuest;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.config.Config;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test Class for {@link org.eventhub.dal.dao.EventGuestRepositor}
 *
 * @author Aya Taha
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class EventGuestRepositoryTest implements BaseRepositoryTest {

    @Autowired
    EventGuestRepository eventGuestRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    OrganizationRepository organizationRepository;

    /**
     * test count Method {@link org.eventhub.dal.dao.EventGuestRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testCount() {
        long bCount = eventGuestRepository.count();
        EventGuest eventGuest = insertEventGuest();
        eventGuestRepository.save(eventGuest);
        long aCount = eventGuestRepository.count();
        assertEquals(bCount + 1, aCount);
    }

    /**
     * test Soft Delete Using Method delete
     * {@link org.eventhub.dal.dao.EventGuestRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testDelete() {
        EventGuest eventGuest = insertEventGuest();
        eventGuestRepository.save(eventGuest);
        EventGuest eventGuest1 = eventGuestRepository.getOne(eventGuest.getUuid());
        assertEquals(eventGuest.getEvent().getName(), eventGuest1.getEvent().getName());
        Long count = eventGuestRepository.count();
        eventGuestRepository.delete(eventGuest);
        assertNull(eventGuestRepository.getOne(eventGuest.getUuid()));
        assertEquals(count, (Long) eventGuestRepository.count());
    }

    /**
     * test Soft Delete Using Method deleteByID
     * {@link org.eventhub.dal.dao.EventGuestRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testDeleteByID() {

        EventGuest eventGuest = insertEventGuest();
        eventGuestRepository.save(eventGuest);
        EventGuest eventGuest1 = eventGuestRepository.getOne(eventGuest.getUuid());
        assertEquals(eventGuest.getEvent().getName(), eventGuest1.getEvent().getName());
        UUID id = eventGuest.getUuid();
        Long count = eventGuestRepository.count();
        eventGuestRepository.deleteById(id);
        assertNull(eventGuestRepository.getOne(id));
        assertEquals(count, (Long) eventGuestRepository.count());

    }

    /**
     * test save Method {@link org.eventhub.dal.dao.EventGuestRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testSave() {
        EventGuest eventGuest = insertEventGuest();
        eventGuestRepository.save(eventGuest);
        EventGuest eventGuest1 = eventGuestRepository.findById(eventGuest.getUuid()).get();
        assertEquals(eventGuest1.getEvent().getName(), eventGuest.getEvent().getName());

    }

    /**
     * test Method update {@link org.eventhub.dal.dao.EventGuestRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testUpdate() {

        EventGuest eventGuest = insertEventGuest();
        eventGuestRepository.save(eventGuest);
         EventGuest eventGuest1=updateEventGuest(eventGuest);
        eventGuestRepository.update(eventGuest1);
        EventGuest eventGuest2 = eventGuestRepository.getOne(eventGuest.getUuid());
        System.out.println(eventGuest2.getEvent().getName());
        assertEquals(eventGuest1.getEvent().getName(), eventGuest2.getEvent().getName());

    }

    /**
     * test findAll Deleted Method
     * {@link org.eventhub.dal.dao.EventGuestRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        Pageable pageable = PageRequest.of(0, 555555);
        int bCount = eventGuestRepository.findAllDeleted(pageable).size();
        EventGuest eventGuest = insertEventGuest();
        eventGuestRepository.save(eventGuest);
        eventGuestRepository.delete(eventGuest);
        assertEquals(bCount + 1, eventGuestRepository.findAllDeleted(pageable).size());
    }

    /**
     * test findAll Method {@link org.eventhub.dal.dao.EventGuestRepository}
     *
     * @author Aya Taha
     */
    @Override
    @Test
    public void testFindAll() {

        int bCount = eventGuestRepository.findAll().size();
        EventGuest eventGuest = insertEventGuest();
        eventGuestRepository.save(eventGuest);
        int aCount = eventGuestRepository.findAll().size();
        assertEquals(bCount + 1, aCount);
    }

    /**
     * test SoftDelete Method {@link org.eventhub.dal.dao.EventGuestRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testSoftDelete() {
        EventGuest eventGuest = insertEventGuest();
        eventGuestRepository.save(eventGuest);
        EventGuest eventGuest1 = eventGuestRepository.getOne(eventGuest.getUuid());
        assertEquals(eventGuest.getEvent().getName(), eventGuest1.getEvent().getName());
        UUID id = eventGuest.getUuid();
        System.out.println(eventGuestRepository.count());
        eventGuestRepository.softDelete(id);
        System.out.println(eventGuestRepository.count());
        assertNull(eventGuestRepository.getOne(id));
    }

    @Test
    public void testFindByName() {
    }

    /**
     * test findAllBySystemUser Method
     * {@link org.eventhub.dal.dao.EventGuestRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllBySystemUser() {
        Pageable pageable = PageRequest.of(0, 555555);
        EventGuest eventGuest = insertEventGuest();
        eventGuestRepository.save(eventGuest);
        List<SystemUser> systemUsers = systemUserRepository.findAllByFirstName("firstName", pageable);
        List<EventGuest> eventGuests = eventGuestRepository.findAllBySystemUser(systemUsers.get(0), pageable);
        assertEquals(eventGuests.get(0).getSystemUser().getFirstName(), eventGuest.getSystemUser().getFirstName());

    }

    /**
     * test findAllByEvent Method
     * {@link org.eventhub.dal.dao.EventGuestRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByEvent() {
        Pageable pageable = PageRequest.of(0, 555555);
        EventGuest eventGuest = insertEventGuest();
        eventGuestRepository.save(eventGuest);
        List<Event> events = eventRepository.findAllByName("name", pageable);
        List<EventGuest> eventGuests = eventGuestRepository.findAllByEvent(events.get(0), pageable);
        assertEquals(eventGuests.get(0).getSystemUser().getFirstName(), eventGuest.getSystemUser().getFirstName());

    }

    private EventGuest insertEventGuest() {
        SystemUser systemUser = new SystemUser(null, "username", "firstName", "password", "email");
        systemUserRepository.save(systemUser);
        Organization organization = new Organization(null, "org");
        organizationRepository.save(organization);
        Event event = new Event(null, "name", "shortDescription", "address", new Date(), new Date(), "style");
        event.setOrganization(organization);
        event.setSystemUser(systemUser);
        eventRepository.save(event);
        EventGuest eventGuest = new EventGuest(null);
        eventGuest.setEvent(event);
        eventGuest.setSystemUser(systemUser);
        return eventGuest;
    }

    private EventGuest updateEventGuest(EventGuest eventGuest) {
        Pageable pageable = PageRequest.of(0, 555555);
        EventGuest eventGuest1 = eventGuestRepository.findById(eventGuest.getUuid()).get();
        List<SystemUser> systemUsers = systemUserRepository.findAllByFirstName("firstName", pageable);
        Organization organization = new Organization(null, "orgn");
        organizationRepository.save(organization);
        Event eventn = new Event(null, "name2", "shortDescription", "address", new Date(), new Date(), "style");
        eventn.setOrganization(organization);
        eventn.setSystemUser(systemUsers.get(0));
        eventRepository.save(eventn);
        List<Event> events = eventRepository.findAllByName("name2", pageable);
        eventGuest1.setEvent(events.get(0));
        return eventGuest1;
    }
}
