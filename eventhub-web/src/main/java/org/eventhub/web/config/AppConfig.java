package org.eventhub.web.config;


import org.springframework.context.annotation.*;

@Configuration
@Import(org.eventhub.remote.config.AppConfig.class)
public class AppConfig {

}
