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
@Table(name = "material")
@XmlRootElement
public class Material extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "path",length=100)
    private String path;
    @JoinColumn(name = "session_instructor", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private SessionInstructor sessionInstructor;

    public Material() {
    }

    public Material(UUID uuid) {
        super(uuid);
    }

    public Material(UUID uuid, String path) {
        super(uuid);
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public SessionInstructor getSessionInstructor() {
        return sessionInstructor;
    }

    public void setSessionInstructor(SessionInstructor sessionInstructor) {
        this.sessionInstructor = sessionInstructor;
    }
}
