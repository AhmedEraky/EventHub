package org.eventhub.web.rest.remote.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.SessionInHall;
import org.eventhub.web.rest.remote.dto.SessionInHallDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionInHallAdapter extends GenericAdapter<SessionInHall, SessionInHallDTO> {

	@Autowired
	HallAdapter hallAdapter;
	@Autowired
	SessionAdapter sessionAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(hallAdapter, sessionAdapter);
	}
	
	public SessionInHallDTO toSessionInHallDTO(SessionInHall sessionInHall) {
		return toDTO(sessionInHall);
	}
	
	public SessionInHall fromSessionInHallDTO(SessionInHallDTO sessionInHallDTO) {
		return fromDTO(sessionInHallDTO);
	}
	
}
