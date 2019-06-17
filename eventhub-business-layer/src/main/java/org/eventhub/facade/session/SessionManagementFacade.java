/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.session;

import org.eventhub.common.model.entity.Session;

/**
 *
 * @author Amer Salah
 */
public interface SessionManagementFacade {
    
    public Session createSession(Session session);
    
    public void updateSession(Session session);
    
}
