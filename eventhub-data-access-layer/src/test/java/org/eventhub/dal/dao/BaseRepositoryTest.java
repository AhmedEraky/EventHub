package org.eventhub.dal.dao;


import org.eventhub.dal.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test Interface for {@link org.eventhub.dal.dao.BaseRepository}
 * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
 */
public interface BaseRepositoryTest {
    @Test
    void testCount();

    @Test
    void testDelete();

    @Test
    void testDeleteByID();

    @Test
    void testSoftDelete();


    @Test
    void testSave();

    @Test
    void testFindAllDeleted();

    @Test
    void testFindAll();

    @Test
    void testUpdate();
}
