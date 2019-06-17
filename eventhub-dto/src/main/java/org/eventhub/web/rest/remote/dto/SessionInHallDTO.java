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

public class SessionInHallDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int orderNumber;
    private HallDTO hall;
    private SessionDTO session;

    public SessionInHallDTO() {
    }

    public SessionInHallDTO(UUID uuid) {
        super(uuid);
    }

    public SessionInHallDTO(UUID uuid, int order) {
        super(uuid);
        this.orderNumber = order;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public HallDTO getHall() {
        return hall;
    }

    public void setHall(HallDTO hall) {
        this.hall = hall;
    }

    public SessionDTO getSession() {
        return session;
    }

    public void setSession(SessionDTO session) {
        this.session = session;
    }
}
