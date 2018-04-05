package com.jdbctemplate.server;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class C3p0Utils {

    static Logger logger = Logger.getLogger(C3p0Utils.class.getName());

    static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql119");

    public static Connection getConn() throws Exception {


        try {

            return (Connection) dataSource.getConnection();

        } catch (Exception e) {
            logger.error("Exception in C3p0Utils!",e);
            throw new Exception("数据库连接出错！",e);
        }

    }



    public static void Close(Connection conn, PreparedStatement preparedStatement){

    }



}
