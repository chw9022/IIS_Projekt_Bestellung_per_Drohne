package iis.project.jpa.services;

import java.io.Serializable;
import java.util.Calendar;

import iis.project.jpa.entities.Order;

public class DroneArrivalTimeMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	Order order;
	Calendar timeOfArrival;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Calendar getTtimeOfArrival() {
		return timeOfArrival;
	}

	public void setTtimeOfArrival(Calendar timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}
}
