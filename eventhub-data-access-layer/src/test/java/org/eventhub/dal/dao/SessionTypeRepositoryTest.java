package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.SessionType;
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

import static org.junit.Assert.assertEquals;

/**
 * Test Class for {@link org.eventhub.dal.dao.SessionTypeRepository}
 * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class SessionTypeRepositoryTest implements BaseRepositoryTest {
    @Autowired
    SessionTypeRepository sessionTypeRepository;
    /**
     * test count Method
     * {@link org.eventhub.dal.dao.SessionTypeRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Override
    @Test
    public void testCount() {
        long bCount=sessionTypeRepository.count();
        SessionType sessionType=createSessionType();
        sessionTypeRepository.save(sessionType);
        long aCount=sessionTypeRepository.count();
        assertEquals(bCount+1,aCount);

    }

    /**
     * test Soft Delete Using Method delete
     * {@link org.eventhub.dal.dao.SessionTypeRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Override
    @Test
    public void testDelete() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionType sessionType=createSessionType();
        sessionTypeRepository.save(sessionType);
        long bCount=sessionTypeRepository.findAllDeleted(pageable).size();
        sessionTypeRepository.delete(sessionType);
        long aCount=sessionTypeRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test Soft Delete Using Method deleteByID
     * {@link org.eventhub.dal.dao.SessionTypeRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Override
    @Test
    public void testDeleteByID() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionType sessionType=createSessionType();
        sessionTypeRepository.save(sessionType);
        long bCount=sessionTypeRepository.findAllDeleted(pageable).size();
        sessionTypeRepository.deleteById(sessionType.getUuid());
        long aCount=sessionTypeRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);

    }
    /**
     * test Soft Delete Method
     * {@link org.eventhub.dal.dao.SessionTypeRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Test
    @Override
    public void testSoftDelete() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionType sessionType=createSessionType();
        sessionTypeRepository.save(sessionType);
        long bCount=sessionTypeRepository.findAllDeleted(pageable).size();
        sessionTypeRepository.softDelete(sessionType.getUuid());
        long aCount=sessionTypeRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);


    }

    /**
     * test save Method
     * {@link org.eventhub.dal.dao.SessionTypeRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Test
    @Override
    public void testSave() {
        long bCount=sessionTypeRepository.count();
        SessionType sessionType=createSessionType();
        sessionTypeRepository.save(sessionType);
        long aCount=sessionTypeRepository.count();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test findAll Deleted Method
     * {@link org.eventhub.dal.dao.SessionTypeRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Test
    @Override
    public void testFindAllDeleted() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionType sessionType=createSessionType();
        sessionTypeRepository.save(sessionType);
        long bCount=sessionTypeRepository.findAllDeleted(pageable).size();
        sessionTypeRepository.softDelete(sessionType.getUuid());
        long aCount=sessionTypeRepository.findAllDeleted(pageable).size();
        assertEquals(bCount+1,aCount);
    }
    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.SessionTypeRepository}
     * @author Ahmed Eraky <ahmedmoeraky@gmail.com>
     */
    @Test
    @Override
    public void testFindAll() {
        Pageable pageable = PageRequest.of(0, 555555);
        SessionType sessionType=createSessionType();
        long bCount=sessionTypeRepository.findAll().size();
        sessionTypeRepository.save(sessionType);
        long aCount=sessionTypeRepository.findAll().size();
        assertEquals(bCount+1,aCount);
    }

    @Test
    @Override
    public void testUpdate() {
        SessionType bSessionType =createSessionType();
        sessionTypeRepository.save(bSessionType);
        SessionType aSessionType=sessionTypeRepository.getOne(bSessionType.getUuid());
        aSessionType.setName("US");
        sessionTypeRepository.update(aSessionType);
        bSessionType=sessionTypeRepository.getOne(bSessionType.getUuid());
        assertEquals(bSessionType.getName(),aSessionType.getName());
    }

    SessionType createSessionType(){
        SessionType sessionType=new SessionType(null,"test Type","test Style");
        return sessionType;
    }
}
