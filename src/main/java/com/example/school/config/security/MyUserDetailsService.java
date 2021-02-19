package com.example.school.config.security;
/* Dev Kelyn created the file on 2021-02-19 inside the package - com.example.school.config.security */

import com.example.school.model.User;
import com.example.school.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user == null){
            throw  new UsernameNotFoundException("User 404");
        }
        return new UserDetailsImpl(user);
    }
}
