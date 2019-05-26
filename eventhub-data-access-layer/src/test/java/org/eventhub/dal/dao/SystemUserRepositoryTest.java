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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test class for {@link org.eventhub.dal.dao.SystemUserRepository}
 * @author Amr Elkady (amrelkady93@gmail.com)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SystemUserRepositoryTest implements BaseRepositoryTest{

    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    SystemUserPhoneRepository systemUserPhoneRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    JobTitleRepository jobTitleRepository;
    @Autowired
    OrganizationRepository organizationRepository;

    Pageable pageable = PageRequest.of(0, 555555);


    /**
     * test count Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    @Override
    public void testCount() {
        SystemUser bSystemUser=
                getSystemUser();
        long bSize=systemUserRepository.count();
        systemUserRepository.save(bSystemUser);
        long aSize=systemUserRepository.count();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test Save Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    @Override
    public void testSave(){
        SystemUser bSystemUser=
                getSystemUser();
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.getOne(bSystemUser.getUuid());
        assertEquals(aSystemUser.getEmail(),bSystemUser.getEmail());

    }

    /**
     * test FindAllDeleted Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        SystemUser bSystemUser=
                getSystemUser();
        long bSize=systemUserRepository.findAllDeleted(pageable).size();
        systemUserRepository.save(bSystemUser);
        systemUserRepository.delete(bSystemUser);
        long aSize=systemUserRepository.findAllDeleted(pageable).size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test FindAll Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    @Override
    public void testFindAll() {
        SystemUser bSystemUser=
                getSystemUser();
        long bSize=systemUserRepository.findAll().size();
        systemUserRepository.save(bSystemUser);
        long aSize=systemUserRepository.findAll().size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test Update Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    @Override
    public void testUpdate(){
        SystemUser bSystemUser=
                getSystemUser();
        systemUserRepository.save(bSystemUser);
        bSystemUser.setEmail("afterupdate@iti.com");
        systemUserRepository.update(bSystemUser);
        SystemUser aUpdateSystemUser=systemUserRepository.findById(bSystemUser.getUuid()).get();
        assertEquals(aUpdateSystemUser.getEmail(),bSystemUser.getEmail());
    }

    /**
     * test SoftDelete Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    @Override
    public void testSoftDelete(){
        SystemUser bSystemUser=
                getSystemUser();
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.getOne(bSystemUser.getUuid());
        assertEquals(aSystemUser.getEmail(),bSystemUser.getEmail());

        systemUserRepository.softDelete(bSystemUser.getUuid());
        assertNull(systemUserRepository.getOne(bSystemUser.getUuid()));
    }


    /**
     * test DeleteByID Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    @Override
    public void testDeleteByID(){
        SystemUser bSystemUser=
                getSystemUser();
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.getOne(bSystemUser.getUuid());
        // to make sure insert in data base
        assertEquals(aSystemUser.getEmail(),bSystemUser.getEmail());

        systemUserRepository.deleteById(bSystemUser.getUuid());
        assertNull(systemUserRepository.getOne(bSystemUser.getUuid()));
    }



    public void testFindByName() {
    }

    /**
     * test Delete Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    @Override
    public void testDelete(){
        SystemUser bSystemUser=
                getSystemUser();
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.getOne(bSystemUser.getUuid());
        // to make sure insert in data base
        assertEquals(aSystemUser.getEmail(),bSystemUser.getEmail());

        systemUserRepository.delete(bSystemUser);
        assertNull(systemUserRepository.getOne(bSystemUser.getUuid()));
    }

    /**
     * test FindAllByUserName Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    public void testFindAllByUserName(){

        SystemUser bSystemUser=
                getSystemUser();
        int bSize=systemUserRepository.findAllByUsername(bSystemUser.getUserName(),pageable).size();
        systemUserRepository.save(bSystemUser);
        int aSize=systemUserRepository.findAllByUsername("elkady",pageable).size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test FindByEmail Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    public void testFindByEmail(){

        SystemUser bSystemUser=
                getSystemUser();
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.findByEmail(bSystemUser.getEmail());
        assertEquals(bSystemUser.getUuid(),aSystemUser.getUuid());
    }

    /**
     * test FindAllByFirstName Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    public void testFindAllByFirstName(){

        SystemUser bSystemUser=
                getSystemUser();
        int bSize=systemUserRepository.findAllByFirstName(bSystemUser.getFirstName(),pageable).size();
        systemUserRepository.save(bSystemUser);
        int aSize=systemUserRepository.findAllByFirstName(bSystemUser.getFirstName(),pageable).size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test FindBySystemUserPhones Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    public void testFindBySystemUserPhones(){

        List<SystemUserPhone> testSet=new ArrayList<>();
        SystemUser bSystemUser=
                getSystemUser();
        SystemUserPhone systemUserPhone =new SystemUserPhone(null,"01117538430");
        systemUserRepository.save(bSystemUser);
        systemUserPhone.setSystemUser(bSystemUser);
        systemUserPhoneRepository.save(systemUserPhone);
        testSet.add(systemUserPhone);
        bSystemUser.setSystemUserPhones(testSet);
        systemUserRepository.save(bSystemUser);

        SystemUser aSystemUser=systemUserRepository.findBySystemUserPhones(systemUserPhone);
        assertEquals(bSystemUser.getUuid(),aSystemUser.getUuid());
    }

    /**
     * test FindAllByCountry Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    public void testFindAllByCountry(){
        SystemUser bSystemUser=
                getSystemUser();
        Country country=new Country(null,"Egypt");
        countryRepository.save(country);
        bSystemUser.setCountry(country);
        int bSize=systemUserRepository.findAllByCountry(bSystemUser.getCountry(),pageable).size();
        systemUserRepository.save(bSystemUser);
        int aSize=systemUserRepository.findAllByCountry(bSystemUser.getCountry(),pageable).size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test AllByJobTitle Method
     * {@link org.eventhub.dal.dao.SystemUserRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    public void findAllByJobTitle(){
        SystemUser bSystemUser=
                getSystemUser();
        JobTitle jobTitle=new JobTitle(null,"Engineer");
        jobTitleRepository.save(jobTitle);
        bSystemUser.setJobTitle(jobTitle);
        int bSize=systemUserRepository.findAllByJobTitle(bSystemUser.getJobTitle(),pageable).size();
        systemUserRepository.save(bSystemUser);
        int aSize=systemUserRepository.findAllByJobTitle(bSystemUser.getJobTitle(),pageable).size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test AllByOrganization Method
     * {@link org.eventhub.dal.dao.VipRepository}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Test
    public void findAllByOrganization(){
        SystemUser bSystemUser= getSystemUser();
        Organization organization=new Organization(null,"ITI");
        organizationRepository.save(organization);
        bSystemUser.setOrganization(organization);
        int bSize=systemUserRepository.findAllByOrganization(bSystemUser.getOrganization(),pageable).size();
        systemUserRepository.save(bSystemUser);
        int aSize=systemUserRepository.findAllByOrganization(bSystemUser.getOrganization(),pageable).size();
        assertEquals(bSize+1,aSize);
    }

    public SystemUser getSystemUser() {
        SystemUser systemUser =
                new SystemUser(null, "amrelkady", "Amr", "12345", "amrelkady93@gmail.com",UserGender.Male,new Date());
        return systemUser;
    }


}
