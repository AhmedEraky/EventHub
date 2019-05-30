package org.eventhub.facade.user.impl;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.facade.user.CreateUserFacade;
import org.eventhub.service.user.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CreateUserFacadeImpl implements CreateUserFacade {

    @Autowired
    CreateUserService createUserService;

    @Override
    public SystemUser createUser(SystemUser systemUser, MultipartFile imageResource) {
        return createUserService.createSystemUser(systemUser, imageResource);
    }
}
