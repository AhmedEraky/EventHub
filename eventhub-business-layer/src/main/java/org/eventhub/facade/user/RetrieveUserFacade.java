package org.eventhub.facade.user;

import org.eventhub.common.model.entity.SystemUser;

import java.util.List;
import java.util.UUID;

public interface RetrieveUserFacade {
    List<SystemUser> getAllUsers();
    public SystemUser getUserByUUID(UUID uuid);
    public SystemUser getUserByEmail(String email);
}
