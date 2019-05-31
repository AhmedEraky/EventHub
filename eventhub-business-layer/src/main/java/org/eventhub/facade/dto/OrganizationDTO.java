/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.dto;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import org.eventhub.common.model.entity.Event;
import org.eventhub.common.model.entity.Organization;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.common.model.entity.Vip;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
public class OrganizationDTO {

    private String name;

    private String description;

    private MultipartFile logo;

    private List<SystemUser> systemUsers;
    private List<Event> events;

    private List<Vip> vips;

    public OrganizationDTO() {
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

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }


    public List<SystemUser> getSystemUsers() {
        return systemUsers;
    }

    public void setSystemUsers(List<SystemUser> systemUsers) {
        this.systemUsers = systemUsers;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Vip> getVips() {
        return vips;
    }

    public void setVips(List<Vip> vips) {
        this.vips = vips;
    }
    
    
    public Organization getEntity() throws IllegalArgumentException, IllegalAccessException, IOException {
        Organization organization = new Organization();
        for (Field field : OrganizationDTO.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType().equals(MultipartFile.class)) {
                MultipartFile multipartFile = (MultipartFile) field.get(MultipartFile.class);
                organization.setLogo(multipartFile.getBytes());
            } else {
                System.out.println("=======" + field.get(this));
                field.set(organization, field.get(this));
            }
        }


        return organization;
    }
    
    
}
