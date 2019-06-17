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

public class SystemUserPhoneDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String phoneNumber;
    private SystemUserDTO systemUser;

    public SystemUserPhoneDTO() {
    }

    public SystemUserPhoneDTO(UUID uuid) {
        super(uuid);
    }

    public SystemUserPhoneDTO(UUID uuid, String phoneNumber) {
        super(uuid);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SystemUserDTO getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUserDTO systemUser) {
        this.systemUser = systemUser;
    }
}
