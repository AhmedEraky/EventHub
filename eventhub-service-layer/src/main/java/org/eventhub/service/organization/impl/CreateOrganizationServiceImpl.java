package org.eventhub.service.organization.impl;

import org.eventhub.common.model.entity.Organization;
import org.eventhub.dal.dao.OrganizationRepository;
import org.eventhub.service.organization.CreateOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohamed Elhoseny (mohamed.elhosany1995@gmail.com)
 */
@Service
public class CreateOrganizationServiceImpl implements CreateOrganizationService
{
    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public void updateOrganization(Organization organization) {
        organizationRepository.update(organization);
    }
}
