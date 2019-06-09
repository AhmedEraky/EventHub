package org.eventhub.web.convertor;

import org.eventhub.common.model.entity.Event;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class EventConverter implements Converter<String, Event>
{
    @Override
    public Event convert(String eventUUID)
    {
        Event event = new Event();
        event.setUuid(UUID.fromString(eventUUID));
        return event;
    }
}
