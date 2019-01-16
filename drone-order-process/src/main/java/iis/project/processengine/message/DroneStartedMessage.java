// #######################################
// Author: Felix Ziegner
// #######################################
package iis.project.processengine.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "droneStartMessage")
public class DroneStartedMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private int droneId;

	public DroneStartedMessage() {
		super();
	}
	public DroneStartedMessage(int droneId) {
		super();
		this.droneId = droneId;
	}

	@XmlElement
	public int getDroneId() {
		return droneId;
	}

	public void setDroneId(int droneId) {
		this.droneId = droneId;
	}

}
