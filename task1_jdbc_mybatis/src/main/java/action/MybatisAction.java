package action;

import mybatis.mapper.PersonMapper;
import mybatis.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
/*
 * 测试MybatisSpring整合
 * MybatisSpring 的 main主函数入口
 * 类：java/mybatis
 * XML：resources/mybatis
 *
 */

@Controller
public class MybatisAction {

    @Autowired
    private PersonMapper personMapper;

    org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MybatisAction.class.getName());

    String contextxml = "mybatis/springmybatis.xml";


    public static void main(String[] args){

        try {

            ApplicationContext conn = new ClassPathXmlApplicationContext("mybatis/springmybatis.xml");

            MybatisAction mybatisAction = (MybatisAction) conn.getBean("mybatisAction");

//            System.out.print("\n ==================================== \n" + mybatisAction.personMapper.selectById(2) + "\n ==================================== \n");
//        System.out.print("\n ==================================== \n" + mybatisAction.personMapper.findAll() + "\n ==================================== \n");



        }catch (Exception e){

            e.fillInStackTrace();

//            抛出异常
//            throw e;

        }



    }

    @Test
    public void testMybatis(){

//        获取上下文连接配置
        ApplicationContext context = new ClassPathXmlApplicationContext(contextxml);

//        获取bean
        MybatisAction mybatisAction = (MybatisAction) context.getBean("mybatisAction");



//        Person p = new Person();
//        p.setName("二师兄");
//        p.setQq(23896235);
//        p.setAge(22);
//        p.setEmail("7799@12.com");
//        p.setPro("包揽全男");
//        p.setSex(1);
//        p.setTell(135000);
//
//        mybatisAction.personMapper.insertPerson(p);

//        System.out.print( mybatisAction.personMapper.selectById(1));
//        logger.debug("\n ==================================== \n" + mybatisAction.personMapper.selectById(2) + "\n ==================================== \n");
        for (int i=0;i<1000;i++){
            System.out.print("\n ==================================== \n" + mybatisAction.personMapper.selectById(i) + "\n ==================================== \n");
        }



    }

    @Test
    public void insertOne(){

        ApplicationContext context = new ClassPathXmlApplicationContext(contextxml);

        MybatisAction mybatisAction = (MybatisAction) context.getBean("mybatisAction");

        Person p = new Person();
        p.setName("三师兄");
        p.setQq(8342657);
        p.setAge(22);
        p.setEmail("7788@12.com");
        p.setPro("巅峰的世界你不懂");
        p.setSex(1);
        p.setTell(138000);
        mybatisAction.personMapper.insertPerson(p);

        logger.info(mybatisAction.personMapper.findAll());

    }




    @Test
    public void insertList(){

        ApplicationContext conn = new ClassPathXmlApplicationContext(contextxml);

        MybatisAction mybatisAction = (MybatisAction) conn.getBean("mybatisAction");

        Random random = new Random();

        int max = 30;
        int min = 20;
        String xing = "问";
        String ming = "天";
        Person pro = new Person();
        pro.setName("大师兄");
        List<Person> list = new ArrayList<Person>();

        for (int j = 0; j < 1; j++) {

            list.clear();

            for (int i = 0; i < 2; i++) {

                int xingshi = (int) (Math.random() * 11);
                int shi = (int) (Math.random() * 11);
                if (xingshi == 0) {
                    xing = "张";
                } else if (xingshi == 1) {
                    xing = "王";
                } else if (xingshi == 2) {
                    xing = "赵";
                } else if (xingshi == 3) {
                    xing = "李";
                } else if (xingshi == 4) {
                    xing = "吕";
                } else if (xingshi == 5) {
                    xing = "刘";
                } else if (xingshi == 6) {
                    xing = "诸葛";
                } else if (xingshi == 7) {
                    xing = "夏侯";
                } else if (xingshi == 8) {
                    xing = "乔";
                } else if (xingshi == 9) {
                    xing = "欧阳";
                } else if (xingshi == 10) {
                    xing = "孙";
                }
                if (shi == 0) {
                    ming = "良";
                } else if (shi == 1) {
                    ming = "楠";
                } else if (shi == 2) {
                    ming = "乾坤";
                } else if (shi == 3) {
                    ming = "天地";
                } else if (shi == 4) {
                    ming = "乾";
                } else if (shi == 5) {
                    ming = "村夫";
                } else if (shi == 6) {
                    ming = "飞龙";
                } else if (shi == 7) {
                    ming = "风";
                } else if (shi == 8) {
                    ming = "叶";
                } else if (shi == 9) {
                    ming = "子赣";
                } else if (shi == 10) {
                    ming = "孔明";
                }

                int age = random.nextInt(max) % (max - min + 1) + min;
                int sex = (int) (Math.random() * 2);
                Person u = new Person();
                u.setName(xing + ming);
                u.setAge(age);
                u.setSex(sex);
                pro.setName(xing + ming);
                //            userMapper.insertUser(u);
                System.out.print("=====  xingshi:" + xing + ming + ",age:" + age + ",sex:" + sex + "  =====\n");
                System.out.print("------已插入第" + (i + 1) + "条数据------\n");
                System.out.print(list.toString());
                System.out.print("list.size():" + list.size() + "\n");

                list.add(u);
            }
            mybatisAction.personMapper.insertPersonList(list);

            mybatisAction.personMapper.findAll();
        }




    }




}
