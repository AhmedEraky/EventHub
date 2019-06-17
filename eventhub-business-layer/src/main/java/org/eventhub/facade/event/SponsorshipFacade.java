package org.eventhub.facade.event;

import java.util.List;
import java.util.UUID;

import org.eventhub.common.model.entity.Sponsor;
import org.eventhub.common.model.entity.SponsorshipType;

/**
 * facade for sponsor and sponsorship type
 * @author M. ALI
 */
public interface SponsorshipFacade {
	/**
	 * get all available sponsorship types
	 * @return list of sponsorship types
	 * @author M. ALI
	 */
	List<SponsorshipType> getAllSponsorshipTypes();
	
	/**
	 * get sponsor
	 * @param sponsorId sponsor id
	 * @return sponsor
	 * @author M. ALI
	 */
	Sponsor getSponsor(UUID sponsorId);
	
	/**
	 * save a new sponsor
	 * @param sponsor new sponsor
	 * @author M. ALI
	 */
	void createSponsor(Sponsor sponsor);
	
	/**
	 * update a sponsor
	 * @param sponsor updated sponsor
	 * @author M. ALI
	 */
    void updateSponsor(Sponsor sponsor);
}
