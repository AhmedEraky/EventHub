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
 * PrivilegeRepository has methods to retrieve Data from database based on some properties
 * @author Amr Elkady <amrelkady93@gmail.com>
 */
public interface PrivilegeRepository extends BaseRepository<Privilege> {

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Privilege} based on name
     * @param name of {@link org.eventhub.common.model.entity.Privilege}
     * @return {@link org.eventhub.common.model.entity.Privilege}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Privilege p where lbower(p.name) like lower(CONCAT('%',?1, '%')) and p.deleted=0")
    List<Privilege> findAllByName(String name, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Privilege} based on {@link org.eventhub.common.model.entity.RolePrivilege}
     * @param rolePrivilede {@link org.eventhub.common.model.entity.RolePrivilege}
     * @return {@link org.eventhub.common.model.entity.Privilege}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Privilege p where ?1 member of p.rolePrivileges and p.deleted=0")
    Privilege findAllByRolePrivileges(RolePrivilege rolePrivilede);
}
