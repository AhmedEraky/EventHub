package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.remote.dto.SystemUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemUserAdapter extends GenericAdapter<SystemUser, SystemUserDTO> {

	@Autowired
	UserGenderAdapter userGenderAdapter;
	@Autowired
	SystemUserPhoneAdapter systemUserPhoneAdapter;
	@Autowired
	EventGuestAdapter eventGuestAdapter;
	@Autowired
	InstructorAdapter instructorAdapter;
	@Autowired
	SystemUserHasRoleAdapter systemUserHasRoleAdapter;
	@Autowired
	EventCoordinatorAdapter eventCoordinatorAdapter;
	@Autowired
	CountryAdapter countryAdapter;
	@Autowired
	JobTitleAdapter jobTitleAdapter;
	@Autowired
	OrganizationAdapter organizationAdapter;
	@Autowired
	EventAdapter eventAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(userGenderAdapter, systemUserPhoneAdapter, eventGuestAdapter,
				instructorAdapter, systemUserHasRoleAdapter, eventCoordinatorAdapter,
				countryAdapter, jobTitleAdapter, organizationAdapter, eventAdapter);
	}
	
	public SystemUserDTO toSystemUserDTO(SystemUser systemUser) {
		return toDTO(systemUser);
	}
	
	public SystemUser fromSystemUserDTO(SystemUserDTO systemUserDTO) {
		return fromDTO(systemUserDTO);
	}
	
}
