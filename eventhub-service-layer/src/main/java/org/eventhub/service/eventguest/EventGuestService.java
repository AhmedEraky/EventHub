package org.eventhub.service.eventguest;

import org.eventhub.common.model.entity.EventGuest;

import java.util.UUID;

/**
 * Event Guest Service interface
 * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
 */
public interface EventGuestService {
    public EventGuest createEventGuest(EventGuest eventGuest);
    public void updateEventGuest(EventGuest eventGuest);
    public EventGuest getEventGuest(UUID id);
}
