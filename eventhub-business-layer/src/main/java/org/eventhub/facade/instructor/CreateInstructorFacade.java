
package org.eventhub.facade.instructor;

import org.eventhub.common.model.entity.Instructor;

/**
 *
 * @author Menna Helmy
 */
public interface CreateInstructorFacade {
    
    Instructor createInstructor(Instructor instructor);
    void updateInstructor(Instructor instructor);
}
