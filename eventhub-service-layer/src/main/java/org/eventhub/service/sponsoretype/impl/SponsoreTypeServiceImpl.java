package org.eventhub.service.sponsoretype.impl;

import org.eventhub.common.model.entity.SponsorshipType;
import org.eventhub.dal.dao.SponsorshipTypeRepository;
import org.eventhub.service.sponsoretype.SponsoreTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Sponsore Ship Type Service implementation
 * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
 */
@Service
public class SponsoreTypeServiceImpl implements SponsoreTypeService {

    @Autowired
    SponsorshipTypeRepository sponsorshipTypeRepository;


    /**
     * method to create Sponsore Ship Type
     * @param sponsorshipType Sponsore Ship Type to be created
     * @return {@link SponsorshipType}  Sponsore Ship Type created with new generated {@link UUID}
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    @Transactional
    public SponsorshipType createSponsoreType(SponsorshipType sponsorshipType) {
        return sponsorshipTypeRepository.save(sponsorshipType);
    }


    /**
     * method to update Sponsore Ship Type
     * @param sponsorshipType Sponsore Ship Type to be updated
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    @Transactional
    public void updateSponsoreType(SponsorshipType sponsorshipType) {
        sponsorshipTypeRepository.update(sponsorshipType);
    }

    /**
     * method to get Sponsore Ship Type by {@link UUID}
     * @param id Sponsore Ship Type {@link UUID} to be retrieved
     * @return {@link org.eventhub.common.model.entity.SponsorshipType}  Sponsore Ship Type with the specified {@link UUID}
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    public SponsorshipType getSponosoreShipType(UUID id) {
        return sponsorshipTypeRepository.findById(id).get();
    }
}
