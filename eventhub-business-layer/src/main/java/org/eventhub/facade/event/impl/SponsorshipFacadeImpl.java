package org.eventhub.facade.event.impl;

import java.util.List;
import java.util.UUID;

import org.eventhub.common.model.entity.Sponsor;
import org.eventhub.common.model.entity.SponsorshipType;
import org.eventhub.facade.event.SponsorshipFacade;
import org.eventhub.service.event.SponsorshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * facade for sponsor and sponsorship type
 * @author M. ALI
 */
@Component
public class SponsorshipFacadeImpl implements SponsorshipFacade {
	
	@Autowired
	SponsorshipService sponsorshipService;
	
	/**
	 * get all available sponsorship types
	 * @return list of sponsorship types
	 * @author M. ALI
	 */
	public List<SponsorshipType> getAllSponsorshipTypes() {
		return sponsorshipService.getAllSponsorshipTypes();
	}
	
	/**
	 * get sponsor
	 * @param sponsorId sponsor id
	 * @return sponsor
	 * @author M. ALI
	 */
	@Override
	public Sponsor getSponsor(UUID sponsorId) {
		return sponsorshipService.getSponsor(sponsorId);
	}
	
	/**
	 * save a new sponsor
	 * @param sponsor new sponsor
	 * @author M. ALI
	 */
	public void createSponsor(Sponsor sponsor) {
		sponsorshipService.createSponsor(sponsor);
	}
	
	/**
	 * update a sponsor
	 * @param sponsor updated sponsor
	 * @author M. ALI
	 */
    public void updateSponsor(Sponsor sponsor) {
    	sponsorshipService.updateSponsor(sponsor);
    }
}
