package org.example.admin.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.admin.pojo.student;
@Mapper
public interface studentMapper {

    @Select("select stu_id,student.name,gender,account,password,classnumber,major.major_name,depart.depart_name,update_time\n" +
            "            from student\n" +
            "            left join major on student.stu_id=major.major_id\n" +
            "            left join depart on student.depart_id = depart.depart_id\n" +
            "            where account=#{account} and password =#{password};")
    @Results(
            {@Result(property = "majorId",column = "major_name"),
                    @Result(property = "departId",column = "depart_name")
            }
            )
    public student getByUsernameAndPassword(student stu);
}
