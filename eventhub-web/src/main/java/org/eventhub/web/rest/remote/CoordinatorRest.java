//package org.eventhub.web.rest.remote;
//
//import org.eventhub.common.model.entity.Event;
//import org.eventhub.common.model.entity.EventCoordinator;
//import org.eventhub.web.rest.remote.dto.JResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import org.eventhub.common.model.entity.SystemUser;
//import org.eventhub.facade.event.EventRetrivalFacade;
//import org.eventhub.service.coordinator.CoordinatorManagmentFacat;
//import org.eventhub.service.user.RetrieveUserService;
//import org.eventhub.web.convertor.NewCoordinatorObject;
//import org.eventhub.web.rest.remote.adapter.EventCoordinatorAdapter;
//import org.eventhub.web.rest.remote.dto.EventCoordinatorDTO;
//
//@RestController
//@RequestMapping("/api")
//public class CoordinatorRest {
//    @Autowired
//    RetrieveUserService userService;
//    @Autowired
//    EventCoordinatorAdapter coordinatorAdapter;
//    @Autowired
//    EventCoordinator eventCoordinator;
//    @Autowired
//    EventRetrivalFacade eventFacade; 
//    @Autowired
//    CoordinatorManagmentFacat coordinatorManagmentFacat;
//
//    @PostMapping("/coordinator")
//    public JResponse<EventCoordinatorDTO> addCoordinator(@RequestBody("newCoordinator") NewCoordinatorObject coordinator){
//        JResponse<EventCoordinatorDTO> EventCoordinatorResponse=new JResponse<>();
//        try {
//            SystemUser systemUser = userService.getUserByEmail(coordinator.getEmail());
//            Event event = eventFacade.getById(coordinator.getEventUuid());
//            eventCoordinator.setEvent(event);
//            eventCoordinator.setSystemUser(systemUser);
//            coordinatorManagmentFacat.addEventCoordinator(eventCoordinator);
//            EventCoordinatorResponse.setDtoContent(coordinatorAdapter.toEventCoordinatorDTO(eventCoordinator));
//            EventCoordinatorResponse.setStatus("Success");
//        }catch (Exception e){
//            EventCoordinatorResponse.setStatus("Fail");
//            EventCoordinatorResponse.setDtoContent(new EventCoordinatorDTO());
//        }
//        return EventCoordinatorResponse;
//    }
//
//}
