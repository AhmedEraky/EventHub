package org.eventhub.service.event;

import java.util.UUID;
import org.eventhub.common.model.entity.Event;

public interface EventRetrivalService {

    public Event getById(UUID uuid);
}
