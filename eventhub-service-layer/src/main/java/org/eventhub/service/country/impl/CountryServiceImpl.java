package org.eventhub.service.country.impl;

import org.eventhub.common.model.entity.Country;
import org.eventhub.dal.dao.CountryRepository;
import org.eventhub.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(UUID uuid) {
        return countryRepository.findById(uuid).get();
    }
}
