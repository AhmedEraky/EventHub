package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Event;
import org.eventhub.remote.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventAdapter extends GenericAdapter<Event, EventDTO> {
	
	@Autowired
	SponsorAdapter sponsorAdapter;
	@Autowired
	SessionAdapter sessionAdapter;
	@Autowired
	HallAdapter hallAdapter;
	@Autowired
	EventGuestAdapter eventGuestAdapter;
	@Autowired
	EventCoordinatorAdapter eventCoordinatorAdapter;
	@Autowired
	OrganizationAdapter organizationAdapter;
	@Autowired
	SystemUserAdapter systemUserAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(sponsorAdapter, sessionAdapter, hallAdapter,
				eventGuestAdapter, eventCoordinatorAdapter, organizationAdapter,
				systemUserAdapter);
	}
	
	public EventDTO toEventDTO(Event event) {
		return toDTO(event);
	}
	
	public Event fromEventDTO(EventDTO eventDTO) {
		return fromDTO(eventDTO);
	}

}
