package org.eventhub.service.organization.impl;

import org.eventhub.common.model.entity.Organization;
import org.eventhub.dal.dao.OrganizationRepository;
import org.eventhub.service.organization.RetrieveOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RetrieveOrganizationServiceImpl implements RetrieveOrganizationService
{
    @Autowired
    private OrganizationRepository organizationRepository;


    @Override
    public List<Organization> getOrganization() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getOrganizationByUUID(UUID uuid) {
        return organizationRepository.findById(uuid).get();
    }
}
