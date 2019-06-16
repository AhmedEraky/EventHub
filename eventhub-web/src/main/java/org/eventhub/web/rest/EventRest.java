package org.eventhub.web.rest;

import org.eventhub.common.model.entity.Event;
import org.eventhub.facade.event.EventFacade;
import org.eventhub.facade.event.EventRetrivalFacade;
import org.eventhub.remote.adapter.EventAdapter;
import org.eventhub.remote.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/api")
public class EventRest {
    @Autowired
    EventRetrivalFacade eventFacade;
    @Autowired
    EventAdapter eventAdapter;

    @GetMapping("event")
    public List<EventDTO> getEvents(){
        List<Event> events=eventFacade.getAllEvents();
        List<EventDTO> eventDTOS=new ArrayList<>();
        for (Event event:events){
            eventDTOS.add(eventAdapter.toDto(event));
        }
        return eventDTOS;
    }
}
