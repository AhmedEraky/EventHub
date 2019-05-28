package org.eventhub.service.user.impl;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.dao.SystemUserRepository;
import org.eventhub.service.user.RetrieveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RetrieveUserServiceImpl implements RetrieveUserService {

    @Autowired
    SystemUserRepository systemUserRepository;

    @Override
    public List<SystemUser> getAllUsers() {
        List<SystemUser> systemUsers=systemUserRepository.findAll();
        return systemUsers;
    }

    @Override
    public SystemUser getUserByUUID(UUID uuid) {
        SystemUser systemUser=systemUserRepository.getOne(uuid);
        return systemUser;
    }


}
