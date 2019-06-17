package org.eventhub.web.rest.remote.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.SessionType;
import org.eventhub.web.rest.remote.dto.SessionTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionTypeAdapter extends GenericAdapter<SessionType, SessionTypeDTO> {

	@Autowired
	SessionAdapter sessionAdapter;

	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(sessionAdapter);
	}
	
	public SessionTypeDTO toSessionTypeDTO(SessionType sessionType) {
		return toDTO(sessionType);
	}
	
	public SessionType fromSessionTypeDTO(SessionTypeDTO sessionTypeDTO) {
		return fromDTO(sessionTypeDTO);
	}
	
}
