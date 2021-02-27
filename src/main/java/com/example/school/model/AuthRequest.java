package com.example.school.model;
/* Dev Kelyn created the file on 2021-02-24 inside the package - com.example.school.model */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthRequest {
    private String username;
    private String password;


}
