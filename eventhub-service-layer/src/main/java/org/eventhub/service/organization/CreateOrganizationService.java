package org.eventhub.service.organization;

import org.eventhub.common.model.entity.Organization;

public interface CreateOrganizationService
{
    Organization createOrganization(Organization organization);
    void updateOrganization(Organization organization);
}
