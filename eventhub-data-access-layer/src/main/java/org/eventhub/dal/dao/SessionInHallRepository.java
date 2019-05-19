/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;
import org.eventhub.common.model.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * SessionInHallRepository has methods to retrieve Data from database based on some properties
 * @author Amr Elkady <amrelkady93@gmail.com>
 */
public interface SessionInHallRepository extends BaseRepository<SessionInHall> {

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SessionInHall} based on {@link org.eventhub.common.model.entity.Hall}
     * @param hall {@link org.eventhub.common.model.entity.Hall}
     * @return {@link org.eventhub.common.model.entity.SessionInHall}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from SessionInHall sih where sih.hall=?1 and sih.deleted=0")
    List<SessionInHall> findAllByHall(Hall hall, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SessionInHall} based on {@link org.eventhub.common.model.entity.Session}
     * @param session {@link org.eventhub.common.model.entity.Session}
     * @return {@link org.eventhub.common.model.entity.SessionInHall}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from SessionInHall sih where sih.session=?1 and sih.deleted=0")
    List<SessionInHall> findAllBySession(Session session, Pageable pageable);

}
