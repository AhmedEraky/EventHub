package org.eventhub.web.controller.eventguest;

import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.EventGuest;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.EventGuestFacade.EventGuestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * MVC Controller for Event Guest Entity
 * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
 */


@Controller
@RequestMapping
public class EventGuestController {

    @Autowired
    EventGuestFacade eventGuestFacade;

    /**
     * get method to create Event Guest
     * @param model model of the MVC controller
     * @param eventId event id of the Event Guest
     * @param guestId guest id of the Event Guest
     * @return {@link String}  logical name of the create event guest view
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @RequestMapping(method = RequestMethod.GET, path = "/addEventGuest", params = {"eventid","guestid"})
    public String getBody(Model model, @RequestParam("eventid") UUID eventId
            , @RequestParam("guestid") UUID guestId) {
        model.addAttribute("eventGuest", new EventGuest());
        return "createEventGuest";
    }

    /**
     * To Convert data to a right format
     * @param binder servlet request binder
     * @throws Exception
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @InitBinder
    protected void initBinder(ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * post method to create Event Guest
     * @param eventGuest event guest model attribute to create
     * @param eventId event id of the Event Guest
     * @param guestId guest id of the Event Guest
     * @param result binding result in case of errors
     * @return {@link String}  logical name of the create event guest view
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @RequestMapping(method = RequestMethod.POST, path = "/addEventGuest", params = {"eventid","guestid"})
    protected String onSubmit(@Valid @ModelAttribute("eventGuest") EventGuest eventGuest
            , @RequestParam("eventid") UUID eventId, @RequestParam("guestid") UUID guestId,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "createEventGuest";
        } else {
            eventGuest.setSystemUser(new SystemUser());
            eventGuest.getSystemUser().setUuid(guestId);
            eventGuest.setEvent(new Event());
            eventGuest.getEvent().setUuid(eventId);

            eventGuestFacade.createEventGuest(eventGuest);
            return "redirect:/createEvent";
        }
    }

    /**
     * get method to update Event Guest
     * @param model model of the MVC controller
     * @param eventId event id of the Event Guest
     * @param guestId guest id of the Event Guest
     * @param eventguestid event guest id to be update
     * @return {@link String}  logical name of the update event guest view
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @RequestMapping(method = RequestMethod.GET, path = "/updateEventGuest/{eventguestid}", params = {"eventid","guestid"})
    public String getUpdateForm(Model model,@PathVariable("eventguestid") UUID eventguestid
            , @RequestParam("eventid") UUID eventId, @RequestParam("guestid") UUID guestId) {
        EventGuest eventGuest = eventGuestFacade.getEventGuest(eventguestid);
        model.addAttribute("eventGuest", eventGuest);
        return "updateEventGuest";
    }


    /**
     * post method to update Event Guest
     * @param model model of the MVC controller
     * @param eventGuest event guest model attribute to create
     * @param eventId event id of the Event Guest
     * @param guestId guest id of the Event Guest
     * @param result binding result in case of errors
     * @return {@link String}  logical name of the create event guest view
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @RequestMapping(method = RequestMethod.POST,path = "/updateEventGuest/{eventguestid}", params = {"eventid","guestid"})
    public String onSubmit(@Valid @ModelAttribute("eventGuest") EventGuest eventGuest, BindingResult result, Model model
            , @RequestParam("eventid") UUID eventId, @RequestParam("guestid") UUID guestId) {
        if (result.hasErrors()) {
            model.addAttribute("path", "updateEventGuest/" + eventGuest.getUuid()
                    + "?eventid=" + eventId + "guestid=" + guestId);
            return "updateEventGuest";
        }
        else {
            eventGuest.setSystemUser(new SystemUser());
            eventGuest.getSystemUser().setUuid(guestId);
            eventGuest.setEvent(new Event());
            eventGuest.getEvent().setUuid(eventId);
            eventGuestFacade.updateEventGuest(eventGuest);
            return "redirect:/createEvent";
        }
    }

}