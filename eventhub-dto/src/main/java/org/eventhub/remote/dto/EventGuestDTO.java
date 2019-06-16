/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.remote.dto;

import java.io.Serializable;
import java.util.UUID;


/**
 * @author Mohamed Ali
 * @author Amr Saber
 * @author Hamada Abdrabou
 */
public class EventGuestDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer feedbackRating;
    private String feedbackReview;
    private EventDTO event;
    private SystemUserDTO systemUser;

    public EventGuestDTO() {
    }

    public EventGuestDTO(UUID uuid) {
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

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public SystemUserDTO getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUserDTO systemUser) {
        this.systemUser = systemUser;
    }

}
