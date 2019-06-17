package org.eventhub.web.rest.remote.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.SponsorshipType;
import org.eventhub.web.rest.remote.dto.SponsorshipTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SponsorshipTypeAdapter extends GenericAdapter<SponsorshipType, SponsorshipTypeDTO> {

	@Autowired
	SponsorAdapter sponsorAdapter;

	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(sponsorAdapter);
	}
	
	public SponsorshipTypeDTO toSponsorshipTypeDTO(SponsorshipType sponsorshipType) {
		return toDTO(sponsorshipType);
	}
	
	public SponsorshipType fromSponsorshipType(SponsorshipTypeDTO sponsorshipTypeDTO) {
		return fromDTO(sponsorshipTypeDTO);
	}
	
}
