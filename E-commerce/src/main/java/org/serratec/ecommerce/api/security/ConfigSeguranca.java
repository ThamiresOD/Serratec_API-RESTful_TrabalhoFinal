package org.serratec.ecommerce.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@SuppressWarnings("deprecation")
@Configuration
public class ConfigSeguranca extends WebSecurityConfigurerAdapter {
	@Override
	 protected void configure(HttpSecurity http) throws Exception {
	 http.authorizeHttpRequests()
	 .antMatchers("/funcionarios").permitAll()
	 .anyRequest().authenticated()
	 .and()
	 .httpBasic()
	 .and()
	 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	 .and()
	 .csrf().disable();
	 }

}
