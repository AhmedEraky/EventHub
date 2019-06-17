package org.eventhub.web.rest.remote.adapter;

import java.util.Arrays;
import java.util.List;

import org.eventhub.common.model.entity.Sponsor;
import org.eventhub.web.rest.remote.dto.SponsorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SponsorAdapter extends GenericAdapter<Sponsor, SponsorDTO> {
	
	@Autowired
	EventAdapter eventAdapter;
	@Autowired
	SponsorshipTypeAdapter sponsorshipTypeAdapter;
	
	@Override
	protected List<GenericAdapter> getAdapters() {
		return Arrays.asList(eventAdapter, sponsorshipTypeAdapter);
	}
	
	public SponsorDTO toSponsorDTO(Sponsor sponsor) {
		return toDTO(sponsor);
	}
	
	public Sponsor fromSponsorDTO(SponsorDTO sponsorDTO) {
		return fromDTO(sponsorDTO);
	}

}
