package org.example.admin.mapper;
import io.jsonwebtoken.Claims;
import org.apache.ibatis.annotations.*;
import org.example.admin.pojo.course;

import java.util.List;

@Mapper
public interface courseMapper {

    @Select("select course_id,course.name,teacher.teacher_name,credit,time,place from course left join teacher on course.teacher_id = teacher.teacher_id;")
    @Results({@Result(property = "teacherId",column="teacher_name")
            })
    List<course> list();

    @Select("select course.course_id,course.name,teacher.teacher_name,credit,time,place from course_student inner join course on course.course_id=course_student.course_id left join teacher on course.teacher_id = teacher.teacher_id where course_student.stu_id =#{sid};")
    @Results({@Result(property = "teacherId",column="teacher_name")
    })
    List<course> mylist(int sid);

    @Insert("insert into course_student (course_id, stu_id) select #{cid},#{sid} from dual where not exists(select * from course_student where course_id=#{cid} and stu_id=#{sid});")
    void add(@Param("cid") int cid,@Param("sid") int sid);

    @Delete("delete from course_student where course_id=#{cid}")
    void delete(int cid);

}
