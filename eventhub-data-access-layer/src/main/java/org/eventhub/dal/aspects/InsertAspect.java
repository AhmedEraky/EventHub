package org.eventhub.dal.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.eventhub.common.model.entity.BaseEntity;
import org.springframework.stereotype.Component;

/**
 * this aspect class to set delete to false before insert it in DataBase
 *
 * @author Amr Elkady (amrelkady93@gmail.com)
 */
@Aspect
@Component
public class InsertAspect {

    /**
     * set delete of entities to false before insert it in DataBase
     *
     * @param joinPoint to access information
     * @author Amr Elkady (amrelkady93@gmail.com)
     */
    @Before("execution(* org.eventhub.dal.dao..save(..))")
    public void beforeInsert(JoinPoint joinPoint) {
        Object[] arg = joinPoint.getArgs();
        BaseEntity baseEntity = (BaseEntity) arg[0];
        baseEntity.setDeleted(false);
    }

}
