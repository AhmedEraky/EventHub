/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.event.impl;

import org.eventhub.common.model.entity.Event;
import org.eventhub.dal.dao.EventRepository;
import org.eventhub.service.event.EventManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventManagementServiceImpl implements EventManagementService {

    @Autowired
    private EventRepository eventRepository;

    @Override

    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

}
