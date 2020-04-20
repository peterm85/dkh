package dkh.demo.geodeapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tracking implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer personId;
	private List<Date> logs;
	
	public Tracking(Integer personId, List<Date> logs) {
		super();
		this.personId = personId;
		this.logs = logs;
	}
	
	public Tracking(Integer personId) {
		super();
		this.personId = personId;
		this.logs = new ArrayList<>();
	}
	public void add(Date l) {
		this.logs.add(l);
	}
	
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public List<Date> getLogs() {
		return logs;
	}
	public void setLogs(List<Date> logs) {
		this.logs = logs;
	}
}
