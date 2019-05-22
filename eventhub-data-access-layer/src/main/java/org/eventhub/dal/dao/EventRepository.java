/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;



import java.util.Date;
import java.util.List;

import org.eventhub.common.model.entity.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

/**
 * Event interface has the needed methods to retrieve according to Unique key or join sql 
 * @author Aya Taha (aya.taha.ali.93@gmail.com)
 */

public interface EventRepository extends BaseRepository<Event>{
   
    /**
     *  retrieve Event based on name
     * @param name  Event name
     * @param pageable set number and size of pages
     * @return Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */ 
     @Query(value="from Event as e where lower(e.name) like lower(CONCAT('%',?1,'%')) and e.deleted=0")
    public List<Event> findAllByName(String name, Pageable pageable);
    
   /**
     *  retrieve Event based on address
     * @param address event address
     * @param pageable set number and size of pages
     * @return Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */ 
    @Query(value="from Event as e where e.address=?1 and e.deleted=0")
    public List<Event> findAllByAddress(String address, Pageable pageable);
    
    /**
     *  retrieve Event based on slogan
     * @param slogan event slogan 
     * @return Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */ 
     @Query(value="from Event as e where e.slogan=?1 and e.deleted=0")
    public Event findBySlogan(String slogan);
    
     /**
     *  retrieve Event based on abbreviation
     * @param abbreviation event abbreviation
     * @return Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */ 
     @Query(value="from Event as e where e.abbreviation=?1 and e.deleted=0")
    public Event findByAbbreviation(String abbreviation);
    
     /**
     *  retrieve Event based on startDate
     * @param startDate event start date
     * @param pageable set number and size of pages
     * @return list of Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */ 
     @Query(value="from Event as e where e.startDate=?1 and e.deleted=0")
    public List<Event> findAllByStartDate(Date startDate, Pageable pageable);
    
     /**
     *  retrieve Event based on endDate
     * @param endDate  event end date
     * @param pageable set number and size of pages
     * @return list of Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */ 
     @Query(value="from Event as e where e.endDate=?1 and e.deleted=0")
    public List<Event> findAllByEndDate(Date endDate, Pageable pageable);
   
    
   
    
    /**
     *  retrieve Event based on published
     * @param published  published event flag
     * @param pageable  set number and size of pages
     * @return Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
     @Query(value="from Event as e where e.published=?1 and e.deleted=0")
    public List<Event> findAllByPublished(Short published, Pageable pageable);
    
     /**
     *  retrieve Event based on sponsors
     * @param sponsor  {@link org.eventhub.common.model.entity.Sponsor}
     * @return Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value="from Event as e where ?1 member of e.sponsors and  e.deleted=0")   
    public Event findBySponor(Sponsor sponsor);
    
     /**
     *  retrieve Event based on sessions
     * @param session  {@link org.eventhub.common.model.entity.Session}
     * @return Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value="from Event as e where ?1 member of e.sessions and  e.deleted=0")   
    public Event findBySession(Session session);
    
     /**
     *  retrieve Event based on halls
     * @param hall  {@link org.eventhub.common.model.entity.Hall}
     * @return Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
      @Query(value="from Event as e where ?1 member of e.halls and  e.deleted=0")   
    public Event findByHall(Hall hall);
    
   
    
     
  
     /**
     *  retrieve Event based on organization
     * @param organization  {@link org.eventhub.common.model.entity.Organization}
     * @param pageable  set number and size of pages
     * @return list of Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
       @Query(value="from Event as e where e.organization=?1 and  e.deleted=0")   
    public List<Event> findAllByOrganization(Organization organization, Pageable pageable);
    
     /**
     *  retrieve Event based on systemUser
     * @param systemUser  {@link org.eventhub.common.model.entity.SystemUser}
     * @param pageable  set number and size of pages
     * @return list of Event {@link org.eventhub.common.model.entity.Event}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
     @Query(value="from Event as e where e.systemUser=?1  and e.deleted=0")   
    public List<Event> findAllBySystemUser(SystemUser systemUser, Pageable pageable);
    
}
