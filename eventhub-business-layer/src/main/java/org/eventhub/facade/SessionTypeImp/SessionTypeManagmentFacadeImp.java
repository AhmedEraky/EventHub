/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.facade.SessionTypeImp;

import org.eventhub.common.model.entity.SessionType;
import org.eventhub.facade.SessionType.SessionTypeManagmentFacade;
import org.eventhub.service.SessionType.SessionTypeManagment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SessionTypeManagmentFacade Implementation, has implementation to
 * SessionTypeManagmentFacade interface
 *
 * @author Hend Zabady (hendzabady04@gmail.com)
 */
@Component
public class SessionTypeManagmentFacadeImp implements SessionTypeManagmentFacade {

    @Autowired
    SessionTypeManagment sessionTypeManagment;

    @Override
    public SessionType addSessionType(SessionType sessionType) {
        return sessionTypeManagment.addSessionType(sessionType);
    }

    @Override
    public void updateSessionType(SessionType sessionType) {
        sessionTypeManagment.addSessionType(sessionType);
    }

    @Override
    public SessionType retriveSessionTypeByName(String name) {
        return sessionTypeManagment.retriveSessionTypeByName(name);
    }

}
