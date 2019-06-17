package org.eventhub.web.rest.remote.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.SystemUserHasRole;
import org.eventhub.web.rest.remote.dto.SystemUserHasRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemUserHasRoleAdapter extends GenericAdapter<SystemUserHasRole, SystemUserHasRoleDTO> {

	@Autowired
	RoleAdapter roleAdapter;
	@Autowired
	SystemUserAdapter systemUserAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(roleAdapter, systemUserAdapter);
	}
	
	public SystemUserHasRoleDTO toSystemUserHasRoleDTO(SystemUserHasRole systemUserHasRole) {
		return toDTO(systemUserHasRole);
	}
	
	public SystemUserHasRole fromSystemUserHasRoleDTO(SystemUserHasRoleDTO systemUserHasRoleDTO) {
		return fromDTO(systemUserHasRoleDTO);
	}
	
}
