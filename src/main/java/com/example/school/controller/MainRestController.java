package com.example.school.controller;

import com.example.school.dao.ContactDAO;
import com.example.school.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
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
}
