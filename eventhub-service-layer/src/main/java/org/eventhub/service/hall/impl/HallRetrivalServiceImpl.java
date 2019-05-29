/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.hall.impl;

import java.util.UUID;
import org.eventhub.common.model.entity.Hall;
import org.eventhub.dal.dao.HallRepository;
import org.eventhub.service.hall.HallRetrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
@Service
public class HallRetrivalServiceImpl implements HallRetrivalService {

    @Autowired
    HallRepository hallRepository;

    @Override
    public Hall getHallById(UUID uuid) {

        return hallRepository.findById(uuid).get();
    }

}
