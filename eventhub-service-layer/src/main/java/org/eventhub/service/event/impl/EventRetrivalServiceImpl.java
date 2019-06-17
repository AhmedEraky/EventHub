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
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventRetrivalServiceImpl implements EventRetrievalService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    @Transactional
    public Event getById(UUID uuid) {
        Event event= eventRepository.findById(uuid).get();
        System.out.println(event.getEventGuests());
        System.out.println(event.getHalls());
        System.out.println(event.getSessions());
        System.out.println(event.getEventCoordinators());
        System.out.println(event.getSponsors());
        System.out.println(event.getOrganization().getVips()+" vips");
        System.out.println(event.getOrganization().getSystemUsers());
        return event;
    }

    @Override
    @Transactional
    public List<Event> getAll() {
        List<Event> events=eventRepository.findAll();
        for (Event event:events){
            System.out.println(event.getEventGuests());
            System.out.println(event.getHalls());
            System.out.println(event.getSessions());
            System.out.println(event.getEventCoordinators());
            System.out.println(event.getSponsors());
            System.out.println(event.getOrganization().getVips()+" vips");
            System.out.println(event.getOrganization().getSystemUsers());

        }
        return events;
    }

}
