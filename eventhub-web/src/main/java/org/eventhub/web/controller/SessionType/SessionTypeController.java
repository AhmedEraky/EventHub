/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.controller.SessionType;

import javax.validation.Valid;
import org.eventhub.common.model.entity.SessionType;
import org.eventhub.facade.SessionTypeImp.SessionTypeManagmentFacadeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SessionType Controller has methods to add and update Session types on
 * database
 *
 * @author Hend Zabady (hendzabady04@gmail.com)
 */
@Controller
@RequestMapping
public class SessionTypeController {

    @Autowired
    SessionTypeManagmentFacadeImp sessionTypeManagmentFacade;

    /**
     * get method to display SessionTypes add form
     *
     * @param model
     * @return form name
     * @author Hend Zabady (hendzabady04@gmail.com)
     */
    @RequestMapping(method = RequestMethod.GET, path = "/addsessiontype")
    public String getBody(Model model) {
        model.addAttribute("sessionType", new SessionType());
        return "addsessionType";
    }

    /**
     * post method to submit SessionTypes add form
     *
     * @param type ,result
     * @return form name
     * @author Hend Zabady (hendzabady04@gmail.com)
     */
    @RequestMapping(method = RequestMethod.POST, path = "/addsessiontype")
    protected String onSubmitAdd(@Valid @ModelAttribute("sessionType") SessionType type, BindingResult result) {
        if (result.hasErrors()) {
            return "addsessionType";
        } else {
            sessionTypeManagmentFacade.addSessionType(type);
            return "redirect:/createEvent";
        }
    }

    /**
     * Get method to Display Update SessionType Form
     *
     * @param model, name
     * @return String
     * @author Hend (hendzabady04@gmail.com)
     */
    @RequestMapping(method = RequestMethod.GET, path = "/updatesessiontype")
    public String getUpdateForm(@RequestParam("name") String name, Model model) {
        SessionType sessionType = sessionTypeManagmentFacade.retriveSessionTypeByName(name);
        model.addAttribute("sessionType", sessionType);
        return "updateSessionType";
    }

    /**
     * post method to Update SessionType
     *
     * @param type
     * @param result
     * @return String
     * @author Hend (hendzabady04@gmail.com)
     */
    @RequestMapping(method = RequestMethod.POST, path = "/updatesessiontype")
    public String onSubmitUpdate(@Valid @ModelAttribute("sessionType") SessionType type, BindingResult result) {
        if (result.hasErrors()) {
            return "updateSessionType";
        } else {
            sessionTypeManagmentFacade.updateSessionType(type);
            return "redirect:/createEvent";
        }

    }
}
