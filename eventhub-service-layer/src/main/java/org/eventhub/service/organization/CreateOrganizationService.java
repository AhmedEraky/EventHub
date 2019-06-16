package org.eventhub.service.organization;

import org.eventhub.common.model.entity.Organization;

/**
 *
 * @author Mohamed Elhoseny (mohamed.elhosany1995@gmail.com)
 */
public interface CreateOrganizationService
{
    Organization createOrganization(Organization organization);
    void updateOrganization(Organization organization);
}
