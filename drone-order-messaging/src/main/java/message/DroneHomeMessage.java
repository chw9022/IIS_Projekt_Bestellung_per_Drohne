// #######################################
// Author: Felix Ziegner
// #######################################
package message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "droneHomeMessage")
public class DroneHomeMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private int droneId;

	public DroneHomeMessage(int droneId) {
		super();
		this.droneId = droneId;
	}

	public int getDroneId() {
		return droneId;
	}

	public void setDroneId(int droneId) {
		this.droneId = droneId;
	}
}
