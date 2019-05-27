package org.eventhub.service.user.impl;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.dao.CountryRepository;
import org.eventhub.dal.dao.SystemUserRepository;
import org.eventhub.service.user.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserServiceImpl implements CreateUserService {
    @Autowired
    SystemUserRepository systemUserRepository;


    @Override
    public SystemUser createSystemUser(SystemUser systemUser) {
        SystemUser user=systemUserRepository.save(systemUser);
        return user;
    }
}
