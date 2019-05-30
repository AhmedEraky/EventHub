
package org.eventhub.facade.instructor.Impl;

import org.eventhub.common.model.entity.Instructor;
import org.eventhub.facade.instructor.CreateInstructorFacade;
import org.eventhub.service.instructor.CreateInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Menna Helmy
 */

@Component
public class CreateInstructorFacadeImpl implements CreateInstructorFacade{
    
    @Autowired
    CreateInstructorService createInstructorService;

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return createInstructorService.createInstructor(instructor);
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        createInstructorService.updateInstructor(instructor);
    }
    
}
