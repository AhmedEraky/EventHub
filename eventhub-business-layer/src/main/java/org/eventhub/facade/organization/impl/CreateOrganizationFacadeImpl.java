package org.eventhub.facade.organization.impl;

import org.eventhub.common.model.entity.Organization;
import org.eventhub.dal.dao.OrganizationRepository;
import org.eventhub.facade.organization.CreateOrganizationFacade;
import org.eventhub.service.organization.CreateOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CreateOrganizationFacadeImpl implements CreateOrganizationFacade
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
