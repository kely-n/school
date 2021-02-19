package com.example.school.config.security;
/* Dev Kelyn created the file on 2021-02-19 inside the package - com.example.school.config.security */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 *
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authProvier(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        //dont return this
//        //return super.userDetailsService();
//        List<UserDetails> users = new ArrayList<>();
//        users.add(User.withDefaultPasswordEncoder().username("kely").password("1234").roles("USER").build());
//
//        return  new InMemoryUserDetailsManager(users);
//    }
}
