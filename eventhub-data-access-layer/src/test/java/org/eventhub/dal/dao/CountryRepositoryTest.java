package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.Country;
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

import static org.junit.Assert.*;

/**
 * Test Class for {@link org.eventhub.dal.dao.CountryRepository}
 * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class CountryRepositoryTest implements BaseRepositoryTest {

    @Autowired
    CountryRepository countryRepository;

    /**
     * test count Method
     * {@link org.eventhub.dal.dao.CountryRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Test
    @Override
    public void testCount(){
        long bCount=countryRepository.count();
        Country country=new Country(null,"Egypt");
        countryRepository.save(country);
        long aCount=countryRepository.count();
        assertEquals(bCount+1,aCount);
    }

    /**
     * test Soft Delete Using Method delete
     * {@link org.eventhub.dal.dao.CountryRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Override
    @Test
    public void testDelete(){
        Country bCountry =new Country(null,"Egypt");
        countryRepository.save(bCountry);
        Country aCountry=countryRepository.getOne(bCountry.getUuid());
        assertEquals(bCountry.getName(),aCountry.getName());
        Long count=countryRepository.count();
        countryRepository.delete(bCountry);
        assertNull(countryRepository.getOne(bCountry.getUuid()));
        assertEquals(count,(Long)countryRepository.count());
    }

    /**
     * test Soft Delete Using Method deleteByID
     * {@link org.eventhub.dal.dao.CountryRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Override
    @Test
    public void testDeleteByID(){
        Country bCountry =new Country(null,"Egypt");
        countryRepository.save(bCountry);
        Country aCountry=countryRepository.getOne(bCountry.getUuid());
        assertEquals(bCountry.getName(),aCountry.getName());
        UUID id=bCountry.getUuid();
        Long count=countryRepository.count();
        countryRepository.deleteById(id);
        assertNull(countryRepository.getOne(id));
        assertEquals(count,(Long)countryRepository.count());

    }


    /**
     * test Soft Delete Method
     * {@link org.eventhub.dal.dao.CountryRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Override
    @Test
    public void testSoftDelete(){
        Country bCountry =new Country(null,"Egypt");
        countryRepository.save(bCountry);
        Country aCountry=countryRepository.getOne(bCountry.getUuid());
        assertEquals(bCountry.getName(),aCountry.getName());
        UUID id=bCountry.getUuid();
        //System.out.println(countryRepository.count());
        countryRepository.softDelete(id);
        //System.out.println(countryRepository.count());
        assertNull(countryRepository.getOne(id));
    }




    /**
     * test findByName Method
     * {@link org.eventhub.dal.dao.CountryRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Test
    public void testFindByName(){
        Pageable pageable = PageRequest.of(0, 555555);
        Country country =new Country(null,"Egypt");
        int bSize=countryRepository.findAllByName(country.getName(),pageable).size();
        countryRepository.save(country);
        int aSize=countryRepository.findAllByName(country.getName(),pageable).size();
        assertEquals(bSize+1,aSize);
    }



    /**
     * test save Method
     * {@link org.eventhub.dal.dao.CountryRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Override
    @Test
    public void testSave(){
        Country bCountry=new Country();
        bCountry.setName("Egypt");
        countryRepository.save(bCountry);
        Country aCountry= countryRepository.findById(bCountry.getUuid()).get();
        assertEquals(aCountry.getName(),bCountry.getName());
    }
    /**
     * test findAll Deleted Method
     * {@link org.eventhub.dal.dao.CountryRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */

    @Override
    @Test
    public void testFindAllDeleted(){
        Pageable pageable = PageRequest.of(0, 555555);
        int bCount=countryRepository.findAllDeleted(pageable).size();
        Country bCountry =new Country(null,"Egypt");
        countryRepository.save(bCountry);
        countryRepository.delete(bCountry);
        assertEquals(bCount+1,countryRepository.findAllDeleted(pageable).size());
    }
    /**
     * test findAll Method
     * {@link org.eventhub.dal.dao.CountryRepository}
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @Override
    @Test
    public void testFindAll(){
        Pageable pageable = PageRequest.of(0, 555555);
        int bCount=countryRepository.findAll().size();
        Country country =new Country(null,"Egypt");
        countryRepository.save(country);
        int aCount=countryRepository.findAll().size();
        assertEquals(bCount+1,aCount);
    }

    @Override
    @Test
    public void testUpdate(){
        Country bCountry =new Country(null,"Egypt");
        countryRepository.save(bCountry);
        Country aCountry=countryRepository.getOne(bCountry.getUuid());
        aCountry.setName("US");
        countryRepository.update(aCountry);
        bCountry=countryRepository.getOne(bCountry.getUuid());
        assertEquals(bCountry.getName(),aCountry.getName());

    }
}

