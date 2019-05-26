package org.eventhub.web.convertor;

import org.eventhub.common.model.entity.Country;
import org.springframework.core.convert.converter.Converter;

public class CountryConverter implements Converter<String, Country> {
    @Override
    public Country convert(String countryName) {
        Country country=new Country();
        country.setName(countryName);
        return country;
    }
}
