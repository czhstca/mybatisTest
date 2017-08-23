package com.pingan.mapper.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.pingan.daoImp.TaskDaoImp;
import com.pingan.mapper.TaskMapper;
import com.pingan.pojo.Task;
import com.pingan.pojo.TaskCustom;
import com.pingan.vo.TaskVo;

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
	
	//测试task综合信息查询
	@Test
	public void testfindTaskList() throws Exception {
		SqlSession session = factory.openSession();
		
		//����Mapper�������,Mybatis�Զ����ɴ������
		TaskMapper taskMapper = session.getMapper(TaskMapper.class);
		
		//创建包装对象
		TaskVo tv = new TaskVo();
		TaskCustom custom = new TaskCustom();
		//这里使用了动态sql拼接，如果不设置值，则相当于没有where条件拼接
		custom.setTargetname("PMDeductData");
		//custom.setTaskname("Split");
		//传入多个taskname
		List<String> tasknameList = new ArrayList<String>();
		tasknameList.add("PMSendDeductFile");
		tasknameList.add("PMSplitFare");
		tasknameList.add("PMSelectDeductDateError");
		tv.setTasknameList(tasknameList);
		
		tv.setTaskCustom(custom);
		
		List<TaskCustom> taskList = taskMapper.findTaskList(tv);
		
		System.out.println(taskList.toString());
	}

	//测试task综合信息查询记录数
	@Test
	public void testfindTaskCount() throws Exception{
		SqlSession session = factory.openSession();
		
		//����Mapper�������,Mybatis�Զ����ɴ������
		TaskMapper taskMapper = session.getMapper(TaskMapper.class);
		
		//创建包装对象
		TaskVo tv = new TaskVo();
		TaskCustom custom = new TaskCustom();
		//这里使用了动态sql拼接，如果不设置值，则相当于没有where条件拼接
		custom.setTargetname("PMDeductData");
		custom.setTaskname("Split");
		tv.setTaskCustom(custom);
		
		int count = taskMapper.findTaskCount(tv);
		
		System.out.println(count);
		
	}
	
	//测试resultMap
	@Test
	public void testfindTaskByTaskNameResultMap() throws Exception{
		SqlSession session = factory.openSession();
		
		//����Mapper�������,Mybatis�Զ����ɴ������
		TaskMapper taskMapper = session.getMapper(TaskMapper.class);
		
		//����TaskMapper����
		Task task = taskMapper.findTaskByTaskNameResultMap("PMgetFCRDeductFileESB");
		
		System.out.println(task.toString());
		
		
	}
	
}
