package org.eventhub.web.controller.hall;


import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.Hall;
import org.eventhub.facade.hall.HallManagementFacade;
import org.eventhub.facade.hall.HallRetrivalFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.UUID;

/**
 *
 * @author Islam El-Rougy
 */

@Controller
@RequestMapping
public class HallController
{
    @Autowired
    HallRetrivalFacade hallRetrivalFacade;
    @Autowired
    HallManagementFacade hallManagementFacade;

    /**
     *
     * get method to display the add hall form
     * @param eventId the id of the event taking place in th hall
     * @param model
     * @return the add hall form logical view name
     */
    @RequestMapping(method = RequestMethod.GET, path = "/addHall")
    public String getBody(@RequestParam("id") UUID eventId, Model model)
    {
        Hall hall = new Hall();
        Event event = new Event();
        event.setUuid(eventId);
        hall.setEvent(event);
        model.addAttribute("hall", hall);
        return "addhall";
    }

    /**
     *
     * post method to add a new hall
     * @param hall the hall to be added
     * @param result
     * @return String the logical view name
     */
    @RequestMapping(method = RequestMethod.POST, path = "/addHall")
    protected String onSubmit(@Valid @ModelAttribute("hall") Hall hall, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "addhall";
        }
        else
        {
            hallManagementFacade.creatHall(hall);
            return "redirect:/createEvent";
        }
    }

    /**
     *
     * get method to display the update hall form
     * @param hallId the id of the hall to be updated
     * @param model
     * @return String the logical view name
     */
    @RequestMapping(method = RequestMethod.GET, path = "/updateHall")
    public String updateBody(@RequestParam("id") UUID hallId, Model model)
    {
        Hall hall = hallRetrivalFacade.getHallById(hallId);
        model.addAttribute("hall", hall);
        return "updatehall";
    }

    /*@RequestMapping(method = RequestMethod.POST, path = "/updateHall")
    public String onUpdateSubmit(@Valid @ModelAttribute("hall") Hall hall, BindingResult result)
    {

    }*/

}
