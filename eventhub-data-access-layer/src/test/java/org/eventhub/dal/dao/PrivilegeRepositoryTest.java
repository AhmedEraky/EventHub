package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.Privilege;
import org.eventhub.common.model.entity.Role;
import org.eventhub.common.model.entity.RolePrivilege;
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
 * Test class for {@link org.eventhub.dal.dao.PrivilegeRepository}
 * @author Menna Ahmed (menna4a.helmi@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class PrivilegeRepositoryTest implements BaseRepositoryTest{

    @Autowired
    PrivilegeRepository privilegeRepository;

    @Autowired
    RolePrivilegeRepository rolePrivilegeRepository;

    @Autowired
    RoleRepository roleRepository;

    Pageable pageable = PageRequest.of(0, 555555);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testCount() {

        Privilege privilege = preparePrivilegeToSave();
        long count = privilegeRepository.count();
        privilegeRepository.save(privilege);
        long countAfter = privilegeRepository.count();
        Assert.assertEquals(count+1,countAfter);
    }

    /**
     * test delete Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testDelete() {
        Privilege privilege = preparePrivilegeToSave();
        privilegeRepository.save(privilege);
        privilegeRepository.delete(privilege);
        Privilege privilegeTest = privilegeRepository.getOne(privilege.getUuid());
        Assert.assertNull(privilegeTest);
    }

    /**
     * test delete by id Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testDeleteByID() {
        Privilege privilege = preparePrivilegeToSave();
        privilegeRepository.save(privilege);
        privilegeRepository.deleteById(privilege.getUuid());
        Privilege privilegeTest = privilegeRepository.getOne(privilege.getUuid());
        Assert.assertNull(privilegeTest);
    }

    /**
     * test soft delete Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testSoftDelete() {
        Privilege privilege = preparePrivilegeToSave();
        privilegeRepository.save(privilege);
        privilegeRepository.softDelete(privilege.getUuid());
        Privilege privilegeTest = privilegeRepository.getOne(privilege.getUuid());
        Assert.assertNull(privilegeTest);

    }

    /**
     * test find Privilege by name Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    public void testFindByName() {

    }

    /**
     * test save Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testSave() {

        Privilege privilege = preparePrivilegeToSave();
        privilegeRepository.save(privilege);
        Privilege privilegeTest = privilegeRepository.getOne(privilege.getUuid());
        Assert.assertNotNull(privilegeTest);
    }

    /**
     * test find all deleted Privilege Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        Privilege privilege = preparePrivilegeToSave();
        privilegeRepository.save(privilege);
        int size = privilegeRepository.findAllDeleted(pageable).size();
        privilegeRepository.delete(privilege);
        int sizeAfter = privilegeRepository.findAllDeleted(pageable).size();
        Assert.assertEquals(size+1,sizeAfter);;
    }

    /**
     * test find all privileges Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testFindAll() {
        Privilege privilege = preparePrivilegeToSave();
        int size = privilegeRepository.findAll().size();
        privilegeRepository.save(privilege);
        int sizeAfter = privilegeRepository.findAll().size();
        Assert.assertEquals(size+1,sizeAfter);;

    }

    /**
     * test update Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    @Override
    public void testUpdate() {
        Privilege privilege = preparePrivilegeToSave();
        privilegeRepository.save(privilege);
        privilege.setName("user");
        privilegeRepository.update(privilege);
        Privilege privilegeTest = privilegeRepository.getOne(privilege.getUuid());
        Assert.assertEquals(privilege.getName(),privilegeTest.getName());

    }

    /**
     * test find Privilege by RolePrivilege Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    @Test
    public void testFindByRolePrivilege(){
        Privilege privilege = preparePrivilegeToSave();
        Role role = new Role(null,"user");
        roleRepository.save(role);
        RolePrivilege rolePrivilege = prepareRolePrivilegeToSave(privilege,role);
        rolePrivilege.setPrivilege(privilege);
        privilegeRepository.save(privilege);
        rolePrivilegeRepository.save(rolePrivilege);
        Privilege privilegeTest = privilegeRepository.findAllByRolePrivileges(rolePrivilege);
        Assert.assertNotNull(privilegeTest);;
    }

    /**
     * instantiate Privilege Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    private Privilege preparePrivilegeToSave(){
        Privilege privilege = new Privilege(null,"user");
        return privilege;
    }
    /**
     * instantiate RolePrivilege Method
     * {@link org.eventhub.dal.dao.PrivilegeRepository}
     * @author Menna Ahmed (menna4a.helmi@gmail.com)
     */
    private RolePrivilege prepareRolePrivilegeToSave(Privilege privilege, Role role){
        RolePrivilege rolePrivilege = new RolePrivilege(null);
        rolePrivilege.setPrivilege(privilege);
        rolePrivilege.setRole(role);
        return rolePrivilege;
    }

}
