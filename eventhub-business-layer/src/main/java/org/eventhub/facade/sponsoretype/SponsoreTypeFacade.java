package org.eventhub.facade.sponsoretype;

import org.eventhub.common.model.entity.SponsorshipType;

import java.util.UUID;

/**
 * Sponsore Ship Type Facade interface
 * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
 */
public interface SponsoreTypeFacade {
    public SponsorshipType createSponsoreType(SponsorshipType sponsorshipType);
    public void updateSponsoreType(SponsorshipType sponsorshipType);
    public SponsorshipType getSponsoreType(UUID id);
}
