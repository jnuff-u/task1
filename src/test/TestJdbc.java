import com.jdbctemplate.pojo.Person;

import java.sql.*;

public class TestJdbc {


    public static void main(String[] args){


        Connection conn;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://119.29.17.188/jnshu";
        String user = "root";
        String password = "root";
        String sql = "select * from person";



        try {

            Class.forName(driver);

            conn = DriverManager.getConnection(url,user,password);

//            PreparedStatement preparedStatement = (PreparedStatement) conn.createStatement();
            Statement preparedStatement = conn.createStatement();

            ResultSet resultSet =  preparedStatement.executeQuery(sql);

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
            }


            conn.close();
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }





}
