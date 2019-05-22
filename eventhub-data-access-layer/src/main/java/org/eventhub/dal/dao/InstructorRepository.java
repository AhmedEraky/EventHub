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
 *  Instructor interface has the needed methods to retrieve
 * according to Unique key or join sql
 * @author Aya Taha (aya.taha.ali.93@gmail.com)
 */

public interface InstructorRepository extends BaseRepository<Instructor>{

    /**
     *  retrieve Instructor based on bio
     * @param bio
     * @return Instructor {@link org.eventhub.common.model.entity.Instructor}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value = "from Instructor as i where  i.bio=?1 and i.deleted=0")
    public Instructor findByBio(String bio);

    /**
     *  retrieve Instructor based on jobTilte
     * @param jobTitle {@link org.eventhub.common.model.entity.JobTitle}
     * @return Instructor {@link org.eventhub.common.model.entity.Instructor}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value = "from Instructor as i where  i.jobTitle=?1 and  i.deleted=0")
    public Instructor findByJobTitle(String jobTitle);

    /**
     *  retrieve Instructor based on   sessionInstructor
     * @param sessionInstructor
     * {@link org.eventhub.common.model.entity.SessionInstructor}
     * @return Instructor {@link org.eventhub.common.model.entity.Instructor}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value = "from Instructor as i where ?1 member of i.sessionInstructors and  i.deleted=0")
    public Instructor findBySessionInstructor(SessionInstructor sessionInstructor);

    /**
     *  retrieve Instructor based on systemUser
     * @param systemUser {@link org.eventhub.common.model.entity.SystemUser}
     * @return list of Instructor {@link org.eventhub.common.model.entity.Instructor}
     * @author Aya Taha (aya.taha.ali.93@gmail.com)
     */
    @Query(value = "from Instructor as i where  i.systemUser =?1 and  i.deleted=0")
    public List<Instructor> findAllBySystemUser(SystemUser systemUser, Pageable pageable);

}
