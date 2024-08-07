package org.example.admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private short teacherId;
    private String name;
    private short departId;
    private String account;
    private String password;
    private LocalDateTime createTime;
}
