package com.jdbctemplate.dao;

import com.jdbctemplate.pojo.Person;
import com.jdbctemplate.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

    User selectById(int id);

    void updateUser(User user);

    void delectUser(int id);

    void insertUser(User user);

    void createUser(User user);


}
