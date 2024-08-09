package org.example.admin.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.admin.pojo.student;
@Mapper
public interface studentMapper {

    @Select("select * from student where account=#{account} and password =#{password}")
    public student getByUsernameAndPassword(student stu);
}
