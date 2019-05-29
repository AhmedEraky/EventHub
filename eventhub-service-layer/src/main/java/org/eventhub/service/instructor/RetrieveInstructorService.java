
package org.eventhub.service.instructor;

import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Instructor;

/**
 *
 * @author Menna Helmy
 */
public interface RetrieveInstructorService {
    
    public List<Instructor> getAllInstructors();
    public Instructor getInstructorByUUID(UUID id);
    
}
