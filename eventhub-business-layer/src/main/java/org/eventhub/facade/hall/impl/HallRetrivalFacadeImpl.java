/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.hall.impl;

import java.util.UUID;
import org.eventhub.common.model.entity.Hall;
import org.eventhub.facade.hall.HallRetrivalFacade;
import org.eventhub.service.hall.HallRetrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
@Component
public class HallRetrivalFacadeImpl implements HallRetrivalFacade{
    
    @Autowired
    HallRetrivalService hallRetrivalService;

    @Override
    public Hall getHallById(UUID uuid) {
        return hallRetrivalService.getHallById(uuid);
    }
    
}
