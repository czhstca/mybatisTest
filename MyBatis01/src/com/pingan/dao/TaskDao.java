package com.pingan.dao;

import com.pingan.pojo.Task;

/**
 * 任务管理的dao
 * @author EX_WLJR_CHENZEHUA
 *
 */
public interface TaskDao {

	//根据taskname查询task信息
	public Task selectTaskByTaskName(String taskName) throws Exception;
	
	//添加task信息
	public void insertTask(Task task) throws Exception;
	
	//根据taskname删除task信息
	public void deleteTask(String taskName) throws Exception;
}
