package org.eventhub.service.user;

import org.eventhub.common.model.entity.SystemUser;

public interface CreateUserService {

    SystemUser createSystemUser(SystemUser systemUser);
}
