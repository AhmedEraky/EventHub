
package org.eventhub.dal.dao;


import java.util.List;

import org.eventhub.common.model.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;



/**
 *Country interface has the needed methods to retrieve according to Unique key or join sql 
 * @author Aya Taha (aya.taha.ali.93@gmail.com)
 */

public interface CountryRepository extends BaseRepository<Country>{

    /**
     *  retrieve Country based on name
     * @param name
     * @return Country {@link org.eventhub.common.model.entity.Country}
     */
    @Query(value= "from Country as c where lower(c.name) like lower(CONCAT('%',?1,'%')) and c.deleted=0")
    public List<Country> findAllByName(String name, Pageable pageable);
}
