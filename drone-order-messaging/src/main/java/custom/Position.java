// #######################################
// Author: Felix Ziegner
// #######################################
package custom;

import java.io.Serializable;

public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	private double latitude;
	private double longitude;

	public Position(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
