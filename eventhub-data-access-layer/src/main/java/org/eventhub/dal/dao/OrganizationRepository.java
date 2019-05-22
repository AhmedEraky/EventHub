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
 * OrganizationRepository has method to retrieve Data from database based on some properties
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
public interface OrganizationRepository extends BaseRepository<Organization> {

    /**
     * retrieve list of {@link org.eventhub.common.model.entity.Organization} based on name
     * @param name of {@link org.eventhub.common.model.entity.Organization}
     * @param pageable set number and size of pages 
     * @return {@link org.eventhub.common.model.entity.Organization}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from Organization o where lower(o.name) like lower(CONCAT('%',?1, '%')) and o.deleted=0")
    List<Organization> findAllByName(String name, Pageable pageable);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Organization} based on {@link org.eventhub.common.model.entity.SystemUser}
     * @param systemUser {@link org.eventhub.common.model.entity.SystemUser}
     * @return {@link org.eventhub.common.model.entity.Organization}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from Organization o where  ?1 member of o.systemUsers and o.deleted=0")
    Organization findBySystemUsers(SystemUser systemUser);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Organization} based on {@link org.eventhub.common.model.entity.Event}
     * @param event  {@link org.eventhub.common.model.entity.Event}
     * @return {@link org.eventhub.common.model.entity.Organization}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from Organization o where ?1 member of o.events and o.deleted=0")
    Organization findByEvents(Event event);

    /**
     * retrieve  {@link org.eventhub.common.model.entity.Organization} based on {@link org.eventhub.common.model.entity.Event}
     * @param vip  {@link org.eventhub.common.model.entity.Vip}
     * @return {@link org.eventhub.common.model.entity.Organization}
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Query(value = "from Organization o where ?1 member of o.vips and o.deleted=0")
    Organization findByVips(Vip vip);

}
