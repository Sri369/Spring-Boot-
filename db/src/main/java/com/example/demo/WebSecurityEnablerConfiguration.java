package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ConfigurationProperties(prefix = "security")
public class WebSecurityEnablerConfiguration extends WebSecurityConfigurerAdapter {

	
	@Value("${security.user.name}")
	private String username;
	
	@Value("${security.user.password}")
	private String password;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception
	    {
	        http
	         .csrf().disable()
	         .authorizeRequests().anyRequest().authenticated()
	         .and()
	         .httpBasic();
	    }
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth)
	            throws Exception
	    {
	        auth.inMemoryAuthentication()
	            .withUser(username)
	            .password(passwordEncoder().encode(password))
	            .roles("USER");
	    }
	@Bean
	public PasswordEncoder passwordEncoder() {
	  return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
