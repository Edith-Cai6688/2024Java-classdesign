package org.example.admin.Service;

import org.example.admin.common.enums.Constants;
import org.example.admin.common.enums.ResultCodeEnums;
import org.example.admin.common.enums.RoleEnums;
import org.example.admin.mapper.TeacherMapper;
import org.example.admin.pojo.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    public void add(Teacher teacher){
        Teacher dbTeacher=teacherMapper.selectByUsername(teacher.getUsername());
        if(ObjectUtils.isEmpty(dbTeacher)==false){
            throw new CustomException(ResultCodeEnums.USER_EXIST_ERROR);
        }
        if(ObjectUtils.isEmpty (teacher.getPassword()){
            teacher.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        if(ObjectUtils.isEmpty(teacher.getName())){
            teacher.setName(teacher.getUsername());
        }
        teacher.setJob(RoleEnums.TEACHER.name()));
        teacherMapper.insert(teacher);
    }
}
