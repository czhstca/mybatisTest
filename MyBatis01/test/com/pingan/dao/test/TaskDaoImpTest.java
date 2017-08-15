package com.pingan.dao.test;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.pingan.daoImp.TaskDaoImp;
import com.pingan.pojo.Task;

public class TaskDaoImpTest {

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
	public void testSelectTaskByTaskName() throws Exception {
		TaskDaoImp tdi = new TaskDaoImp(factory);
		
		Task task = tdi.selectTaskByTaskName("BatchXBRepay");
		
		System.out.println(task.toString());
	}

}
