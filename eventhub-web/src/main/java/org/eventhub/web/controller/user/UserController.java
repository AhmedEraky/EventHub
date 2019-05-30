package org.eventhub.web.controller.user;

import java.io.IOException;
import org.eventhub.common.model.entity.Country;
import org.eventhub.common.model.entity.SystemUser;
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
import org.eventhub.facade.country.CountryRetrivalFacade;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    CreateUserFacade createUserFacade;
    @Autowired
    RetrieveUserFacade retrieveUserFacade;
    @Autowired
    CountryRetrivalFacade countryFacade;

    /**
     *
     * get method to display the signup form
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/signup")
    public String getBody(Model model) {
        model.addAttribute("systemUser", new SystemUser());
        return "signUp";
    }

    /**
     *
     * method to fill the country data
     * @param model
     */
    @ModelAttribute
    public void setCountry(Model model){
        model.addAttribute("countries", countryFacade.getCountries());
    }

    /**
     * To Convert data to a right format
     * @param request
     * @param binder
     * @throws Exception
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     *
     * @param user
     * @param attachement
     * @param result
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "/signup")
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

    /**
     * Get method to Display Update User Form
     * @param  model
     * @param httpSession
     * @return String
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @RequestMapping(method = RequestMethod.GET,path = "/update")
    public String getUpdateForm( Model model, HttpSession httpSession) {

        if(httpSession.getAttribute("user")!=null){
            model.addAttribute("systemUser",httpSession.getAttribute("user"));
            return "updateUser";
        }else {
            return "redirect:/login";
        }
    }


    /**
     * post method to update the user Data
     * @param user
     * @param result
     * @param httpSession
     * @return String
     * @author Ahmed Eraky (ahmedmoeraky@gmail.com)
     */
    @RequestMapping(method = RequestMethod.POST, path = "/update")
    public String onSubmit(@Valid @ModelAttribute("systemUser") SystemUser user, BindingResult result, HttpSession httpSession) {
        if (result.hasErrors()) {
            return "updateUser";
        }
        else {
            // check if user ID is same as the ID on Session
            SystemUser currentSystemUser= (SystemUser) httpSession.getAttribute("user");
            if(user.getUuid().equals(currentSystemUser.getUuid())) {
                user.setPassword(currentSystemUser.getPassword());
                createUserFacade.UpdateUser(user);
                return "redirect:/success";
            }else {
                return "redirect:/login";
            }
        }
    }


    /**
     * get method to display login form
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String getLoginForm(){
        return "login";
    }


    /**
     * get method to display login form
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/success")
    public String getSuccessPage(){
        return "success";
    }

}
