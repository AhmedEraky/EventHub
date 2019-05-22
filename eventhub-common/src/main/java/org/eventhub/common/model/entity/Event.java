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
import javax.persistence.Lob;
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
@Table(name = "event")
@XmlRootElement
public class Event extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name",length=45)
    private String name;
    @Basic(optional = false)
    @Column(name = "short_description",length=200)
    private String shortDescription;

    @Column(name = "long_description",length=1000)
    private String longDescription;
    @Basic(optional = false)
    @Column(name = "address",length=100)
    private String address;
    @Column(name = "latitude",length=45)
    private String latitude;
    @Column(name = "longitude",length=45)
    private String longitude;
    @Column(name = "slogan",length=45)
    private String slogan;
    @Column(name = "abbreviation",length=45)
    private String abbreviation;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @Column(name = "background",length=100)
    private String background;
    @Column(name = "published")
    private Short published;
    @Basic(optional = false)
    @Column(name = "style",length=10)
    private String style;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Sponsor> sponsors;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Session> sessions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Hall> halls;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<EventGuest> eventGuests;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<EventCoordinator> eventCoordinators;
    @JoinColumn(name = "organization", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Organization organization;
    @JoinColumn(name = "system_user", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private SystemUser systemUser;

    public Event() {
    }

    public Event(UUID uuid) {
        super(uuid);
    }

    public Event(UUID uuid, String name, String shortDescription, String address, Date startDate, Date endDate,String style) {
        super(uuid);
        this.name = name;
        this.shortDescription = shortDescription;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.style=style;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Short getPublished() {
        return published;
    }

    public void setPublished(Short published) {
        this.published = published;
    }

    @XmlTransient
    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    @XmlTransient
    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @XmlTransient
    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

    @XmlTransient
    public List<EventGuest> getEventGuests() {
        return eventGuests;
    }

    public void setEventGuests(List<EventGuest> eventGuests) {
        this.eventGuests = eventGuests;
    }

    @XmlTransient
    public List<EventCoordinator> getEventCoordinators() {
        return eventCoordinators;
    }

    public void setEventCoordinators(List<EventCoordinator> eventCoordinators) {
        this.eventCoordinators = eventCoordinators;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

}
