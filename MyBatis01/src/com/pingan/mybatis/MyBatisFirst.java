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
	 * 根据taskname查询task信息,只得到一条记录结果
	 * @throws Exception
	 */
	@Test
	public void findTaskByTaskName() throws Exception{
		//1.创建SqlSessionFactory
		
		//定义配置文件
		String resource = "SqlMapConfig.xml";
		//向流中放入mybatis主配置信息
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//2.得到SqlSession
		SqlSession session = factory.openSession();
		
		//3.通过SqlSession操作数据库
		//只查找一条记录
		//第一个参数：Statement的id，命名空间+"."+id
		//第二个参数: parameter
		Task task = session.selectOne("test.findTaskByTaskName", "BatchXBRepay");
		
		System.out.println(task.toString());
		
		//释放资源
		session.close();
		is.close();
		
	}
	
	/**
	 * 根据任务名模糊查询任务信息
	 */
	@Test
	public void findTaskByTaskNameLike() throws Exception{
		//1.创建SqlSessionFactory
		
		//定义配置文件
		String resource = "SqlMapConfig.xml";
		//向流中放入mybatis主配置信息
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//2.得到SqlSession
		SqlSession session = factory.openSession();
		
		//3.通过SqlSession操作数据库
		//这里可能查询的结果会返回多条记录
		//第一个参数：Statement的id，命名空间+"."+id
		//第二个参数: parameter
		List<Task> taskList = session.selectList("test.findTaskByTaskNamelike", "File");
		
		for(Task task : taskList){
			System.out.println(task.toString());
		}
		
		//释放资源
		session.close();
		is.close();
		
	}
	
	/**
	 * 新增一条任务信息
	 */
	@Test
	public void insertTask() throws Exception{
		//1.创建SqlSessionFactory
		
		//定义配置文件
		String resource = "SqlMapConfig.xml";
		//向流中放入mybatis主配置信息
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//2.得到SqlSession
		SqlSession session = factory.openSession();
		
		//3.通过SqlSession操作数据库
		//第一个参数：Statement的id，命名空间+"."+id
		//第二个参数: parameter
		Task task = new Task();
		task.setInputdate("2017/08/10");
		task.setTargetname("target11");
		task.setTaskname("task11");
		
		int count = session.insert("test.insertTask", task);
		
		//注意，在mysql中，insert之后可以调用mysql独有的函数  LAST_INSERT_ID()
		//通过这个函数可以获取刚才insert数据的主键信息(主键必须为自增)
		//task.getid();
		
		
		//提交事务
		session.commit();
		
		//释放资源
		session.close();
		is.close();
				
	}
	
	/**
	 * 根据taskname更新任务
	 * @throws Exception
	 */
	@Test
	public void updateTaskbyTaskName() throws Exception{
		//1.创建SqlSessionFactory
		
		//定义配置文件
		String resource = "SqlMapConfig.xml";
		//向流中放入mybatis主配置信息
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//2.得到SqlSession
		SqlSession session = factory.openSession();
		
		//3.通过SqlSession操作数据库
		//第一个参数：Statement的id，命名空间+"."+id
		//第二个参数: parameter
		Task task = new Task();
		task.setTargetname("target22");
		task.setTaskname("task11");
		
		int count = session.update("test.updateTask", task);
		
		//提交事务
		session.commit();
		
		//释放资源
		session.close();
		is.close();
	}
	
	/**
	 * 根据taskName删除task
	 * @throws Exception
	 */
	@Test
	public void deleteTask() throws Exception{
		//1.创建SqlSessionFactory
		
		//定义配置文件
		String resource = "SqlMapConfig.xml";
		//向流中放入mybatis主配置信息
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//2.得到SqlSession
		SqlSession session = factory.openSession();
		
		//3.通过SqlSession操作数据库
		//第一个参数：Statement的id，命名空间+"."+id
		//第二个参数: parameter
		
		int count = session.delete("test.deleteTask", "task11");

		//提交事务
		session.commit();
		
		//释放资源
		session.close();
		is.close();
	}
}
