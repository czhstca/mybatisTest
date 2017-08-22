package com.pingan.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.pingan.pojo.Task;

/**
 * Mybatis入门程序
 * @author EX_WLJR_CHENZEHUA
 *
 */
public class MyBatisFirst {

	/**
	 * 根据taskname查找Task信息
	 * @throws Exception
	 */
	@Test
	public void findTaskByTaskName() throws Exception{
		//1.创建SqlSessionFactory
		
		//定义myBatis配置文件路径
		String resource = "SqlMapConfig.xml";
		//加载配置文件
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//2.创建aSqlSession
		SqlSession session = factory.openSession();
		
		//3.ͨ使用sqlSession操纵数据库
		//selectOne 查询一条数据
		//参数1：Mapper.xml中定义的namespace+"."+statement id
		//参数2:where条件的具体值
		Task task = session.selectOne("test.findTaskByTaskName", "BatchXBRepay");
		
		System.out.println(task.toString());
		
		//关闭资源
		session.close();
		is.close();
		
	}
	
	/**
	 * ����������ģ����ѯ������Ϣ
	 */
	@Test
	public void findTaskByTaskNameLike() throws Exception{
		//1.����SqlSessionFactory
		
		//���������ļ�
		String resource = "SqlMapConfig.xml";
		//�����з���mybatis��������Ϣ
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//2.�õ�SqlSession
		SqlSession session = factory.openSession();
		
		//3.ͨ��SqlSession�������ݿ�
		//������ܲ�ѯ�Ľ���᷵�ض�����¼
		//��һ��������Statement��id�������ռ�+"."+id
		//�ڶ�������: parameter
		List<Task> taskList = session.selectList("test.findTaskByTaskNamelike", "File");
		
		for(Task task : taskList){
			System.out.println(task.toString());
		}
		
		//�ͷ���Դ
		session.close();
		is.close();
		
	}
	
	/**
	 * ����һ��������Ϣ
	 */
	@Test
	public void insertTask() throws Exception{
		//1.����SqlSessionFactory
		
		//���������ļ�
		String resource = "SqlMapConfig.xml";
		//�����з���mybatis��������Ϣ
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//2.�õ�SqlSession
		SqlSession session = factory.openSession();
		
		//3.ͨ��SqlSession�������ݿ�
		//��һ��������Statement��id�������ռ�+"."+id
		//�ڶ�������: parameter
		Task task = new Task();
		task.setInputdate("2017/08/10");
		task.setTargetname("target11");
		task.setTaskname("task11");
		
		int count = session.insert("test.insertTask", task);
		
		//ע�⣬��mysql�У�insert֮����Ե���mysql���еĺ���  LAST_INSERT_ID()
		//ͨ������������Ի�ȡ�ղ�insert���ݵ�������Ϣ(��������Ϊ����)
		//task.getid();
		
		
		//�ύ����
		session.commit();
		
		//�ͷ���Դ
		session.close();
		is.close();
				
	}
	
	/**
	 * ����taskname��������
	 * @throws Exception
	 */
	@Test
	public void updateTaskbyTaskName() throws Exception{
		//1.����SqlSessionFactory
		
		//���������ļ�
		String resource = "SqlMapConfig.xml";
		//�����з���mybatis��������Ϣ
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//2.�õ�SqlSession
		SqlSession session = factory.openSession();
		
		//3.ͨ��SqlSession�������ݿ�
		//��һ��������Statement��id�������ռ�+"."+id
		//�ڶ�������: parameter
		Task task = new Task();
		task.setTargetname("target22");
		task.setTaskname("task11");
		
		int count = session.update("test.updateTask", task);
		
		//�ύ����
		session.commit();
		
		//�ͷ���Դ
		session.close();
		is.close();
	}
	
	/**
	 * ����taskNameɾ��task
	 * @throws Exception
	 */
	@Test
	public void deleteTask() throws Exception{
		//1.����SqlSessionFactory
		
		//���������ļ�
		String resource = "SqlMapConfig.xml";
		//�����з���mybatis��������Ϣ
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//2.�õ�SqlSession
		SqlSession session = factory.openSession();
		
		//3.ͨ��SqlSession�������ݿ�
		//��һ��������Statement��id�������ռ�+"."+id
		//�ڶ�������: parameter
		
		int count = session.delete("test.deleteTask", "task11");

		//�ύ����
		session.commit();
		
		//�ͷ���Դ
		session.close();
		is.close();
	}
}
