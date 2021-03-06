// #######################################
// Author: Felix Ziegner
// #######################################
package iis.project.processengine.message;

public class CamundaCorrelationKey {
	private String name;
	private String value;
	private String type;

	public CamundaCorrelationKey(String name, String value, String type) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
