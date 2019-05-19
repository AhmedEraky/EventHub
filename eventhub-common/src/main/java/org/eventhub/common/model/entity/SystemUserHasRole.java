/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.common.model.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
@Entity
@Table(name = "system_user_has_role")
@XmlRootElement
public class SystemUserHasRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "role", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Role role;
    @JoinColumn(name = "system_user", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private SystemUser systemUser;

    public SystemUserHasRole() {
    }

    public SystemUserHasRole(UUID uuid) {
        super(uuid);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
    
}
