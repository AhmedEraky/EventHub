/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.hall.impl;

import org.eventhub.common.model.entity.Hall;
import org.eventhub.dal.dao.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.eventhub.service.hall.HallManagementService;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
@Service
public class HallManagementServiceImpl implements HallManagementService{
    
    
    @Autowired
    HallRepository hallRepository;

    @Override
    public Hall creatHall(Hall hall) {
       return hallRepository.save(hall);
    }

    @Override
    public void updateHall(Hall hall) {
        hallRepository.update(hall);
    }
    
}
