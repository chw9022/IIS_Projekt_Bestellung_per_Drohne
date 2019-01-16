package iis.project.processengine.message;

import java.io.Serializable;
import java.util.Calendar;

public class DroneArrivalTimeMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer order;
	String timeOfArrival;

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getTtimeOfArrival() {
		return timeOfArrival;
	}

	public void setTtimeOfArrival(Calendar timeOfArrival) {
		this.timeOfArrival = timeOfArrival.toString();
	}
}
