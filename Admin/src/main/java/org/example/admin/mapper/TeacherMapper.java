package org.example.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.admin.pojo.Teacher;
import java.util.List;

@Mapper
public interface TeacherMapper {

    int insert(Teacher teacher);

    int deleteById(Integer id);

    int updateById(Teacher teacher);

    Teacher selectById(Integer id);

    List<Teacher> selectAll(Teacher teacher);

    @Select("select * from Teacher where username = #{username}")
    Teacher selectByUsername(String username);
}
