/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.country.impl;

import org.eventhub.common.model.entity.Country;
import org.eventhub.dal.dao.CountryRepository;
import org.eventhub.service.country.CountryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryManagementServiceImpl implements CountryManagementService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public void createCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void updateCountry(Country country) {
        countryRepository.save(country);
    }

}
