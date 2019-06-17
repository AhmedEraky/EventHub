package org.eventhub.facade.dto;

import org.eventhub.common.model.entity.Instructor;
import org.eventhub.common.model.entity.SessionInstructor;

import java.lang.reflect.Field;
import java.util.List;

public class InstructorDTO {

    private String bio;

    private String jobTitle;

    private List<SessionInstructor> sessionInstructors;

    private SystemUserDTO systemUserDTO;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<SessionInstructor> getSessionInstructors() {
        return sessionInstructors;
    }

    public void setSessionInstructors(List<SessionInstructor> sessionInstructors) {
        this.sessionInstructors = sessionInstructors;
    }

    public SystemUserDTO getSystemUserDTO() {
        return systemUserDTO;
    }

    public void setSystemUserDTO(SystemUserDTO systemUserDTO) {
        this.systemUserDTO = systemUserDTO;
    }

    public Instructor getEntity() throws IllegalAccessException {
        Instructor instructor = new Instructor();
        for(Field  field : InstructorDTO.class.getDeclaredFields()){
            field.set(instructor,field.get(this));
        }
        return instructor;
    }
}
