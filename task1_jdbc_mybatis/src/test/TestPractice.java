import com.jdbctemplate.pojo.Person;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * 纯粹练习
 *
 */
public class TestPractice {


    public static void main(String[] args){

        Logger logger = Logger.getLogger(TestPractice.class.getName());

        Connection conn;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://119.29.17.188/jnshu";
        String user = "root";
        String password = "root";
        String sql = "select * from person";

        try {

            conn = (Connection) DriverManager.getConnection(url,user,password);

            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Person> list = new ArrayList<Person>();

            while (resultSet.next()){

                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setSex(resultSet.getInt("sex"));
                person.setEmail(resultSet.getString("email"));
                person.setPro(resultSet.getString("pro"));
                person.setQq(resultSet.getInt("qq"));
                person.setTell(resultSet.getInt("tell"));
                System.out.print(person.toString() + "\n");
                list.add(person);
            }

            logger.debug(list);

            conn.close();
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}
