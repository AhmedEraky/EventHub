/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.aspects;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.utils.EncryptionUtils;

/**
 * this aspect class to encrypt password before insert it in DataBase
 *
 * @author Amr Elkady <amrelkady93@gmail.com>
 */
@Aspect
public class EncryptPassword {

    EncryptionUtils passwordencryptionUtility;

    /**
     * encrypt password of {@link org.eventhub.common.model.entity.SystemUser}
     *
     * @param joinPoint
     * @return Object the result of insert object
     *
     */
    @Around("execution(* com.eventhub.model.dal.daos.SystemUserRepository.save(..))")
    public Object beforeInsert(ProceedingJoinPoint joinPoint) {

        Object[] arg = joinPoint.getArgs();
        SystemUser systemUser = (SystemUser) arg[0];
        String plainPassword = systemUser.getPassword();
        String newPassword = EncryptionUtils.hash(plainPassword);
        systemUser.setPassword(newPassword);
        try {
            return joinPoint.proceed();
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }

    }

}
