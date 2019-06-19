/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.coordinator.impl;

import org.eventhub.common.model.entity.EventCoordinator;
import org.eventhub.dal.dao.EventCoordinatorRepository;
import org.eventhub.service.coordinator.CoordinatorManagment;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author pc
 */
public class CoordinatorManagmentImpl implements CoordinatorManagment{
    
    
    @Autowired
    EventCoordinatorRepository coordinatorRepository;
    
    @Override
    public void addEventCoordinator(EventCoordinator eventCoordinator){
        coordinatorRepository.save(eventCoordinator);
    }
    
}
