/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;
import org.eventhub.common.model.entity.*;
import org.springframework.data.jpa.repository.Query;

/**
 * SessionTypeRepository has methods to retrieve Data from database based on some properties
 * @author Amr Elkady <amrelkady93@gmail.com>
 */
public interface SessionTypeRepository extends BaseRepository<SessionType>{

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SessionType} based on name
     * @param name of {@link org.eventhub.common.model.entity.SessionType}
     * @return {@link org.eventhub.common.model.entity.SessionType}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from SessionType  st where lower(st.name) like lower(CONCAT('%',?1, '%')) and st.deleted=0")
    SessionType findByName(String name);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SessionType} based on {@link org.eventhub.common.model.entity.Session}
     * @param session {@link org.eventhub.common.model.entity.VipSpeaksInSession}
     * @return {@link org.eventhub.common.model.entity.SessionType}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from SessionType st where ?1 member of st.sessions and st.deleted=0")
    SessionType findBySessions(Session session);


}
