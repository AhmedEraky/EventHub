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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
@Entity
@Table(name = "sponsor")
@XmlRootElement
public class Sponsor extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name",length=45)
    private String name;
    @Column(name = "description",length=500)
    private String description;
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @Column(name = "url",length=45)
    private String url;
    @JoinColumn(name = "event", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Event event;
    @JoinColumn(name = "sponsorship_type", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private SponsorshipType sponsorshipType;

    public Sponsor() {
    }

    public Sponsor(UUID uuid) {
        super(uuid);
    }

    public Sponsor(UUID uuid, String name) {
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public SponsorshipType getSponsorshipType() {
        return sponsorshipType;
    }

    public void setSponsorshipType(SponsorshipType sponsorshipType) {
        this.sponsorshipType = sponsorshipType;
    }

}
