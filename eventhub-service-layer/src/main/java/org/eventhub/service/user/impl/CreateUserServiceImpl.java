package org.eventhub.service.user.impl;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.common.util.ImagePathProviderUtil;
import org.eventhub.common.util.ImageResourceHandlerUtil;
import org.eventhub.dal.dao.CountryRepository;
import org.eventhub.dal.dao.SystemUserRepository;
import org.eventhub.service.user.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CreateUserServiceImpl implements CreateUserService {

    @Autowired
    SystemUserRepository systemUserRepository;

    @Override
    public SystemUser createSystemUser(SystemUser systemUser, MultipartFile imageResource) {
        SystemUser user = systemUserRepository.save(systemUser);
        String userImagePath = ImagePathProviderUtil.getUserImagePath(systemUser);
        ImageResourceHandlerUtil.saveSystemUserImageResource(systemUser, imageResource);
        return user;
    }
}
