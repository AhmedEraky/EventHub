package org.eventhub.web.convertor;

import org.eventhub.common.model.entity.Country;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class CountryConverter implements Converter<String, Country> {
    @Override
    public Country convert(String countryUUID) {
        Country country=new Country();
        country.setUuid(UUID.fromString(countryUUID));
        return country;
    }
}
