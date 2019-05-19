package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.Country;
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
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class CountryRepositoryTest {

    @Autowired
    CountryRepository countryRepository;

    @Test
    public void testInsert(){
        Country country=new Country();
        country.setName("Egypt");
        countryRepository.save(country);
        Country testCountry= countryRepository.findById(country.getUuid()).get();
        assertEquals(testCountry.getName(),country.getName());
    }

    @Test
    public void testFind(){
        Country country =new Country(null,"Egypt");
        


    }

}
