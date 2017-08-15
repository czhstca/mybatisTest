package com.pingan.mapper;

import java.util.List;

import com.pingan.pojo.Task;

/**
 * mybatis的Mapper接口
 * @author EX_WLJR_CHENZEHUA
 *
 */
public interface TaskMapper {
	
	//Mapper开发规范:
	//注意：使用Mapper代理开发时，接口中方法名应该和Mapper.xml中配置的statementid一致!
	//Mapper接口中方法的参数类型应该和xml中parameterType指定类型一致!
	//Mapper借口中的返回值类型应该和xml中resultType指定类型一致!
	//使用Mapper代理开发时，xml中namespace应该为Mapper接口文件全路径!
	
	//根据taskname查询单个task信息
	public Task findTaskByTaskName(String taskName) throws Exception;
	
	//根据taskname模糊查询多个Task信息(代理对象会根据需要返回的对象类型自动选择调用selectOne 或者  selectList)
	public List<Task> findTaskByTaskNamelike(String taskName) throws Exception;
	 
	//添加task信息
	public void insertTask(Task task) throws Exception;
	
	//根据taskname删除task信息
	public void deleteTask(String taskName) throws Exception;
	
}
