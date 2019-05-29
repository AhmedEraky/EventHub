package org.eventhub.service.organization;

import org.eventhub.common.model.entity.Organization;

import java.util.List;
import java.util.UUID;

public interface RetrieveOrganizationService
{
    List<Organization> getOrganization();
    Organization getOrganizationByUUID(UUID uuid);
}
