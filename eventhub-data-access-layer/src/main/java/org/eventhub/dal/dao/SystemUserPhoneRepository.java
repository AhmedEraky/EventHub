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

/**
 *  SystemUserPhone interface has the needed methods to retrieve
 * according to Unique key or join sql
 * @author
 */

public interface SystemUserPhoneRepository extends BaseRepository<SystemUserPhone> {

    /**
     *  retrieve SystemUserPhone based on SystemUser
     * @param systemUser {@link org.eventhub.common.model.entity.SystemUser}
     * @return list of SystemUserPhone
     * {@link org.eventhub.common.model.entity.SystemUserPhone}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value = "from SystemUserPhone as sp where sp.systemUser=?1 and  sp.deleted=0")
    public List<SystemUserPhone> findAllBySystemUser(SystemUser systemUser, Pageable pageable);
}
