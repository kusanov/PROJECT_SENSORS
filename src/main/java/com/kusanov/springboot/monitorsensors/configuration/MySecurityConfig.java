package com.kusanov.springboot.monitorsensors.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("admin").password("admin").roles("ADMIN"))
                .withUser(userBuilder.username("viewer").password("viewer").roles("VIEWER"));
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/addNewSensor").hasAnyRole("ADMIN")
//                .antMatchers("/edit/").hasAnyRole("ADMIN")
//                .antMatchers("/delete/").hasAnyRole("ADMIN");
//    }
}
