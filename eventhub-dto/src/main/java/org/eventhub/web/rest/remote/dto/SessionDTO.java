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

public class SessionDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date startDate;
    private Date endDate;
    private String name;
    private String shortDescription;
    private String longDescription;
    private int capacity;
    private EventDTO event;
    private SessionTypeDTO sessionType;
    private List<SessionInHallDTO> sessionInHalls;
    private List<SessionInstructorDTO> sessionInstructors;
    private List<VipSpeaksInSessionDTO> vipSpeaksInSessionDTOs;

    public SessionDTO() {
    }

    public SessionDTO(UUID uuid) {
        super(uuid);
    }

    public SessionDTO(UUID uuid, Date startDate, Date endDate, String name, String shortDescription, int capacity) {
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

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public SessionTypeDTO getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionTypeDTO sessionType) {
        this.sessionType = sessionType;
    }

    public List<SessionInHallDTO> getSessionInHalls() {
        return sessionInHalls;
    }

    public void setSessionInHalls(List<SessionInHallDTO> sessionInHalls) {
        this.sessionInHalls = sessionInHalls;
    }

    public List<SessionInstructorDTO> getSessionInstructors() {
        return sessionInstructors;
    }

    public void setSessionInstructors(List<SessionInstructorDTO> sessionInstructors) {
        this.sessionInstructors = sessionInstructors;
    }

    public List<VipSpeaksInSessionDTO> getVipSpeaksInSessions() {
        return vipSpeaksInSessionDTOs;
    }

    public void setVipSpeaksInSessions(List<VipSpeaksInSessionDTO> vipSpeaksInSessionDTOs) {
        this.vipSpeaksInSessionDTOs = vipSpeaksInSessionDTOs;
    }
}
