package cn.hjycjc.spring.spring_mybatis.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil { 
	
	
	public SqlSession getSqlSession() throws IOException{
		
		Reader configuration=Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(configuration);
		//默认手动插入
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;	
	}

}
