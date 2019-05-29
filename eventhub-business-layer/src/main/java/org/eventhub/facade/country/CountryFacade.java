package org.eventhub.facade.country;

import org.eventhub.common.model.entity.Country;

import java.util.List;

public interface CountryFacade {
    List<Country> getCountries();
}
