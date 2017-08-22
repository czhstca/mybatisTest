package com.pingan.vo;

import com.pingan.pojo.TaskCustom;

/**
 * Task对象的vo，用于复杂查询时必要的条件
 * @author EX_WLJR_CHENZEHUA
 *
 */
public class TaskVo {

	//在这里可以包装任何需要进行复杂查询的条件
	private TaskCustom taskCustom;

	public TaskCustom getTaskCustom() {
		return taskCustom;
	}

	public void setTaskCustom(TaskCustom taskCustom) {
		this.taskCustom = taskCustom;
	}
	
	//在这里通过组合的方式可以组合很多需要的类作为查询条件
}
