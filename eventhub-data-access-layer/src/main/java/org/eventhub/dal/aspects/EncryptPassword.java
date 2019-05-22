/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.utils.EncryptionUtils;
import org.springframework.stereotype.Component;

/**
 * this aspect class to encrypt password before insert it in DataBase
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
@Aspect
@Component
public class EncryptPassword {

    /**
     * encrypt password of {@link org.eventhub.common.model.entity.SystemUser}
     *
     * @param joinPoint to access information
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Before("execution(* org.eventhub.dal.dao.SystemUserRepository.save(..))")
    public void beforeInsert(JoinPoint joinPoint) {
        Object[] arg = joinPoint.getArgs();
        SystemUser systemUser = (SystemUser) arg[0];
        String plainPassword = systemUser.getPassword();
        systemUser.setPassword(EncryptionUtils.hash(plainPassword));
    }

}
