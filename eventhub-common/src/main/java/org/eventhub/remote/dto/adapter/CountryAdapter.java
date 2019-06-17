package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Country;
import org.eventhub.remote.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryAdapter extends GenericAdapter<Country, CountryDTO> {
	
	@Autowired
	SystemUserAdapter SystemUserAdapter;

	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(SystemUserAdapter);
	}
	
	public CountryDTO toCountryDTO(Country country) {
		return toDTO(country);
	}
	
	public Country fromCountryDTO(CountryDTO countryDTO) {
		return fromDTO(countryDTO);
	}

}
