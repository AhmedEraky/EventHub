/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.session.impl;

import org.eventhub.common.model.entity.Session;
import org.eventhub.dal.dao.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.eventhub.service.session.SessionManagementService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amer Salah
 * @author Hamada
 */
@Service
public class SessionManagementServiceImpl implements SessionManagementService{

    @Autowired
    SessionRepository sessionRepository;
    
    
    @Transactional
    @Override
    public Session createSession(Session session) {
        
        Session sessionAdded =sessionRepository.save(session);
        return sessionAdded;
    }

    @Transactional
    @Override
    public void updateSession(Session session) {
        
        sessionRepository.update(session);
    }
    
}
