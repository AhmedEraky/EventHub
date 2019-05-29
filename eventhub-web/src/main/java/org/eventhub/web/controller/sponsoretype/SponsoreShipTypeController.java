package org.eventhub.web.controller.sponsoretype;

import org.eventhub.common.model.entity.SponsorshipType;
import org.eventhub.facade.sponsoretype.SponsoreTypeFacade;
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
import java.util.UUID;

/**
 * MVC Controller for Sponsore Ship Type Entity
 * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
 */

@Controller
@RequestMapping
public class SponsoreShipTypeController {

    @Autowired
    SponsoreTypeFacade sponsoreTypeFacade;

    /**
     * get method to create sponsore ship type
     * @param model model of the MVC controller
     * @return {@link String}  logical name of the create sponsore ship type view
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @RequestMapping(method = RequestMethod.GET, path = "/addSponsoreType")
    public String getBody(Model model) {
        model.addAttribute("sponsoreShipType", new SponsorshipType());
        return "createSponsoreType";
    }

    /**
     * To Convert data to a right format
     * @param binder servlet request binder
     * @throws Exception
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * post method to create Sponsore Ship Type
     * @param sponsorshipType sponsore ship type model attribute to create
     * @param result binding result in case of errors
     * @return {@link String}  logical name of the create sponsore ship type view
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @RequestMapping(method = RequestMethod.POST, path = "/addSponsoreType")
    protected String onSubmit(@Valid @ModelAttribute("sponsoreShipType") SponsorshipType sponsorshipType,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "createSponsoreType";
        } else {
            sponsoreTypeFacade.createSponsoreType(sponsorshipType);
            return "redirect:/createEvent";
        }
    }

    /**
     * get method to update Event Guest
     * @param model model of the MVC controller
     * @param sponsoretypeid sponsore ship type id of the Sponsore Ship Type
     * @return {@link String}  logical name of the update Sponsore Ship Type view
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @RequestMapping(method = RequestMethod.GET,path = "/updateSponsoreType/{sponsoretypeid}")
    public String getUpdateForm(Model model,@PathVariable("sponsoretypeid") UUID sponsoretypeid) {
        SponsorshipType sponsorshipType = sponsoreTypeFacade.getSponsoreType(sponsoretypeid);
        model.addAttribute("sponsoreShipType", sponsorshipType);
        return "updateSponsoreType";
    }


    /**
     * post method to update Event Guest
     * @param model model of the MVC controller
     * @param sponsorshipType Sponsore Ship Type model attribute to create
     * @param result binding result in case of errors
     * @return {@link String}  logical name of the create event guest view
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @RequestMapping(method = RequestMethod.POST, path = "/updateSponsoreType/{sponsoretypeid}")
    public String onSubmit(@Valid @ModelAttribute("sponsoreShipType") SponsorshipType sponsorshipType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("path", "updateSponsoreType/" + sponsorshipType.getUuid());
            return "updateSponsoreType";
        }
        else {
            sponsoreTypeFacade.updateSponsoreType(sponsorshipType);
            return "redirect:/createEvent";
        }
    }

}