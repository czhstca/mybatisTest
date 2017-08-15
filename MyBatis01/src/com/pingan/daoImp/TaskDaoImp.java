package com.pingan.daoImp;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pingan.dao.TaskDao;
import com.pingan.pojo.Task;

public class TaskDaoImp implements TaskDao {

	private SqlSessionFactory factory;
	
	//注入SqlSessionFactory
	//此处未和Spring整合，模拟通过构造函数注入
	public TaskDaoImp(SqlSessionFactory factory){
		this.factory = factory;
	}
	
	
	@Override
	public Task selectTaskByTaskName(String taskName) throws Exception {
		// Sqlsession是线程不安全的，定义在局部方法中可以避免多线程共享变量导致的数据异常
		SqlSession session = factory.openSession();
		Task task = session.selectOne("test.findTaskByTaskName",taskName);
		session.close();
		return task;
	}

	@Override
	public void insertTask(Task task) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		session.insert("test.insertTask", task);
		session.commit();
		session.close();
	}

	@Override
	public void deleteTask(String taskName) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		session.delete("test.deleteTask", taskName);
		session.commit();
		session.close();
	}

}
