package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.EventGuest;
import org.eventhub.remote.dto.EventGuestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventGuestAdapter extends GenericAdapter<EventGuest, EventGuestDTO> {

	@Autowired
	EventAdapter eventAdapter;
	@Autowired
	SystemUserAdapter systemUserAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(eventAdapter, systemUserAdapter);
	}
	
	public EventGuestDTO toEventGuestDTO(EventGuest eventGuest) {
		return toDTO(eventGuest);
	}
	
	public EventGuest fromEventGuestDTO(EventGuestDTO eventGuestDTO) {
		return fromDTO(eventGuestDTO);
	}
	
}
