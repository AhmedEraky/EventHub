package org.eventhub.web.controller.temp;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.country.CountryFacade;
import org.eventhub.facade.user.RetrieveUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping
public class TempController {
    @Autowired
    CountryFacade countryFacade;
    @Autowired
    RetrieveUserFacade retrieveUserFacade;

    @RequestMapping(method = RequestMethod.GET,path = "/form")
    public String getTempForm(Model model, HttpSession httpSession){
        SystemUser currentSystemUser= (SystemUser) httpSession.getAttribute("user");
        SystemUser systemUser=retrieveUserFacade.getUserByUUID(currentSystemUser.getUuid());
        systemUser.setSystemUserPhones(new ArrayList<>());
        model.addAttribute("systemUser",systemUser);
        return "formTemp";
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

}
