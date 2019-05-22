/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.dao;

import org.eventhub.common.model.entity.*;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

/**
 *  JobTitle interface has the needed methods to retrieve according to Unique key or join sql 
 * @author Aya Taha
 */

public interface JobTitleRepository extends BaseRepository<JobTitle> {

     /**
     *  retrieve JobTitle based on name
     * @param name
     * @return  JobTitle {@link org.eventhub.common.model.entity.JobTitle}
     * @author Aya Taha
     */
    @Query(value = "from JobTitle as jt where lower(jt.name) like lower(CONCAT('%',?1,'%')) and  jt.deleted=0")
    public List<JobTitle> findAllByName(String name, Pageable pageable);
    
    /**
     *  retrieve JobTitle based on  systemUser
     * @param systemUser {@link org.eventhub.common.model.entity.SystemUser}
     * @return JobTitle {@link org.eventhub.common.model.entity.JobTitle}
     * @author Aya Taha
     */
    
    @Query(value = "from JobTitle as jt where ?1 member of jt.systemUsers and  jt.deleted=0")
    public JobTitle findBySystemUsers(SystemUser systemUser);
    
      
    /**
     *  retrieve JobTitle based on  Vip
     * @param vip {@link org.eventhub.common.model.entity.Vip}
     * @return JobTitle {@link org.eventhub.common.model.entity.JobTitle}
     * @author Aya Taha
     */
    
    @Query(value = "from JobTitle as jt where ?1 member of jt.vips and  jt.deleted=0")
    public JobTitle findByVips(Vip vip);
}
