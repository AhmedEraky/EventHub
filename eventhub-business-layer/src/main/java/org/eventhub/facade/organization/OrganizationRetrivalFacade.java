package org.eventhub.facade.organization;

import org.eventhub.common.model.entity.Organization;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Mohamed Elhoseny (mohamed.elhosany1995@gmail.com)
 */
public interface OrganizationRetrivalFacade
{
    List<Organization> getOrganization();
    Organization getOrganizationByUUID(UUID uuid);
}
