package org.eventhub.web.rest.remote.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.RolePrivilege;
import org.eventhub.web.rest.remote.dto.RolePrivilegeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolePrivilegeAdapter extends GenericAdapter<RolePrivilege, RolePrivilegeDTO> {

	@Autowired
	PrivilegeAdapter privilegeAdapter;
	@Autowired
	RoleAdapter roleAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(privilegeAdapter, roleAdapter);
	}
	
	public RolePrivilegeDTO toRolePrivilegeDTO(RolePrivilege rolePrivilege) {
		return toDTO(rolePrivilege);
	}
	
	public RolePrivilege fromRolePrivilegeDTO(RolePrivilegeDTO rolePrivilegeDTO) {
		return fromDTO(rolePrivilegeDTO);
	}
	
}
