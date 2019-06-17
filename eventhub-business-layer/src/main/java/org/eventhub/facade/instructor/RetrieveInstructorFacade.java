/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.instructor;

import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Instructor;

/**
 *
 * @author Menna Helmy
 */
public interface RetrieveInstructorFacade {
    List<Instructor> getAllInstructors();
    public Instructor getInstructorByUUID(UUID uuid);
    
}
