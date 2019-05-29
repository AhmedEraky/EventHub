
package org.eventhub.service.instructor.impl;

import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Instructor;
import org.eventhub.dal.dao.InstructorRepository;
import org.eventhub.service.instructor.RetrieveInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Menna Helmy
 */
@Service
public class RetrieveInstructorServiceImpl implements RetrieveInstructorService{

    @Autowired
    InstructorRepository instructorRepository;
    
    @Transactional
    @Override
    public List<Instructor> getAllInstructors() {
        List<Instructor> instructors = instructorRepository.findAll();
        return instructors;
    }

    @Transactional
    @Override
    public Instructor getInstructorByUUID(UUID id) {
        Instructor instructor = instructorRepository.getOne(id);
        instructor.getSystemUser();
        return instructor;
    }
    
}
