package com.town.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

	    return new BCryptPasswordEncoder();
	}

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{

        http
        	.csrf()
        		.disable()
        		.httpBasic()
            .and()
            	.authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/login"),
                        		 new AntPathRequestMatcher("/loginProc"),
                        		 new AntPathRequestMatcher("/user/register"),
                        		 new AntPathRequestMatcher("/post/list")
                		).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/post/form")).hasRole("USER")
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginProc")
        		.usernameParameter("id")
        		.passwordParameter("password")
        		.defaultSuccessUrl("/post/list", true)
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/post/list");

        return http.build();
    }
}