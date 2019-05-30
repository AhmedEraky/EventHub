package org.eventhub.service.eventguest.impl;

import org.eventhub.common.model.entity.EventGuest;
import org.eventhub.dal.dao.EventGuestRepository;
import org.eventhub.service.eventguest.EventGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Event Guest Service implementation
 * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
 */
@Service
public class EventGuestServiceImpl implements EventGuestService {

    @Autowired
    EventGuestRepository eventGuestRepository;


    /**
     * method to create Event Guest
     * @param eventGuest Event Guest to be created
     * @return {@link EventGuest}  Event Guest created with new generated {@link UUID}
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    @Transactional
    public EventGuest createEventGuest(EventGuest eventGuest) {
        return eventGuestRepository.save(eventGuest);
    }


    /**
     * method to update Event Guest
     * @param eventGuest Event Guest to be updated
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    @Transactional
    public void updateEventGuest(EventGuest eventGuest) {
        eventGuestRepository.save(eventGuest);
    }


    /**
     * method to get Event Guest by {@link UUID}
     * @param id Event Guest {@link UUID} to be retrieved
     * @return {@link EventGuest}  Event Guest with the specified {@link UUID}
     * @author Mahmoud Shereif (mahmoud.shereiffathi@gmail.com)
     */
    @Override
    public EventGuest getEventGuest(UUID id) {
        return eventGuestRepository.findById(id).get();
    }
}
