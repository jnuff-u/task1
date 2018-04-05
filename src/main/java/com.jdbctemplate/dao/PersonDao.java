package com.jdbctemplate.dao;

import com.jdbctemplate.pojo.Person;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface PersonDao {

    public List<Person> findAll();

    Person selectById(int id);

    void updatePserson(Person person);

    void delectPserson(int id);

    void insertPserson(Person person);

    void createPserson(Person person);


}
