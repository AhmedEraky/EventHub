/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;
import org.eventhub.common.model.entity.*;
import org.springframework.data.jpa.repository.Query;

/**
 * RoleRepository has methods to retrieve Data from database based on some properties
 * @author Amr Elkady <amrelkady93@gmail.com>
 */
public interface RoleRepository extends BaseRepository<Role> {

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Role} based on name
     * @param name of {@link org.eventhub.common.model.entity.Role}
     * @return {@link org.eventhub.common.model.entity.Role}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Role r where lower(r.name) like lower(CONCAT('%',?1, '%')) and r.deleted=0")
    Role findByName(String name);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Role} based on {@link org.eventhub.common.model.entity.RolePrivilege}
     * @param rolePrivilege {@link org.eventhub.common.model.entity.RolePrivilege}
     * @return {@link org.eventhub.common.model.entity.Role}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Role r where ?1 member of r.rolePrivileges and r.deleted=0")
    Role findByRolePrivileges(RolePrivilege rolePrivilege);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Role} based on {@link org.eventhub.common.model.entity.SystemUserHasRole}
     * @param systemUserHasRole {@link org.eventhub.common.model.entity.SystemUserHasRole}
     * @return {@link org.eventhub.common.model.entity.Role}
     * @author Amr Elkady <amrelkady93@gmail.com>
     */
    @Query(value = "from Role r where ?1 member of r.systemUserHasRoles and r.deleted=0")
    Role findBySystemUserHasRoles(SystemUserHasRole systemUserHasRole);

}
