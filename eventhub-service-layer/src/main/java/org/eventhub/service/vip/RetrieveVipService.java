package org.eventhub.service.vip;

import java.util.List;
import org.eventhub.common.model.entity.Vip;

import java.util.UUID;

public interface RetrieveVipService {
    public Vip getById(UUID uuid);

    public List<Vip> getAll();

}
