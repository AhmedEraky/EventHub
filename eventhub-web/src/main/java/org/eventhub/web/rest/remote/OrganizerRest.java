package org.eventhub.web.rest.remote;

import java.util.UUID;
import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.EventCoordinator;
import org.eventhub.web.rest.remote.dto.JResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.event.EventManagementFacade;
import org.eventhub.facade.event.EventRetrivalFacade;
import org.eventhub.facade.user.impl.CreateUserFacadeImpl;
import org.eventhub.service.coordinator.CoordinatorManagmentFacat;
import org.eventhub.service.user.RetrieveUserService;
import org.eventhub.web.rest.remote.adapter.EventAdapter;
import org.eventhub.web.rest.remote.adapter.SystemUserAdapter;
import org.eventhub.web.rest.remote.dto.EventCoordinatorDTO;
import org.eventhub.web.rest.remote.dto.EventDTO;
import org.eventhub.web.rest.remote.dto.SystemUserDTO;

@RestController
@RequestMapping("/api")
public class OrganizerRest {
    @Autowired
    RetrieveUserService userService;
    @Autowired
    SystemUserAdapter userAdapter;
    @Autowired
    EventCoordinator eventCoordinator;
    @Autowired
    EventRetrivalFacade eventFacade;
    @Autowired
    EventManagementFacade eventManagementFacade;
    
    @Autowired
    CoordinatorManagmentFacat coordinatorManagmentFacat;

    @PostMapping("/user")
    public JResponse<EventCoordinatorDTO> addUser(@RequestBody UUID SystemUserUuid,@RequestBody UUID eventUuid){
        JResponse<EventCoordinatorDTO> EventCoordinatorResponse=new JResponse<>();
        //SystemUser systemUser = userAdapter.fromSystemUserDTO(SystemUserDTO);
        //Event event=eventAdapter.fromEventDTO(eventDTO);
        //event.set
        try {
            SystemUser systemUser = userService.getUserByUUID(SystemUserUuid);
            Event event = eventFacade.getById(eventUuid);
            eventCoordinator.setEvent(event);
            eventCoordinator.setSystemUser(systemUser);
            coordinatorManagmentFacat.addEventCoordinator(eventCoordinator);
            EventCoordinatorResponse.setDtoContent(eventCoordinator);
            EventCoordinatorResponse.setStatus("Success");
        }catch (Exception e){
            EventCoordinatorResponse.setStatus("Fail");
            EventCoordinatorResponse.setDtoContent(new EventCoordinatorDTO());
        }
        return EventCoordinatorResponse;
    }

}
