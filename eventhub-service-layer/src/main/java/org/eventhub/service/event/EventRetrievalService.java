package org.eventhub.service.event;

import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Event;

public interface EventRetrievalService {

    public Event getById(UUID uuid);
    public List<Event> getAll();
}
