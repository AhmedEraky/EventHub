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
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */

public class HallDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String floor;
    private String building;
    private String name;
    private Integer capacity;
    private EventDTO event;
    private List<SessionInHallDTO> sessionInHallDTOs;

    public HallDTO() {
    }

    public HallDTO(UUID uuid) {
        super(uuid);
    }

    public HallDTO(UUID uuid, String name) {
        super(uuid);
        this.name = name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public List<SessionInHallDTO> getSessionInHallDTOs() {
        return sessionInHallDTOs;
    }

    public void setSessionInHallDTOs(List<SessionInHallDTO> sessionInHallDTOs) {
        this.sessionInHallDTOs = sessionInHallDTOs;
    }
}
