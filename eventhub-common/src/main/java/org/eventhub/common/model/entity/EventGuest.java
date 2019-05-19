/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.common.model.entity;

import java.io.Serializable;
import java.util.UUID;
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
@Table(name = "event_guest")
@XmlRootElement
public class EventGuest extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "feedback_rating")
    private Integer feedbackRating;
    @Column(name = "feedback_review",length=45)
    private String feedbackReview;
    @JoinColumn(name = "event", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Event event;
    @JoinColumn(name = "system_user", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private SystemUser systemUser;

    public EventGuest() {
    }

    public EventGuest(UUID uuid) {
        super(uuid);
    }

    public Integer getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(Integer feedbackRating) {
        this.feedbackRating = feedbackRating;
    }

    public String getFeedbackReview() {
        return feedbackReview;
    }

    public void setFeedbackReview(String feedbackReview) {
        this.feedbackReview = feedbackReview;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

}
