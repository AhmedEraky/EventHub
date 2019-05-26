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
 * Test Class for {@link org.eventhub.dal.dao.SessionInstructorRepository}
 * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SessionInstructorRepositoryTest implements BaseRepositoryTest {
    @Autowired
    SessionInstructorRepository sessionInstructorRepository;
    @Autowired
    InstructorRepository instructorRepository;
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
    @Autowired
    MaterialRepository materialRepository;

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.SessionInstructorRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Override
    @Test
    public void testCount() {
        long bCount=sessionInstructorRepository.count();
        SessionInstructor sessionInstructor=createSessionInstructor();
        sessionInstructorRepository.save(sessionInstructor);
        long aCount=sessionInstructorRepository.count();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test Soft Delete Using Method delete
     * {@link org.eventhub.dal.dao.SessionInstructorRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Override
    @Test
    public void testDelete() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionInstructor sessionInstructor=createSessionInstructor();
        sessionInstructorRepository.save(sessionInstructor);
        long bCount=sessionInstructorRepository.findAllDeleted(pageable).size();
        sessionInstructorRepository.delete(sessionInstructor);
        long aCount=sessionInstructorRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test Soft Delete Using Method deleteByID
     * {@link org.eventhub.dal.dao.SessionInstructorRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Override
    @Test
    public void testDeleteByID() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionInstructor sessionInstructor=createSessionInstructor();
        sessionInstructorRepository.save(sessionInstructor);
        long bCount=sessionInstructorRepository.findAllDeleted(pageable).size();
        sessionInstructorRepository.deleteById(sessionInstructor.getUuid());
        long aCount=sessionInstructorRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test Soft Delete Method
     * {@link org.eventhub.dal.dao.SessionInstructorRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Test
    @Override
    public void testSoftDelete() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionInstructor sessionInstructor=createSessionInstructor();
        sessionInstructorRepository.save(sessionInstructor);
        long bCount=sessionInstructorRepository.findAllDeleted(pageable).size();
        sessionInstructorRepository.softDelete(sessionInstructor.getUuid());
        long aCount=sessionInstructorRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }


    /**
     * test save Method
     * {@link org.eventhub.dal.dao.SessionInstructorRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Test
    @Override
    public void testSave() {
        long bCount=sessionInstructorRepository.count();
        SessionInstructor sessionInstructor=createSessionInstructor();
        sessionInstructorRepository.save(sessionInstructor);
        long aCount=sessionInstructorRepository.count();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test findAll Deleted Method
     * {@link org.eventhub.dal.dao.SessionInstructorRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionInstructor sessionInstructor=createSessionInstructor();
        sessionInstructorRepository.save(sessionInstructor);
        long bCount=sessionInstructorRepository.findAllDeleted(pageable).size();
        sessionInstructorRepository.delete(sessionInstructor);
        long aCount=sessionInstructorRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.SessionInstructorRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Test
    @Override
    public void testFindAll() {
        SessionInstructor sessionInstructor=createSessionInstructor();
        long bCount=sessionInstructorRepository.findAll().size();
        sessionInstructorRepository.save(sessionInstructor);
        long aCount=sessionInstructorRepository.findAll().size();
        assertEquals(bCount+1,aCount);
    }

    @Test
    @Override
    public void testUpdate() {
    }

    Material createMaterial(){
        Material material=new Material(null,"test Path") ;
        materialRepository.save(material);
        return material;
    }

    Instructor createInstructor(){
        Instructor instructor=new Instructor(null);
        instructor.setSystemUser(createSystemUser());
        instructorRepository.save(instructor);
        return instructor;
    }
    SessionInstructor createSessionInstructor(){
        SessionInstructor sessionInstructor=new SessionInstructor(null);
        sessionInstructor.setInstructor(createInstructor());
        sessionInstructor.setSession(createSession());
        return sessionInstructor;
    }
    SystemUser createSystemUser(){
        SystemUser systemUser = new SystemUser(null, "username", "firstName", "password", "email",UserGender.Female);
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
        sessionRepository.save(session);
        return session;
    }
}
