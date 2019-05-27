package org.eventhub.web.controller;

import org.eventhub.common.model.entity.Country;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.country.CountryFacade;
import org.eventhub.facade.user.CreateUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    CreateUserFacade createUserFacade;
    @Autowired
    CountryFacade countryFacade;


    @RequestMapping(method = RequestMethod.GET,path = "/signup")
    public String getBody(Model model) {
        model.addAttribute("systemUser", new SystemUser());
        model.addAttribute("countries",countryFacade.getCountries());
        return "signUp";
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @RequestMapping(method = RequestMethod.POST,path = "/signup")
    protected String onSubmit(@Valid @ModelAttribute("systemUser") SystemUser user, BindingResult result) {
        if (result.hasErrors()){
            return "signUp";
        }else {
            createUserFacade.createUser(user);
            return "redirect:/createEvent";
        }
    }
}
