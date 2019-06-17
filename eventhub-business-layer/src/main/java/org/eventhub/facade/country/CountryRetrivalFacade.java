package org.eventhub.facade.country;

import org.eventhub.common.model.entity.Country;

import java.util.List;
import java.util.UUID;

public interface CountryRetrivalFacade {

    Country getById(UUID uuid);

    List<Country> getCountries();
}
