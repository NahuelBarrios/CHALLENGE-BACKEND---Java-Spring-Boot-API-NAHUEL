package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
    {
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/agregarnuevopersonaje","/guardarpersonajenuevo","/editarpersonaje/**","/eliminarpersonaje/**")
                .hasRole("ADMIN")
                .antMatchers("/","/personaje","/genero","/pelicula","/registronuevo","/guardarnuevoregistro","/logout")
                .hasAnyRole("ADMIN","USER")
                .antMatchers("/login","/registronuevo","/guardarnuevoregistro")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login");
    }
    
    
}
