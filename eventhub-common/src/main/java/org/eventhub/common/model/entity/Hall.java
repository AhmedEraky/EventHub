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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "hall")
@XmlRootElement
public class Hall extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max=45,message="Floor name shouldn't exceed 45 characters.")
    @Column(name = "floor",length=45)
    private String floor;
    @Size(max=45,message="Building name shouldn't exceed 45 characters.")
    @Column(name = "building",length=45)
    private String building;
    @Size(max=30,message="Hall name shouldn't exceed 30 characters.")
    @Basic(optional = false)
    @Column(name = "name",length=30)
    private String name;
    @Column(name = "capacity")
    private Integer capacity;
    @JoinColumn(name = "event", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Event event;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hall")
    private List<SessionInHall> sessionInHalls;

    public Hall() {
    }

    public Hall(UUID uuid) {
        super(uuid);
    }

    public Hall(UUID uuid, String name) {
        super(uuid);
        this.name = name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<SessionInHall> getSessionInHalls() {
        return sessionInHalls;
    }

    public void setSessionInHalls(List<SessionInHall> sessionInHalls) {
        this.sessionInHalls = sessionInHalls;
    }
}
