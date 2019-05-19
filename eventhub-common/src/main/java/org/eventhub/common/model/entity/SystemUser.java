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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
@Entity
@Table(name = "system_user")
@XmlRootElement
public class SystemUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "user_name",length=45)
    private String userName;
    @Basic(optional = false)
    @Column(name = "first_name",length=45)
    private String firstName;
    @Column(name = "middle_name",length=45)
    private String middleName;
    @Column(name = "last_name",length=45)
    private String lastName;
    @Basic(optional = false)
    @Column(name = "password",length=45)
    private String password;
    @Basic(optional = false)
    @Column(name = "email",length=45)
    private String email;
    @Column(name = "profile_image",length=100)
    private String profileImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private Set<SystemUserPhone> systemUserPhones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private Set<EventGuest> eventGuests;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private Set<Instructor> instructors;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private Set<SystemUserHasRole> systemUserHasRoles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private Set<EventCoordinator> eventCoordinators;
    @JoinColumn(name = "country", referencedColumnName = "uuid")
    @ManyToOne
    private Country country;
    @JoinColumn(name = "job_title", referencedColumnName = "uuid")
    @ManyToOne
    private JobTitle jobTitle;
    @JoinColumn(name = "organization", referencedColumnName = "uuid")
    @ManyToOne
    private Organization organization;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private Set<Event> event;

    public SystemUser() {
    }

    public SystemUser(UUID uuid) {
        super(uuid);
    }

    public SystemUser(UUID uuid, String username, String firstName, String password, String email) {
        super(uuid);
        this.userName = username;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @XmlTransient
    public Set<SystemUserPhone> getSystemUserPhones() {
        return systemUserPhones;
    }

    public void setSystemUserPhones(Set<SystemUserPhone> systemUserPhones) {
        this.systemUserPhones = systemUserPhones;
    }

    @XmlTransient
    public Set<EventGuest> getEventGuests() {
        return eventGuests;
    }

    public void setEventGuests(Set<EventGuest> eventGuests) {
        this.eventGuests = eventGuests;
    }

    @XmlTransient
    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    @XmlTransient
    public Set<SystemUserHasRole> getSystemUserHasRoles() {
        return systemUserHasRoles;
    }

    public void setSystemUserHasRoles(Set<SystemUserHasRole> systemUserHasRoles) {
        this.systemUserHasRoles = systemUserHasRoles;
    }

    @XmlTransient
    public Set<EventCoordinator> getEventCoordinators() {
        return eventCoordinators;
    }

    public void setEventCoordinators(Set<EventCoordinator> eventCoordinators) {
        this.eventCoordinators = eventCoordinators;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @XmlTransient
    public Set<Event> getEventSet() {
        return event;
    }

    public void setEventSet(Set<Event> event) {
        this.event = event;
    }


}
