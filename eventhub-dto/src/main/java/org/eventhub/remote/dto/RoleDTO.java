/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */

public class RoleDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private List<RolePrivilegeDTO> rolePrivileges;
    private List<SystemUserHasRoleDTO> systemUserHasRoleDTOs;

    public RoleDTO() {
    }

    public RoleDTO(UUID uuid) {
        super(uuid);
    }

    public RoleDTO(UUID uuid, String name) {
        super(uuid);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RolePrivilegeDTO> getRoleDTOPrivileges() {
        return rolePrivileges;
    }

    public void setRoleDTOPrivileges(List<RolePrivilegeDTO> rolePrivileges) {
        this.rolePrivileges = rolePrivileges;
    }

    public List<SystemUserHasRoleDTO> getSystemUserHasRoleDTOs() {
        return systemUserHasRoleDTOs;
    }

    public void setSystemUserHasRoleDTOs(List<SystemUserHasRoleDTO> systemUserHasRoleDTOs) {
        this.systemUserHasRoleDTOs = systemUserHasRoleDTOs;
    }
}
