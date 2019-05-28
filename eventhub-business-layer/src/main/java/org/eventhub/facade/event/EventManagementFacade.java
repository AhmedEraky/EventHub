/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.event;

import org.eventhub.common.model.entity.Event;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
public interface EventManagementFacade {

    public void createEvent(Event event);

    public void updateEvent(Event event);

}
