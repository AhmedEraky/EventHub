/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.event.impl;

import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Event;
import org.eventhub.dal.dao.EventRepository;
import org.eventhub.service.event.EventRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventRetrivalServiceImpl implements EventRetrievalService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event getById(UUID uuid) {
        return eventRepository.findById(uuid).get();
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

}
