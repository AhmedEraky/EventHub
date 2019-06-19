package org.eventhub.web.controller.country;

import java.util.ArrayList;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.eventhub.common.model.entity.Country;
import org.eventhub.facade.country.CountryManagementFacade;
import org.eventhub.facade.country.CountryRetrivalFacade;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryController {

    @Autowired
    private CountryManagementFacade managementFacade;

    @Autowired
    private CountryRetrivalFacade retrivalFacade;

    /**
     * get method to display the add country form form
     *
     * @return
     *
     */
    @GetMapping(path = "/addCountry")
    public String addCountry(Model model) {
        model.addAttribute("country", new Country());
        return "addCountry";
    }

    /**
     *
     * @param country
     * @param result
     * @return
     */
    @PostMapping(path = "/addCountry")
    public String onAdd(@Valid @ModelAttribute("country") Country country,
            BindingResult result) {
        if (result.hasErrors()) {
            return "addCountry";
        } else {
            managementFacade.createCountry(country);
            return "redirect:addCountry?success&id=" + country.getUuid().toString();
        }
    }

    @GetMapping(path = "/editCountry")
    public String editCountry(Model model, @RequestParam("id") String id) {
        UUID uuid = UUID.fromString(id);
        model.addAttribute("country", retrivalFacade.getById(uuid));
        return "editCountry";
    }

    @PostMapping(path = "/editCountry")
    public String onEdit(@Valid @ModelAttribute("country") Country country,
            BindingResult result) {
        if (result.hasErrors()) {
            return "editCountry";
        } else {
            managementFacade.updateCountry(country);
            return "redirect:editCountry?success&id=" + country.getUuid().toString();
        }
    }

    /**
     * get method to display all countries in countries page
     *
     * @return
     *
     */
    @GetMapping(path = "/countries")
    public String displayCountry(ModelAndView modelAndView) {
        ArrayList<Country> countryList = (ArrayList<Country>) retrivalFacade.getCountries();
        for (int i = 0; i < countryList.size(); i++) {
            System.out.println(countryList.get(i).getName());
        }
        modelAndView.addObject("countries", countryList);
        return "countries";
    }
}
