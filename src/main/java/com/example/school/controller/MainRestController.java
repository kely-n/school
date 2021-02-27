package com.example.school.controller;

import com.example.school.config.security.util.JwtUtil;
import com.example.school.dao.ContactDAO;
import com.example.school.model.AuthRequest;
import com.example.school.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRestController {
    @Autowired
    private ContactDAO contactDAO;


    @GetMapping("/api/get/contacts")
    public List<Contact> listContact(){
       return contactDAO.list();
    }

    @GetMapping("/api/contact")
    public Contact getContact(@RequestParam Integer id){
        return contactDAO.get(id);
    }

    @PostMapping("/api/add/contact")
    public String addContact(@RequestBody Contact contact){
       if(contactDAO.save(contact) > 0){
           return "{\"message\":\"successfully added\"}";
       }else {
           return "{\"message\":\"failed\"}";
       }
    }

    @PutMapping("/api/update/contact")
    public String updateContact(@RequestBody Contact contact){
        if(contactDAO.update(contact) > 0){
            return "{\"message\":\"successfully updated\"}";
        }else {
            return "{\"message\":\"update failed\"}";
        }
    }

    @DeleteMapping("/api/delete/contact")
    public String deleteContact(@RequestParam Integer id){
        if(contactDAO.delete(id) > 0){
            return "{\"message\":\"successfully deleted\"}";
        }else {
            return "{\"message\":\"deletion failed\"}";
        }
    }

    //generate access token

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/api/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

        }catch (Exception ex){
//            throw new Exception("invalid username/password");
            return ("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
