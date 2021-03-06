/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.hall.impl;

import org.eventhub.common.model.entity.Hall;
import org.eventhub.facade.hall.HallManagementFacade;
import org.eventhub.service.hall.HallManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
@Component
public class HallManagementFacadeImpl implements HallManagementFacade {

    @Autowired
    HallManagementService hallManagementServic;
    
    @Override
    public Hall creatHall(Hall hall) {
        return hallManagementServic.creatHall(hall);
    }

    @Override
    public void updateHall(Hall hall) {
        hallManagementServic.updateHall(hall);
    }
    
    
    
}
