/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.SessionType;

import org.eventhub.common.model.entity.SessionType;

/**
 * SessionTypeFacade interface has methods to add and update Session types on
 * database
 *
 * @author Hend Zabady (hendzabady04@gmail.com)
 */
public interface SessionTypeManagmentFacade {

    public SessionType addSessionType(SessionType sessionType);

    public void updateSessionType(SessionType sessionType);
    
    public SessionType retriveSessionTypeByName(String name);

}
