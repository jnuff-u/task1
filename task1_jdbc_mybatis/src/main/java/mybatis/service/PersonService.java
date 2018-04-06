package mybatis.service;

import mybatis.mapper.PersonMapper;
import mybatis.model.Person;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends SqlSessionDaoSupport implements PersonMapper{


    @Autowired
    public void setSessionFactory(SqlSessionFactory sqlSessionFactory){
            super.setSqlSessionFactory(sqlSessionFactory);
    }


    public Person selectById(int id) {

        /**
         * *从语句键和参数中检索单个行。
         * statement :mapper.xml里的 namespace
         * @param <T>返回的对象类型。
         * @param语句唯一标识符匹配使用的语句。
         * @param参数一个参数对象传递到语句。
         * @return映射对象
         *   <T> T selectOne(String statement, Object parameter);
         */
        return this.getSqlSession().selectOne("mybatis.mapper.PersonMapper.selectById",id);
    }

    public List<Person> findAll() {
        return this.getSqlSession().selectList("mybatis.mapper.PersonMapper.findAll");
    }

    public void updatePerson(Person person) {
        this.getSqlSession().update("mybatis.mapper.PersonMapper.updatePerson",person);
    }

    public void deletePerson(int id) {
        this.getSqlSession().delete("mybatis.mapper.PersonMapper.deletePerson",id);
    }

    public void insertPerson(Person person) {
        this.getSqlSession().insert("mybatis.mapper.PersonMapper.insertPerson",person);
    }

    public void createPerson(Person person) {
        this.getSqlSession().insert("mybatis.mapper.PersonMapper.createPerson",person);
    }

    public void insertPersonList(List<Person> list) {
        this.getSqlSession().insert("mybatis.mapper.PersonMapper.insertPersonList",list);
    }

}
