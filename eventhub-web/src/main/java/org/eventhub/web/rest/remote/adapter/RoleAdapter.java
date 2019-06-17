package org.eventhub.web.rest.remote.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Role;
import org.eventhub.web.rest.remote.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleAdapter extends GenericAdapter<Role, RoleDTO> {
	
	@Autowired
	PrivilegeAdapter privilegeAdapter;
	@Autowired
	RoleAdapter roleAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(privilegeAdapter, roleAdapter);
	}
	
	public RoleDTO toRoleDTO(Role role) {
		return toDTO(role);
	}
	
	public Role fromRoleDTO(RoleDTO roleDTO) {
		return fromDTO(roleDTO);
	}

}
