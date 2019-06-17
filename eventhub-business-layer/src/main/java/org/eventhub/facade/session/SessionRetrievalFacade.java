/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.session;

import java.util.List;
import java.util.UUID;
import org.eventhub.common.model.entity.Session;

/**
 *
 * @author Amer Salah
 */
public interface SessionRetrievalFacade {
    
    public Session getSessionById(UUID uuid);
    
    public List<Session> getAllSession();
    
    
}
