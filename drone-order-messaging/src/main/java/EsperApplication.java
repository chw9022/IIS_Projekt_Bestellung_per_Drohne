// #######################################
// Author: Felix Ziegner
// #######################################
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

import dronesimulation.DroneSimulationManager;
import event.DronePositionNotification;
import listener.DroneHomeListener;

public class EsperApplication implements Runnable {
	private EPServiceProvider epsServiceProvider;

	public static void main(String[] args) {
		EsperApplication esperApplication = new EsperApplication();
		esperApplication.run();
	}

	public void run() {
		epsServiceProvider = EPServiceProviderManager.getDefaultProvider();
		epsServiceProvider.getEPAdministrator().getConfiguration().addEventType(DronePositionNotification.class);
		DroneHomeListener droneHomeListener = new DroneHomeListener();
		EPStatement epsStatement = epsServiceProvider.getEPAdministrator().createEPL(droneHomeListener.getQuery());
		epsStatement.addListener(droneHomeListener);
		DroneSimulationManager droneSimulationManager = new DroneSimulationManager(epsServiceProvider);
		System.out.print("simulatormanager started");
		droneSimulationManager.run();
	
	}
}
