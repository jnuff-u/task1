package mybatis.mapper;

import mybatis.model.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonMapper {

//    @Select("SELECT * FROM person")
    public List<Person> findAll();

//    @Select(" SELECT * FROM person WHERE id = #{id}")
//    @ResultMap("personMap")
    Person selectById(int id);

//    @Update("Update person SET name=#{name},age=#{age},sex=#{sex},tell=#{tell},qq=#{qq},email=#{email},pro=#{pro},waikey=#{waikey} WHERE id=#{id}")
    void updatePerson(Person person);

//    @Delete("DELETE FROM person WHERE id = #{id}")
    void delectPerson(int id);

//    @Insert("INSERT INTO person (id,create_at,update_at,name,age,sex,pro,tell,qq,email,waikey) values (#{id},#{create_at},#{update_at},#{name},#{age},#{sex},#{pro},#{tell},#{qq},#{email},#{waikey})")
    void insertPerson(Person person);

//    @Insert("INSERT INTO person (id,create_at,update_at,name,age,sex,pro,tell,qq,email,waikey) values (#{id},#{create_at},#{update_at},#{name},#{age},#{sex},#{pro},#{tell},#{qq},#{email},#{waikey})")
    void createPerson(Person person);

    void insertPersonList(List<Person> list);

}
