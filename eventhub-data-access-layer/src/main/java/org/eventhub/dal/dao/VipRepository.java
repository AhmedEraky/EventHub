/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.*;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *  Vip interface has the needed methods to retrieve according to
 * Unique key or join sql
 * @author Aya Taha (aya.taha.ali.93@gmail.com)
 */

public interface VipRepository extends BaseRepository<Vip> {

    /**
     * retrieve Vip based on name
     * @param name
     * @return Vip {@link org.eventhub.common.model.entity.Vip}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value = "from Vip as v where lower(v.name) like lower(CONCAT('%',?1,'%')) and v.deleted=0")
    public List<Vip> findAllByName(String name, Pageable pageable);

    /**
     *  retrieve Vip based on VipSpeaksInSessions
     * @param vipSpeaksInSession
     * {@link org.eventhub.common.model.entity.VipSpeaksInSession}
     * @return Vip {@link org.eventhub.common.model.entity.Vip}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value = "from Vip as v where ?1 member of v.vipSpeaksInSessions and  v.deleted=0")
    public Vip findByVipSpeaksInSession(VipSpeaksInSession vipSpeaksInSession);

    /**
     *  retrieve Event based on jobTitle
     * @param jobTitle {@link org.eventhub.common.model.entity.JobTitle}
     * @return list of Vip {@link org.eventhub.common.model.entity.Vip}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value = "from Vip as v where v.jobTitle=?1 and  v.deleted=0")
    public List<Vip> findAllByJobTitle(JobTitle jobTitle, Pageable pageable);

    /**
     *  retrieve Event based on organization
     * @param organization {@link org.eventhub.common.model.entity.Organization}
     * @return list of Vip {@link org.eventhub.common.model.entity.Vip}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value = "from Vip as v where v.organization=?1 and  v.deleted=0")
    public List<Vip> findAllByOrganization(Organization organization, Pageable pageable);

}
