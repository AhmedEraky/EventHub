package org.eventhub.remote.dto.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Hall;
import org.eventhub.remote.dto.HallDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HallAdapter extends GenericAdapter<Hall, HallDTO> {
	
	@Autowired
	EventAdapter eventAdapter;
	@Autowired
	SessionInHallAdapter sessionInHallAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(eventAdapter, sessionInHallAdapter);
	}
	
	public HallDTO toHallDTO(Hall hall) {
		return toDTO(hall);
	}
	
	public Hall fromHallDTO(HallDTO hallDTO) {
		return fromDTO(hallDTO);
	}

}
