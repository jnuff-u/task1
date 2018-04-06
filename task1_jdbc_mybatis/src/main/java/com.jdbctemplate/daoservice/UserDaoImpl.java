package com.jdbctemplate.daoservice;

import com.jdbctemplate.dao.UserDao;
import com.jdbctemplate.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbctemplate;

    public JdbcTemplate getJdbctemplate() {
        return jdbctemplate;
    }

    public void setJdbctemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    public List<User> findAll() {

        String sql = "select * from jnshu_user";

        List<User> list = new ArrayList<User>();
        jdbctemplate.queryForList(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setCreate_at(resultSet.getInt("create_at"));
                u.setUpdate_at(resultSet.getInt("update_at"));
                u.setAge(resultSet.getInt("age"));
                u.setSex(resultSet.getInt("sex"));
                u.setPro(resultSet.getString("pro"));
                u.setBrother(resultSet.getString("brother"));
                list.add(u);
            }
        });

        return list;
    }

    public User selectById(int id) {

        String sql = "select * from jnshu_user where id = ?";

//        查询出来的数据是返回类型
        User user = jdbctemplate.queryForObject(sql, new RowMapper<User>() {

            @Nullable
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setCreate_at(resultSet.getInt("create_at"));
                u.setUpdate_at(resultSet.getInt("update_at"));
                u.setAge(resultSet.getInt("age"));
                u.setSex(resultSet.getInt("sex"));
                u.setPro(resultSet.getString("pro"));
                u.setBrother(resultSet.getString("brother"));
                return u;
            }
        }, id);

        return user;
    }

    public void updateUser(User user) {

//        String sql = "update jnshu_user set (name,create_at,update_at,age,sex,pro,brother) values( ?,?,?,?,?,?,? ) where id = ?";
        String sql = "update jnshu_user set name=?,create_at=?,update_at=?,age=?,sex=?,pro=?,brother=? where id = ?";
        jdbctemplate.update(sql,user.getName(),user.getCreate_at(),user.getUpdate_at(),user.getAge(),user.getSex(),user.getPro(),user.getBrother(),user.getId());

    }

    public void delectUser(int id) {

        String sql = "delete jnshu_user where id = ?";

        jdbctemplate.update(sql,id);
    }

    public void insertUser(User user) {

//        留方法修改
        String sql = "insert into jnshu_user values (?,?,?,?,?,?,?,?)";

        jdbctemplate.update(sql,user);
    }

    public void createUser(User user) {

        String sql = "insert into jnshu_user values (?,?,?,?,?,?,?,?)";

        jdbctemplate.update(sql,user);

    }

    public int selectCount(){
//        查询数据总数，null不计
        String sql = "select Count(*) from jnshu_user ";
//        spring 3.2.2后取消ForInt
        int conut =  jdbctemplate.queryForObject(sql,new Object[]{},Integer.class);
        return conut;
    }

}
