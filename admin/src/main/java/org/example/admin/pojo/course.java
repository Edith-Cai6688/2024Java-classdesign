package org.example.admin.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class course {
    private int courseId;
    private String name;
    private String teacherId;
    private short credit;
    private String time;
    private String place;
}
