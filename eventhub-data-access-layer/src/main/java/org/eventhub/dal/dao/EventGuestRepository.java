/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;


import java.util.List;

import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.EventGuest;
import org.eventhub.common.model.entity.SystemUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 *EventGuest interface has the needed methods to retrieve according to Unique key or join sql 
 * @author Aya Taha (aya.taha.ali.93@gmail.com)
 */

public interface EventGuestRepository extends BaseRepository<EventGuest>{
   /**
     *  retrieve EventGuest based on event
     * @param event 
     * @return List of EventGuest {@link org.eventhub.common.model.entity.EventGuest}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */         
     @Query(value="from EventGuest as eg where  eg.event=?1 and eg.deleted=0")   
    public List<EventGuest> findAllByEvent(Event event, Pageable pageable);
    
    
    /**
     *  retrieve EventGuest based on systemUser
     * @param systemUser 
     * @return list of EventGuest {@link org.eventhub.common.model.entity.EventGuest}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */ 
   @Query(value="from EventGuest as eg where  eg.systemUser=?1 and eg.deleted=0")   
    public List<EventGuest> findAllBySystemUser(SystemUser systemUser, Pageable pageable);
}
