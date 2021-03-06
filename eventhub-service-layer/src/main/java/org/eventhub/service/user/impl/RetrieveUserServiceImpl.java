package org.eventhub.service.user.impl;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.dao.SystemUserRepository;
import org.eventhub.service.user.RetrieveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class RetrieveUserServiceImpl implements RetrieveUserService {

    @Autowired
    SystemUserRepository systemUserRepository;

    @Override
    @Transactional
    public List<SystemUser> getAllUsers() {
        List<SystemUser> systemUsers=systemUserRepository.findAll();
        return systemUsers;
    }

    @Transactional
    @Override
    public SystemUser getUserByUUID(UUID uuid) {
        SystemUser systemUser=systemUserRepository.getOne(uuid);
        systemUser.getSystemUserPhones();
        return systemUser;
    }
    
    @Transactional
    @Override
    public SystemUser getUserByEmail(String email) {
        SystemUser systemUser=systemUserRepository.findByEmail(email);
        return systemUser;
    }


}
