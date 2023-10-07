package com.bc46.eurekaserver;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /*Securización Servidor Eureka*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); /**Desactivación de protección entre dominios */
        http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic(); /**Políticas de autenticación*/
    }

    @Override
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.
                inMemoryAuthentication()
                .withUser("root")
                .password("{noop}s3cr3t")
                .roles("ADMIN");
    }
}
