package com.example.school.model;
/* Dev Kelyn created the file on 2021-02-19 inside the package - com.example.school.model */

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
