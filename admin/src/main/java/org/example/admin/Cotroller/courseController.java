package org.example.admin.Cotroller;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import lombok.extern.slf4j.Slf4j;
import org.example.admin.Service.courseService;
import org.example.admin.pojo.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.admin.pojo.result;

import java.util.List;
import org.example.admin.utils.jwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class courseController {

    @Autowired
    private courseService service;

    @GetMapping("/course")
    public result list(){
        log.info("查询所有课程");
        List<course> courselist=service.list();
        return result.success(courselist);
    }

    @GetMapping("/mycourse")
    public result mylist(HttpServletRequest request){
        log.info("查询我的课程课程");
        String token = request.getHeader("token");
        log.info(token);
        Claims claims=jwtUtils.parseToken(token);
        String cl=String.valueOf(claims);
        log.info(cl);
        int sid=Integer.parseInt(String.valueOf(claims.get("id")));
        List<course> mycourselist=service.mylist(sid);
        return result.success(mycourselist);
    }

    @PostMapping("/chooseClass")
    public result chooseClass(HttpServletRequest request,@RequestBody course addcourse){
        log.info("查询选中课程信息");
        log.info(addcourse.toString());
        String token = request.getHeader("token");
        log.info(token);
        Claims claims=jwtUtils.parseToken(token);
        int sid=Integer.parseInt(String.valueOf(claims.get("id")));
        int cid= addcourse.getCourseId();
        service.add(cid,sid);
        return result.success();
    }

    @PostMapping("/deleteClass")
    public result deleteClass(@RequestBody course deletecourse){
        log.info("查询选中课程信息");
        log.info(deletecourse.toString());
        int cid= deletecourse.getCourseId();
        service.delete(cid);
        return result.success();
    }
}
