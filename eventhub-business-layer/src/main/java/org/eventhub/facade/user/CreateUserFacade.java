package org.eventhub.facade.user;

import org.eventhub.common.model.entity.SystemUser;

public interface CreateUserFacade {
    SystemUser createUser(SystemUser systemUser);
    void UpdateUser(SystemUser systemUser);
}
