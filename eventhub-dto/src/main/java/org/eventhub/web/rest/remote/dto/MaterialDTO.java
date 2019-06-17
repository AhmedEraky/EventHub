/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.rest.remote.dto;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */
public class MaterialDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String path;
    private SessionInstructorDTO sessionInstructor;

    public MaterialDTO() {
    }

    public MaterialDTO(UUID uuid) {
        super(uuid);
    }

    public MaterialDTO(UUID uuid, String path) {
        super(uuid);
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public SessionInstructorDTO getSessionInstructor() {
        return sessionInstructor;
    }

    public void setSessionInstructor(SessionInstructorDTO sessionInstructor) {
        this.sessionInstructor = sessionInstructor;
    }
}
