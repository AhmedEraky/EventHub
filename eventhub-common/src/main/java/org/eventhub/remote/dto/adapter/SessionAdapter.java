package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Session;
import org.eventhub.remote.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionAdapter extends GenericAdapter<Session, SessionDTO> {
	
	@Autowired
	EventAdapter eventAdapter;
	@Autowired
	SessionTypeAdapter sessionTypeAdapter;
	@Autowired
	SessionInHallAdapter sessionInHallAdapter;
	@Autowired
	SessionInstructorAdapter sessionInstructorAdapter;
	@Autowired
	VipSpeaksInSessionAdapter vipSpeaksInSessionAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(eventAdapter, sessionTypeAdapter, sessionInHallAdapter,
				sessionInstructorAdapter, vipSpeaksInSessionAdapter);
	}
	
	public SessionDTO toSessionDTO(Session session) {
		return toDTO(session);
	}
	
	public Session fromSessionDTO(SessionDTO sessionDTO) {
		return fromDTO(sessionDTO);
	}

}
