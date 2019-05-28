/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.common.model.entity;

import java.io.Serializable;
import java.util.UUID;
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
@Table(name = "vip_speaks_in_session")
@XmlRootElement
public class VipSpeaksInSession extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "session", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Session session;
    @JoinColumn(name = "vip", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Vip vip;

    public VipSpeaksInSession() {
    }

    public VipSpeaksInSession(UUID uuid) {
        super(uuid);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Vip getVip() {
        return vip;
    }

    public void setVip(Vip vip) {
        this.vip = vip;
    }
}
