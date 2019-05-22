package org.eventhub.dal.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.eventhub.common.model.entity.BaseEntity;

/**
 * this aspect class to set delete to false before insert it in DataBase
 * @author Amr Elkady (amrelkady93@gmail.com)
 */

@Aspect
public class InsertAspect {

    /**
     * set delete of entities to false before insert it in DataBase
     * @param joinPoint  to access information 
     * @return Object the result of insert object
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Around("execution(* com.eventhub.model.dal.daos..insert(..))")
    public Object beforeInsert(ProceedingJoinPoint joinPoint) {

        Object result = null;
        try {
            Object[] arg = joinPoint.getArgs();
            BaseEntity baseEntity = (BaseEntity) arg[0];
            baseEntity.setDeleted(false);
            result = joinPoint.proceed();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
