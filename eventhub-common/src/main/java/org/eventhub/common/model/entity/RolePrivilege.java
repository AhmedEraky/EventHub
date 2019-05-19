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
@Table(name = "role_privilege")
@XmlRootElement
public class RolePrivilege extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "privilege", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Privilege privilege;
    @JoinColumn(name = "role", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Role role;

    public RolePrivilege() {
    }

    public RolePrivilege(UUID uuid) {
        super(uuid);
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
