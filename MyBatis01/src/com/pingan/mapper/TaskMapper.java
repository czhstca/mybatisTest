package com.pingan.mapper;

import java.util.List;

import com.pingan.pojo.Task;
import com.pingan.pojo.TaskCustom;
import com.pingan.vo.TaskVo;

/**
 * mybatis的Mapper接口
 * @author EX_WLJR_CHENZEHUA
 *
 */
public interface TaskMapper {
	
	//Mapper编写规范:
	//Mapper接口中的方法必须和Mapper.xml中的statement的id保持一致
	//Mapper接口方法中的输入参数类型必须和Mapper.xml中的ParameterType类型一致
	//Mapper接口方法的返回类型必须和Mapper.xml中的resultType类型一致
	//Mapper.xml中的namespace必须为Mapper接口的全路径!
	
	//根据taskname查询task信息
	public Task findTaskByTaskName(String taskName) throws Exception;
	
	//根据taskname查询task信息(动态代理对象会自动根据返回类型决定调用selectList/selectOne)
	public List<Task> findTaskByTaskNamelike(String taskName) throws Exception;
	 
	//新增task信息
	public void insertTask(Task task) throws Exception;
	
	//根据taskname删除task信息
	public void deleteTask(String taskName) throws Exception;
	
	//Task信息综合查询
	public List<TaskCustom> findTaskList(TaskVo taskVo) throws Exception;
	
	//Task信息综合查询记录数
	public int findTaskCount(TaskVo taskVo) throws Exception;
	
	//测试resultMap
	public  Task findTaskByTaskNameResultMap(String taskName) throws Exception;
	
}
