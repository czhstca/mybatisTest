package com.pingan.dao;

import com.pingan.pojo.Task;

/**
 * ��������dao
 * @author EX_WLJR_CHENZEHUA
 *
 */
public interface TaskDao {

	//����taskname��ѯtask��Ϣ
	public Task selectTaskByTaskName(String taskName) throws Exception;
	
	//���task��Ϣ
	public void insertTask(Task task) throws Exception;
	
	//����tasknameɾ��task��Ϣ
	public void deleteTask(String taskName) throws Exception;
}
