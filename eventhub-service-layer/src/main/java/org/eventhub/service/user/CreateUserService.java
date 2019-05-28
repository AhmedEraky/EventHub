package org.eventhub.service.user;

import org.eventhub.common.model.entity.SystemUser;

public interface CreateUserService {

    public SystemUser createSystemUser(SystemUser systemUser);
    public void updateUser(SystemUser systemUser);
}
