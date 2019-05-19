/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.utils.EncryptionUtils;

/**
 * @Description this aspect class to encrypt password before insert it in DataBase
 * @author Amr Elkady <amrelkady93@gmail.com>
 */
@Aspect
public class EncryptPassword {
    
    EncryptionUtils passwordencryptionUtility;

    
    /**
     * encrypt password of {@link org.eventhub.common.model.entity.SystemUser}
     * @param joinPoint
     * @return Object the result of insert object 
     *  
     */
    @Around("execution(*.com.eventhub.model.dal.daos.SystemUserRepository.insert(..))")
    public Object beforeInsert(ProceedingJoinPoint joinPoint) {
        
        Object result = null;
        passwordencryptionUtility=
                new EncryptionUtils();
        try {
            Object[] arg = joinPoint.getArgs();
            SystemUser systemUser = (SystemUser) arg[0];
            String plainPassword = systemUser.getPassword();
            String newPassword=
                    passwordencryptionUtility.encrypt(plainPassword);
            systemUser.setPassword(new String(newPassword));
            result = joinPoint.proceed();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
