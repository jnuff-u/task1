import com.jdbctemplate.daoservice.UserDaoImpl;
import com.jdbctemplate.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *  Spring JdbcTemplate
 *
 *  类：java/com.jdbctemplate
 *
 *  xml:resource/jdbctemplate/applicationtext.xml
 *
 *
 */
public class TestjdbcTemplate {


        public static void main(String[] args){

                try {
                        ApplicationContext conn = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");

                        UserDaoImpl userDaoimp = (UserDaoImpl) conn.getBean("userService");


                System.out.print("\n" + userDaoimp.selectById(1) + "\n");

                System.out.print("\n查出的总数据为：" + userDaoimp.selectCount() + " 条\n");



                }catch (Exception e){

                        System.out.print("\n\n  main   error  \n\n");
                        e.fillInStackTrace();
                }
        }

        @Test
        public void testTemlpalte(){

                ApplicationContext conn = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");
//                applicationcontext.xml里定义的bean ，不使用注解扫描自动注册就需要在xml里注册
                UserDaoImpl userDaoimp = (UserDaoImpl) conn.getBean("userService");

                System.out.print( "========================\n未修改前:\n" + userDaoimp.selectById(99) + "\n========================\n");
                System.out.print("\n总数据：" + userDaoimp.selectCount() + "条\n");

                User user = new User();
                user.setId(99);
                user.setName("王大锤");
                user.setAge(1);
                user.setPro("我已经走上人生巅峰！！");
                user.setBrother("我兄弟是赵日天！！");
                userDaoimp.updateUser(user);
                System.out.print( "========================\n修改后:\n" + userDaoimp.selectById(99) + "\n========================\n");

                System.out.print("\n总数据：" + userDaoimp.selectCount() + "条\n");
//                userDaoimp.delectUser(99);
                System.out.print("\n总数据：" + userDaoimp.selectCount() + "条\n");
        }







}
