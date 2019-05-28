package org.eventhub.web.controller.country;

import org.eventhub.common.model.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.FormParam;
import org.eventhub.facade.country.CountryManagementFacade;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping
public class CountryController {
    
    @Autowired
    CountryManagementFacade countryFacade;

    /**
     * get method to display the add country form form
     * @return
     * 
     */
    @GetMapping(path = "/addCountry")
    public String addCountry() {
        return "addCountry";
    }

    /**
     *
     * @param user
     * @param attachement
     * @param result
     * @return
     */
    @PostMapping(path = "/addCountry")
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
}
