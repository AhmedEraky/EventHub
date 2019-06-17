package org.eventhub.web.rest.remote;

import org.eventhub.common.model.entity.Event;
import org.eventhub.facade.event.EventManagementFacade;
import org.eventhub.facade.event.EventRetrivalFacade;
import org.eventhub.web.rest.remote.dto.EventDTO;
import org.eventhub.web.rest.remote.dto.JResponse;
import org.eventhub.web.rest.remote.adapter.EventAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eraky
 */
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
    public JResponse<List<EventDTO>> getEvents(){
        List<Event> events=eventFacade.getAllEvents();
        List<EventDTO> eventDTOS=new ArrayList<>();
        for (Event event:events){
            eventDTOS.add(eventAdapter.toEventDTO(event));
        }
        JResponse<List<EventDTO>> listJResponse=new JResponse<>();
        listJResponse.setDtoContent(eventDTOS);
        listJResponse.setStatus("Success");
        return listJResponse;
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

    @PutMapping("/event")
    public JResponse<EventDTO> updateEvent(@RequestBody EventDTO eventDTO){
        JResponse<EventDTO> eventDTOJResponse=new JResponse<>();
        Event event=eventFacade.getById(eventDTO.getUuid());
        for (Field field : eventDTO.getClass().getDeclaredFields())
        {
            field.setAccessible(true);
            try {
                if(field.get(eventDTO)!=null){
                    event.getClass().getMethod("set"+Character.toUpperCase(field.getName().charAt(0))+field.getName().substring(1),field.getType()).invoke(event,field.get(eventDTO));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        try {
            eventManagementFacade.updateEvent(event);
            event=eventFacade.getById(eventDTO.getUuid());
            EventDTO dto=eventAdapter.toEventDTO(event);
            eventDTOJResponse.setDtoContent(dto);
            eventDTOJResponse.setStatus("Success");
        }catch (Exception e){
            eventDTOJResponse.setStatus("Fail");
        }
        return eventDTOJResponse;

    }



}
