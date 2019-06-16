/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.common.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
@Entity
@Table(name = "instructor")
@XmlRootElement
public class Instructor extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "bio",length=500)
    private String bio;
    @Column(name = "job_title",length=45)
    private String jobTitle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<SessionInstructor> sessionInstructors;
    @JoinColumn(name = "system_user", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private SystemUser systemUser;

    public Instructor() {
    }

    public Instructor(UUID uuid) {
        super(uuid);
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<SessionInstructor> getSessionInstructors() {
        return sessionInstructors;
    }

    public void setSessionInstructors(List<SessionInstructor> sessionInstructors) {
        this.sessionInstructors = sessionInstructors;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
}
