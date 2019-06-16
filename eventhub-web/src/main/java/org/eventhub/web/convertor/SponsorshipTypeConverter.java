package org.eventhub.web.convertor;

import java.util.UUID;

import org.eventhub.common.model.entity.SponsorshipType;
import org.springframework.core.convert.converter.Converter;

/**
 * SponsorshipType converter to convert the uuid to a SponsorshipType object
 * This is used in drop down lists in forms
 * @author M. ALI
 */
public class SponsorshipTypeConverter implements Converter<String, SponsorshipType> {

	/**
	 * convert the uuid to a SponsorshipType object
	 * @param sponsorshipTypeId uuid
	 * @return SponsorshipType object
	 */
	@Override
	public SponsorshipType convert(String sponsorshipTypeId) {
		SponsorshipType sponsorshipType = new SponsorshipType();
		sponsorshipType.setUuid(UUID.fromString(sponsorshipTypeId));
        return sponsorshipType;
	}
}
