package cn.hjycjc.spring.spring_mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hjycjc.spring.spring_mybatis.dao.UserDao;
import cn.hjycjc.spring.spring_mybatis.entity.User;

public class TestApp {
	
	private UserDao userDao=null;
	
	/*
	 * 测试mybatis
	 */
	@Test
	public void test() throws IOException{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*
		 * 需要改进
		 */
		Reader configuration=Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(configuration);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statement ="cn.hjycjc.spring.spring_mybatis.dao"+".getUser";
		
		int parameter =2;		
		User result=sqlSession.selectOne(statement, parameter);
		
		System.out.println(result);
	
	}
	
	/*
	 * 测试select，是参数是一个对象。
	 */
	@Test
	public void testObject() throws IOException{
		
		Reader configuration=Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(configuration);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statement ="cn.hjycjc.spring.spring_mybatis.dao"+".insertUser";
		
		User parameter =new User();
		parameter.setName("Queey");
		parameter.setAge(18);
		sqlSession.insert(statement, parameter);
		
	}
	
	

}
