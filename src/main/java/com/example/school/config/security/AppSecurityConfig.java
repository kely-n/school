package com.example.school.config.security;
/* Dev Kelyn created the file on 2021-02-19 inside the package - com.example.school.config.security */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
        //make sure you bcrypt passwords, the line below undoes the bycrypt.
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll();

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
