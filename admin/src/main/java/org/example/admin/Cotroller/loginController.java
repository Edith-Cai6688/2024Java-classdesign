package org.example.admin.Cotroller;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.example.admin.Service.studentService;
import org.example.admin.pojo.student;
import org.example.admin.utils.jwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.example.admin.pojo.result;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class loginController {

    @Autowired
    private studentService stuservice;

    @PostMapping("/login")
    public result login(@RequestBody student stu){
        student s=stuservice.login(stu);

        if(s!=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",s.getStuId());
            claims.put("name",s.getName());
            claims.put("account",s.getAccount());
            claims.put("password",s.getPassword());
            claims.put("classNumber",s.getClassnumber());
            claims.put("major",s.getMajorId());
            claims.put("depart",s.getDepartId());
            claims.put("gender",s.getGender());
            String token=jwtUtils.generateToken(claims);
            return result.success(token);
        }
        return result.error("用户名或密码错误！");
    }
}
