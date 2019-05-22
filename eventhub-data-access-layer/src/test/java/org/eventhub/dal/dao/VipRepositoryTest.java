package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.Vip;
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
import static org.junit.Assert.*;

/**
 * Test class for {@link org.eventhub.dal.dao.VipRepository}
 * @author Amr Elkady <amrelkady93@gmail.com>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class VipRepositoryTest implements BaseRepositoryTest {

    @Autowired
    VipRepository vipRepository;
    @Autowired
    JobTitleRepository jobTitleRepository;
    @Autowired
    OrganizationRepository organizationRepository;

    Pageable pageable = PageRequest.of(0, 555555);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testCount() {
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        long bSize=vipRepository.count();
        vipRepository.save(bvip);
        long aSize=vipRepository.count();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test Save Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testSave(){
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        vipRepository.save(bvip);
        Vip aVip=vipRepository.getOne(bvip.getUuid());
        assertEquals(bvip.getUuid(),aVip.getUuid());

    }

    /**
     * test FindByName Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    public void testFindByName() {

        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        long bSize=vipRepository.findAllByName(bvip.getName(),pageable).size();
        vipRepository.save(bvip);
        long aSize=vipRepository.findAllByName("Amr",pageable).size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test Delete Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testDelete() {
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        vipRepository.save(bvip);
        Vip aVip=vipRepository.getOne(bvip.getUuid());
        assertEquals(bvip.getUuid(),aVip.getUuid());
        vipRepository.delete(aVip);
        assertNull(vipRepository.getOne(aVip.getUuid()));

    }

    /**
     * test DeleteByID Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testDeleteByID() {
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        vipRepository.save(bvip);
        Vip aVip=vipRepository.getOne(bvip.getUuid());
        assertEquals(bvip.getUuid(),aVip.getUuid());
        vipRepository.deleteById(aVip.getUuid());
        assertNull(vipRepository.getOne(aVip.getUuid()));

    }

    /**
     * test SoftDelete Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testSoftDelete() {
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        vipRepository.save(bvip);
        Vip aVip=vipRepository.getOne(bvip.getUuid());
        assertEquals(bvip.getUuid(),aVip.getUuid());
        vipRepository.softDelete(aVip.getUuid());
        assertNull(vipRepository.getOne(aVip.getUuid()));
    }

    /**
     * test FindAllDeleted Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        long bSize=vipRepository.findAllDeleted(pageable).size();
        vipRepository.save(bvip);
        vipRepository.delete(bvip);
        long aSize=vipRepository.findAllDeleted(pageable).size();
        assertEquals(bSize+1,aSize);

    }

    /**
     * test FindAll Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testFindAll() {
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        long bSize=vipRepository.findAll().size();
        vipRepository.save(bvip);
        long aSize=vipRepository.findAll().size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test Update Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testUpdate() {
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        vipRepository.save(bvip);
        bvip.setName("Kady");
        vipRepository.update(bvip);
        Vip aVip=vipRepository.getOne(bvip.getUuid());
        assertEquals(bvip.getName(),aVip.getName());

    }

    /**
     * test FindByJobTitle Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    public void testFindByJobTitle(){
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        long bSize=vipRepository.findAllByJobTitle(jobTitle,pageable).size();
        vipRepository.save(bvip);
        long aSize=vipRepository.findAllByJobTitle(jobTitle,pageable).size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test FindAllByOrganization Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    public void testFindAllByOrganization(){
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        Organization organization =new Organization(null,"ITI");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        long bSize=vipRepository.findAllByOrganization(organization,pageable).size();
        vipRepository.save(bvip);
        long aSize=vipRepository.findAllByOrganization(organization,pageable).size();
        assertEquals(bSize+1,aSize);
    }

}
