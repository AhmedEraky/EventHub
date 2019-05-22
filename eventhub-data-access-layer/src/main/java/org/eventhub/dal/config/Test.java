/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.config;

import org.eventhub.common.model.entity.SystemUser;
import org.eventhub.dal.dao.SystemUserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
public class Test {
       @PersistenceContext
       EntityManager entityManager;
    
    public static void main(String[] args) {
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
       
        SystemUserRepository systemUserRepository = context.getBean(SystemUserRepository.class);
        Random rand = new Random();
        SystemUser user = new SystemUser(null, "user", "user","user", "user"+rand.nextInt(1000));
        UUID uuid = systemUserRepository.save(user).getUuid();
        systemUserRepository.softDelete(uuid);
        systemUserRepository.findAll().forEach(System.out::println);
    }
}
