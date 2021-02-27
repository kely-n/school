package com.example.school.config.security.filter;
/* Dev Kelyn created the file on 2021-02-26 inside the package - com.example.school.config.security.filter */

import com.example.school.config.security.MyUserDetailsService;
import com.example.school.config.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * class is injected in the appSecurityConfig class.
 */
@Component
public class JwtFilter extends OncePerRequestFilter {
    //inject jwtUtil to extract username from password
    @Autowired
    private JwtUtil jwtUtil;

    //inject userdetails class to get the details of a user
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    //extract the authentication token from the header of the request
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //get the header of the request named Authorization
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        String token = null;
        String username = null;
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){//if Authorization header is not null, then perform the following
            //remove the first part of the string "Bearer "
            token = authorizationHeader.substring(7);
            //extract username
            username = jwtUtil.extractUsername(token);
        }
        if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null){//validate the username, if correct get user details
            //get the user details
          UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
          //validate the token, compare it with userDetails
          if(jwtUtil.validateToken(token, userDetails)){//if the details are valid, perform the following
              UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                      userDetails, null, userDetails.getAuthorities()
              );
              usernamePasswordAuthenticationToken
                      .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
              SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
          }
        }
        //call the do filter method, passing in the request and response
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
