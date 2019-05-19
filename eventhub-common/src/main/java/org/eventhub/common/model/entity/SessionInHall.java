/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.common.model.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
@Entity
@Table(name = "session_in_hall")
@XmlRootElement
public class SessionInHall extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "order_number")
    private int orderNumber;
    @JoinColumn(name = "hall", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Hall hall;
    @JoinColumn(name = "session", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Session session;

    public SessionInHall() {
    }

    public SessionInHall(UUID uuid) {
        super(uuid);
    }

    public SessionInHall(UUID uuid, int order) {
        super(uuid);
        this.orderNumber = order;
    }

    public int getOrder() {
        return orderNumber;
    }

    public void setOrder(int order) {
        this.orderNumber = order;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
