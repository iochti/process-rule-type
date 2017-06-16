package iochti.processRuleType.dto;

import java.util.Properties;

public class ProcessRuleTypeDTO {
	
	private String id;
	
	private String name;
	
	private Properties parameters;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Properties getParameters() {
		return parameters;
	}

	public void setParameters(Properties parameters) {
		this.parameters = parameters;
	}
}
