/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.dto;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import org.eventhub.common.model.entity.Country;
import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.EventCoordinator;
import org.eventhub.common.model.entity.EventGuest;
import org.eventhub.common.model.entity.Instructor;
import org.eventhub.common.model.entity.JobTitle;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.common.model.entity.SystemUserHasRole;
import org.eventhub.common.model.entity.SystemUserPhone;
import org.eventhub.common.model.entity.UserGender;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author FARES-LAP
 */
public class SystemUserDTO {

    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String email;
    private UserGender gender;
    private Date dateOfBirth;
    private MultipartFile profileImageMultipart;
    private List<SystemUserPhone> systemUserPhones;
    private List<EventGuest> eventGuests;
    private List<Instructor> instructors;
    private List<SystemUserHasRole> systemUserHasRoles;
    private List<EventCoordinator> eventCoordinators;
    private Country country;
    private JobTitle jobTitle;
    private Organization organization;
    private List<Event> event;

    public SystemUserDTO() {
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

    public MultipartFile getProfileImageMultipart() {
        return profileImageMultipart;
    }

    public void setProfileImageMultipart(MultipartFile profileImageMultipart) {
        this.profileImageMultipart = profileImageMultipart;
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

    public SystemUser getEntity() throws IllegalArgumentException, IllegalAccessException {
        SystemUser systemUser = new SystemUser();
        for (Field field : SystemUserDTO.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType().equals(MultipartFile.class)) {
                MultipartFile multipartFile = (MultipartFile) field.get(MultipartFile.class);
                systemUser.setProfileImage(multipartFile.getOriginalFilename());
            } else {
                System.out.println("=======" + field.get(this));
                //field.set(systemUser, field.get(this));
            }
        }


        return systemUser;
    }
}
