/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.rest.remote.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


/**
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */

public class InstructorDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String bio;
    private String jobTitle;
    private List<SessionInstructorDTO> sessionInstructorDTOs;
    private SystemUserDTO systemUser;

    public InstructorDTO() {
    }

    public InstructorDTO(UUID uuid) {
        super(uuid);
    }

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

    public List<SessionInstructorDTO> getSessionInstructors() {
        return sessionInstructorDTOs;
    }

    public void setSessionInstructors(List<SessionInstructorDTO> sessionInstructorDTOs) {
        this.sessionInstructorDTOs = sessionInstructorDTOs;
    }

    public SystemUserDTO getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUserDTO systemUser) {
        this.systemUser = systemUser;
    }
}
