/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.session.impl;

import java.util.UUID;
import org.eventhub.common.model.entity.Session;
import org.eventhub.facade.session.SessionRetrievalFacade;
import org.eventhub.service.session.SessionManagementService;
import org.eventhub.service.session.SessionRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 * @author Amer Salah
 * @author Hamada
 */
@Component
public class SessionRetrievalFacadeImpl implements SessionRetrievalFacade {
    
    @Autowired
    SessionRetrievalService sessionRetrievalService;
    
    @Override
    public Session getSessionById(UUID uuid) {
        return sessionRetrievalService.getSessionById(uuid);
    }
    
}
