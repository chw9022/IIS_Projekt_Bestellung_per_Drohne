package dronesimulation;
// #######################################
// Author: Felix Ziegner
// #######################################
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;

import custom.Position;
import event.DronePositionNotification;

public class DroneSimulation implements Runnable {
	private EPRuntime epRuntime;
	private int droneId;
	private List<Position> route;

	public DroneSimulation(EPServiceProvider epsServiceProvider, int droneId) {
		super();
		this.droneId = droneId;
		this.epRuntime = epsServiceProvider.getEPRuntime();
		this.initializeRoute();
	}

	private void initializeRoute() {
		this.route = new ArrayList<Position>();
		this.route.add(new Position(48.710860, 11.521270)); // base
		this.route.add(new Position(48.72, 11.50));
		this.route.add(new Position(48.73, 11.48));
		this.route.add(new Position(48.74, 11.46));
		this.route.add(new Position(48.75, 11.44));
		this.route.add(new Position(48.767110, 11.432440)); // destination
		this.route.add(new Position(48.75, 11.44));
		this.route.add(new Position(48.74, 11.46));
		this.route.add(new Position(48.73, 11.48));
		this.route.add(new Position(48.72, 11.50));
		this.route.add(new Position(48.710860, 11.521270)); // base
	}

	public void run() {
		for (Position position : this.route) {
			DronePositionNotification dronePositionNotification = new DronePositionNotification(droneId, new Date(),
					position);
			epRuntime.sendEvent(dronePositionNotification);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
