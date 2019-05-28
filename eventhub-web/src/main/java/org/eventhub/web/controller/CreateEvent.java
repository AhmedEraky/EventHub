package org.eventhub.web.controller;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.user.RetrieveUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/createEvent")
public class CreateEvent {

    @Autowired
    RetrieveUserFacade retrieveUserFacade;
    /**
     * Dummy Code To Add User To Session
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createEvent(HttpSession httpSession){

        SystemUser systemUser=retrieveUserFacade.getAllUsers().get(0);
        if(systemUser!=null&&httpSession.getAttribute("user")==null){
            httpSession.setAttribute("user",systemUser);
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("createEvent");
        return modelAndView;
    }
}
