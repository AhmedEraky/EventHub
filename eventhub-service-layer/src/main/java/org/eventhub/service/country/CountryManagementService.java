package org.eventhub.service.country;

import org.eventhub.common.model.entity.Country;


public interface CountryManagementService {
    void createCountry(Country country);
    void updateCountry(Country country);
}
