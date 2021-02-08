package com.example.school.dao;

import com.example.school.model.Contact;

import java.util.List;

public interface ContactDAO {
    public int save(Contact contact);
    public int update(Contact contact);
    public Contact get(Integer id);
    public int delete(Integer contact);
    public List<Contact> list();
}
