package org.eventhub.dal.dao;
import org.eventhub.common.model.entity.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 * SystemUserHasRoleRepository has methods to retrieve Data from database based on some properties
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
public interface SystemUserHasRoleRepository extends BaseRepository<SystemUserHasRole> {

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SystemUserHasRole} based on {@link org.eventhub.common.model.entity.Role}
     * @param role  {@link org.eventhub.common.model.entity.Role}
     * @param pageable set number and size of pages 
     * @return {@link org.eventhub.common.model.entity.SystemUserHasRole}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from SystemUserHasRole suhr where suhr.role=?1 and suhr.deleted=0")
    List<SystemUserHasRole> findAllByRole(Role role, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SystemUserHasRole} based on {@link org.eventhub.common.model.entity.SystemUser}
     * @param systemUser  {@link org.eventhub.common.model.entity.SystemUser}
     * @param pageable set number and size of pages 
     * @return {@link org.eventhub.common.model.entity.SystemUserHasRole}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from SystemUserHasRole suhr where suhr.systemUser=?1 and suhr.deleted=0")
    List<SystemUserHasRole> findAllBySystemUser(SystemUser systemUser, Pageable pageable);
}
