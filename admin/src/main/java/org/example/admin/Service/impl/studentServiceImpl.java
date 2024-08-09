package org.example.admin.Service.impl;
import lombok.extern.slf4j.Slf4j;
import org.example.admin.Service.studentService;
import org.example.admin.mapper.studentMapper;
import org.example.admin.pojo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class studentServiceImpl implements studentService {

    @Autowired
    private studentMapper studentMapper;

    @Override
    public student login(student stu){
        return studentMapper.getByUsernameAndPassword(stu);
    }
}
