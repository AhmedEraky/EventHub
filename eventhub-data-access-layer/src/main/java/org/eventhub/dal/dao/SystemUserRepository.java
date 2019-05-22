/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 * SystemUserRepository has methods to retrieve Data from database based on some properties
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
public interface SystemUserRepository extends BaseRepository<SystemUser> {

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SystemUser} based on userName
     * @param userName of {@link org.eventhub.common.model.entity.SystemUser}
     * @return {@link org.eventhub.common.model.entity.SystemUser}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from SystemUser su where lower(su.userName) like lower(CONCAT('%',?1, '%')) and su.deleted=0")
    List<SystemUser> findAllByUsername(String userName, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SystemUser} based on email
     * @param email of {@link org.eventhub.common.model.entity.SystemUser}
     * @return {@link org.eventhub.common.model.entity.SystemUser}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from SystemUser su where lower(su.email) like lower(CONCAT('%',?1, '%')) and su.deleted=0")
    SystemUser findByEmail(String email);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SystemUser} based on firstName
     * @param firstName of {@link org.eventhub.common.model.entity.SystemUser}
     * @return {@link org.eventhub.common.model.entity.SystemUser}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from SystemUser su where lower(su.firstName) like lower(CONCAT('%',?1, '%')) and su.deleted=0")
    List<SystemUser> findAllByFirstName(String firstName, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SystemUser} based on {@link org.eventhub.common.model.entity.SystemUserPhone}
     * @param systemUserPhone  {@link org.eventhub.common.model.entity.SystemUserPhone}
     * @return {@link org.eventhub.common.model.entity.SystemUser}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from SystemUser su where ?1 member of su.systemUserPhones and su.deleted=0")
    SystemUser findBySystemUserPhones(SystemUserPhone systemUserPhone);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SystemUser} based on {@link org.eventhub.common.model.entity.Country}
     * @param country  {@link org.eventhub.common.model.entity.Country}
     * @return {@link org.eventhub.common.model.entity.SystemUser}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from SystemUser su where su.country=?1 and su.deleted=0")
    List<SystemUser> findAllByCountry(Country country,Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SystemUser} based on {@link org.eventhub.common.model.entity.JobTitle}
     * @param jobTitle  {@link org.eventhub.common.model.entity.JobTitle}
     * @return {@link org.eventhub.common.model.entity.SystemUser}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from SystemUser su where su.jobTitle=?1 and su.deleted=0")
    List<SystemUser> findAllByJobTitle(JobTitle jobTitle, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.SystemUser} based on {@link org.eventhub.common.model.entity.Organization}
     * @param organization  {@link org.eventhub.common.model.entity.Organization}
     * @return {@link org.eventhub.common.model.entity.SystemUser}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from SystemUser su where su.organization=?1 and su.deleted=0")
    List<SystemUser> findAllByOrganization(Organization organization, Pageable pageable);



}
