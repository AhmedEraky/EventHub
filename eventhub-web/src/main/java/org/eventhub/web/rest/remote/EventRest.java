package org.eventhub.web.rest.remote;

import org.eventhub.common.model.entity.Event;
import org.eventhub.facade.event.EventManagementFacade;
import org.eventhub.facade.event.EventRetrivalFacade;
import org.eventhub.web.rest.remote.dto.EventDTO;
import org.eventhub.web.rest.remote.dto.JResponse;
import org.eventhub.web.rest.remote.adapter.EventAdapter;
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
            eventDTOS.add(eventAdapter.toEventDTO(event));
        }
        return eventDTOS;
    }

    @PostMapping("/event")
    public JResponse<EventDTO> addEvent(@RequestBody EventDTO eventDTO){
        JResponse<EventDTO> eventResponse=new JResponse<>();
        Event event=eventAdapter.fromEventDTO(eventDTO);

        try {
            eventManagementFacade.createEvent(event);
            eventResponse.setDtoContent(eventDTO);
            eventResponse.setStatus("Success");
        }catch (Exception e){
            eventResponse.setStatus("Fail");
            eventResponse.setDtoContent(new EventDTO());
        }
        return eventResponse;
    }

}
