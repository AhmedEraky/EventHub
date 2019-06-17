package org.eventhub.web.rest.remote;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.eventhub.common.model.entity.Country;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.web.config.AppConfig;
import org.eventhub.web.rest.remote.adapter.CountryAdapter;
import org.eventhub.web.rest.remote.dto.CountryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
public class CountryDTOTest {

	@Autowired
	CountryAdapter countryAdapter;

	@Test
	public void testCountry() {
		Country country = new Country();
		country.setUuid(UUID.randomUUID());
		country.setName("country");
		SystemUser systemUser = new SystemUser();
		systemUser.setCountry(country);
		List<SystemUser> systemUserList = new ArrayList<>();
		systemUserList.add(systemUser);
		country.setSystemUsers(systemUserList);
		CountryDTO countryDTO = countryAdapter.toCountryDTO(country);
		assertEquals(country.getUuid(), countryDTO.getUuid());
		assertEquals(country.getName(), countryDTO.getName());
		assertNull(countryDTO.getSystemUsers().get(0).getCountry());
		Country country2 = countryAdapter.fromCountryDTO(countryDTO);
		assertEquals(country.getUuid(), country2.getUuid());
		assertEquals(country.getName(), country2.getName());
		assertNull(country2.getSystemUsers().get(0).getCountry());
	}

}
