package org.eventhub.dal.dao;


import org.eventhub.common.model.entity.Instructor;
import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.common.model.entity.SessionInstructor;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.config.Config;
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

import java.util.Optional;

/**
 * Test class for {@link org.eventhub.dal.dao.InstructorRepository}
 * @author Menna Ahmed (menna4a.helmi@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class InstructorRepositoryTest implements BaseRepositoryTest
{

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    InstructorRepository instructorRepository;

    Pageable pageable = PageRequest.of(0, 555555);


    /**
     * test count Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Override
    @Test
    public void testCount() {
        SystemUser systemUser = prepareSystemUserToSave();
        Instructor instructor = prepareInstructorToSave(systemUser);
        systemUserRepository.save(systemUser);
        long count = instructorRepository.count();
        instructorRepository.save(instructor);
        long count2 = instructorRepository.count();
        Assert.assertEquals(count+1,count2);

    }

    /**
     * test delete Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Override
    @Test
    public void testDelete() {
        SystemUser systemUser = prepareSystemUserToSave();
        systemUserRepository.save(systemUser);

        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);
        instructorRepository.delete(instructor);
        Assert.assertNull(instructorRepository.getOne(instructor.getUuid()));

    }

    /**
     * test delete by Id Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testDeleteByID() {
        SystemUser systemUser = prepareSystemUserToSave();
        systemUserRepository.save(systemUser);

        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);
        instructorRepository.deleteById(instructor.getUuid());
        Assert.assertNull(instructorRepository.getOne(instructor.getUuid()));

    }

    /**
     * test soft delete Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testSoftDelete() {
        SystemUser systemUser = prepareSystemUserToSave();
        systemUserRepository.save(systemUser);

        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);
        instructorRepository.softDelete(instructor.getUuid());
        Assert.assertNull(instructorRepository.getOne(instructor.getUuid()));

    }


    /**
     * test find by system user Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    public void testFindAllBySystemUser(){
        SystemUser systemUser = prepareSystemUserToSave();
        systemUserRepository.save(systemUser);

        Instructor instructor = prepareInstructorToSave(systemUser);
        int size  = instructorRepository.findAllBySystemUser(instructor.getSystemUser(),pageable).size();
        instructorRepository.save(instructor);
        int sizeAfter = instructorRepository.findAllBySystemUser(instructor.getSystemUser(),pageable).size();
        Assert.assertEquals(size+1,sizeAfter);
    }


    /**
     * test save Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testSave() {
        SystemUser systemUser = prepareSystemUserToSave();
        systemUserRepository.save(systemUser);
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);
        Instructor instructorTest = instructorRepository.getOne(instructor.getUuid());
        Assert.assertEquals(instructor.getJobTitle(),instructorTest.getJobTitle());

    }

    /**
     * test find all deleted Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testFindAllDeleted() {

        SystemUser systemUser = prepareSystemUserToSave();
        systemUserRepository.save(systemUser);

        Instructor instructor = prepareInstructorToSave(systemUser);
        int size = instructorRepository.findAllDeleted(pageable).size();

        systemUserRepository.save(systemUser);

        instructorRepository.save(instructor);
        instructorRepository.delete(instructor);
        int sizeAfter = instructorRepository.findAllDeleted(pageable).size();
        Assert.assertEquals(size+1,sizeAfter);

    }

    /**
     * test find all Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testFindAll() {

        SystemUser systemUser = prepareSystemUserToSave();
        systemUserRepository.save(systemUser);

        Instructor instructor = prepareInstructorToSave(systemUser);
        int size = instructorRepository.findAll().size();
        instructorRepository.save(instructor);
        int sizeAfter = instructorRepository.findAll().size();
        Assert.assertEquals(size+1,sizeAfter);

    }

    /**
     * test update Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testUpdate() {
        SystemUser systemUser = prepareSystemUserToSave();
        systemUserRepository.save(systemUser);

        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);
        instructor.setJobTitle("SoftwareEngineer");
        instructorRepository.update(instructor);
        Instructor instructorUpdated = instructorRepository.getOne(instructor.getUuid());
        Assert.assertEquals(instructor.getJobTitle(),instructorUpdated.getJobTitle());

    }

    /**
     * test find all by bio Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    public void testFindAllByBio(){
        Instructor instructor = new Instructor();
        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");

        systemUserRepository.save(systemUser);
        instructor.setSystemUser(systemUser);
        instructor.setBio("developer");
        instructorRepository.save(instructor);
        Instructor instructorAfter = instructorRepository.findByBio("developer");
        Assert.assertEquals(instructor.getBio(),instructorAfter.getBio());

    }

    /**
     * test find by job title Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    public void testFindByJobTitle(){

        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");

        systemUserRepository.save(systemUser);
        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);

        Instructor instructor1  = instructorRepository.findByJobTitle("Developer");
        Assert.assertEquals(instructor.getJobTitle(),instructor1.getJobTitle());
    }

    /**
     * test find by id Method
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    public void testFindById(){
        SystemUser systemUser = prepareSystemUserToSave();
        systemUserRepository.save(systemUser);

        Instructor instructor = prepareInstructorToSave(systemUser);
        instructorRepository.save(instructor);
        Optional<Instructor> instructor1 = instructorRepository.findById(instructor.getUuid());
        Assert.assertNotNull(instructor1);
    }

    /**
     *  to instatiate Instructor to be Used
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    private Instructor prepareInstructorToSave(SystemUser systemUser){
        Instructor instructor = new Instructor();

        instructor.setJobTitle("Developer");
        instructor.setSystemUser(systemUser);
        instructor.setDeleted(false);
        return instructor;
    }

    /**
     *  to instatiate SystemUser to be Used
     * {@link org.eventhub.dal.dao.InstructorRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    private SystemUser prepareSystemUserToSave(){
        SystemUser systemUser =  new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");
        return systemUser;
    }

}
