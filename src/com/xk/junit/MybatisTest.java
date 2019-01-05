package com.xk.junit;

//import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xk.javabean.User;

public class MybatisTest {
	
	@Test 
	public void test() throws Exception { 
//	public static void main(String[] args) throws Exception {
		//加载核心配置文件 
		String resource = "sqlMapConfig.xml"; 
		InputStream in = Resources.getResourceAsStream(resource); 
		//创建SqlSessionFactory 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in); 
		//创建SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession(); 
		//执行sql语句 
		User user = sqlSession.selectOne("test.findUserById", 1); 
		System.out.println(user); 
		} 
}
