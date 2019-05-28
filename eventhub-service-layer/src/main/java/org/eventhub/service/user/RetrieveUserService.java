package org.eventhub.service.user;

import org.eventhub.common.model.entity.SystemUser;

import java.util.List;
import java.util.UUID;

public interface RetrieveUserService {
    List<SystemUser> getAllUsers();
    SystemUser getUserByUUID(UUID uuid);
}
