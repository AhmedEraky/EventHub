package org.eventhub.service.sponsoretype;

import org.eventhub.common.model.entity.SponsorshipType;

import java.util.UUID;

/**
 * Sponsore Ship Type Service interface
 * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
 */
public interface SponsoreTypeService {
    public SponsorshipType createSponsoreType(SponsorshipType sponsorshipType);
    public void updateSponsoreType(SponsorshipType sponsorshipType);
    public SponsorshipType getSponosoreShipType(UUID id);
}
