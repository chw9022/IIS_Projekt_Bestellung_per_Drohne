// #######################################
// Author: Felix Ziegner
// #######################################
package event;

import java.io.Serializable;
import java.util.Date;

import custom.Position;

public class DronePositionNotification implements Serializable {

	private static final long serialVersionUID = 1L;

	private int droneId;
	private Date timeStamp;
	private Position position;
	private Boolean isHome;

	public DronePositionNotification(int droneId, Date timeStamp, Position position) {
		super();
		this.droneId = droneId;
		this.timeStamp = timeStamp;
		this.position = position;
		this.setIsHome(this.isHome());
		System.out.println(this.isHome());
	}

	public int getDroneId() {
		return droneId;
	}

	public void setDroneId(int droneId) {
		this.droneId = droneId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Boolean isHome() {
		if (this.position.getLatitude() == 48.710860 && this.position.getLongitude() == 11.521270) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean getIsHome() {
		return isHome;
	}

	public void setIsHome(Boolean isHome) {
		this.isHome = isHome;
	}

}
