/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.convertor;

import java.util.UUID;
import org.eventhub.common.model.entity.Organization;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
public class OrganizationConverter implements Converter<String, Organization> {

    @Override
    public Organization convert(String id) {
        return new Organization(UUID.fromString(id));
    }

}
