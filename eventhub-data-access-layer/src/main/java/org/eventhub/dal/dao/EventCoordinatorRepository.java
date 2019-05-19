/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;


import java.util.List;

import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.EventCoordinator;
import org.eventhub.common.model.entity.SystemUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * EventCoordinator interface has the needed methods to retrieve according to Unique key or join sql 
 * @author Aya Taha
 */
@Repository
public interface EventCoordinatorRepository extends BaseRepository<EventCoordinator>{
    
    /**
     *  retrieve EventCoordinator based on systemUser
     * @param systemUser {@link org.eventhub.common.model.entity.SystemUser}
     * @return EventCoordinator {@link org.eventhub.common.model.entity.EventCoordinator}
     * @author Aya Taha
     */
     @Query(value="from EventCoordinator as ec where  ec.systemUser=?1 and ec.deleted=0")   
    public List<EventCoordinator> findAllBySystemUser(SystemUser systemUser, Pageable pageable);
    
    /**
     *  retrieve EventCoordinator based on event
     * @param event {@link org.eventhub.common.model.entity.Event}
     * @return List of EventCoordinator {@link org.eventhub.common.model.entity.EventCoordinator}
     * @author Aya Taha
     */
     @Query(value="from EventCoordinator as ec where  ec.event=?1 and ec.deleted=0")   
    public List<EventCoordinator> findAllByEvent(Event event, Pageable pageable);
}

