/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.common.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
@Entity
@Table(name = "job_title")
@XmlRootElement
public class JobTitle extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(min = 2, max = 45,message = "{jobTitle.name.size}")
    @Basic(optional = false)
    @Column(name = "name",length=45)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobTitle")
    private List<SystemUser> systemUsers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobTitle")
    private List<Vip> vips;

    public JobTitle() {
    }

    public JobTitle(UUID uuid) {
        super(uuid);
    }

    public JobTitle(UUID uuid, String name) {
        super(uuid);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SystemUser> getSystemUsers() {
        return systemUsers;
    }

    public void setSystemUsers(List<SystemUser> systemUsers) {
        this.systemUsers = systemUsers;
    }

    public List<Vip> getVips() {
        return vips;
    }

    public void setVips(List<Vip> vips) {
        this.vips = vips;
    }
}
