package org.eventhub.web.controller.event;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.facade.event.EventManagementFacade;
import org.eventhub.facade.event.EventRetrivalFacade;
import org.springframework.ui.Model;

@Controller
public class EventController {

    @Autowired
    private EventManagementFacade managementFacade;

    @Autowired
    private EventRetrivalFacade retrivalFacade;

    @ModelAttribute(name = "organizations")
    public List<Organization> organizations() {
        Organization org = new Organization(UUID.randomUUID(), "Dummy org");
        return Arrays.asList(org);
    }

    /**
     * get method to display the add event form form
     *
     * @return
     *
     */
    @GetMapping(path = "/addEvent")
    public String addEvent(Model model) {
        model.addAttribute("event", new Event());
        return "addEvent";
    }

    /**
     *
     * @param event
     * @param result
     * @return
     */
    @PostMapping(path = "/addEvent")
    public String onAdd(@Valid @ModelAttribute("event") Event event,
            BindingResult result) {
        if (result.hasErrors()) {
            return "addEvent";
        } else {
            managementFacade.createEvent(event);
            return "redirect:addEvent?success&id=" + event.getUuid().toString();
        }
    }

    @GetMapping(path = "/editEvent")
    public String editEvent(Model model, @RequestParam("id") String id) {
        UUID uuid = UUID.fromString(id);
        model.addAttribute("event", retrivalFacade.getById(uuid));
        return "editEvent";
    }

    @PostMapping(path = "/editEvent")
    public String onEdit(@Valid @ModelAttribute("event") Event event,
            BindingResult result) {
        if (result.hasErrors()) {
            return "editEvent";
        } else {
            managementFacade.updateEvent(event);
            return "redirect:editEvent?success&id=" + event.getUuid().toString();
        }
    }
}
