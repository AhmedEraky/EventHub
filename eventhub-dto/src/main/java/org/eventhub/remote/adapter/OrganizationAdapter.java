/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.adapter;

import org.eventhub.common.model.entity.BaseEntity;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.remote.dto.BaseDTO;
import org.eventhub.remote.dto.OrganizationDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author FARES-LAP
 */
@Component
public class OrganizationAdapter implements DtoAdapter<Organization, OrganizationDTO> {

    @Override
    public Organization fromDto(OrganizationDTO baseDTO) {
        return null;
    }

    @Override
    public OrganizationDTO toDto(Organization baseEntity) {
        return null;
    }
}
