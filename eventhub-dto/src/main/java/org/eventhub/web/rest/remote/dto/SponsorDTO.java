/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.web.rest.remote.dto;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */
public class SponsorDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private byte[] logo;
    private String url;
    private EventDTO event;
    private SponsorshipTypeDTO sponsorshipType;

    public SponsorDTO() {
    }

    public SponsorDTO(UUID uuid) {
        super(uuid);
    }

    public SponsorDTO(UUID uuid, String name) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public SponsorshipTypeDTO getSponsorDTOshipType() {
        return sponsorshipType;
    }

    public void setSponsorDTOshipType(SponsorshipTypeDTO sponsorshipType) {
        this.sponsorshipType = sponsorshipType;
    }
}
