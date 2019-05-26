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
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

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
    @Basic(optional = false)
    @Column(name = "gender",length=10)
    private UserGender gender;
    @Basic(optional = false)
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Column(name = "profile_image",length=100)
    private String profileImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private List<SystemUserPhone> systemUserPhones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private List<EventGuest> eventGuests;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private List<Instructor> instructors;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private List<SystemUserHasRole> systemUserHasRoles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUser")
    private List<EventCoordinator> eventCoordinators;
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
    private List<Event> event;

    public SystemUser() {
    }

    public SystemUser(UUID uuid) {
        super(uuid);
    }

    public SystemUser(UUID uuid, String username, String firstName, String password, String email,UserGender gender,Date dateOfBirth) {
        super(uuid);
        this.userName = username;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
        this.gender=gender;
        this.dateOfBirth=dateOfBirth;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public UserGender getGender() {
        return gender;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public List<SystemUserPhone> getSystemUserPhones() {
        return systemUserPhones;
    }

    public void setSystemUserPhones(List<SystemUserPhone> systemUserPhones) {
        this.systemUserPhones = systemUserPhones;
    }

    public List<EventGuest> getEventGuests() {
        return eventGuests;
    }

    public void setEventGuests(List<EventGuest> eventGuests) {
        this.eventGuests = eventGuests;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<SystemUserHasRole> getSystemUserHasRoles() {
        return systemUserHasRoles;
    }

    public void setSystemUserHasRoles(List<SystemUserHasRole> systemUserHasRoles) {
        this.systemUserHasRoles = systemUserHasRoles;
    }

    public List<EventCoordinator> getEventCoordinators() {
        return eventCoordinators;
    }

    public void setEventCoordinators(List<EventCoordinator> eventCoordinators) {
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

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
}
