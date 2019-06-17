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
public class EventDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String shortDescription;

    private String longDescription;
    private String address;
    private String latitude;
    private String longitude;
    private String slogan;
    private String abbreviation;
    private Date startDate;
    private Date endDate;
    private byte[] logo;
    private String background;
    private Short published;
    private String style;
    private List<SponsorDTO> sponsors;
    private List<SessionDTO> sessions;
    private List<HallDTO> halls;
    private List<EventGuestDTO> eventGuests;
    private List<EventCoordinatorDTO> eventCoordinators;
    private OrganizationDTO organization;
    private SystemUserDTO systemUser;

    public EventDTO() {
    }

    public EventDTO(UUID uuid) {
        super(uuid);
    }

    public EventDTO(UUID uuid, String name, String shortDescription, String address, Date startDate, Date endDate,String style) {
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public List<SponsorDTO> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<SponsorDTO> sponsors) {
        this.sponsors = sponsors;
    }

    public List<SessionDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDTO> sessions) {
        this.sessions = sessions;
    }

    public List<HallDTO> getHalls() {
        return halls;
    }

    public void setHalls(List<HallDTO> halls) {
        this.halls = halls;
    }

    public List<EventGuestDTO> getEventDTOGuests() {
        return eventGuests;
    }

    public void setEventDTOGuests(List<EventGuestDTO> eventGuests) {
        this.eventGuests = eventGuests;
    }

    public List<EventCoordinatorDTO> getEventDTOCoordinators() {
        return eventCoordinators;
    }

    public void setEventDTOCoordinators(List<EventCoordinatorDTO> eventCoordinators) {
        this.eventCoordinators = eventCoordinators;
    }

    public OrganizationDTO getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDTO organization) {
        this.organization = organization;
    }

    public SystemUserDTO getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUserDTO systemUser) {
        this.systemUser = systemUser;
    }
}
