package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.*;
import org.eventhub.dal.config.AppConfig;
import org.junit.Assert;
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

/**
 * Test class for {@link org.eventhub.dal.dao.MaterialRepository}
 * @author Menna Ahmed (menna4a.helmi@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional

public class MaterialRepositoryTest implements BaseRepositoryTest{

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    SessionInstructorRepository sessionInstructorRepository;

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    SessionTypeRepository sessionTypeRepository;

    Pageable pageable = PageRequest.of(0, 555555);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testCount() {

        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);

        Event event = prepareEventToSave(systemUser);
        eventRepository.save(event);

        Session session = prepareSessionToSave(event);
        sessionRepository.save(session);

        SessionInstructor sessionInstructor = prepareSessionInstructorToSave(instructor,session);
        sessionInstructorRepository.save(sessionInstructor);

        Material material = prepareMaterialToSave(sessionInstructor);
        long count = materialRepository.count();
        materialRepository.save(material);
        long countAfter = materialRepository.count();
        Assert.assertEquals(count+1,countAfter);
    }

    /**
     * test delete Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testDelete() {
        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);

        Event event = prepareEventToSave(systemUser);
        eventRepository.save(event);

        Session session = prepareSessionToSave(event);
        sessionRepository.save(session);

        SessionInstructor sessionInstructor = prepareSessionInstructorToSave(instructor,session);
        sessionInstructorRepository.save(sessionInstructor);

        Material material = prepareMaterialToSave(sessionInstructor);
        materialRepository.save(material);

        materialRepository.delete(material);
        Material materialTest = materialRepository.getOne(material.getUuid());
        Assert.assertNull(materialTest);

    }

    /**
     * test delete by Id Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testDeleteByID() {
        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);

        Event event = prepareEventToSave(systemUser);
        eventRepository.save(event);

        Session session = prepareSessionToSave(event);
        sessionRepository.save(session);

        SessionInstructor sessionInstructor = prepareSessionInstructorToSave(instructor,session);
        sessionInstructorRepository.save(sessionInstructor);

        Material material = prepareMaterialToSave(sessionInstructor);
        materialRepository.save(material);

        materialRepository.deleteById(material.getUuid());
        Material materialTest = materialRepository.getOne(material.getUuid());
        Assert.assertNull(materialTest);

    }

    /**
     * test soft delete Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testSoftDelete() {
        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);

        Event event = prepareEventToSave(systemUser);
        eventRepository.save(event);

        Session session = prepareSessionToSave(event);
        sessionRepository.save(session);

        SessionInstructor sessionInstructor = prepareSessionInstructorToSave(instructor,session);
        sessionInstructorRepository.save(sessionInstructor);

        Material material = prepareMaterialToSave(sessionInstructor);
        materialRepository.save(material);

        materialRepository.softDelete(material.getUuid());
        Material materialTest = materialRepository.getOne(material.getUuid());
        Assert.assertNull(materialTest);

    }

    /**
     * test save Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testSave() {
        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);

        Event event = prepareEventToSave(systemUser);
        eventRepository.save(event);

        Session session = prepareSessionToSave(event);
        sessionRepository.save(session);

        SessionInstructor sessionInstructor = prepareSessionInstructorToSave(instructor,session);
        sessionInstructorRepository.save(sessionInstructor);

        Material material = prepareMaterialToSave(sessionInstructor);
        materialRepository.save(material);
        Material materialTest = materialRepository.getOne(material.getUuid());
        Assert.assertNotNull(materialTest);

    }

    /**
     * test find all deleted Material Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testFindAllDeleted() {

        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);

        Event event = prepareEventToSave(systemUser);
        eventRepository.save(event);

        Session session = prepareSessionToSave(event);
        sessionRepository.save(session);

        SessionInstructor sessionInstructor = prepareSessionInstructorToSave(instructor,session);
        sessionInstructorRepository.save(sessionInstructor);

        Material material = prepareMaterialToSave(sessionInstructor);
        materialRepository.save(material);

        int size = materialRepository.findAllDeleted(pageable).size();
        materialRepository.delete(material);
        int sizeAfter = materialRepository.findAllDeleted(pageable).size();
        Assert.assertEquals(size+1,sizeAfter);

    }

    /**
     * test find all Material Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testFindAll() {
        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);

        Event event = prepareEventToSave(systemUser);
        eventRepository.save(event);

        Session session = prepareSessionToSave(event);
        sessionRepository.save(session);

        SessionInstructor sessionInstructor = prepareSessionInstructorToSave(instructor,session);
        sessionInstructorRepository.save(sessionInstructor);

        Material material = prepareMaterialToSave(sessionInstructor);
        int size = materialRepository.findAll().size();
        materialRepository.save(material);
        int sizeAfter = materialRepository.findAll().size();
        Assert.assertEquals(size+1,sizeAfter);

    }


    /**
     * test update Material Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testUpdate() {
        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);

        Event event = prepareEventToSave(systemUser);
        eventRepository.save(event);

        Session session = prepareSessionToSave(event);
        sessionRepository.save(session);

        SessionInstructor sessionInstructor = prepareSessionInstructorToSave(instructor,session);
        sessionInstructorRepository.save(sessionInstructor);

        Material material = prepareMaterialToSave(sessionInstructor);
        materialRepository.save(material);
        material.setPath("D:\\");
        materialRepository.update(material);
        Material materialTest = materialRepository.getOne(material.getUuid());
        Assert.assertEquals(material.getPath(),materialTest.getPath());

    }

    /**
     * test find Material by path Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    public void testFindAllByPath(){
        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);

        Event event = prepareEventToSave(systemUser);
        eventRepository.save(event);

        Session session = prepareSessionToSave(event);
        sessionRepository.save(session);

        SessionInstructor sessionInstructor = prepareSessionInstructorToSave(instructor,session);
        sessionInstructorRepository.save(sessionInstructor);

        Material material = prepareMaterialToSave(sessionInstructor);
        materialRepository.save(material);
        Material materialTest = materialRepository.findByPath("C:\\");
        Assert.assertNotNull(materialTest);
    }

    /**
     * instantiate SystemUser Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    private Event prepareEventToSave(SystemUser systemUser){
        Event event = new Event(null, "name", "shortDescription", "address", new Date(), new Date(), "style");
        Organization organization = new Organization(null, "org");
        organizationRepository.save(organization);
        event.setOrganization(organization);
        event.setSystemUser(systemUser);
        return event;
    }
    /**
     *  instantiate Session Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    private Session prepareSessionToSave(Event event){

        SessionType sessionType = new SessionType(null,"programming","long");

        Session session = new Session(null,new Date(),new Date(),"session","jvhbv",20);
        sessionTypeRepository.save(sessionType);
        session.setEvent(event);
        session.setSessionType(sessionType);
        return session;
    }
    /**
     * instantiate Instructor Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    private Instructor prepareInstructorToSave(SystemUser systemUser){

        Instructor instructor = new Instructor();
        systemUserRepository.save(systemUser);
        instructor.setJobTitle("Developer");
        instructor.setSystemUser(systemUser);
        instructor.setDeleted(false);
        return  instructor;
    }
    /**
     *  instantiate SessionInstructor Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    private SessionInstructor prepareSessionInstructorToSave(Instructor instructor,Session session){

        SessionInstructor sessionInstructor = new SessionInstructor(null);
        sessionInstructor.setInstructor(instructor);
        sessionInstructor.setSession(session);
        return sessionInstructor;
    }
    /**
     *  instantiate Material Method
     * {@link org.eventhub.dal.dao.MaterialRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    private Material prepareMaterialToSave(SessionInstructor sessionInstructor){
        Material material = new Material(null,"C:\\");
        material.setSessionInstructor(sessionInstructor);
        return material;
    }

}
