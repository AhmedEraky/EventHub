package org.eventhub.web.rest.remote.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.EventCoordinator;
import org.eventhub.web.rest.remote.dto.EventCoordinatorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventCoordinatorAdapter extends GenericAdapter<EventCoordinator, EventCoordinatorDTO> {

	@Autowired
	EventAdapter eventAdapter;
	@Autowired
	SystemUserAdapter systemUserAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(eventAdapter, systemUserAdapter);
	}
	
	public EventCoordinatorDTO toEventCoordinatorDTO(EventCoordinator eventCoordinator) {
		return toDTO(eventCoordinator);
	}
	
	public EventCoordinator fromEventCoordinator(EventCoordinatorDTO eventCoordinatorDTO) {
		return fromDTO(eventCoordinatorDTO);
	}
	
}
