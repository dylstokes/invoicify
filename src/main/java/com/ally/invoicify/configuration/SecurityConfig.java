package com.ally.invoicify.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ally.invoicify.services.AppUserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AppUserDetailsServiceImpl userDetailsService;

    public SecurityConfig(AppUserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    //allow POST routes to /api/user and /api/session endpoints
    //require authorization for everything else
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    
            .authorizeRequests()
                .antMatchers(HttpMethod.PUT, "/api/session").permitAll()
                .antMatchers(HttpMethod.POST, "/api/user").permitAll()    
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }

}
