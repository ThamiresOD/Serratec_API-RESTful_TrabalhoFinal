package org.serratec.ecommerce.api.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


@SuppressWarnings("deprecation")
@Configuration
public class ConfigSeguranca extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	JwtUtil jwtUtil;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	 protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/api/**").authenticated()
			.antMatchers("/api/usuario/").hasAuthority("ADMIN")		
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.cors()
			.and()
			.csrf().disable();
		http.addFilter(new JwtAuthenticationFilter(this.authenticationManager(), jwtUtil));
		http.addFilter(new JwtAuthorizationFilter(this.authenticationManager(), jwtUtil, userDetailsService));

	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
	 return new BCryptPasswordEncoder();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000/"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration.applyPermitDefaultValues());
		return source;
	}

}
