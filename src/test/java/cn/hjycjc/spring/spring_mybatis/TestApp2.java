package cn.hjycjc.spring.spring_mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.hjycjc.spring.spring_mybatis.entity.User;
import cn.hjycjc.spring.spring_mybatis.utils.MybatisUtil;

public class TestApp2 {
	
	private MybatisUtil mybatisUtil=new MybatisUtil();
	
	/*
	 * 将一些公共的放在Util类中。
	 */
	@Test
	public void test() throws IOException{
		SqlSession sqlSession =mybatisUtil.getSqlSession();
		
		String statement ="cn.hjycjc.spring.spring_mybatis.dao"+".updateUser";
		User parameter =new User();
		parameter.setName("Tom");
		parameter.setAge(30);
		parameter.setId(1);
		sqlSession.update(statement, parameter);
	}
	
	@Test
	public void test2() throws IOException{
		
		SqlSession sqlSession =mybatisUtil.getSqlSession();
		String statement ="cn.hjycjc.spring.spring_mybatis.dao"+".insertUser";
		
		User parameter =new User();
		parameter.setName("LUCE");
		parameter.setAge(19);
		sqlSession.insert(statement, parameter);
		sqlSession.commit();
	}
	/*
	 * 测试delete,默认有返回值，返回删除几条记录。
	 */
	@Test
	public void test3() throws IOException{
		
		SqlSession sqlSession =mybatisUtil.getSqlSession();
		String statement ="cn.hjycjc.spring.spring_mybatis.dao"+".deleteUser";
		
		User parameter =new User();
		parameter.setName("LUCE");
		parameter.setAge(19);
		parameter.setId(5);
		System.out.println(sqlSession.delete(statement, parameter));
	}
	
	@Test
	public void testGetAll() throws IOException{
		
		SqlSession sqlSession =mybatisUtil.getSqlSession();
		String statement ="cn.hjycjc.spring.spring_mybatis.dao"+".getAll";
		
		List<User> users=sqlSession.selectList(statement);
		
		System.out.println(users);
		for(User user: users){
			System.out.println(user);
		}
	}
}
