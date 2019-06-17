package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Instructor;
import org.eventhub.remote.dto.InstructorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstructorAdapter extends GenericAdapter<Instructor, InstructorDTO> {
	
	@Autowired
	SessionInstructorAdapter sessionInstructorAdapter;
	@Autowired
	SystemUserAdapter systemUserAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(sessionInstructorAdapter, systemUserAdapter);
	}
	
	public InstructorDTO toInstructorDTO(Instructor instructor) {
		return toDTO(instructor);
	}
	
	public Instructor fromInstructorDTO(InstructorDTO instructorDTO) {
		return fromDTO(instructorDTO);
	}

}
