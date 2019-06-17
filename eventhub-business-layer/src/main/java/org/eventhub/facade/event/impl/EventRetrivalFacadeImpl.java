/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.event.impl;

import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Event;
import org.eventhub.facade.event.EventRetrivalFacade;
import org.eventhub.service.event.EventRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventRetrivalFacadeImpl implements EventRetrivalFacade {

    @Autowired
    private EventRetrievalService eventRetrivalService;

    @Override

    public Event getById(UUID uuid) {
        return eventRetrivalService.getById(uuid);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRetrivalService.getAll();
    }

}
