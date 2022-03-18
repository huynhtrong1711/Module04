package com.codegym.config;

import com.codegym.service.IUserService;
import com.codegym.service.impl.MyUserDetailService;
import com.codegym.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}12345").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}12345").roles("ADMIN");
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and()
                .formLogin().loginPage("/blog/login")
//                .loginProcessingUrl("login")
                .permitAll()
                .defaultSuccessUrl("/blog");
//        http.csrf().disable()
//                .formLogin()
//                .defaultSuccessUrl("/blog").permitAll()
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
    }
}
