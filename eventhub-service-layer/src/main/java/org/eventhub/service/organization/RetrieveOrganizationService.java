package org.eventhub.service.organization;

import org.eventhub.common.model.entity.Organization;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Mohamed Elhoseny (mohamed.elhosany1995@gmail.com)
 */
public interface RetrieveOrganizationService
{
    List<Organization> getOrganization();
    Organization getOrganizationByUUID(UUID uuid);
}
