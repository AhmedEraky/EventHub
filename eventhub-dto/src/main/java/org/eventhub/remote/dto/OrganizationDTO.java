/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


/**
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */
public class OrganizationDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private byte[] logo;
    private List<SystemUserDTO> systemUsers;
    private List<EventDTO> events;
    private List<VipDTO> vips;

    public OrganizationDTO() {
    }

    public OrganizationDTO(UUID uuid) {
        super(uuid);
    }

    public OrganizationDTO(UUID uuid, String name) {
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

    public List<SystemUserDTO> getSystemUsers() {
        return systemUsers;
    }

    public void setSystemUsers(List<SystemUserDTO> systemUsers) {
        this.systemUsers = systemUsers;
    }

    public List<EventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }

    public List<VipDTO> getVips() {
        return vips;
    }

    public void setVips(List<VipDTO> vips) {
        this.vips = vips;
    }
}
