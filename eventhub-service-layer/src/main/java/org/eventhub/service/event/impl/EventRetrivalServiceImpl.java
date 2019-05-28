/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.event.impl;

import java.util.UUID;
import org.eventhub.common.model.entity.Event;
import org.eventhub.dal.dao.EventRepository;
import org.eventhub.service.event.EventRetrivalService;
import org.springframework.beans.factory.annotation.Autowired;

public class EventRetrivalServiceImpl implements EventRetrivalService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event getById(UUID uuid) {
        return eventRepository.findById(uuid).get();
    }

}
