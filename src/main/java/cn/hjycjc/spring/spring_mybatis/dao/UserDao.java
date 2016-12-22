package cn.hjycjc.spring.spring_mybatis.dao;


import cn.hjycjc.spring.spring_mybatis.entity.User;
public interface UserDao {
	
	public User getUser(Integer id);
	
	public User insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(Integer id);

}
