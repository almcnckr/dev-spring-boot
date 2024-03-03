package com.springmvc.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return userDetailsManager;
        //return new JdbcUserDetailsManager(dataSource);
    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}12345")
                .roles("EMPLOYEE").build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}12345")
                .roles("MANAGER").build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}12345")
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
    */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> {
                    configurer.requestMatchers("/").hasAnyRole("EMPLOYEE", "ADMIN", "MANAGER")
                            .requestMatchers("/leaders/**").hasAnyRole("MANAGER", "ADMIN")
                            .requestMatchers("/systems/**").hasAnyRole("ADMIN")
                            .anyRequest().authenticated();
                }).formLogin(form ->
                        form.loginPage("/customLoginPage").loginProcessingUrl("/authenticateUser").permitAll())
                .logout(logout -> logout.permitAll()).exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"));

        return httpSecurity.build();
    }
}
