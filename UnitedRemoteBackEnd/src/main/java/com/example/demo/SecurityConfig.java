package com.example.demo;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true) //to activate @secured
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder authBuilder, DataSource dataSource) throws Exception {
//		authBuilder.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
//		authBuilder.inMemoryAuthentication().withUser("user").password("{noop}123").roles("USER");
		
		authBuilder.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select email as principal, password as credentials, activated from user where email = ?")
		.authoritiesByUsernameQuery("select user_email as principal, role_nom as role from users_roles where user_email = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and()
			.authorizeRequests()
			.antMatchers("index.html","/css/**","/js/**").permitAll() //permit access to css and javascripts
			.anyRequest().authenticated()   //all requests are authenticated
		.and().formLogin().loginPage("/login").permitAll();
		
	}
}
