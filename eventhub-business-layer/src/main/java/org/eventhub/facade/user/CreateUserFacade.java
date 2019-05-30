package org.eventhub.facade.user;

import org.eventhub.common.model.entity.SystemUser;
import org.springframework.web.multipart.MultipartFile;

public interface CreateUserFacade {
    SystemUser createUser(SystemUser systemUser,  MultipartFile imageResource);

    public void UpdateUser(SystemUser user);
}
