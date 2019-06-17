package org.eventhub.web.rest.remote.adapter;

import java.util.List;

import org.eventhub.common.model.entity.UserGender;
import org.eventhub.web.rest.remote.dto.UserGenderDTO;
import org.springframework.stereotype.Component;

@Component
public class UserGenderAdapter extends GenericAdapter<UserGender, UserGenderDTO> {

	@Override
	protected List<GenericAdapter> getAdapters() {
		return null;
	}
	
	public UserGenderDTO toUserGenderDTO(UserGender userGender) {
		return UserGenderDTO.valueOf(userGender.toString());
	}
	
	public UserGender fromUserGenderDTO(UserGenderDTO userGenderDTO) {
		return UserGender.valueOf(userGenderDTO.toString());
	}

}
