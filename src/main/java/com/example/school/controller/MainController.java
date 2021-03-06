package com.example.school.controller;

import com.example.school.dao.ContactDAO;
import com.example.school.model.Contact;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ContactDAO contactDAO;

    @RequestMapping("/login")
    public String loginPage(){
       return "login";
    }

    @RequestMapping("/logout")
    public String logoutPage(){
        return "logout";
    }

    @RequestMapping("/")
    public ModelAndView listContact(ModelAndView model){
        List<Contact> listContact = contactDAO.list();
        model.addObject("listContact", listContact);
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model){
        Contact newContact = new Contact();
        model.addObject("contact", newContact);
        model.setViewName("contact_form");

        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact){
        System.out.println(contact.toString());
        if(contact.getContactId() != 0) {
            contactDAO.update(contact);
        }else{
            contactDAO.save(contact);
        }
       return new ModelAndView("redirect:/");
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactDAO.get(id);
        ModelAndView model = new ModelAndView("contact_form");

        model.addObject("contact", contact);

        return model;

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        contactDAO.delete(id);
        return new ModelAndView("redirect:/");
    }

}
