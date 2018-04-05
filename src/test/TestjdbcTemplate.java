import com.jdbctemplate.daoservice.PersonDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestjdbcTemplate {


        public static void main(String[] args){

                ApplicationContext conn = new ClassPathXmlApplicationContext("jdbctemplate/applicationcontext.xml");

                PersonDaoImpl personimpl = (PersonDaoImpl) conn.getBean("personService");

                System.out.print(personimpl.selectById(1));

        }






}
