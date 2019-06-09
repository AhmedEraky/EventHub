package org.eventhub.facade.EventGuestFacade.impl;

import org.eventhub.common.model.entity.EventGuest;
import org.eventhub.facade.EventGuestFacade.EventGuestFacade;
import org.eventhub.service.eventguest.EventGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Event Guest Facade implementation
 * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
 */
@Component
public class EventGuestFacadeImpl implements EventGuestFacade {

    @Autowired
    EventGuestService eventGuestService;

    /**
     * method to create Event Guest
     * @param eventGuest Event Guest to be created
     * @return {@link EventGuest}  Event Guest created with new generated {@link UUID}
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    public EventGuest createEventGuest(EventGuest eventGuest) {
        return eventGuestService.createEventGuest(eventGuest);
    }

    /**
     * method to update Event Guest
     * @param eventGuest Event Guest to be updated
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    public void updateEventGuest(EventGuest eventGuest) {
        eventGuestService.updateEventGuest(eventGuest);
    }

    /**
     * method to get Event Guest by {@link UUID}
     * @param id Event Guest {@link UUID} to be retrieved
     * @return {@link EventGuest}  Event Guest with the specified {@link UUID}
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    public EventGuest getEventGuest(UUID id) {
        return eventGuestService.getEventGuest(id);
    }
}
