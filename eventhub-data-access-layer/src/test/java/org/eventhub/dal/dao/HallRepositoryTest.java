/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.EventCoordinator;
import org.eventhub.common.model.entity.Hall;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.Session;
import org.eventhub.common.model.entity.SessionInHall;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.config.Config;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test Class for {@link org.eventhub.dal.dao.EventCoordinatorRepository}
 *
 * @author Aya Taha
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class HallRepositoryTest {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    HallRepository hallRepository;
    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    SessionInHallRepository sessionInHallRepository;

    /**
     * test count Method {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testCount() {
        long bCount = hallRepository.count();
        Hall hall = insertHall();
        hallRepository.save(hall);
        long aCount = hallRepository.count();
        assertEquals(bCount + 1, aCount);
    }

    /**
     * test Soft Delete Using Method delete
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testDelete() {
        Hall hall = insertHall();
        hallRepository.save(hall);
        Hall hall1 = hallRepository.getOne(hall.getUuid());
        assertEquals(hall.getEvent().getName(), hall1.getEvent().getName());
        Long count = hallRepository.count();
        hallRepository.delete(hall);
        assertNull(hallRepository.getOne(hall.getUuid()));
        assertEquals(count, (Long) hallRepository.count());
    }

    
    /**
     * test Soft Delete Using Method deleteByID
     * {@link org.eventhub.dal.dao.HallRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testDeleteByID() {

         Hall hall = insertHall();
        hallRepository.save(hall);
        Hall hall1 = hallRepository.getOne(hall.getUuid());
        assertEquals(hall.getEvent().getName(), hall1.getEvent().getName());
        assertEquals(hall.getEvent().getName(), hall1.getEvent().getName());
        UUID id = hall.getUuid();
        Long count = hallRepository.count();
        hallRepository.deleteById(id);
        assertNull(hallRepository.getOne(id));
        assertEquals(count, (Long) hallRepository.count());

    }
    
    private Hall insertHall() {
        SystemUser systemUser = new SystemUser(null, "username", "firstName", "password", "email");
        systemUserRepository.save(systemUser);
        Organization organization = new Organization(null, "org");
        organizationRepository.save(organization);
        Event event = new Event(null, "name", "shortDescription", "address", new Date(), new Date(), "style");
        event.setOrganization(organization);
        event.setSystemUser(systemUser);
        eventRepository.save(event);
        Hall hall = new Hall(null, "mainHall");
        hall.setEvent(event);
        return hall;
    }
}
