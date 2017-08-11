package com.pingan.pojo;

/**
 * Task POJO 
 * @author EX_WLJR_CHENZEHUA
 *
 */
public class Task {

	private String inputdate;
	
	private String targetname;
	
	private String taskname;
	
	private String targetdescribe;
	
	private String taskdescribe;
	
	private String begintime;
	
	private String endtime;
	
	private String status;
	
	private String dateflag;

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getTargetname() {
		return targetname;
	}

	public void setTargetname(String targetname) {
		this.targetname = targetname;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTargetdescribe() {
		return targetdescribe;
	}

	public void setTargetdescribe(String targetdescribe) {
		this.targetdescribe = targetdescribe;
	}

	public String getTaskdescribe() {
		return taskdescribe;
	}

	public void setTaskdescribe(String taskdescribe) {
		this.taskdescribe = taskdescribe;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateflag() {
		return dateflag;
	}

	public void setDateflag(String dateflag) {
		this.dateflag = dateflag;
	}

	@Override
	public String toString() {
		return "Task [inputdate=" + inputdate + ", targetname=" + targetname + ", taskname=" + taskname
				+ ", targetdescribe=" + targetdescribe + ", taskdescribe=" + taskdescribe + ", begintime=" + begintime
				+ ", endtime=" + endtime + ", status=" + status + ", dateflag=" + dateflag + "]";
	}
	
	
}
