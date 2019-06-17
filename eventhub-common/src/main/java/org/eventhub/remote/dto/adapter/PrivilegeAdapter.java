package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Privilege;
import org.eventhub.remote.dto.PrivilegeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrivilegeAdapter extends GenericAdapter<Privilege, PrivilegeDTO> {
	
	@Autowired
	RolePrivilegeAdapter rolePrivilegeAdapter;

	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(rolePrivilegeAdapter);
	}
	
	public PrivilegeDTO toPrivilegeDTO(Privilege privilege) {
		return toDTO(privilege);
	}
	
	public Privilege fromPrivilegeDTO(PrivilegeDTO privilegeDTO) {
		return fromDTO(privilegeDTO);
	}

}
