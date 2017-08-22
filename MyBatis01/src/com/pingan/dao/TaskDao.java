package com.pingan.dao;

import com.pingan.pojo.Task;

/**
 * Taskdao
 * @author EX_WLJR_CHENZEHUA
 *
 */
public interface TaskDao {

	//根据taskname查询Task信息
	public Task selectTaskByTaskName(String taskName) throws Exception;
	
	//新增task
	public void insertTask(Task task) throws Exception;
	
	//根据taskname删除Task信息
	public void deleteTask(String taskName) throws Exception;
}
