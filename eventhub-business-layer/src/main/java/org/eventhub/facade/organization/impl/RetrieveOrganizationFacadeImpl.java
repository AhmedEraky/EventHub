package org.eventhub.facade.organization.impl;

import org.eventhub.common.model.entity.Organization;
import org.eventhub.dal.dao.OrganizationRepository;
import org.eventhub.facade.organization.RetrieveOrganizationFacade;
import org.eventhub.service.organization.RetrieveOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component
public class RetrieveOrganizationFacadeImpl implements RetrieveOrganizationFacade
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
