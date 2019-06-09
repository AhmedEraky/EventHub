package org.eventhub.facade.vip.impl;

import org.eventhub.common.model.entity.Vip;
import org.eventhub.facade.vip.RetrieveVipFacade;
import org.eventhub.service.vip.RetrieveVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RetrieveVipFacadeImpl implements RetrieveVipFacade {

    @Autowired
    RetrieveVipService  retrieveVipService;
    @Override
    public Vip getVipById(UUID uuid) {
        return retrieveVipService.getById(uuid);
    }
}
