/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.*;
import java.util.List;

import org.eventhub.common.model.entity.VipSpeaksInSession;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *VipSpeaksInSession interface has the needed methods to retrieve according to Unique key or join sql 
 * @author Aya Taha
 */

public interface VipSpeaksInSessionRepository  extends BaseRepository<VipSpeaksInSession>{
    
    /**
     * retrieve VipSpeaksInSession based on session
     * @param session  {@link org.eventhub.common.model.entity.Session}
     * @return list of VipSpeaksInSession {@link org.eventhub.common.model.entity.VipSpeaksInSession}
     * @author Aya Taha
     */
       @Query(value="from VipSpeaksInSession as vs where vs.session=?1 and  vs.deleted=0")   
    public List<VipSpeaksInSession> findBySession(Session session, Pageable pageable);
    
    
     /**
     *  retrieve VipSpeaksInSession based on Vip
     * @param vip  {@link org.eventhub.common.model.entity.Vip}
     * @return Set of VipSpeaksInSession {@link org.eventhub.common.model.entity.VipSpeaksInSession}
     * @author Aya Taha
     */
       @Query(value="from VipSpeaksInSession as vs where vs.vip=?1 and  vs.deleted=0")   
    public List<VipSpeaksInSession> findByVip(Vip vip, Pageable pageable);
}
