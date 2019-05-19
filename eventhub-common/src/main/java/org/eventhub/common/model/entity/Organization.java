/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.common.model.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
@Entity
@Table(name = "organization")
@XmlRootElement
public class Organization extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name",length=45)
    private String name;
    @Column(name = "description",length=500)
    private String description;
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @OneToMany(mappedBy = "organization")
    private Set<SystemUser> systemUsers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Set<Event> events;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Set<Vip> vips;

    public Organization() {
    }

    public Organization(UUID uuid) {
        super(uuid);
    }

    public Organization(UUID uuid, String name) {
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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @XmlTransient
    public Set<SystemUser> getSystemUsers() {
        return systemUsers;
    }

    public void setSystemUsers(Set<SystemUser> systemUsers) {
        this.systemUsers = systemUsers;
    }

    @XmlTransient
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @XmlTransient
    public Set<Vip> getVips() {
        return vips;
    }

    public void setVips(Set<Vip> vips) {
        this.vips = vips;
    }

}
