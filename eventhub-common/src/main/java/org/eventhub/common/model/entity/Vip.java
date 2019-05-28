/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.common.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "vip")
@XmlRootElement
public class Vip extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "bio",length=100)
    private String bio;
    @Basic(optional = false)
    @Column(name = "name",length=45)
    private String name;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vip")
    private List<VipSpeaksInSession> vipSpeaksInSessions;
    @JoinColumn(name = "job_title", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private JobTitle jobTitle;
    @JoinColumn(name = "organization", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Organization organization;

    public Vip() {
    }

    public Vip(UUID uuid) {
        super(uuid);
    }

    public Vip(UUID uuid, String bio, String name) {
        super(uuid);
        this.bio = bio;
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<VipSpeaksInSession> getVipSpeaksInSessions() {
        return vipSpeaksInSessions;
    }

    public void setVipSpeaksInSessions(List<VipSpeaksInSession> vipSpeaksInSessions) {
        this.vipSpeaksInSessions = vipSpeaksInSessions;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
