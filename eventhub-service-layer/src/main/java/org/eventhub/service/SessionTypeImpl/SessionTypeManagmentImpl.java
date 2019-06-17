/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.service.SessionTypeImpl;

import org.eventhub.common.model.entity.SessionType;
import org.eventhub.dal.dao.SessionTypeRepository;
import org.eventhub.service.SessionType.SessionTypeManagment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SessionTypeManagment Implementation, has implementation to SessionTypeManagment interface
 * @author Hend Zabady (hendzabady04@gmail.com)
 */
@Service
public class SessionTypeManagmentImpl implements SessionTypeManagment {

    @Autowired
    SessionTypeRepository sessionTypeRepository;

    /**
     * add {@link org.eventhub.common.model.entity.SessionType} based on {@link org.eventhub.common.model.entity.SessionType}
     * @param sessionType {@link org.eventhub.common.model.entity.SessionType}
     * @return {@link org.eventhub.common.model.entity.SessionType}
     * @author  Hend Zabady (hendzabady04@gmail.com)
     */
    @Transactional
    @Override
    public SessionType addSessionType(SessionType sessionType) {
        return sessionTypeRepository.save(sessionType);
    }

    /**
     * update  {@link org.eventhub.common.model.entity.SessionType} based on {@link org.eventhub.common.model.entity.SessionType}
     * @param sessionType {@link org.eventhub.common.model.entity.SessionType}
     * @author  Hend Zabady (hendzabady04@gmail.com)
     */
    @Transactional
    @Override
    public void updateSessionType(SessionType sessionType) {
        sessionTypeRepository.save(sessionType);
    }

    @Override
    public SessionType retriveSessionTypeByName(String name) {
        return sessionTypeRepository.findByName(name);
    }

}
