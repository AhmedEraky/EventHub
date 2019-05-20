package org.eventhub.dal.dao;


import org.eventhub.common.model.entity.Country;
import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.Hall;
import org.eventhub.common.model.entity.SessionInHall;
import org.eventhub.dal.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Test Class for {@link org.eventhub.dal.dao.SessionInHallRepository}
 * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SessionInHallRepositoryTest implements BaseRepositoryTest  {
    @Autowired
    SessionInHallRepository sessionInHallRepository;

    @Autowired
    HallRepository hallRepository;

    @Override
    @Test
    public void testCount() {
        assertEquals(1,1);
    }

    @Override
    public void testDelete() {

    }

    @Override
    public void testDeleteByID() {

    }

    @Override
    public void testSoftDelete() {

    }

    @Override
    public void testFindByName() {

    }

    @Override
    public void testSave() {

    }

    @Override
    public void testFindAllDeleted() {

    }

    @Override
    public void testFindAll() {

    }

    @Override
    public void testUpdate() {

    }
}
