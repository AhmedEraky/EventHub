/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.dto;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */
public class EventCoordinatorDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private EventDTO event;
    private SystemUserDTO systemUser;

    public EventCoordinatorDTO() {
    }

    public EventCoordinatorDTO(UUID uuid) {
        super(uuid);
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public SystemUserDTO getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUserDTO systemUser) {
        this.systemUser = systemUser;
    }

}
