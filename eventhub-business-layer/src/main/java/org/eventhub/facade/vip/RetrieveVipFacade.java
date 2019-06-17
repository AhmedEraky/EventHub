package org.eventhub.facade.vip;

import java.util.List;
import org.eventhub.common.model.entity.Vip;

import java.util.UUID;

public interface RetrieveVipFacade {

    public Vip getVipById(UUID uuid);

    public List<Vip> getAll();
}
