
package org.eventhub.service.instructor.impl;

import org.eventhub.common.model.entity.Instructor;
import org.eventhub.dal.dao.InstructorRepository;
import org.eventhub.service.instructor.CreateInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Menna Helmy
 */
@Service
public class CreateInstructorServiceImpl implements CreateInstructorService{
    
    @Autowired
    InstructorRepository instructorRepository;

    @Transactional
    @Override
    public Instructor createInstructor(Instructor instructor) {
        Instructor instructorSaved = instructorRepository.save(instructor);
        return instructorSaved;
    }

    @Transactional
    @Override
    public void updateInstructor(Instructor instructor) {
        instructorRepository.update(instructor);
    }
    
}
