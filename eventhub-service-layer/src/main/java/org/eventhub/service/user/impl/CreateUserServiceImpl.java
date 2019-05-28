package org.eventhub.service.user.impl;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.dao.CountryRepository;
import org.eventhub.dal.dao.SystemUserRepository;
import org.eventhub.service.user.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateUserServiceImpl implements CreateUserService {
    @Autowired
    SystemUserRepository systemUserRepository;


    @Transactional
    @Override
    public SystemUser createSystemUser(SystemUser systemUser) {
        SystemUser user=systemUserRepository.save(systemUser);
        return user;
    }

    @Transactional
    @Override
    public void updateUser(SystemUser systemUser) {
        systemUserRepository.update(systemUser);
    }
}
