package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.filters.AuthFilter;
import com.example.demo.services.UserService;

@Configuration
@EnableWebSecurity
public class UserConfig extends WebSecurityConfigurerAdapter{

	   @Autowired
	   UserService service;

	    @Autowired
	     AuthFilter filter;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	        auth.userDetailsService(service);
	    }

	    @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf()
	                .disable()
	                .authorizeRequests()
	                .antMatchers("/authenticate")
	                .permitAll()
	                .anyRequest()
	                .authenticated()
	                .and()
	                .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

	    }
}
