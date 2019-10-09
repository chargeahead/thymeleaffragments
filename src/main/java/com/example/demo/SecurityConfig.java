package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource datasource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception{
		authenticationMgr.inMemoryAuthentication()
		.withUser("devuser").password("{noop}dev").authorities("ROLE_USER")
		.and()
		.withUser("adminuser").password("{noop}admin").authorities("ROLE_USER","ROLE_ADMIN");
		
//		authenticationMgr.jdbcAuthentication().dataSource(datasource).passwordEncoder(new BCryptPasswordEncoder())
//		                 .usersByUsernameQuery("select username,passwd,enabled from users where username =?")
//		                 .authoritiesByUsernameQuery("select username,role from user_roles where username = ?");
		
	}
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/inventory/edit/*").hasRole("USER")
		.antMatchers("/inventory/add*").hasRole("ADMIN")
		.antMatchers("/inventory/delete/*").hasRole("ADMIN")
		.antMatchers("/actuator/health").hasRole("ADMIN")
		.antMatchers("/inventory/all","/inventory*").permitAll()
		.and()
		.httpBasic();
	}

}
