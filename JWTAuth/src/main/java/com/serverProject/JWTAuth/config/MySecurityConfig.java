package com.serverProject.JWTAuth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.serverProject.JWTAuth.services.CustomUserDetailsService;



@Configuration
@EnableWebSecurity
public class MySecurityConfig   {
	
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtAuthFilter jwtAuthFilter ;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	

	protected void configure(HttpSecurity http) throws Exception {
	http
		.csrf()
		.disable()
		.cors().disable()
		.authorizeRequests()
		.requestMatchers("/token").permitAll()
		.anyRequest().authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
	
	// Add a filter to validate the tokens with every request
		http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
	
	
		
	}
	

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}
	
	
	@Bean
	  public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	  }
	
	
//	 @Bean
//	 public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

	
//	    @Bean
//	    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
//	        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//	        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//	        return authenticationManagerBuilder.build();
//	    }
	
	
	
	    @Bean
	    public AuthenticationManager authenticationManager(
	            AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
	

}
