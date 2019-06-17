/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.rest.remote.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */

public class SystemUserDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String email;
    private UserGenderDTO gender;
    private Date dateOfBirth;
    private String profileImage;
    private List<SystemUserPhoneDTO> systemUserPhones;
    private List<EventGuestDTO> eventGuests;
    private List<InstructorDTO> instructors;
    private List<SystemUserHasRoleDTO> systemUserHasRoles;
    private List<EventCoordinatorDTO> eventCoordinators;
    private CountryDTO country;
    private JobTitleDTO jobTitle;
    private OrganizationDTO organization;
    private List<EventDTO> event;

    public SystemUserDTO() {
    }

    public SystemUserDTO(UUID uuid) {
        super(uuid);
    }

    public SystemUserDTO(UUID uuid, String username, String firstName, String password, String email,UserGenderDTO gender,Date dateOfBirth) {
        super(uuid);
        this.userName = username;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
        this.gender=gender;
        this.dateOfBirth=dateOfBirth;
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

    public UserGenderDTO getGender() {
        return gender;
    }

    public void setGender(UserGenderDTO gender) {
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

    public List<SystemUserPhoneDTO> getSystemUserPhones() {
        return systemUserPhones;
    }

    public void setSystemUserPhones(List<SystemUserPhoneDTO> systemUserPhones) {
        this.systemUserPhones = systemUserPhones;
    }

    public List<EventGuestDTO> getEventGuests() {
        return eventGuests;
    }

    public void setEventGuests(List<EventGuestDTO> eventGuests) {
        this.eventGuests = eventGuests;
    }

    public List<InstructorDTO> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<InstructorDTO> instructors) {
        this.instructors = instructors;
    }

    public List<SystemUserHasRoleDTO> getSystemUserHasRoles() {
        return systemUserHasRoles;
    }

    public void setSystemUserHasRoles(List<SystemUserHasRoleDTO> systemUserHasRoles) {
        this.systemUserHasRoles = systemUserHasRoles;
    }

    public List<EventCoordinatorDTO> getEventCoordinators() {
        return eventCoordinators;
    }

    public void setEventCoordinators(List<EventCoordinatorDTO> eventCoordinators) {
        this.eventCoordinators = eventCoordinators;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public JobTitleDTO getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitleDTO jobTitle) {
        this.jobTitle = jobTitle;
    }

    public OrganizationDTO getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDTO organization) {
        this.organization = organization;
    }

    public List<EventDTO> getEvent() {
        return event;
    }

    public void setEvent(List<EventDTO> event) {
        this.event = event;
    }
}
