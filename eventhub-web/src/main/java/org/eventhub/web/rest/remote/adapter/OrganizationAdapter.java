package org.eventhub.web.rest.remote.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Organization;
import org.eventhub.web.rest.remote.dto.OrganizationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationAdapter extends GenericAdapter<Organization, OrganizationDTO> {

	@Autowired
	SystemUserAdapter systemUserAdapter;
	@Autowired
	EventAdapter eventAdapter;
	@Autowired
	VipAdapter VipAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(systemUserAdapter, eventAdapter);
	}
	
	public OrganizationDTO toOrganizationDTO(Organization organization) {
		return toDTO(organization);
	}
	
	public Organization fromOrganizationDTO(OrganizationDTO organizationDTO) {
		return fromDTO(organizationDTO);
	}
	
}
