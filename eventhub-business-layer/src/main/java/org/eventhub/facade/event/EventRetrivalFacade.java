/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.event;

import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Event;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
public interface EventRetrivalFacade {

    public Event getById(UUID uuid);

    public List<Event> getAllEvents();
}
