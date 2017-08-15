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
		//���Է���֮ǰִ��
		//1.����SqlSessionFactory
		
		//���������ļ�
		String resource = "SqlMapConfig.xml";
		//�����з���mybatis��������Ϣ
		InputStream is = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void testfindTaskByTaskName() throws Exception {
		
		SqlSession session = factory.openSession();
		
		//����Mapper�������,Mybatis�Զ����ɴ������
		TaskMapper taskMapper = session.getMapper(TaskMapper.class);
		
		//����TaskMapper����
		Task task = taskMapper.findTaskByTaskName("BatchXBRepay");
		
		System.out.println(task.toString());
	}

}
