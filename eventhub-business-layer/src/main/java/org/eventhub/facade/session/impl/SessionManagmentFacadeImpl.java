/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.session.impl;

import org.eventhub.common.model.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.eventhub.facade.session.SessionManagementFacade;
import org.springframework.stereotype.Component;


/**
 *
 * @author Amer Salah
 * @author Hamada
 */
@Component
public class SessionManagmentFacadeImpl implements SessionManagementFacade{
    
    @Autowired
    org.eventhub.service.session.SessionManagementService dao;

    @Override
    public Session createSession(Session session) {
        
        return dao.createSession(session);
    }

    @Override
    public void updateSession(Session session) {
        
        dao.updateSession(session);
    }
    
}
