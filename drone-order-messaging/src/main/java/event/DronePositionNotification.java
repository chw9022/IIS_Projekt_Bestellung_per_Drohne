// #######################################
// Author: Felix Ziegner
// #######################################
package event;

import java.io.Serializable;

import custom.Position;

public class DronePositionNotification implements Serializable {

	private static final long serialVersionUID = 1L;

	private int droneId;
	private Position position;
	private Boolean isHome;

	public DronePositionNotification(int droneId, Position position) {
		super();
		this.droneId = droneId;
		this.position = position;
		this.setIsHome(this.isHome());
	}

	public int getDroneId() {
		return droneId;
	}

	public void setDroneId(int droneId) {
		this.droneId = droneId;
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

	@Override
	public String toString() {
		return "DronePositionNotification [droneId=" + droneId + ", position=" + position + ", isHome=" + isHome + "]";
	}
}
