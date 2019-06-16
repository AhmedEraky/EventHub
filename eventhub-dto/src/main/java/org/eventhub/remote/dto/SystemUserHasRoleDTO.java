/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.dto;

import java.io.Serializable;
import java.util.UUID;
/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
public class SystemUserHasRoleDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private RoleDTO role;
    private SystemUserDTO systemUser;

    public SystemUserHasRoleDTO() {
    }

    public SystemUserHasRoleDTO(UUID uuid) {
        super(uuid);
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public SystemUserDTO getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUserDTO systemUser) {
        this.systemUser = systemUser;
    }
}
