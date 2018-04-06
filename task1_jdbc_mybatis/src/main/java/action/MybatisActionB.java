package action;

import com.jdbctemplate.pojo.Person;
import mybatis.mapper.PersonMapper;
import mybatis.service.PersonService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


//自动化 测试运行器 打包测试，可以看到全部的测试结果
@RunWith(SpringJUnit4ClassRunner.class)
//注解方式获取xml配置
@ContextConfiguration(locations = {"classpath*:mybatis/springmybatis.xml"})
public class MybatisActionB {

    static Logger logger = Logger.getLogger(MybatisAction.class.getName());

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testAction(){

//        System.out.print(personMapper.selectById(1));
        logger.debug(personMapper.selectById(1));

    }


    @Test
    public void testDaoSuport(){

        logger.debug("\n ==================================== \n" +personMapper.selectById(5) + "\n ==================================== \n");
    }

    @Test
    public void testFindAll(){
       List<mybatis.model.Person> list = personMapper.findAll();

       System.out.print("\n ==================================== \n list的长度为：" + list.size() + "\n ==================================== \n" +list.toString() + "\n ==================================== \n");



    }


}
