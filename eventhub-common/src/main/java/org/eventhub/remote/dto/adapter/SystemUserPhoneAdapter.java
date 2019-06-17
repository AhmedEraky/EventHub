package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.SystemUserPhone;
import org.eventhub.remote.dto.SystemUserPhoneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemUserPhoneAdapter extends GenericAdapter<SystemUserPhone, SystemUserPhoneDTO> {

	@Autowired
	SystemUserAdapter systemUserAdapter;

	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(systemUserAdapter);
	}
	
	public SystemUserPhoneDTO toSystemUserPhoneDTO(SystemUserPhone systemUserPhone) {
		return toDTO(systemUserPhone);
	}
	
	public SystemUserPhone fromSystemUserPhoneDTO(SystemUserPhoneDTO systemUserPhoneDTO) {
		return fromDTO(systemUserPhoneDTO);
	}
	
}
