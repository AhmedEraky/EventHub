/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.country.impl;

import org.eventhub.common.model.entity.Country;
import org.eventhub.facade.country.CountryManagementFacade;
import org.eventhub.service.country.CountryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CountryManagementFacadeImpl implements CountryManagementFacade {

    @Autowired
    CountryManagementService countryService;
    
    @Override
    public void createCountry(Country country) {
        countryService.createCountry(country);
    }

    @Override
    public void updateCountry(Country country) {
        countryService.updateCountry(country);
    }
    
}
