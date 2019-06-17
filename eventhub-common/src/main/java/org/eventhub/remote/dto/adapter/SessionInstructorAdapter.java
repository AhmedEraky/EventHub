package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.SessionInstructor;
import org.eventhub.remote.dto.SessionInstructorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionInstructorAdapter extends GenericAdapter<SessionInstructor ,SessionInstructorDTO> {

	@Autowired
	InstructorAdapter instructorAdapter;
	@Autowired
	SessionAdapter sessionAdapter;
	@Autowired
	MaterialAdapter materialAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(instructorAdapter, sessionAdapter, materialAdapter);
	}
	
	public SessionInstructorDTO toSessionInstructorDTO(SessionInstructor sessionInstructor) {
		return toDTO(sessionInstructor);
	}
	
	public SessionInstructor fromSessionInstructorDTO(SessionInstructorDTO sessionInstructorDTO) {
		return fromDTO(sessionInstructorDTO);
	}
	
}
