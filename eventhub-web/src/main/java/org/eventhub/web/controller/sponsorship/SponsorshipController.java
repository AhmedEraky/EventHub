package org.eventhub.web.controller.sponsorship;

import java.util.UUID;

import javax.validation.Valid;

import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.Sponsor;
import org.eventhub.facade.event.EventFacade;
import org.eventhub.facade.event.SponsorshipFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * controller for sponsorship
 * @author M. ALI
 */
@Controller
public class SponsorshipController {
	
	@Autowired
	SponsorshipFacade sponsorshipFacade;
	@Autowired
	EventFacade eventFacade;
	
	/**
	 * get add sponsor form
	 * @return the form
	 * @author M. ALI
	 */
	@GetMapping(path = "/sponsor/addSponsor", params = {"event"})
	public ModelAndView getAddSponsor() {
		ModelAndView modelAndView = new ModelAndView("addSponsor");
		modelAndView.addObject("sponsor", new Sponsor());
		modelAndView.addObject("sponsorshipTypes", sponsorshipFacade.getAllSponsorshipTypes());
		return modelAndView;
	}
	
	/**
	 * save the sponsor in database
	 * @return add sponsor form
	 * @author M. ALI
	 */
	@PostMapping(path = "/sponsor/addSponsor", params = {"event"})
	public String addNewSponsor(@ModelAttribute("sponsor") @Valid Sponsor sponsor, @RequestParam("event") UUID eventId, BindingResult result) {
		String viewName = "/sponsor/addSponsor?event=" + eventId.toString();
		if(result.hasErrors()) {
			return viewName;
		}
		else {
			Event event = new Event(eventId);
			sponsor.setEvent(event);
			sponsorshipFacade.createSponsor(sponsor);
			return "redirect:" + viewName;
		}
	}
	
	/**
	 * get update sponsor form
	 * @return the form
	 * @author M. ALI
	 */
	@GetMapping(path = "/sponsor/updateSponsor", params = {"sponsor"})
	public ModelAndView getUpdateSponsor(@RequestParam("sponsor") UUID sponsorId) {
		ModelAndView modelAndView = new ModelAndView("updateSponsor");
		Sponsor sponsor = sponsorshipFacade.getSponsor(sponsorId);
		modelAndView.addObject("sponsor", sponsor);
		modelAndView.addObject("sponsorshipTypes", sponsorshipFacade.getAllSponsorshipTypes());
		return modelAndView;
	}
	
	/**
	 * update the sponsor in database
	 * @return update sponsor form
	 * @author M. ALI
	 */
	@PostMapping(path = "/sponsor/updateSponsor", params = {"sponsor"})
	public String updateNewSponsor(@ModelAttribute("sponsor") @Valid Sponsor sponsor, @RequestParam("sponsor") UUID sponsorId, BindingResult result) {
		String viewName = "/sponsor/updateSponsor?sponsor=" + sponsorId.toString();
		if(result.hasErrors()) {
			return viewName;
		}
		else {
			Sponsor oldSponsor = sponsorshipFacade.getSponsor(sponsorId);
			Event event = oldSponsor.getEvent();
			sponsor.setEvent(event);
			sponsorshipFacade.updateSponsor(sponsor);
			return "redirect:" + viewName;
		}
	}
	
}
