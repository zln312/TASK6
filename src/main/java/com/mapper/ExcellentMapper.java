package com.mapper;

import com.model.Excellent;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface ExcellentMapper {

    @Select(value = "select *from excellent_student order by salary desc limit 4")
    List<Excellent> show();

    @Select(value = "select count(0) from excellent_student where status=#{status}")
    long showNumber(int status);

    @Insert(value = "insert into excellent_student (profession,name,description,picture,salary,status,job) values ( #{profession}, #{name}, #{description}, #{picture}, #{salary} ,#{status}, #{job})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Boolean add(Excellent excellent);

    @Update(value = "update excellent_student set profession=#{profession}, name=#{name}, description=#{description} ,picture=#{picture} ,salary=#{salary},status=#{status},job=#{job} where id=#{id}")
    Boolean update(Excellent excellent);

    @Select(value = "select *from excellent_student where id = #{id}")
    Excellent showOne(long id);

    @Delete(value = "delete from  excellent_student where id = #{id}")
    Boolean delete(long id);

    @Select(value = "select *from excellent_student")
    List<Excellent> showAll();
}
