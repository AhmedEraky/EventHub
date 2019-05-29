package org.eventhub.facade.organization.impl;

import org.eventhub.common.model.entity.Organization;
import org.eventhub.facade.organization.OrganizationManagementFacade;
import org.eventhub.service.organization.CreateOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mohamed Elhoseny (mohamed.elhosany1995@gmail.com)
 */
@Component
public class OrganizationManagementFacadeImpl implements OrganizationManagementFacade
{
    @Autowired
    private CreateOrganizationService organizationService;

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationService.createOrganization(organization);
    }

    @Override
    public void updateOrganization(Organization organization) {
        organizationService.updateOrganization(organization);
    }
}
