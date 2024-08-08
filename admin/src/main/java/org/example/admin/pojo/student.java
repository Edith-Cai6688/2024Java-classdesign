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
    private short gender;//1是男，2是女
    private short classnumber;
    private short majorId;
    private short departId;
    private LocalDateTime updateTime;
}
