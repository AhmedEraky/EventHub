package org.eventhub.service.user;

import org.eventhub.common.model.entity.SystemUser;
import org.springframework.web.multipart.MultipartFile;

public interface CreateUserService {

    SystemUser createSystemUser(SystemUser systemUser, MultipartFile imageResource);
}
