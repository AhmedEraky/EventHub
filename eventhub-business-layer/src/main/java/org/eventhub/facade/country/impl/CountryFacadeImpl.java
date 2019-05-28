package org.eventhub.facade.country.impl;

import org.eventhub.common.model.entity.Country;
import org.eventhub.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import org.eventhub.facade.country.CountryRetrivalFacade;

@Component
public class CountryFacadeImpl implements CountryRetrivalFacade {

    @Autowired
    CountryService countryService;

    @Override
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @Override
    public Country getById(UUID uuid) {
        return countryService.getById(uuid);
    }
}
