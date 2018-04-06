import com.jdbctemplate.pojo.Person;
import org.junit.Test;

import java.sql.*;

/*
 * jdbc的增改查询
 *
 *  未使用spring
 *  只用了pojo类
 *
 */

public class TestJdbc {


    public static void main(String[] args) throws SQLException {

        Connection conn = null;

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

            preparedStatement.close();

            resultSet.close();

        } catch (SQLException e) {
            System.out.print("\nSQL异常\n");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.print("\nClassNotFoundException Class未找到异常\n");
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.close();
            }
        }


    }

    @Test
    public void insert() throws SQLException {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://119.29.17.188/jnshu";
        String user = "root";
        String password = "root";
        String sql = "INSERT INTO person (name,age,sex,pro,tell,qq,email) values (?,?,?,?,?,?,?) ";
        String sqlQuery = "select * from person";
        String sqlCount = "select count(*) from person";

        try {

//            Class.forName(driver);

            conn = DriverManager.getConnection(url,user,password);

            preparedStatement = conn.prepareStatement(sql);


            Person p = new Person();
            p.setName("jdbc大大的");
            p.setQq(873645);
            p.setAge(25);
            p.setEmail("8749@12.com");
            p.setPro("麻烦的下一代");
            p.setSex(1);
            p.setTell(186000);

            preparedStatement.setString(1,p.getName());
            preparedStatement.setInt(2,p.getAge());
            preparedStatement.setInt(3,p.getSex());
            preparedStatement.setString(4,p.getPro());
            preparedStatement.setInt(5,p.getTell());
            preparedStatement.setInt(6,p.getQq());
            preparedStatement.setString(7,p.getEmail());

            preparedStatement.executeUpdate();

            ResultSet resultSet =  preparedStatement.executeQuery(sqlQuery);

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

            System.out.print("\n总数：" + preparedStatement.executeQuery(sqlCount) + "\n");

        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            if (conn != null){
                conn.close();
            }
        }





    }



}
