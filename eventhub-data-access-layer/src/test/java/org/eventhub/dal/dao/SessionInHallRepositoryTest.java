package org.eventhub.dal.dao;


import org.eventhub.common.model.entity.*;
import org.eventhub.dal.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Test Class for {@link org.eventhub.dal.dao.SessionInHallRepository}
 * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SessionInHallRepositoryTest implements BaseRepositoryTest  {
    @Autowired
    SessionInHallRepository sessionInHallRepository;
    @Autowired
    HallRepository hallRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    SessionTypeRepository sessionTypeRepository;


    /**
     * test count Method
     * {@link org.eventhub.dal.dao.SessionInHallRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Override
    @Test
    public void testCount() {
        long bCount=sessionInHallRepository.count();
        SessionInHall sessionInstructor=createSessionInHall();
        sessionInHallRepository.save(sessionInstructor);
        long aCount=sessionInHallRepository.count();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test Soft Delete Using Method delete
     * {@link org.eventhub.dal.dao.SessionInHallRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Override
    @Test
    public void testDelete() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionInHall sessionInHall=createSessionInHall();
        sessionInHallRepository.save(sessionInHall);
        long bCount=sessionInHallRepository.findAllDeleted(pageable).size();
        sessionInHallRepository.delete(sessionInHall);
        long aCount=sessionInHallRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test Soft Delete Using Method deleteByID
     * {@link org.eventhub.dal.dao.SessionInHallRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Override
    @Test
    public void testDeleteByID() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionInHall sessionInHall=createSessionInHall();
        sessionInHallRepository.save(sessionInHall);
        long bCount=sessionInHallRepository.findAllDeleted(pageable).size();
        sessionInHallRepository.deleteById(sessionInHall.getUuid());
        long aCount=sessionInHallRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test Soft Delete Method
     * {@link org.eventhub.dal.dao.SessionInHallRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Test
    @Override
    public void testSoftDelete() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionInHall sessionInHall=createSessionInHall();
        sessionInHallRepository.save(sessionInHall);
        long bCount=sessionInHallRepository.findAllDeleted(pageable).size();
        sessionInHallRepository.softDelete(sessionInHall.getUuid());
        long aCount=sessionInHallRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);

    }


    /**
     * test save Method
     * {@link org.eventhub.dal.dao.SessionInHallRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Test
    @Override
    public void testSave() {
        long bCount=sessionInHallRepository.count();
        SessionInHall sessionInHall=createSessionInHall();
        sessionInHallRepository.save(sessionInHall);
        long aCount=sessionInHallRepository.count();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test findAll Deleted Method
     * {@link org.eventhub.dal.dao.SessionInHallRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionInHall sessionInHall=createSessionInHall();
        sessionInHallRepository.save(sessionInHall);
        long bCount=sessionInHallRepository.findAllDeleted(pageable).size();
        sessionInHallRepository.delete(sessionInHall);
        long aCount=sessionInHallRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.SessionInHallRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Test
    @Override
    public void testFindAll() {

        Pageable pageable = PageRequest.of(0, 555555);
        long bCount=sessionInHallRepository.findAll(pageable).get().count();
        SessionInHall sessionInHall=createSessionInHall();
        sessionInHallRepository.save(sessionInHall);
        long aCount=sessionInHallRepository.findAll(pageable).get().count();
        assertEquals(bCount+1,aCount);
    }

    @Test
    @Override
    public void testUpdate() {

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
    Hall crateHall(){
        Hall hall = new Hall(null, "mainHall");
        hall.setEvent(createEvent());
        hallRepository.save(hall);
        return hall;
    }
    Session createSession(){
        Session session=new Session(null,new Date(),new Date(),"test Session","test Description",3);
        session.setEvent(createEvent());
        session.setSessionType(createSessionType());
        sessionRepository.save(session);
        return session;
    }
    SessionType createSessionType(){
        SessionType sessionType=new SessionType(null,"test Type","test Style");
        sessionTypeRepository.save(sessionType);
        return sessionType;

    }
    SessionInHall createSessionInHall(){
        SessionInHall sessionInHall=new SessionInHall(null,3);
        sessionInHall.setHall(crateHall());
        sessionInHall.setSession(createSession());
        return sessionInHall;
    }
}
