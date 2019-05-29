package org.eventhub.facade.organization.impl;

import org.eventhub.common.model.entity.Organization;
import org.eventhub.facade.organization.OrganizationRetrivalFacade;
import org.eventhub.service.organization.RetrieveOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Mohamed Elhoseny (mohamed.elhosany1995@gmail.com)
 */
@Component
public class OrganizationRetrivalFacadeImpl implements OrganizationRetrivalFacade
{
    @Autowired
    private RetrieveOrganizationService organizationService;


    @Override
    public List<Organization> getOrganization() {
        return organizationService.getOrganization();
    }

    @Override
    public Organization getOrganizationByUUID(UUID uuid) {
        return organizationService.getOrganizationByUUID(uuid);
    }
}
