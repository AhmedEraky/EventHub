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
import org.eventhub.common.model.entity.Hall;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.Session;
import org.eventhub.common.model.entity.SessionType;
import org.eventhub.common.model.entity.Sponsor;
import org.eventhub.common.model.entity.SponsorshipType;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.config.AppConfig;
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
 * Test Class for {@link org.eventhub.dal.dao.EventRepository}
 *
 * @author Aya Taha
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class EventRepositoryTest implements BaseRepositoryTest {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    SponsorRepository sponsorRepository;
    @Autowired
    SponsorshipTypeRepository sponsorshipTypeRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    SessionTypeRepository sessionTypeRepository;
    @Autowired
    HallRepository hallRepository;
    @Autowired
    EventGuestRepository eventGuestRepository;

    /**
     * test count Method {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testCount() {
        long bCount = eventRepository.count();
        Event event = insertEvent();
        eventRepository.save(event);
        long aCount = eventRepository.count();
        assertEquals(bCount + 1, aCount);
    }

    /**
     * test Method delete {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testDelete() {
        Event event = insertEvent();
        eventRepository.save(event);
        Event event1 = eventRepository.getOne(event.getUuid());
        assertEquals(event.getName(), event1.getName());
        Long count = eventRepository.count();
        eventRepository.delete(event);
        assertNull(eventRepository.getOne(event.getUuid()));
        assertEquals(count, (Long) eventRepository.count());
    }

    /**
     * test Method deleteByID {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testDeleteByID() {

        Event event = insertEvent();
        eventRepository.save(event);
        Event event1 = eventRepository.getOne(event.getUuid());
        assertEquals(event.getName(), event1.getName());
        UUID id = event.getUuid();
        Long count = eventRepository.count();
        eventRepository.deleteById(id);
        assertNull(eventRepository.getOne(id));
        assertEquals(count, (Long) eventRepository.count());
    }

    /**
     * test Method softDelete {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testSoftDelete() {
        Event event = insertEvent();
        eventRepository.save(event);
        Event event1 = eventRepository.getOne(event.getUuid());
        assertEquals(event.getName(), event1.getName());
        UUID id = event.getUuid();
        System.out.println(eventRepository.count());
        eventRepository.softDelete(id);
        System.out.println(eventRepository.count());
        assertNull(eventRepository.getOne(id));
    }

    @Test
    public void testFindByName() {
    }

    /**
     * test save Method {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testSave() {
        Event event = insertEvent();
        eventRepository.save(event);
        Event event1 = eventRepository.getOne(event.getUuid());
        assertEquals(event.getName(), event1.getName());
    }

    /**
     * test findAll Deleted Method {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        Pageable pageable = PageRequest.of(0, 555555);
        int bCount = eventRepository.findAllDeleted(pageable).size();
        Event event = insertEvent();
        eventRepository.save(event);
        eventRepository.delete(event);
        assertEquals(bCount + 1, eventRepository.findAllDeleted(pageable).size());
    }

    /**
     * test findAll Method {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testFindAll() {

        int bCount = eventRepository.findAll().size();
        Event event = insertEvent();
        eventRepository.save(event);
        int aCount = eventRepository.findAll().size();
        assertEquals(bCount + 1, aCount);
    }

    /**
     * test Method update {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    @Override
    public void testUpdate() {
        Pageable pageable = PageRequest.of(0, 555555);
        Event event = insertEvent();
        eventRepository.save(event);
        Event event1 = eventRepository.getOne(event.getUuid());
        Organization organization = new Organization(null, "org2");
        organizationRepository.save(organization);
        List<Event> events = eventRepository.findAllByName("name", pageable);
        events.get(0).setOrganization(organization);
        eventRepository.update(events.get(0));
        System.out.println(events.get(0).getOrganization().getName());
        assertEquals(event1.getOrganization().getName(), events.get(0).getOrganization().getName());
    }

    /**
     * test Method findAllByName {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByName() {
        Pageable pageable = PageRequest.of(0, 555555);
        Event event = insertEvent();
        eventRepository.save(event);
        List<Event> events = eventRepository.findAllByName("name", pageable);
        assertEquals(event.getName(), events.get(0).getName());
    }

    /**
     * test Method findAllByAddress {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByAddress() {
        Pageable pageable = PageRequest.of(0, 555555);
        Event event = insertEvent();
        eventRepository.save(event);
        List<Event> events = eventRepository.findAllByAddress("address", pageable);
        assertEquals(event.getAddress(), events.get(0).getAddress());
    }

    /**
     * test Method findAllBySlogan {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindBySlogan() {

        Event event = insertEvent();
        event.setSlogan("slogan");
        eventRepository.save(event);
        Event event1 = eventRepository.findBySlogan("slogan");
        assertEquals(event.getSlogan(), event1.getSlogan());
    }

    /**
     * test Method findByAbbreviation
     * {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindByAbbreviation() {

        Event event = insertEvent();
        event.setAbbreviation("abbrev");
        eventRepository.save(event);
        Event event1 = eventRepository.findByAbbreviation("abbrev");
        assertEquals(event.getAbbreviation(), event1.getAbbreviation());
    }

    /**
     * test Method findAllByStartDate
     * {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByStartDate() {
        Pageable pageable = PageRequest.of(0, 555555);
        Event event = insertEvent();
        Date start = event.getStartDate();
        eventRepository.save(event);
        List<Event> events = eventRepository.findAllByStartDate(start, pageable);
        assertEquals(event.getStartDate(), events.get(0).getStartDate());
    }

    /**
     * test Method findAllByEndDate {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByEndDate() {
        Pageable pageable = PageRequest.of(0, 555555);
        Event event = insertEvent();
        Date end = event.getEndDate();
        eventRepository.save(event);
        List<Event> events = eventRepository.findAllByEndDate(end, pageable);
        assertEquals(event.getEndDate(), events.get(0).getEndDate());
    }

    /**
     * test Method findAllByPublished
     * {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByPublished() {
        Pageable pageable = PageRequest.of(0, 555555);
        Event event = insertEvent();
        Short s = new Short("1");
        event.setPublished(s);
        eventRepository.save(event);
        List<Event> events = eventRepository.findAllByPublished(s, pageable);
        assertEquals(event.getPublished(), events.get(0).getPublished());
    }

    /**
     * test Method findBySponors {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindBySponor() {

        Event event = insertEvent();
        SponsorshipType sponsorshipType = new SponsorshipType(null, "gold");
        sponsorshipTypeRepository.save(sponsorshipType);
        Sponsor sponsor = new Sponsor(null, "sponsor");
        eventRepository.save(event);
        sponsor.setEvent(event);
        sponsor.setSponsorshipType(sponsorshipType);
        sponsorRepository.save(sponsor);
        Set<Sponsor> sponsors = new HashSet<>();
        sponsors.add(sponsor);
        event.setSponsors(sponsors);
        Event event1 = eventRepository.findBySponor(sponsor);
        assertEquals(event, sponsor.getEvent());
    }

    /**
     * test Method findBySessions {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindBySession() {
        Event event = insertEvent();
        Session session = new Session(null, new Date(), new Date(), "name", "desc", 5);
        SessionType sessionType = new SessionType(null, "type", "style");
        sessionTypeRepository.save(sessionType);
        session.setSessionType(sessionType);
        eventRepository.save(event);
        session.setEvent(event);
        sessionRepository.save(session);
        Set<Session> sessions = new HashSet<>();
        sessions.add(session);
        event.setSessions(sessions);

        Event event1 = eventRepository.findBySession(session);
        assertEquals(event, session.getEvent());
    }

    /**
     * test Method findByHall {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindByHall() {
        Event event = insertEvent();
        Hall hall = new Hall(null, "hall");
        eventRepository.save(event);
        hall.setEvent(event);
        hallRepository.save(hall);
        Set<Hall> halls = new HashSet<>();
        halls.add(hall);
        event.setHalls(halls);

        Event event1 = eventRepository.findByHall(hall);
        assertEquals(event, hall.getEvent());
    }

    /**
     * test Method findAllByOrganization
     * {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllByOrganization() {
        Pageable pageable = PageRequest.of(0, 555555);
        Event event = insertEvent();
        Organization organization = new Organization(null, "org");
        organizationRepository.save(organization);
        event.setOrganization(organization);
        eventRepository.save(event);
        List<Event> events = eventRepository.findAllByOrganization(organization, pageable);
        assertEquals(event.getOrganization(), events.get(0).getOrganization());
    }

    /**
     * test Method findAllBySystemUser
     * {@link org.eventhub.dal.dao.EventRepository}
     *
     * @author Aya Taha
     */
    @Test
    public void testFindAllBySystemUser() {
        Pageable pageable = PageRequest.of(0, 555555);
        Event event = insertEvent();
        SystemUser systemUser = new SystemUser(null, "username", "firstName", "password", "email");
        systemUserRepository.save(systemUser);
        event.setSystemUser(systemUser);
        eventRepository.save(event);
        List<Event> events = eventRepository.findAllBySystemUser(systemUser, pageable);
        assertEquals(event.getSystemUser(), events.get(0).getSystemUser());
    }

    private Event insertEvent() {
        Event event = new Event(null, "name", "shortDescription", "address", new Date(), new Date(), "style");
        SystemUser systemUser = new SystemUser(null, "username", "firstName", "password", "email");
        systemUserRepository.save(systemUser);
        Organization organization = new Organization(null, "org");
        organizationRepository.save(organization);
        event.setOrganization(organization);
        event.setSystemUser(systemUser);
        return event;
    }
}
