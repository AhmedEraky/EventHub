package org.eventhub.facade.vip;

import org.eventhub.common.model.entity.Vip;

import java.util.UUID;

public interface RetrieveVipFacade {
    public Vip getVipById(UUID uuid);
}
