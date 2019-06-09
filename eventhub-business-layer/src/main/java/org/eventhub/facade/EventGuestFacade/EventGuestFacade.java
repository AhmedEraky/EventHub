package org.eventhub.facade.EventGuestFacade;

import org.eventhub.common.model.entity.EventGuest;
import org.eventhub.common.model.entity.SponsorshipType;

import java.util.UUID;

/**
 * Event Guest Facade interface
 * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
 */
public interface EventGuestFacade {
    public EventGuest createEventGuest(EventGuest eventGuest);
    public void updateEventGuest(EventGuest eventGuest);
    public EventGuest getEventGuest(UUID id);
}
