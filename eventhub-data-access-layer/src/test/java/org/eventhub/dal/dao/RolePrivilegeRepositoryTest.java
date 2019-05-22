package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.Privilege;
import org.eventhub.common.model.entity.Role;
import org.eventhub.common.model.entity.RolePrivilege;
import org.eventhub.dal.config.AppConfig;
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

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test Class for {@link org.eventhub.dal.dao.RolePrivilegeRepository}
 *
 * @author Mohamed Gamal (mohamedj239@gmail.com)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class RolePrivilegeRepositoryTest implements BaseRepositoryTest {

    @Autowired
    RolePrivilegeRepository rolePrivilegeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PrivilegeRepository privilegeRepository;

    Pageable pageable = PageRequest.of(0, 5);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.RolePrivilegeRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testCount() {
        long bSize = rolePrivilegeRepository.count();

        saveRolePrivilege();

        long aSize = rolePrivilegeRepository.count();
        assertEquals(bSize + 1, aSize);
    }


    /**
     * test delete Method
     * {@link org.eventhub.dal.dao.RolePrivilegeRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testDelete() {
        RolePrivilege bRolePrivilege = saveRolePrivilege();

        RolePrivilege aRolePrivilege = rolePrivilegeRepository.getOne(bRolePrivilege.getUuid());
        assertEquals(bRolePrivilege.getUuid(), aRolePrivilege.getUuid());

        long bSize = rolePrivilegeRepository.count();
        rolePrivilegeRepository.delete(bRolePrivilege);
        long aSize = rolePrivilegeRepository.count();

        assertNull("Object Should Not Exist", rolePrivilegeRepository.getOne(bRolePrivilege.getUuid()));
        assertEquals(bSize, aSize);

    }

    /**
     * test deleteById Method
     * {@link org.eventhub.dal.dao.RolePrivilegeRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testDeleteByID() {
        RolePrivilege bRolePrivilege = saveRolePrivilege();

        RolePrivilege aRolePrivilege = rolePrivilegeRepository.getOne(bRolePrivilege.getUuid());
        assertEquals(bRolePrivilege.getUuid(), aRolePrivilege.getUuid());

        UUID id = bRolePrivilege.getUuid();

        long bSize = rolePrivilegeRepository.count();
        rolePrivilegeRepository.deleteById(id);
        long aSize = rolePrivilegeRepository.count();

        assertNull("Object Should Not Exist", rolePrivilegeRepository.getOne(id));
        assertEquals(bSize, aSize);
    }

    /**
     * test softDelete Method
     * {@link org.eventhub.dal.dao.RolePrivilegeRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testSoftDelete() {
        RolePrivilege bRolePrivilege = saveRolePrivilege();

        RolePrivilege aRolePrivilege = rolePrivilegeRepository.getOne(bRolePrivilege.getUuid());
        assertEquals(bRolePrivilege.getUuid(), aRolePrivilege.getUuid());

        UUID id = bRolePrivilege.getUuid();

        long bSize = rolePrivilegeRepository.count();
        rolePrivilegeRepository.softDelete(id);
        long aSize = rolePrivilegeRepository.count();

        assertNull("Object Should Not Exist", rolePrivilegeRepository.getOne(id));
        assertEquals(bSize, aSize);
    }

    /**
     * test save Method
     * {@link org.eventhub.dal.dao.RolePrivilegeRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testSave() {
        RolePrivilege bRolePrivilege = saveRolePrivilege();

        RolePrivilege aRolePrivilege = rolePrivilegeRepository.getOne(bRolePrivilege.getUuid());
        assertEquals(bRolePrivilege.getUuid(), aRolePrivilege.getUuid());
    }

    /**
     * test findAllDeleted Method
     * {@link org.eventhub.dal.dao.RolePrivilegeRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        long bSize = rolePrivilegeRepository.findAllDeleted(pageable).size();
        RolePrivilege bRolePrivilege = saveRolePrivilege();

        rolePrivilegeRepository.delete(bRolePrivilege);
        long aSize = rolePrivilegeRepository.findAllDeleted(pageable).size();
        assertEquals(bSize + 1, aSize);

    }

    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.RolePrivilegeRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testFindAll() {
        long bSize = rolePrivilegeRepository.findAll().size();
        saveRolePrivilege();

        long aSize = rolePrivilegeRepository.findAll().size();
        assertEquals(bSize + 1, aSize);
    }

    /**
     * test update Method
     * {@link org.eventhub.dal.dao.RolePrivilegeRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    @Override
    public void testUpdate() {

        RolePrivilege bRolePrivilege = saveRolePrivilege();
        bRolePrivilege.getRole().setName("updatedDummyRole");

        rolePrivilegeRepository.update(bRolePrivilege);

        RolePrivilege aUpdatedRolePrivilege = rolePrivilegeRepository.getOne(bRolePrivilege.getUuid());
        assertEquals(bRolePrivilege.getRole().getName(), aUpdatedRolePrivilege.getRole().getName());

    }

    private RolePrivilege saveRolePrivilege() {
        RolePrivilege rolePrivilege = new RolePrivilege();
        Role role = new Role(null, "dummyRole");
        Privilege privilege = new Privilege(null, "dummyPrivilege");

        roleRepository.save(role);
        privilegeRepository.save(privilege);

        rolePrivilege.setRole(role);
        rolePrivilege.setPrivilege(privilege);
        rolePrivilegeRepository.save(rolePrivilege);
        return rolePrivilege;
    }
}
