/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.session.impl;

import java.util.UUID;
import org.eventhub.common.model.entity.Session;
import org.eventhub.dal.dao.SessionRepository;
import org.eventhub.service.session.SessionRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amer Salah
 * @author Hamada
 */
@Service
public class SessionRetrievalServiceImpl implements SessionRetrievalService{

    @Autowired
    SessionRepository sessionRepository;
    
    @Override
    public Session getSessionById(UUID uuid) {
        return sessionRepository.findById(uuid).get();
    }
    
}
