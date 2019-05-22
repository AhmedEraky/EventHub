package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.Role;
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

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test Class for {@link org.eventhub.dal.dao.RoleRepository}
 *
 * @author Mohamed Gamal (mohamedj239@gmail.com)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class RoleRepositoryTest implements BaseRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    Pageable pageable = PageRequest.of(0, 5);

    /**
     * test findByName Method
     * {@link org.eventhub.dal.dao.RoleRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Test
    public void testFindByName() {
        Role bRole = new Role(null, "dummyRole");
        roleRepository.save(bRole);
        Role aRole = roleRepository.findByName("dummyRole");
        assertEquals(bRole.getName(), aRole.getName());
    }

    /**
     * test save Method
     * {@link org.eventhub.dal.dao.RoleRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Override
    @Test
    public void testSave() {
        Role bRole = new Role(null, "dummyRole");
        roleRepository.save(bRole);
        Role aRole = roleRepository.findById(bRole.getUuid()).get();

        assertEquals(bRole.getName(), aRole.getName());

    }

    /**
     * test findAllDeleted Method
     * {@link org.eventhub.dal.dao.RoleRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Override
    @Test
    public void testFindAllDeleted() {
        Role bRole = new Role(null, "dummyRole");
        long bSize = roleRepository.findAllDeleted(pageable).size();

        roleRepository.save(bRole);
        roleRepository.delete(bRole);
        long aSize = roleRepository.findAllDeleted(pageable).size();

        assertEquals(bSize + 1, aSize);
    }

    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.RoleRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Override
    @Test
    public void testFindAll() {

        Role bRole = new Role(null, "dummyRole");
        long bSize = roleRepository.findAll().size();

        roleRepository.save(bRole);
        long aSize = roleRepository.findAll().size();

        assertEquals(bSize + 1, aSize);
    }

    /**
     * test update Method
     * {@link org.eventhub.dal.dao.RoleRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Override
    @Test
    public void testUpdate() {
        Role bRole = new Role(null, "dummyRole");
        roleRepository.save(bRole);
        bRole.setName("updatedDummyRole");
        roleRepository.update(bRole);

        Role aUpdateRole = roleRepository.findById(bRole.getUuid()).get();
        assertEquals(bRole.getName(), aUpdateRole.getName());

    }

    /**
     * test softDelete Method
     * {@link org.eventhub.dal.dao.RoleRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Override
    @Test
    public void testSoftDelete() {

        Role bRole = new Role(null, "dummyRole");
        roleRepository.save(bRole);
        Role aRole = roleRepository.getOne(bRole.getUuid());
        assertEquals(bRole.getName(), aRole.getName());

        UUID id = bRole.getUuid();
        Long count = roleRepository.count();
        roleRepository.softDelete(id);
        assertNull("Object Should not Exist", roleRepository.getOne(id));
        assertEquals(count, (Long) roleRepository.count());
    }

    /**
     * test Soft Delete Using Method deleteByID
     * {@link org.eventhub.dal.dao.RoleRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */

    @Override
    @Test
    public void testDeleteByID() {
        Role bRole = new Role(null, "dummRole");
        roleRepository.save(bRole);

        Role aRole = roleRepository.getOne(bRole.getUuid());
        assertEquals(bRole.getName(), aRole.getName());

        UUID id = bRole.getUuid();
        Long count = roleRepository.count();
        roleRepository.deleteById(id);
        assertNull("Object Should not Exist", roleRepository.getOne(id));
        assertEquals(count, (Long) roleRepository.count());
    }

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.RoleRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Override
    @Test
    public void testCount() {
        Role bRole = new Role(null, "dummyRole");
        long bSize = roleRepository.count();

        roleRepository.save(bRole);
        long aSize = roleRepository.count();

        assertEquals(bSize + 1, aSize);
    }

    /**
     * test Soft Delete Using Method delete
     * {@link org.eventhub.dal.dao.RoleRepository}
     *
     * @author Mohamed Gamal (mohamedj239@gmail.com)
     */
    @Override
    @Test
    public void testDelete() {
        Role bRole = new Role(null, "dummyRole");
        roleRepository.save(bRole);

        Role aRole = roleRepository.getOne(bRole.getUuid());
        assertEquals(bRole.getName(), aRole.getName());

        Long count = roleRepository.count();
        roleRepository.delete(bRole);
        assertNull(roleRepository.getOne(bRole.getUuid()));
        assertEquals(count, (Long) roleRepository.count());
    }

}
