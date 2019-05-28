package org.eventhub.web.controller;

import java.io.IOException;
import org.eventhub.common.model.entity.Country;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.country.CountryFacade;
import org.eventhub.facade.user.CreateUserFacade;
import org.eventhub.facade.user.RetrieveUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.FormParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    CreateUserFacade createUserFacade;
    @Autowired
    RetrieveUserFacade retrieveUserFacade;
    @Autowired
    CountryFacade countryFacade;

    @RequestMapping(method = RequestMethod.GET, path = "/signup")
    public String getBody(Model model) {
        model.addAttribute("systemUser", new SystemUser());
        model.addAttribute("countries", countryFacade.getCountries());
        return "signUp";
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

   /* @RequestMapping(method = RequestMethod.POST, path = "/signup")
    protected String onSubmit(@Valid @ModelAttribute("systemUser") SystemUser user,
            @FormParam("attachment") MultipartFile attachement,
            BindingResult result) {
        if (result.hasErrors()) {
            return "signUp";
        } else {
            System.out.println(attachement.getOriginalFilename());
            user.setProfileImage(attachement.getOriginalFilename());
            createUserFacade.createUser(user);
            return "redirect:/createEvent";
        }
    }
*/

    @RequestMapping(method = RequestMethod.GET,path = "/update")
    public String getupdateForm( Model model, HttpSession httpSession) {
        SystemUser systemUser=new SystemUser();
        if(httpSession.getAttribute("userID")!=null){
            UUID uuid= (UUID) httpSession.getAttribute("userID");
            systemUser=retrieveUserFacade.getUserByUUID(uuid);
        }
        model.addAttribute("countries",countryFacade.getCountries());
        model.addAttribute("systemUser",systemUser);
        return "updateUser";
    }


    @RequestMapping(method = RequestMethod.POST, path = "/update")
    protected String onSubmit(@Valid @ModelAttribute("systemUser") SystemUser user, BindingResult result) {
        if (result.hasErrors()) {
            return "updateUser";
        } else {
            createUserFacade.UpdateUser(user);
            return "redirect:/createEvent";
        }
    }
}
