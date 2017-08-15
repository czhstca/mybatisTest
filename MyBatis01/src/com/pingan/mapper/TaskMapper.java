package com.pingan.mapper;

import java.util.List;

import com.pingan.pojo.Task;

/**
 * mybatis��Mapper�ӿ�
 * @author EX_WLJR_CHENZEHUA
 *
 */
public interface TaskMapper {
	
	//Mapper�����淶:
	//ע�⣺ʹ��Mapper������ʱ���ӿ��з�����Ӧ�ú�Mapper.xml�����õ�statementidһ��!
	//Mapper�ӿ��з����Ĳ�������Ӧ�ú�xml��parameterTypeָ������һ��!
	//Mapper����еķ���ֵ����Ӧ�ú�xml��resultTypeָ������һ��!
	//ʹ��Mapper������ʱ��xml��namespaceӦ��ΪMapper�ӿ��ļ�ȫ·��!
	
	//����taskname��ѯ����task��Ϣ
	public Task findTaskByTaskName(String taskName) throws Exception;
	
	//����tasknameģ����ѯ���Task��Ϣ(�������������Ҫ���صĶ��������Զ�ѡ�����selectOne ����  selectList)
	public List<Task> findTaskByTaskNamelike(String taskName) throws Exception;
	 
	//���task��Ϣ
	public void insertTask(Task task) throws Exception;
	
	//����tasknameɾ��task��Ϣ
	public void deleteTask(String taskName) throws Exception;
	
}
