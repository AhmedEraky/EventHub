package org.eventhub.dal.dao;


import org.junit.Test;

/**
 * Test Interface for {@link org.eventhub.dal.dao.BaseRepository}
 * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
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
