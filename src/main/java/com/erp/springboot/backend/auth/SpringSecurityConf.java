package com.erp.springboot.backend.auth;

import com.erp.springboot.backend.auth.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConf {

    private final AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    public SpringSecurityConf(AuthenticationConfiguration authenticationConfiguration) {
        this.authenticationConfiguration = authenticationConfiguration;
    }

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authz ->
                authz
                .requestMatchers(HttpMethod.GET, "/usuarios", "/usuarios/page/{page}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuarios/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/usuarios").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/usuarios/{id}").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/{id}").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
        )
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
