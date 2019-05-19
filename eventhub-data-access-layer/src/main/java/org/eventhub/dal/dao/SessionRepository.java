/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;


import java.util.Date;
import java.util.List;

/**
 * SessionRepository has method to retrieve Data from database based on some properties
 * @author Amr Elkady <amrelkady93@gmail.com>
 */
public interface SessionRepository extends BaseRepository<Session>{

    /**
     * retrieve list of {@link org.eventhub.common.model.entity.Session} based on startDate
     * @param startDate of {@link org.eventhub.common.model.entity.Session}
     * @return {@link org.eventhub.common.model.entity.Session}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Session s where s.startDate=?1 and s.deleted=0")
    List<Session> findAllByStartDate(Date startDate, Pageable pageable);

    /**
     * retrieve list of {@link org.eventhub.common.model.entity.Session} based on endData
     * @param endData of {@link org.eventhub.common.model.entity.Session}
     * @return {@link org.eventhub.common.model.entity.Session}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Session s where s.endDate=?1 and s.deleted=0")
    List<Session> findAllByEndDate(Date endData, Pageable pageable);

    /**
     * retrieve list of {@link org.eventhub.common.model.entity.Session} based on capacity
     * @param capacity of {@link org.eventhub.common.model.entity.Session}
     * @return {@link org.eventhub.common.model.entity.Session}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Session s where s.capacity>?1 and s.deleted=0")
    List<Session> findAllByCapacityGreaterThan(int capacity, Pageable pageable);

    /**
     * retrieve list of {@link org.eventhub.common.model.entity.Session} based on capacity
     * @param capacity of {@link org.eventhub.common.model.entity.Session}
     * @return {@link org.eventhub.common.model.entity.Session}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Session s where s.capacity<?1 and s.deleted=0")
    List<Session> findAllByCapacityLessThan(int capacity, Pageable pageable);

    /**
     * retrieve list of {@link org.eventhub.common.model.entity.Session} based on capacity
     * @param capacity of {@link org.eventhub.common.model.entity.Session}
     * @return {@link org.eventhub.common.model.entity.Session}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Session s where s.capacity=?1 and s.deleted=0")
    List<Session> findAllByCapacityEquals(int capacity, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Session} based on {@link org.eventhub.common.model.entity.VipSpeaksInSession}
     * @param vipSpeaksInSession {@link org.eventhub.common.model.entity.VipSpeaksInSession}
     * @return {@link org.eventhub.common.model.entity.Session}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Session s where ?1 member of s.vipSpeaksInSessions and s.deleted=0")
    Session findByVipSpeaksInSessions(VipSpeaksInSession vipSpeaksInSession);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Session} based on {@link org.eventhub.common.model.entity.Event}
     * @param event {@link org.eventhub.common.model.entity.Event}
     * @return {@link org.eventhub.common.model.entity.Session}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Session s where s.event=?1 and s.deleted=0")
    List<Session> findAllByEvent(Event event, Pageable pageable);


    /**
     * retrieve  {@link org.eventhub.common.model.entity.Session} based on {@link org.eventhub.common.model.entity.SessionType}
     * @param sessionType {@link org.eventhub.common.model.entity.SessionType}
     * @return {@link org.eventhub.common.model.entity.Session}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Session s where s.sessionType=?1 and s.deleted=0")
    List<Session> findAllBySessionType(SessionType sessionType, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Session} based on {@link org.eventhub.common.model.entity.SessionInstructor}
     * @param sessionInstructor {@link org.eventhub.common.model.entity.SessionInstructor}
     * @return {@link org.eventhub.common.model.entity.Session}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Session  s where ?1 member of s.sessionInstructors and s.deleted=0")
    Session findBySessionInstructors(SessionInstructor sessionInstructor);


}
