package com.example.school.test;

import java.util.List;

import com.example.school.dao.ContactDAO;
import com.example.school.dao.ContactDAOImpl;
import com.example.school.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static org.junit.jupiter.api.Assertions.*;

class ContactDAOTest {
    private DriverManagerDataSource dataSource;
    private ContactDAO dao;
    @BeforeEach
    void setUpBeforeEach(){
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
        dataSource.setUsername("*****");
        dataSource.setPassword("###########");
        dao = new ContactDAOImpl(dataSource);
    }
    @Test
    void save() {
        Contact contact = new Contact("Sweet Debra", "debsweet@nomans.com", "santon, kenya","07567");
        int result = dao.save(contact);

        assertTrue(result > 0);
    }

    @Test
    void update() {
        Contact contact = new Contact(3, "kelly Blanks", "debs@nomans.com", "Juja, Norway","07567");
        int result = dao.update(contact);
        assertTrue(result > 0);
    }

    @Test
    void get() {
        Integer id = 2  ;
        Contact contact = dao.get(id);
        if(contact != null){
            System.out.println(contact);
        }
        assertNotNull(contact);
    }

    @Test
    void delete() {
        Integer id = 2  ;
        int result = dao.delete(id);
        assertTrue(result>0);
    }

    @Test
    void list() {
        List<Contact> listContacts = dao.list();

        for(Contact eachContact : listContacts){
            System.out.println(eachContact);
        }

        assertTrue(!listContacts.isEmpty());
    }
}