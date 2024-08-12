package org.example.admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class student {
    private short stuId;
    private String name;
    private String account;
    private String password;
    private String gender;
    private short classnumber;
    private String majorId;
    private String departId;
    private LocalDateTime updateTime;
}
