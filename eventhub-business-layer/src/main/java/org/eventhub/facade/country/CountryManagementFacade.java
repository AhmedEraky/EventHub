package org.eventhub.facade.country;

import org.eventhub.common.model.entity.Country;


public interface CountryManagementFacade {
    void createCountry(Country country);
    void updateCountry(Country country);
}
