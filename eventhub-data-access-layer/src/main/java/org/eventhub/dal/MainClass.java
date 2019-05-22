package org.eventhub.dal;

import org.eventhub.dal.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String arg[]){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    }
}
