package org.example.admin.Cotroller;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.example.admin.Service.studentService;
import org.example.admin.utils.jwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.admin.pojo.result;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@RestController
public class studentController {

    @GetMapping("/home")
    public result home(HttpServletRequest request) {
        String token = request.getHeader("token");
        log.info(token);
        Claims claims= jwtUtils.parseToken(token);
        String cl=String.valueOf(claims);
        log.info(cl);
        return result.success(claims);
    }
}
