package org.eventhub.web.config;

import org.eventhub.dal.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.eventhub.web")
@PropertySource("classpath:org/eventhub/web/config/datastore.properties")
@EnableWebSecurity
@Import(AppConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**")
                .access("hasRole('USER')").and().formLogin();
    }



    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    protected void configure(DataSource datasource,AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery(
                "select email,password,deleted from system_user where email=? ").rolePrefix("ROLE_").authoritiesByUsernameQuery(
        "select email,user_name from system_user where email=?");

        auth.getDefaultUserDetailsService().loadUserByUsername("aa1@gmail.com");

        auth.inMemoryAuthentication().withUser("a").password("a").roles("USER");
    }

}
