/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.common.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
@Entity
@Table(name = "session")
@XmlRootElement
public class Session extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "name",length=45)
    private String name;
    @Basic(optional = false)
    @Column(name = "short_description",length=200)
    private String shortDescription;
    @Column(name = "long_description",length=500)
    private String longDescription;
    @Basic(optional = false)
    @Column(name = "capacity")
    private int capacity;
    @JoinColumn(name = "event", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Event event;
    @JoinColumn(name = "session_type", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private SessionType sessionType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private List<SessionInHall> sessionInHalls;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private List<SessionInstructor> sessionInstructors;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private List<VipSpeaksInSession> vipSpeaksInSessions;

    public Session() {
    }

    public Session(UUID uuid) {
        super(uuid);
    }

    public Session(UUID uuid, Date startDate, Date endDate, String name, String shortDescription, int capacity) {
        super(uuid);
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.shortDescription = shortDescription;
        this.capacity = capacity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public List<SessionInHall> getSessionInHalls() {
        return sessionInHalls;
    }

    public void setSessionInHalls(List<SessionInHall> sessionInHalls) {
        this.sessionInHalls = sessionInHalls;
    }

    public List<SessionInstructor> getSessionInstructors() {
        return sessionInstructors;
    }

    public void setSessionInstructors(List<SessionInstructor> sessionInstructors) {
        this.sessionInstructors = sessionInstructors;
    }

    public List<VipSpeaksInSession> getVipSpeaksInSessions() {
        return vipSpeaksInSessions;
    }

    public void setVipSpeaksInSessions(List<VipSpeaksInSession> vipSpeaksInSessions) {
        this.vipSpeaksInSessions = vipSpeaksInSessions;
    }
}
