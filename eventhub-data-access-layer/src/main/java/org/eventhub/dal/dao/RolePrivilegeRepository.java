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
 * RolePrivilegeRepository has methods to retrieve Data from database based on some properties
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
public interface RolePrivilegeRepository extends BaseRepository<RolePrivilege> {

    /**
     * retrieve  {@link org.eventhub.common.model.entity.RolePrivilege} based on {@link org.eventhub.common.model.entity.Privilege}
     * @param privilege {@link org.eventhub.common.model.entity.Privilege}
     * @return {@link org.eventhub.common.model.entity.RolePrivilege}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from RolePrivilege rp where rp.privilege=?1 and rp.deleted=0")
    List<RolePrivilege> findAllByPrivilege(Privilege privilege, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.RolePrivilege} based on {@link org.eventhub.common.model.entity.Role}
     * @param role {@link org.eventhub.common.model.entity.Role}
     * @return {@link org.eventhub.common.model.entity.RolePrivilege}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from RolePrivilege rp where rp.role=?1 and rp.deleted=0")
    List<RolePrivilege> findAllByRole(Role role, Pageable pageable);

}
