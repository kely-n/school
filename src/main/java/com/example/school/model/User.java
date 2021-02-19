package com.example.school.model;
/* Dev Kelyn created the file on 2021-02-19 inside the package - com.example.school.model */

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *for security purposes
 */

@Entity
public class User {

    @Id
    private long id;

    private String username;
    private String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passsword) {
        this.password = passsword;
    }
}
