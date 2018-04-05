package com.jdbctemplate.daoservice;

import com.jdbctemplate.dao.PersonDao;
import com.jdbctemplate.pojo.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    private JdbcTemplate jdbctemplate;

    public JdbcTemplate getJdbctemplate() {
        return jdbctemplate;
    }

    public void setJdbctemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    public List<Person> findAll() {
        return null;
    }

    public Person selectById(int id) {

        String sql = "select * from person where id = ?";

//        查询出来的数据是返回类型
        Person person = jdbctemplate.queryForObject(sql, new RowMapper<Person>() {

            @Nullable
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {

                Person person1 = new Person();
                person1.setId(resultSet.getInt("id"));
                person1.setName(resultSet.getString("name"));
                person1.setAge(resultSet.getInt("age"));
                person1.setSex(resultSet.getInt("sex"));
                person1.setEmail(resultSet.getString("email"));
                person1.setPro(resultSet.getString("pro"));
                person1.setQq(resultSet.getInt("qq"));
                person1.setTell(resultSet.getInt("tell"));
                return person1;
            }
        }, new Object[]{1});

        return person;
    }

    public void updatePserson(Person person) {

        String sql = "update";


    }

    public void delectPserson(int id) {

    }

    public void insertPserson(Person person) {

    }

    public void createPserson(Person person) {

    }


}
