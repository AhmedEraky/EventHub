package org.eventhub.service.event;

import org.eventhub.common.model.entity.Event;

public interface EventManagementService {

    public void createEvent(Event event);

    public void updateEvent(Event event);
}
