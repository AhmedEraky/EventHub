package org.eventhub.dal.dao;


import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.common.model.entity.SystemUserPhone;
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

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

/**
 * Test class for {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
 * @author Amr Elkady <amrelkady93@gmail.com>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SystemUserPhoneRepositoryTest implements BaseRepositoryTest {

    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    SystemUserPhoneRepository systemUserPhoneRepository;

    Pageable pageable = PageRequest.of(0, 555555);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testCount() {
        SystemUserPhone bSystemUserPhone=new SystemUserPhone(null,"01117538430");
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        bSystemUserPhone.setSystemUser(bSystemUser);
        long bSize=systemUserPhoneRepository.count();
        systemUserPhoneRepository.save(bSystemUserPhone);
        long aSize=systemUserPhoneRepository.count();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test Save Method
     * {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
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

    /**
     * test Update Method
     * {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testUpdate(){
        SystemUserPhone bSystemUserPhone=new SystemUserPhone(null,"01117538430");
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        bSystemUserPhone.setSystemUser(bSystemUser);
        systemUserPhoneRepository.save(bSystemUserPhone);
        bSystemUserPhone.setPhoneNumber("3438571110");
        systemUserPhoneRepository.update(bSystemUserPhone);
        SystemUserPhone aUpdateSystemUserPhone=systemUserPhoneRepository.getOne(bSystemUserPhone.getUuid());
        assertEquals(bSystemUserPhone.getPhoneNumber(),aUpdateSystemUserPhone.getPhoneNumber());
    }

    /**
     * test FindAllDeleted Method
     * {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        SystemUserPhone bSystemUserPhone=new SystemUserPhone(null,"01117538430");
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        bSystemUserPhone.setSystemUser(bSystemUser);
        long bSize=systemUserPhoneRepository.findAllDeleted(pageable).size();
        systemUserPhoneRepository.save(bSystemUserPhone);
        systemUserPhoneRepository.delete(bSystemUserPhone);
        long aSize=systemUserPhoneRepository.findAllDeleted(pageable).size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test Delete Method
     * {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
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

    /**
     * test SoftDelete Method
     * {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
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

    /**
     * test FindAll Method
     * {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testFindAll() {
        SystemUserPhone bSystemUserPhone=new SystemUserPhone(null,"01117538430");
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        systemUserRepository.save(bSystemUser);
        bSystemUserPhone.setSystemUser(bSystemUser);
        long bSize=systemUserPhoneRepository.findAll().size();
        systemUserPhoneRepository.save(bSystemUserPhone);
        long aSize=systemUserPhoneRepository.findAll().size();
        assertEquals(bSize+1,aSize);
    }

    /**
     * test FindByName Method
     * {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    public void testFindByName() {

    }

    /**
     * test DeleteByID Method
     * {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
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

    /**
     * test FindAllByUserSystem Method
     * {@link org.eventhub.dal.dao.SystemUserPhoneRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
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
