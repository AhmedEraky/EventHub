package org.eventhub.remote.adapter;

import org.eventhub.common.model.entity.BaseEntity;
import org.eventhub.common.model.entity.Event;
import org.eventhub.remote.dto.BaseDTO;
import org.eventhub.remote.dto.EventDTO;
import org.springframework.stereotype.Component;

@Component
public class EventAdapter implements DtoAdapter<Event,EventDTO> {
    @Override
    public Event fromDto(EventDTO baseDTO) {
        return null;
    }

    @Override
    public EventDTO toDto(Event baseEntity) {
        EventDTO eventDTO=new EventDTO();
        eventDTO.setName(baseEntity.getName());
        eventDTO.setAddress(baseEntity.getAddress());
        return eventDTO;
    }
}
