package org.eventhub.web.controller.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.eventhub.common.model.entity.Country;
import org.eventhub.facade.country.CountryManagementFacade;
import org.springframework.ui.Model;

@Controller
public class CountryController {

    @Autowired
    CountryManagementFacade countryFacade;

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
    protected String onSubmit(@Valid @ModelAttribute("country") Country country,
            BindingResult result) {
        if (result.hasErrors()) {
            return "addCountry";
        } else {
            countryFacade.createCountry(country);
            return "redirect:addCountry?success";
        }
    }
}
