package org.eventhub.web.controller;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import org.eventhub.common.util.ImagePathProviderUtil;
import org.eventhub.facade.dto.SystemUserDTO;

@Controller
@RequestMapping
@MultipartConfig(location = ImagePathProviderUtil.SYSTEM_USERS_IMAGES_PATH)
public class UserController {

    @Autowired
    CreateUserFacade createUserFacade;
    @Autowired
    CountryFacade countryFacade;

    @RequestMapping(method = RequestMethod.GET, path = "/signup")
    public String getBody(Model model) {
        model.addAttribute("systemUser", new SystemUserDTO());
        model.addAttribute("countries", countryFacade.getCountries());
        return "signUp";
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/signup")
    protected String onSubmit(@Valid @ModelAttribute("systemUser") SystemUserDTO user,
            BindingResult result) {
        if (result.hasErrors()) {
            return "signUp";
        } else {
            try {
                createUserFacade.createUser(user.getEntity(), user.getProfileImageMultipart());
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/createEvent";
        }
    }
}
