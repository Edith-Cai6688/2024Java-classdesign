package org.example.admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private short gender;
    private String photo;
    private short job;
    private String email;
    private Integer phone;
}
