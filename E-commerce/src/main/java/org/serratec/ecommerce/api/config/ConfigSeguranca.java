package org.serratec.ecommerce.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class ConfigSeguranca extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("teste").password("{noop}123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("teste").password("{noop}123456").roles("ADMIN").and()
				.withUser("bulinha").password("{noop}654321").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/usuarios")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.cors()
		.and()
		.csrf()
		.disable();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
	 return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	 CorsConfigurationSource corsConfigurationSource() {
//		 CorsConfiguration corsConfiguration = new CorsConfiguration();
//		 corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000/"));
//		 corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
//		 UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		 source.registerCorsConfiguration("/**", corsConfiguration.applyPermitDefaultValues());
//		 return source;
//	 }

}