// #######################################
// Author: Felix Ziegner
// #######################################
package processengine.adapter;

import java.util.HashMap;
import java.util.Map;

public class CamundaMessage {

	private String messageName;
	private Map<String, Map<String, String>> correlationKeys = new HashMap<String, Map<String, String>>();

	public CamundaMessage() {
		super();
	}

	public CamundaMessage(String messageName) {
		super();
		this.messageName = messageName;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public Map<String, Map<String, String>> getCorrelationKeys() {
		return correlationKeys;
	}

	public void addCorrelationKey(CamundaCorrelationKey correlationKey) {
		Map<String, String> canumdaVariable = new HashMap<String, String>();
		canumdaVariable.put("value", correlationKey.getValue());
		canumdaVariable.put("type", correlationKey.getType());
		this.correlationKeys.put(correlationKey.getName(), canumdaVariable);
	}
}
