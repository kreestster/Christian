package servlet;

import java.io.Serializable;

public class Parameters implements Serializable {
	private java.util.Map<String, String> params = new java.util.HashMap<>(); 
	
	public void addParam(String key, String value) {
		this.params.put(key, value);
	}

	public String getParam(String key) {
		return this.params.get(key);
	}

}
