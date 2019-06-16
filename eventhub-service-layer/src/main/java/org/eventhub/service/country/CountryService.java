package org.eventhub.service.country;

import org.eventhub.common.model.entity.Country;

import java.util.List;
import java.util.UUID;

public interface CountryService {

    List<Country> getCountries();

    Country getById(UUID uuid);
}
