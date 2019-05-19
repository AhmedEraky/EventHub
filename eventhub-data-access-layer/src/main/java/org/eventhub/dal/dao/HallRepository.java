/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;import org.eventhub.common.model.entity.*;



/**
 * Hall interface has the needed methods to retrieve according to Unique key or join sql 
 * @author Aya Taha
 */
@Repository
public interface HallRepository extends BaseRepository<Hall>{
    
    
    /**
     *  retrieve Hall based on floor
     * @param floor 
     * @return Hall {@link org.eventhub.common.model.entity.Hall}
     * @author Aya Taha
     */ 
      @Query(value="from Hall as h where h.floor=?1 and h.deleted=0")
    public List<Hall> findAllByFloor(String floor, Pageable pageable);
    
   /**
     *  retrieve Hall based on building
     * @param building 
     * @return Hall {@link org.eventhub.common.model.entity.Hall}
     * @author Aya Taha
     */ 
    @Query(value="from Hall as h where h.building=?1 and h.deleted=0")
    public List<Hall> findAllByBuilding(String building, Pageable pageable);
    /**
     *  retrieve Hall based on name
     * @param name 
     * @return Hall {@link org.eventhub.common.model.entity.Hall}
     * @author Aya Taha
     */ 
     @Query(value="from Hall as h where lower(h.name) like lower(CONCAT('%',?1,'%')) and h.deleted=0")
    public List<Hall> findAllByName(String name, Pageable pageable);
    
  /**
     *  retrieve Hall based on capacity
     * @param capacity 
     * @return Hall {@link org.eventhub.common.model.entity.Hall}
     * @author Aya Taha
     */ 
    @Query(value="from Hall as h where h.capacity=?1 and h.deleted=0")
    public List<Hall> findAllByCapacity(Integer capacity, Pageable pageable);
    
    
    
    /**
     *  retrieve Hall based on event
     * @param event {@link org.eventhub.common.model.entity.Event}
     * @return list of Hall {@link org.eventhub.common.model.entity.Hall}
     * @author Aya Taha
     */ 
      @Query(value="from Hall as h where h.event=?1 and h.deleted=0")
    public List<Hall> findAllByEvent(Event event, Pageable pageable);
    
   /**
     * retrieve Hall based on sessionInHalls
     * @param sessionInHall {@link org.eventhub.common.model.entity.SessionInHall}
     * @return list of Hall {@link org.eventhub.common.model.entity.Hall}
     * @author Aya Taha
     */ 
    @Query(value="from Hall as h where ?1 member of h.sessionInHalls and  h.deleted=0")
    public List<Hall> findAllBySessionInHalls(Session sessionInHall, Pageable pageable);
            
}
