
package org.eventhub.facade.instructor.Impl;

import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Instructor;
import org.eventhub.facade.instructor.RetrieveInstructorFacade;
import org.eventhub.service.instructor.RetrieveInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Menna Helmy
 */
@Component
public class RetrieveInstructorFacadeImpl implements RetrieveInstructorFacade{
    
    @Autowired
    RetrieveInstructorService retrieveInstructorService;

    @Override
    public List<Instructor> getAllInstructors() {
        return retrieveInstructorService.getAllInstructors();
    }

    @Override
    public Instructor getInstructorByUUID(UUID uuid) {
        return retrieveInstructorService.getInstructorByUUID(uuid);
    }

    
    
}
