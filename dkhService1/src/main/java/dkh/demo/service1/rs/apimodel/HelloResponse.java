package dkh.demo.service1.rs.apimodel;

import java.io.Serializable;

public class HelloResponse implements Serializable{

	private static final long serialVersionUID = -8304036209854980974L;
	private String message;

	public HelloResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
