package Entites;

public class MessageObject extends AbstractEntity {

	private Object obj;
	private String task;
	private String mess;

	public MessageObject(Object obj1, String Task1) {
		
		obj = obj1;
		task = Task1;
		mess = "";
	}

	/***************************************** Getters and Setters ********************************/

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Object getObject() {
		return obj;
	}

	public void setObject(Object obj1) {
		this.obj = obj1;
	}
}