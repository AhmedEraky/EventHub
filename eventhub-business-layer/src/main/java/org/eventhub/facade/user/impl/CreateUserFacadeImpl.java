package org.eventhub.facade.user.impl;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.user.CreateUserFacade;
import org.eventhub.service.user.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CreateUserFacadeImpl implements CreateUserFacade {
    @Autowired
    CreateUserService createUserService;

    @Override
    public SystemUser createUser(SystemUser systemUser) {
        return createUserService.createSystemUser(systemUser);
    }

    @Override
    public void UpdateUser(SystemUser systemUser) {
        createUserService.updateUser(systemUser);
    }
}
