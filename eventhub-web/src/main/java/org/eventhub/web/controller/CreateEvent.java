package org.eventhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/createEvent")
public class CreateEvent {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createEvent(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("createEvent");
        return modelAndView;
    }
}
