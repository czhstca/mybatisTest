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
		//���Է���֮ǰִ��
		//1.����SqlSessionFactory
		
		//���������ļ�
		String resource = "SqlMapConfig.xml";
		//�����з���mybatis��������Ϣ
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
