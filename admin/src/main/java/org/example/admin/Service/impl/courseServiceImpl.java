package org.example.admin.Service.impl;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.example.admin.Service.courseService;
import org.example.admin.mapper.courseMapper;
import org.example.admin.pojo.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service

public class courseServiceImpl implements courseService {
    @Autowired
    private courseMapper courseMapper;

    @Override
    public List<course> list(){
        List<course> courseList=courseMapper.list();
        return courseList;
    }

    @Override
    public List<course> mylist(int sid){
        List<course> mycourseList=courseMapper.mylist(sid);
        return mycourseList;
    }

    @Override
    public void add(int cid,int sid) {
        courseMapper.add(cid,sid);
    }

    @Override
    public void delete(int cid) {
        courseMapper.delete(cid);
    }


}
