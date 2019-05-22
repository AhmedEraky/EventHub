package org.eventhub.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("org.eventhub.service")
@Import(org.eventhub.dal.config.AppConfig.class)
public class AppConfig {
}
