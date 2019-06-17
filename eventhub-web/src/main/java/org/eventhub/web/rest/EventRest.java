package org.eventhub.web.rest;

import org.eventhub.common.model.entity.Event;
import org.eventhub.facade.event.EventManagementFacade;
import org.eventhub.facade.event.EventRetrivalFacade;
import org.eventhub.remote.adapter.EventAdapter;
import org.eventhub.remote.dto.EventDTO;
import org.eventhub.remote.response.EventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EventRest {
    @Autowired
    EventRetrivalFacade eventFacade;
    @Autowired
    EventAdapter eventAdapter;
    @Autowired
    EventManagementFacade eventManagementFacade;

    @GetMapping("/event")
    public List<EventDTO> getEvents(){
        List<Event> events=eventFacade.getAllEvents();
        List<EventDTO> eventDTOS=new ArrayList<>();
        for (Event event:events){
            eventDTOS.add(eventAdapter.toDto(event));
        }
        return eventDTOS;
    }

    @PostMapping("/event")
    public EventResponse addEvent(@RequestBody EventDTO eventDTO){
        EventResponse eventResponse=new EventResponse();
        Event event=eventAdapter.fromDto(eventDTO);
        eventManagementFacade.createEvent(event);
        eventResponse.setDto(eventDTO);
        eventResponse.setStatus("Success");
        return eventResponse;
    }

}
