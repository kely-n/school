package com.example.school.dao;

import com.example.school.model.Contact;

import java.util.List;

public interface ContactDAO {
    int save(Contact contact);
    int update(Contact contact);
    Contact get(Integer id);
    int delete(Integer contact);
    List<Contact> list();
}
