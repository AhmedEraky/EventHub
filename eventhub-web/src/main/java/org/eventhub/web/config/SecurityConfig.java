package org.eventhub.web.config;

import javax.sql.DataSource;
import org.eventhub.dal.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.multipart.support.MultipartFilter;

@Configuration
@EnableWebSecurity
@Import({AppConfig.class, WebViewsConfig.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/*");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
//                .antMatchers("/**").access("hasRole('ROLE_USER')");
        http.formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    protected void configure(DataSource datasource, AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(datasource)
                .usersByUsernameQuery("SELECT u.email, u.password, 1 "
                        + "FROM system_user u "
                        + "WHERE u.email = ?")
                .authoritiesByUsernameQuery("SELECT u.email, p.name "
                        + "FROM system_user u "
                        + "INNER JOIN system_user_has_role ur ON u.uuid = ur.system_user "
                        + "INNER JOIN role r ON ur.role = r.uuid "
                        + "INNER JOIN role_privilege rp ON r.uuid = rp.role "
                        + "INNER JOIN privilege p ON rp.privilege = p.uuid "
                        + "WHERE u.email = ?");
    }

}
