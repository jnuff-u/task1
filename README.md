# task1 
│ 
│    
└─ src  
    ├─ main  
    │  ├─ filters  
    │  │  
    │  ├─ java  
    │  │  │
├─ action  
    │  │  │   ├─     MybatisAction.java  ———— *//main主入口*   
    │  │  │   └─     MybatisActionB.java    
    │  │  │        
    │  │  ├─ com.jdbctemplate   ————*//jdbcTemplate*  
    │  │  │   │
    ├─ dao  
    │  │  │   │    └─    UserDao.java   
    │  │  │   │        
    │  │  │   ├─ daoservice  
    │  │  │   │    └─    UserDaoImpl.java  
    │  │  │   │        
    │  │  │   └─ pojo  
    │  │  │   │     ├─    Person.java  
    │  │  │   │     └─    User.java  
    │  │  │   
    │  │  │
 ├─ controller  
    │  │  │
 ├─ mybatis  ————*//SpringMybatis整合类*  
    │  │  │     ├─ mapper  
    │  │  │     │   └─     PersonMapper.java  
    │  │  │     │        
    │  │  │     ├─ model  
    │  │  │     │   └─     Person.java  
    │  │  │     │        
    │  │  │     └─ service  
    │  │  │     │    ├─     C3p0_Conn.java    
    │  │  │     │    └─     PersonService.java   
    │  │                
    │  ├─ resources  
    │  │  │  ├─  c3p0.properties ————*//c3p0连接池配置文件*  
    │  │  │  └─  log4j.properties ————*//日志配置文件*  
    │  │  │    
    │  │  ├─ jdbctemplate  ————*//jdbcTemplate使用配置文件*  
    │  │  │   └─   applicationcontext.xml  
    │  │  │        
    │  │  └─ mybatis ————*//springMybatis使用配置文件*  
    │  │   │   ├─ springmybatis.xml  
    │  │   │   │    
    │  │   │   └─ mapper  
    │  │   │   │     └─   personMapper.xml  
    │  │      
    │  │  
    │  └─ webapp  
    │      │  └─ ndex.jsp  
    │      │    
    │      └─ WEB-INF  
    │      │     └─     web.xml  
    │                
    └─ test  
    │     ├─     TestJdbc.java          ————*//jdbc测试类*  
    │     ├─     TestjdbcTemplate.java  ————*//jdbcTemplate测试类*  
    │     ├─     TestMybatis.java       ————*//简单测试 SpringMybatis，其它测试在java/action目录下*  
    │     └─     TestPractice.java      ————*//其它练习*  
    │         
    └─  pom.xml  
