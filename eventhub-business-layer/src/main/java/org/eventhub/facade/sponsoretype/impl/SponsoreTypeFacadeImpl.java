package org.eventhub.facade.sponsoretype.impl;

import org.eventhub.common.model.entity.SponsorshipType;
import org.eventhub.facade.sponsoretype.SponsoreTypeFacade;
import org.eventhub.service.sponsoretype.SponsoreTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


/**
 * Sponsore Ship Type Facade implementation
 * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
 */
@Component
public class SponsoreTypeFacadeImpl implements SponsoreTypeFacade {

    @Autowired
    SponsoreTypeService sponsoreTypeService;

    /**
     * method to create Sponsore Ship Type
     * @param sponsorshipType Sponsore Ship Type to be created
     * @return {@link SponsorshipType}  Sponsore Ship Type created with new generated {@link UUID}
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    public SponsorshipType createSponsoreType(SponsorshipType sponsorshipType) {
        return sponsoreTypeService.createSponsoreType(sponsorshipType);
    }

    /**
     * method to update Sponsore Ship Type
     * @param sponsorshipType Sponsore Ship Type to be updated
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    public void updateSponsoreType(SponsorshipType sponsorshipType) {
        sponsoreTypeService.updateSponsoreType(sponsorshipType);
    }

    /**
     * method to get Sponsore Ship Type by {@link UUID}
     * @param id Sponsore Ship Type {@link UUID} to be retrieved
     * @return {@link org.eventhub.common.model.entity.SponsorshipType}  Sponsore Ship Type with the specified {@link UUID}
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    public SponsorshipType getSponsoreType(UUID id) {
        return sponsoreTypeService.getSponosoreShipType(id);
    }
}
