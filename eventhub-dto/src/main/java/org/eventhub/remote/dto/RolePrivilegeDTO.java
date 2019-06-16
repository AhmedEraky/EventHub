/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.dto;

import java.io.Serializable;
/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */

public class RolePrivilegeDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private PrivilegeDTO privilege;
    private RoleDTO role;

    public RolePrivilegeDTO() {
    }

    public PrivilegeDTO getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeDTO privilege) {
        this.privilege = privilege;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}
