package org.eventhub.facade.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("org.eventhub.facade")
@Import(org.eventhub.service.config.AppConfig.class)
public class AppConfig {
}
