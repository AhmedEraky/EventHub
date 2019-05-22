package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.common.model.entity.Vip;
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

import java.util.HashSet;
import java.util.Set;

/**
 * Test class for {@link org.eventhub.dal.dao.OrganizationRepository}
 * @author Menna Ahmed <menna4a.helmi@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional

public class OrganizationRepositoryTest implements BaseRepositoryTest{


    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    JobTitleRepository jobTitleRepository;

    @Autowired
            VipRepository vipRepository;

    Pageable pageable = PageRequest.of(0, 555555);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    @Override
    public void testCount() {
        Organization organization = prepareOrganizationToSave();
        long count = organizationRepository.count();
        organizationRepository.save(organization);
        long countAfter = organizationRepository.count();
        Assert.assertEquals(count+1,countAfter);

    }

    /**
     * test delete Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    @Override
    public void testDelete() {
        Organization organization = prepareOrganizationToSave();
        organizationRepository.save(organization);
        organizationRepository.delete(organization);
        Organization organizationTest = organizationRepository.getOne(organization.getUuid());
        Assert.assertNull(organizationTest);

    }

    /**
     * test delete by Id Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    @Override
    public void testDeleteByID() {
        Organization organization = prepareOrganizationToSave();
        organizationRepository.save(organization);
        organizationRepository.deleteById(organization.getUuid());
        Organization organizationTest = organizationRepository.getOne(organization.getUuid());
        Assert.assertNull(organizationTest);
    }

    /**
     * test soft delete Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    @Override
    public void testSoftDelete() {

        Organization organization = prepareOrganizationToSave();
        organizationRepository.save(organization);
        organizationRepository.softDelete(organization.getUuid());
        Organization organizationTest = organizationRepository.getOne(organization.getUuid());
        Assert.assertNull(organizationTest);

    }

    /**
     * test find organization by name Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    public void testFindByName() {

        Organization organization = prepareOrganizationToSave();
        int size = organizationRepository.findAllByName("IBM",pageable).size();
        organizationRepository.save(organization);
        int sizeAfter = organizationRepository.findAllByName("IBM",pageable).size();
        Assert.assertEquals(size+1,sizeAfter);

    }

    /**
     * test save Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    @Override
    public void testSave() {
        Organization organization = prepareOrganizationToSave();
        organizationRepository.save(organization);
        Organization organizationTest = organizationRepository.getOne(organization.getUuid());
        Assert.assertNotNull(organizationTest);
    }

    /**
     * test find all deleted Organizations Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    @Override
    public void testFindAllDeleted() {

        Organization organization = prepareOrganizationToSave();
        int size = organizationRepository.findAllDeleted(pageable).size();
        organizationRepository.save(organization);
        organizationRepository.delete(organization);
        int sizeAfter = organizationRepository.findAllDeleted(pageable).size();
        Assert.assertEquals(size+1,sizeAfter);
    }

    /**
     * test find all Organization Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    @Override
    public void testFindAll() {
        Organization organization = prepareOrganizationToSave();
        int size = organizationRepository.findAll().size();
        organizationRepository.save(organization);
        int sizeAfter = organizationRepository.findAll().size();
        Assert.assertEquals(size+1,sizeAfter);
    }

    /**
     * test update Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    @Override
    public void testUpdate()
    {
        Organization organization = prepareOrganizationToSave();
        organizationRepository.save(organization);
        organization.setName("Microsoft");
        organizationRepository.update(organization);
        Organization organizationTest = organizationRepository.getOne(organization.getUuid());
        Assert.assertEquals(organization.getName(),organizationTest.getName());

    }

    /**
     * test find Organization By Vip Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    public void testFindByVip(){
        Organization organization = prepareOrganizationToSave();
        Vip vip = prepareVipToSave(organization);
        vipRepository.save(vip);
        Set<Vip> vips = new HashSet<>();
        vips.add(vip);
        organization.setVips(vips);
        organizationRepository.save(organization);
        Organization organizationTest = organizationRepository.findByVips(vip);
        Assert.assertNotNull(organizationTest);

    }

    /**
     * test find Organization by System Users Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    @Test
    public void testFindBySystemUsers(){
        SystemUser systemUser = new SystemUser(null,"MennaAhmed","Menna","41111","menna4a.helmi@gmail.com");

        Set<SystemUser> systemUsers = new HashSet<>();
        systemUsers.add(systemUser);
        Organization organization = prepareOrganizationToSave();
        systemUser.setOrganization(organization);
        organization.setSystemUsers(systemUsers);
        systemUserRepository.save(systemUser);
        organizationRepository.save(organization);
        Organization organizationTest = organizationRepository.findBySystemUsers(systemUser);
        Assert.assertNotNull(organizationTest);
    }

    /**
     * instantiate Organization Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    private Organization prepareOrganizationToSave(){
        Organization organization = new Organization(null,"IBM");
        return organization;
    }

    /**
     * instantiate Vip Method
     * {@link org.eventhub.dal.dao.OrganizationRepository}
     * @author Menna Ahmed <menna4a.helmi@gmail.com>
     */
    private Vip prepareVipToSave(Organization organization){
        Vip bvip = new Vip(null,"Engineer","Amr Elkady");
        JobTitle jobTitle= new JobTitle(null,"Engineer");
        jobTitleRepository.save(jobTitle);
        organizationRepository.save(organization);
        bvip.setJobTitle(jobTitle);
        bvip.setOrganization(organization);
        return bvip;
    }
}
