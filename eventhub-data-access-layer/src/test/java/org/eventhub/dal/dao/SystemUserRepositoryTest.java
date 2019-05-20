package org.eventhub.dal.dao;


import org.eventhub.common.model.entity.*;
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

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SystemUserRepositoryTest {

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


    @Test
    public void testSave(){
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.getOne(bSystemUser.getUuid());
        assertEquals(aSystemUser.getEmail(),bSystemUser.getEmail());

    }

//    @Test
    public void testUpdate(){
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.findById(bSystemUser.getUuid()).get();
        aSystemUser.setEmail("afterupdate@iti.com");
        systemUserRepository.save(aSystemUser);
        SystemUser aUpdateSystemUser=systemUserRepository.findById(bSystemUser.getUuid()).get();
        assertNotEquals(aUpdateSystemUser.getEmail(),bSystemUser.getEmail());
    }

    @Test
    public void testSoftDeleted(){
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.getOne(bSystemUser.getUuid());
        assertEquals(aSystemUser.getEmail(),bSystemUser.getEmail());

        systemUserRepository.softDelete(bSystemUser.getUuid());
        assertNull(systemUserRepository.getOne(bSystemUser.getUuid()));
    }


    @Test
    public void testDeleteByID(){
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.getOne(bSystemUser.getUuid());
        // to make sure insert in data base
        assertEquals(aSystemUser.getEmail(),bSystemUser.getEmail());

        systemUserRepository.deleteById(bSystemUser.getUuid());
        assertNull(systemUserRepository.getOne(bSystemUser.getUuid()));
    }

    @Test
    public void testDelete(){
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.getOne(bSystemUser.getUuid());
        // to make sure insert in data base
        assertEquals(aSystemUser.getEmail(),bSystemUser.getEmail());

        systemUserRepository.delete(bSystemUser);
        assertNull(systemUserRepository.getOne(bSystemUser.getUuid()));
    }

    @Test
    public void testFindAllByUserName(){

        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        int bSize=systemUserRepository.findAllByUsername(bSystemUser.getUsername(),pageable).size();
        systemUserRepository.save(bSystemUser);
        int aSize=systemUserRepository.findAllByUsername("elkady",pageable).size();
        assertEquals(bSize+1,aSize);
    }

    @Test
    public void testFindByEmail(){

        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        SystemUser aSystemUser=systemUserRepository.findByEmail(bSystemUser.getEmail());
        assertEquals(bSystemUser.getUuid(),aSystemUser.getUuid());
    }

    @Test
    public void testFindAllByFirstName(){

        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        int bSize=systemUserRepository.findAllByUsername(bSystemUser.getFirstName(),pageable).size();
        systemUserRepository.save(bSystemUser);
        int aSize=systemUserRepository.findAllByUsername(bSystemUser.getFirstName(),pageable).size();
        assertEquals(bSize+1,aSize);
    }

    @Test
    public void testFindBySystemUserPhones(){

        Set<SystemUserPhone> testSet=new HashSet<>();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
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

    @Test
    public void findAllByCountry(){
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Country country=new Country(null,"Egypt");
        countryRepository.save(country);
        bSystemUser.setCountry(country);
        int bSize=systemUserRepository.findAllByCountry(bSystemUser.getCountry(),pageable).size();
        systemUserRepository.save(bSystemUser);
        int aSize=systemUserRepository.findAllByCountry(bSystemUser.getCountry(),pageable).size();
        assertEquals(bSize+1,aSize);
    }

    @Test
    public void findAllByJobTitle(){
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        JobTitle jobTitle=new JobTitle(null,"Engineer");
        jobTitleRepository.save(jobTitle);
        bSystemUser.setJobTitle(jobTitle);
        int bSize=systemUserRepository.findAllByJobTitle(bSystemUser.getJobTitle(),pageable).size();
        systemUserRepository.save(bSystemUser);
        int aSize=systemUserRepository.findAllByJobTitle(bSystemUser.getJobTitle(),pageable).size();
        assertEquals(bSize+1,aSize);
    }

    @Test
    public void findAllByOrganization(){
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Organization organization=new Organization(null,"ITI");
        organizationRepository.save(organization);
        bSystemUser.setOrganization(organization);
        int bSize=systemUserRepository.findAllByOrganization(bSystemUser.getOrganization(),pageable).size();
        systemUserRepository.save(bSystemUser);
        int aSize=systemUserRepository.findAllByOrganization(bSystemUser.getOrganization(),pageable).size();
        assertEquals(bSize+1,aSize);
    }


}
