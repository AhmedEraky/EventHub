package org.eventhub.dal.dao;


import org.eventhub.common.model.entity.*;
import org.eventhub.dal.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Test Class for {@link org.eventhub.dal.dao.SessionRepository}
 * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
@Component
public class SessionRepositoryTest implements BaseRepositoryTest{
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    SessionTypeRepository sessionTypeRepository;

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.SessionRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Override
    @Test
    public void testCount() {
        long bCount=sessionRepository.count();
        Session session=createSession();
        sessionRepository.save(session);
        long aCount=sessionRepository.count();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test Soft Delete Using Method delete
     * {@link org.eventhub.dal.dao.SessionRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Override
    @Test
    public void testDelete() {
        Pageable pageable = PageRequest.of(0, 555555);
        Session session=createSession();
        sessionRepository.save(session);
        long bCount=sessionRepository.findAllDeleted(pageable).size();
        sessionRepository.delete(session);
        long aCount=sessionRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test Soft Delete Using Method deleteByID
     * {@link org.eventhub.dal.dao.SessionRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Override
    @Test
    public void testDeleteByID() {
        Pageable pageable = PageRequest.of(0, 555555);
        Session session=createSession();
        sessionRepository.save(session);
        long bCount=sessionRepository.findAllDeleted(pageable).size();
        sessionRepository.deleteById(session.getUuid());
        long aCount=sessionRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test Soft Delete Method
     * {@link org.eventhub.dal.dao.SessionRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Test
    @Override
    public void testSoftDelete() {
        Pageable pageable = PageRequest.of(0, 555555);
        Session session=createSession();
        sessionRepository.save(session);
        long bCount=sessionRepository.findAllDeleted(pageable).size();
        sessionRepository.softDelete(session.getUuid());
        long aCount=sessionRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }

    /**
     * test save Method
     * {@link org.eventhub.dal.dao.SessionRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */

    @Test
    @Override
    public void testSave() {
        long bCount=sessionRepository.count();
        Session session=createSession();
        sessionRepository.save(session);
        long aCount=sessionRepository.count();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test findAll Deleted Method
     * {@link org.eventhub.dal.dao.SessionRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        Pageable pageable = PageRequest.of(0, 555555);
        Session session=createSession();
        sessionRepository.save(session);
        long bCount=sessionRepository.findAllDeleted(pageable).size();
        sessionRepository.delete(session);
        long aCount=sessionRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.SessionRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */

    @Test
    @Override
    public void testFindAll() {
        Pageable pageable = PageRequest.of(0, 555555);
        Session session=createSession();
        long bCount=sessionRepository.findAll().size();
        sessionRepository.save(session);
        long aCount=sessionRepository.findAll().size();
        assertEquals(bCount+1,aCount);
    }

    @Test
    @Override
    public void testUpdate() {
        Session bSession =createSession();
        sessionRepository.save(bSession);
        Session aSession=sessionRepository.getOne(bSession.getUuid());
        aSession.setName("Test two");
        sessionRepository.update(aSession);
        bSession=sessionRepository.getOne(bSession.getUuid());
        assertEquals(bSession.getName(),aSession.getName());
    }

    SystemUser createSystemUser(){
        SystemUser systemUser = new SystemUser(null, "username", "firstName", "password", "email");
        systemUserRepository.save(systemUser);
        return systemUser;
    }
    Organization crateOrganization(){
        Organization organization = new Organization(null, "org");
        organizationRepository.save(organization);
        return organization;
    }
    Event createEvent(){
        Event event = new Event(null, "name", "shortDescription", "address", new Date(), new Date(), "style");
        event.setSystemUser(createSystemUser());
        event.setOrganization(crateOrganization());
        eventRepository.save(event);
        return event;
    }
    SessionType createSessionType(){
        SessionType sessionType=new SessionType(null,"test Type","test Style");
        sessionTypeRepository.save(sessionType);
        return sessionType;

    }
    Session createSession(){
        Session session=new Session(null,new Date(),new Date(),"test Session","test Description",3);
        session.setEvent(createEvent());
        session.setSessionType(createSessionType());
        return session;
    }
}
