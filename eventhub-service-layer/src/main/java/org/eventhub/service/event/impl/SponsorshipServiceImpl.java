package org.eventhub.service.event.impl;

import java.util.List;
import java.util.UUID;

import org.eventhub.common.model.entity.Sponsor;
import org.eventhub.common.model.entity.SponsorshipType;
import org.eventhub.dal.dao.SponsorRepository;
import org.eventhub.dal.dao.SponsorshipTypeRepository;
import org.eventhub.service.event.SponsorshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service for sponsor and sponsorship type
 * @author M. ALI
 */
@Service
public class SponsorshipServiceImpl implements SponsorshipService {
	
	@Autowired
	SponsorRepository sponsorRepository;
	@Autowired
	SponsorshipTypeRepository sponsorshipTypeRepository;

	/**
	 * get all available sponsorship types
	 * @return list of sponsorship types
	 * @author M. ALI
	 */
	@Override
	public List<SponsorshipType> getAllSponsorshipTypes() {
		return sponsorshipTypeRepository.findAll();
	}
	
	/**
	 * get sponsor
	 * @param sponsorId sponsor id
	 * @return sponsor
	 * @author M. ALI
	 */
	@Override
	public Sponsor getSponsor(UUID sponsorId) {
		return sponsorRepository.getOne(sponsorId);
	}
	
	/**
	 * save a new sponsor
	 * @param sponsor new sponsor
	 * @author M. ALI
	 */
	@Override
	public void createSponsor(Sponsor sponsor) {
		sponsorRepository.save(sponsor);
	}

	/**
	 * update a sponsor
	 * @param sponsor updated sponsor
	 * @author M. ALI
	 */
	@Override
	public void updateSponsor(Sponsor sponsor) {
		sponsorRepository.update(sponsor);
	}
	

}
