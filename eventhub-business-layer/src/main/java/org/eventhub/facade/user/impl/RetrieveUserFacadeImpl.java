package org.eventhub.facade.user.impl;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.user.RetrieveUserFacade;
import org.eventhub.service.user.RetrieveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RetrieveUserFacadeImpl implements RetrieveUserFacade {
    @Autowired
    RetrieveUserService retrieveUserService;
    @Override
    public List<SystemUser> getAllUsers() {
        return retrieveUserService.getAllUsers();
    }

    @Override
    public SystemUser getUserByUUID(UUID uuid) {
        return retrieveUserService.getUserByUUID(uuid);
    }
}
