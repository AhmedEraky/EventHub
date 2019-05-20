package org.eventhub.dal.dao;

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlAttr;
import org.eventhub.common.model.entity.Role;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.common.model.entity.SystemUserHasRole;
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

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
 * @author Amr Elkady <amrelkady93@gmail.com>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SystemUserHasRoleRepositoryTest implements BaseRepositoryTest {

    @Autowired
    SystemUserHasRoleRepository systemUserHasRoleRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SystemUserRepository systemUserRepository;

    Pageable pageable = PageRequest.of(0, 555555);

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testCount() {
        SystemUserHasRole systemUserHasRole =
                new SystemUserHasRole();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Role role = new Role(null,"Admin");
        systemUserRepository.save(bSystemUser);
        roleRepository.save(role);
        systemUserHasRole.setRole(role);
        systemUserHasRole.setSystemUser(bSystemUser);
        long bsize=systemUserHasRoleRepository.count();
        systemUserHasRoleRepository.save(systemUserHasRole);
        long asize=systemUserHasRoleRepository.count();
        assertEquals(bsize+1,asize);
    }

    /**
     * test Save Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testSave() {

        SystemUserHasRole systemUserHasRole =
                new SystemUserHasRole();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Role role = new Role(null,"Admin");
        systemUserRepository.save(bSystemUser);
        roleRepository.save(role);
        systemUserHasRole.setRole(role);
        systemUserHasRole.setSystemUser(bSystemUser);
        systemUserHasRoleRepository.save(systemUserHasRole);
        SystemUserHasRole aSystemUserHasRole1=systemUserHasRoleRepository.getOne(systemUserHasRole.getUuid());
        assertEquals(systemUserHasRole.getRole(), aSystemUserHasRole1.getRole());
    }

    /**
     * test Update Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testUpdate() {
        SystemUserHasRole bsystemUserHasRole =
                new SystemUserHasRole();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Role role = new Role(null,"Admin");
        Role role2 = new Role(null,"User");
        systemUserRepository.save(bSystemUser);
        roleRepository.save(role);
        roleRepository.save(role2);
        bsystemUserHasRole.setRole(role);
        bsystemUserHasRole.setSystemUser(bSystemUser);
        systemUserHasRoleRepository.save(bsystemUserHasRole);
        bsystemUserHasRole.setRole(role2);
        systemUserRepository.update(bSystemUser);
        SystemUserHasRole asystemUserHasRole1=systemUserHasRoleRepository.getOne(bsystemUserHasRole.getUuid());
        assertEquals(asystemUserHasRole1.getRole().getName()
                ,bsystemUserHasRole.getRole().getName());
    }

    /**
     * test Delete Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testDelete() {

        SystemUserHasRole systemUserHasRole =
                new SystemUserHasRole();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Role role = new Role(null,"Admin");
        systemUserRepository.save(bSystemUser);
        roleRepository.save(role);
        systemUserHasRole.setRole(role);
        systemUserHasRole.setSystemUser(bSystemUser);
        systemUserHasRoleRepository.save(systemUserHasRole);
        long bsize=systemUserHasRoleRepository.count();
        systemUserHasRoleRepository.delete(systemUserHasRole);
        long asize=systemUserHasRoleRepository.count();
        assertEquals(bsize,asize);
    }

    /**
     * test DeleteByID Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testDeleteByID() {
        SystemUserHasRole systemUserHasRole =
                new SystemUserHasRole();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Role role = new Role(null,"Admin");
        systemUserRepository.save(bSystemUser);
        roleRepository.save(role);
        systemUserHasRole.setRole(role);
        systemUserHasRole.setSystemUser(bSystemUser);
        systemUserHasRoleRepository.save(systemUserHasRole);
        long bsize=systemUserHasRoleRepository.count();
        systemUserHasRoleRepository.deleteById(systemUserHasRole.getUuid());
        long asize=systemUserHasRoleRepository.count();
        assertEquals(bsize,asize);
    }

    /**
     * test SoftDelete Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testSoftDelete() {
        SystemUserHasRole systemUserHasRole =
                new SystemUserHasRole();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Role role = new Role(null,"Admin");
        systemUserRepository.save(bSystemUser);
        roleRepository.save(role);
        systemUserHasRole.setRole(role);
        systemUserHasRole.setSystemUser(bSystemUser);
        systemUserHasRoleRepository.save(systemUserHasRole);
        long bsize=systemUserHasRoleRepository.count();
        systemUserHasRoleRepository.softDelete(systemUserHasRole.getUuid());
        long asize=systemUserHasRoleRepository.count();
        assertEquals(bsize,asize);
    }

    /**
     * test FindAllDeleted Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        SystemUserHasRole systemUserHasRole =
                new SystemUserHasRole();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Role role = new Role(null,"Admin");
        systemUserRepository.save(bSystemUser);
        roleRepository.save(role);
        systemUserHasRole.setRole(role);
        systemUserHasRole.setSystemUser(bSystemUser);
        long bsize=systemUserHasRoleRepository.findAllDeleted(pageable).size();
        systemUserHasRoleRepository.save(systemUserHasRole);
        systemUserHasRoleRepository.delete(systemUserHasRole);
        long asize=systemUserHasRoleRepository.findAllDeleted(pageable).size();
        assertEquals(bsize+1,asize);
    }

    /**
     * test FindByName Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testFindByName() {

    }

    /**
     * test FindAll Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    @Override
    public void testFindAll() {
        SystemUserHasRole systemUserHasRole =
                new SystemUserHasRole();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Role role = new Role(null,"Admin");
        systemUserRepository.save(bSystemUser);
        roleRepository.save(role);
        systemUserHasRole.setRole(role);
        systemUserHasRole.setSystemUser(bSystemUser);
        long bsize=systemUserHasRoleRepository.findAll().size();
        systemUserHasRoleRepository.save(systemUserHasRole);
        long asize=systemUserHasRoleRepository.findAll().size();
        assertEquals(bsize+1,asize);
    }

    /**
     * test FindAllByRole Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    public void testFindAllByRole(){

        SystemUserHasRole systemUserHasRole =
                new SystemUserHasRole();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Role role = new Role(null,"Admin");
        systemUserRepository.save(bSystemUser);
        roleRepository.save(role);
        systemUserHasRole.setRole(role);
        systemUserHasRole.setSystemUser(bSystemUser);
        long bsize=systemUserHasRoleRepository.findAllByRole(role,pageable).size();
        systemUserHasRoleRepository.save(systemUserHasRole);
        long asize=systemUserHasRoleRepository.findAllByRole(role,pageable).size();
        assertEquals(bsize+1,asize);
    }

    /**
     * test FindAllByUserSystem Method
     * {@link org.eventhub.dal.dao.SystemUserHasRoleRepository}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Test
    public void testFindAllByUserSystem(){

        SystemUserHasRole systemUserHasRole =
                new SystemUserHasRole();
        SystemUser bSystemUser=
                new SystemUser(null,"amrelkady","Amr","12345","amrelkady93@gmail.com");
        Role role = new Role(null,"Admin");
        systemUserRepository.save(bSystemUser);
        roleRepository.save(role);
        systemUserHasRole.setRole(role);
        systemUserHasRole.setSystemUser(bSystemUser);
        long bsize=systemUserHasRoleRepository.findAllBySystemUser(bSystemUser,pageable).size();
        systemUserHasRoleRepository.save(systemUserHasRole);
        long asize=systemUserHasRoleRepository.findAllBySystemUser(bSystemUser,pageable).size();
        assertEquals(bsize+1,asize);
    }
}
