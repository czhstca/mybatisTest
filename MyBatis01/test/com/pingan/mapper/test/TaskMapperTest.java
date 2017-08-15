package com.pingan.mapper.test;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.pingan.daoImp.TaskDaoImp;
import com.pingan.mapper.TaskMapper;
import com.pingan.pojo.Task;

public class TaskMapperTest {

	private SqlSessionFactory factory;
	
	@Before
	public void setUp() throws Exception {
		//测试方法之前执行
		//1.创建SqlSessionFactory
		
		//定义配置文件
		String resource = "SqlMapConfig.xml";
		//向流中放入mybatis主配置信息
		InputStream is = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void testfindTaskByTaskName() throws Exception {
		
		SqlSession session = factory.openSession();
		
		//创建Mapper代理对象,Mybatis自动生成代理对象
		TaskMapper taskMapper = session.getMapper(TaskMapper.class);
		
		//调用TaskMapper方法
		Task task = taskMapper.findTaskByTaskName("BatchXBRepay");
		
		System.out.println(task.toString());
	}

}
