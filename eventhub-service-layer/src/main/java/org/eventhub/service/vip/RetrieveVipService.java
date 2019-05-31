package org.eventhub.service.vip;

import org.eventhub.common.model.entity.Vip;

import java.util.UUID;

public interface RetrieveVipService {
    public Vip getById(UUID uuid);
}
