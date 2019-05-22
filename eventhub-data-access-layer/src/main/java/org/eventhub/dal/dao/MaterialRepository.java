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
 *
 *  Material interface has the needed methods to retrieve according to Unique
 * 
 *  @author Aya Taha (aya.taha.ali.93@gmail.com)
 */
@Repository
public interface MaterialRepository extends BaseRepository<Material> {

    /**
     *  retrieve material based on Path
     * @param path
     * @return  Material {@link org.eventhub.common.model.entity.Material}
     *  @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value = "from Material as m where  m.path=?1 and m.deleted=0")
    public Material findByPath(String path);
    
    /**
     *  retrieve material based on sessionInstructor
     * @param sessionInstructor {@link org.eventhub.common.model.entity.SessionInstructor}
     * @param pageable set number and size of pages 
     * @return list of Material {@link org.eventhub.common.model.entity.Material}
     *  @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    
    @Query(value = "from Material as m where  m.sessionInstructor=?1 and m.deleted=0")
    public List<Material> findBySessionInstructor(SessionInstructor sessionInstructor, Pageable pageable);
}
