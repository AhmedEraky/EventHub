package org.eventhub.facade.organization;

import org.eventhub.common.model.entity.Organization;

public interface CreateOrganizationFacade
{
    Organization createOrganization(Organization organization);
    void updateOrganization(Organization organization);
}
