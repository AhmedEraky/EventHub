
package org.eventhub.facade.vip.impl;

import org.eventhub.common.model.entity.Vip;
import org.eventhub.facade.vip.CreateVipFacade;
import org.eventhub.service.vip.CreateVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateVipFacadeImpl implements CreateVipFacade{

    @Autowired
    CreateVipService createVipService;
    @Override
    public Vip createVip(Vip vip) {
        return createVipService.createVip(vip);
    }

    @Override
    public void updateVip(Vip vip) {
        createVipService.updateVip(vip);

    }

}
