package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.config.AppConfig;
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

/**
 * Test class for {@link org.eventhub.dal.dao.JobTitleRepository}
 * @author Menna Ahmed (menna4a.helmi@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional

public class JobTitleRepositoryTest implements BaseRepositoryTest{

    @Autowired
    JobTitleRepository jobTitleRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
     SystemUserRepository systemUserRepository;

    Pageable pageable = PageRequest.of(0, 555555);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.JobTitleRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testCount()
    {
        JobTitle jobTitle = new JobTitle(null,"Developer");
        long size = jobTitleRepository.count();
        jobTitleRepository.save(jobTitle);
        long sizeAfter = jobTitleRepository.count();
        Assert.assertEquals(size+1,sizeAfter);
    }

    /**
     * test delete Method
     * {@link org.eventhub.dal.dao.JobTitleRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testDelete() {
        JobTitle jobTitle = new JobTitle(null,"Developer");
        jobTitleRepository.save(jobTitle);
        jobTitleRepository.delete(jobTitle);
        Assert.assertNull(jobTitleRepository.getOne(jobTitle.getUuid()));

    }

    /**
     * test delete by id Method
     * {@link org.eventhub.dal.dao.JobTitleRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testDeleteByID() {

        JobTitle jobTitle = new JobTitle(null,"Developer");;
        jobTitleRepository.save(jobTitle);
        jobTitleRepository.deleteById(jobTitle.getUuid());
        Assert.assertNull(jobTitleRepository.getOne(jobTitle.getUuid()));

    }

    /**
     * test soft delete Method
     * {@link org.eventhub.dal.dao.JobTitleRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testSoftDelete() {
        JobTitle jobTitle = new JobTitle(null,"Developer");
        jobTitleRepository.save(jobTitle);
        jobTitleRepository.softDelete(jobTitle.getUuid());
        Assert.assertNull(jobTitleRepository.getOne(jobTitle.getUuid()));

    }

    /**
     * test find JobTitle by name Method
     * {@link org.eventhub.dal.dao.JobTitleRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    public void testFindByName() {
        JobTitle jobTitle = new JobTitle(null,"Developer");
        int size = jobTitleRepository.findAllByName(jobTitle.getName(),pageable).size();
        jobTitleRepository.save(jobTitle);
        int sizeAfter = jobTitleRepository.findAllByName(jobTitle.getName(),pageable).size();
        Assert.assertEquals(size+1,sizeAfter);

    }

    /**
     * test save Method
     * {@link org.eventhub.dal.dao.JobTitleRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testSave() {

        JobTitle jobTitle = new JobTitle(null,"Developer");
        int size = jobTitleRepository.findAllByName(jobTitle.getName(),pageable).size();
        jobTitleRepository.save(jobTitle);
        JobTitle jobTitleTest = jobTitleRepository.getOne(jobTitle.getUuid());
        Assert.assertNotNull(jobTitleTest);
    }

    /**
     * test find all deleted JobTitles Method
     * {@link org.eventhub.dal.dao.JobTitleRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testFindAllDeleted() {

        JobTitle jobTitle = new JobTitle(null,"Developer");
        long size = jobTitleRepository.findAllDeleted(pageable).size();
        jobTitleRepository.save(jobTitle);
        jobTitleRepository.delete(jobTitle);
        long sizeAfter = jobTitleRepository.findAllDeleted(pageable).size();
        Assert.assertEquals(size+1,sizeAfter);
    }

    /**
     * test find all JobTitles Method
     * {@link org.eventhub.dal.dao.JobTitleRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testFindAll() {
        int size = jobTitleRepository.findAll().size();
        JobTitle jobTitle = new JobTitle(null,"Developer");
        jobTitleRepository.save(jobTitle);
        int sizeAfter = jobTitleRepository.findAll().size();
        Assert.assertEquals(size+1,sizeAfter);

    }

    /**
     * test update Method
     * {@link org.eventhub.dal.dao.JobTitleRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testUpdate() {
        JobTitle jobTitle = new JobTitle(null,"Developer");
        jobTitleRepository.save(jobTitle);
        jobTitle.setName("SoftwareEngineer");
        jobTitleRepository.update(jobTitle);

        JobTitle jobTitleTest = jobTitleRepository.getOne(jobTitle.getUuid());
        Assert.assertEquals(jobTitle.getName(),jobTitleTest.getName());
    }

}
