package org.eventhub.facade.country.impl;

import org.eventhub.common.model.entity.Country;
import org.eventhub.facade.country.CountryFacade;
import org.eventhub.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryFacadeImpl implements CountryFacade {
    @Autowired
    CountryService countryService;
    @Override
    public List<Country> getCountries() {
        return countryService.getCountries();
    }
}
