package org.eventhub.facade.organization;

import org.eventhub.common.model.entity.Organization;

import java.util.List;
import java.util.UUID;

public interface RetrieveOrganizationFacade
{
    List<Organization> getOrganization();
    Organization getOrganizationByUUID(UUID uuid);
}
