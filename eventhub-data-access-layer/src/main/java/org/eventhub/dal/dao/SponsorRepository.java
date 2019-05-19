package org.eventhub.dal.dao;
import org.eventhub.common.model.entity.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 * SponsorRepository has methods to retrieve Data from database based on some properties
 * @author Amr Elkady <amrelkady93@gmail.com>
 */
public interface SponsorRepository extends BaseRepository<Sponsor> {

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Sponsor} based on name
     * @param name of {@link org.eventhub.common.model.entity.Sponsor}
     * @return {@link org.eventhub.common.model.entity.Sponsor}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Sponsor s where lower(s.name) like lower(CONCAT('%',?1, '%')) and s.deleted=0")
    Sponsor findByName(String name);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Sponsor} based on {@link org.eventhub.common.model.entity.Event}
     * @param event  {@link org.eventhub.common.model.entity.Event}
     * @return {@link org.eventhub.common.model.entity.Sponsor}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Sponsor s where s.event=?1 and s.deleted=0")
    List<Sponsor> findAllByEvent(Event event, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Sponsor} based on {@link org.eventhub.common.model.entity.SponsorshipType}
     * @param sponsorshipType  {@link org.eventhub.common.model.entity.SponsorshipType}
     * @return {@link org.eventhub.common.model.entity.Sponsor}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Sponsor s where s.sponsorshipType=?1 and s.deleted=0")
    List<Sponsor> findAllBySponsorshipType(SponsorshipType sponsorshipType, Pageable pageable);
}
