/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.event.impl;

import org.eventhub.common.model.entity.Event;
import org.eventhub.facade.event.EventManagementFacade;
import org.eventhub.service.event.EventManagementService;
import org.springframework.beans.factory.annotation.Autowired;

public class EventManagementFacadeImpl implements EventManagementFacade {

    @Autowired
    EventManagementService eventManagementService;

    @Override
    public void createEvent(Event event) {
        eventManagementService.createEvent(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventManagementService.updateEvent(event);
    }

}
