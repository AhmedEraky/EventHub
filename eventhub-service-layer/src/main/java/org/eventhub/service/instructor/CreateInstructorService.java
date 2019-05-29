
package org.eventhub.service.instructor;

import org.eventhub.common.model.entity.Instructor;

/**
 *
 * @author Menna Helmy
 */
public interface CreateInstructorService {
    
    public Instructor createInstructor(Instructor instructor);
    public void updateInstructor(Instructor instructor);
}
