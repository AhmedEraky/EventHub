package org.eventhub.dal.dao;


import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.common.model.entity.SystemUserPhone;
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

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SystemUserPhoneRepositoryTest {

    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    SystemUserPhoneRepository systemUserPhoneRepository;

    Pageable pageable = PageRequest.of(0, 555555);

    @Test
    public void testSave(){
        SystemUserPhone bSystemUserPhone=new SystemUserPhone(null,"01117538430");
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        bSystemUserPhone.setSystemUser(bSystemUser);
        systemUserPhoneRepository.save(bSystemUserPhone);
        SystemUserPhone aSystemUserPhone=systemUserPhoneRepository.getOne(bSystemUserPhone.getUuid());
        assertEquals(bSystemUserPhone.getUuid(),aSystemUserPhone.getUuid());
    }

    @Test
    public void testDelete(){
        SystemUserPhone bSystemUserPhone=new SystemUserPhone(null,"01117538430");
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        bSystemUserPhone.setSystemUser(bSystemUser);
        systemUserPhoneRepository.save(bSystemUserPhone);
        SystemUserPhone aSystemUserPhone=systemUserPhoneRepository.getOne(bSystemUserPhone.getUuid());
        assertEquals(bSystemUserPhone.getUuid(),aSystemUserPhone.getUuid());
        systemUserPhoneRepository.delete(bSystemUserPhone);
        assertNull(systemUserPhoneRepository.getOne(bSystemUser.getUuid()));
    }

    @Test
    public void testSoftDelete(){
        SystemUserPhone bSystemUserPhone=new SystemUserPhone(null,"01117538430");
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        bSystemUserPhone.setSystemUser(bSystemUser);
        systemUserPhoneRepository.save(bSystemUserPhone);
        SystemUserPhone aSystemUserPhone=systemUserPhoneRepository.getOne(bSystemUserPhone.getUuid());
        assertEquals(bSystemUserPhone.getUuid(),aSystemUserPhone.getUuid());
        systemUserPhoneRepository.softDelete(bSystemUserPhone.getUuid());
        assertNull(systemUserPhoneRepository.getOne(bSystemUser.getUuid()));
    }

    @Test
    public void testDeleteByID(){
        SystemUserPhone bSystemUserPhone=new SystemUserPhone(null,"01117538430");
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        bSystemUserPhone.setSystemUser(bSystemUser);
        systemUserPhoneRepository.save(bSystemUserPhone);
        SystemUserPhone aSystemUserPhone=systemUserPhoneRepository.getOne(bSystemUserPhone.getUuid());
        assertEquals(bSystemUserPhone.getUuid(),aSystemUserPhone.getUuid());
        systemUserPhoneRepository.deleteById(bSystemUserPhone.getUuid());
        assertNull(systemUserPhoneRepository.getOne(bSystemUser.getUuid()));
    }

//    @Test
    public void testUpdate(){
        SystemUserPhone bSystemUserPhone=new SystemUserPhone(null,"01117538430");
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        bSystemUserPhone.setSystemUser(bSystemUser);
        systemUserPhoneRepository.save(bSystemUserPhone);
        SystemUserPhone aSystemUserPhone=systemUserPhoneRepository.getOne(bSystemUserPhone.getUuid());
        aSystemUserPhone.setPhoneNumber("3438571110");
        systemUserPhoneRepository.save(aSystemUserPhone);
        SystemUserPhone aUpdateSystemUserPhone=systemUserPhoneRepository.findById(bSystemUser.getUuid()).get();
        assertNotEquals(bSystemUserPhone.getPhoneNumber(),aUpdateSystemUserPhone.getPhoneNumber());
    }

    @Test
    public void testFindAllByUserSystem(){

        SystemUserPhone bSystemUserPhone=new SystemUserPhone(null,"01117538430");
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        int bSize=systemUserPhoneRepository.findAllBySystemUser(bSystemUser,pageable).size();
        bSystemUserPhone.setSystemUser(bSystemUser);
        systemUserPhoneRepository.save(bSystemUserPhone);
        int aSize=systemUserPhoneRepository.findAllBySystemUser(bSystemUser,pageable).size();
        assertEquals(bSize+1,aSize);
    }
}
