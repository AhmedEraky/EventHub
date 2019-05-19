package org.eventhub.dal.dao;
import org.eventhub.common.model.entity.*;
import org.springframework.data.jpa.repository.Query;

/**
 * SponsorshipTypeRepository has methods to retrieve Data from database based on some properties
 * @author Amr Elkady <amrelkady93@gmail.com>
 */
public interface SponsorshipTypeRepository extends BaseRepository<SponsorshipType> {

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SponsorshipType} based on name
     * @param name of {@link org.eventhub.common.model.entity.SponsorshipType}
     * @return {@link org.eventhub.common.model.entity.SponsorshipType}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from SponsorshipType st where lower(st.name) like lower(CONCAT('%',?1, '%')) and st.deleted=0")
    SponsorshipType findByName(String name);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SponsorshipType} based on {@link org.eventhub.common.model.entity.Sponsor}
     * @param sponsor  {@link org.eventhub.common.model.entity.Sponsor}
     * @return {@link org.eventhub.common.model.entity.SponsorshipType}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from SponsorshipType st where ?1 member of st.sponsors and st.deleted=0")
    SponsorshipType findBySponsors(Sponsor sponsor);
}
