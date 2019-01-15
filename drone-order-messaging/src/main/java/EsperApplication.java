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
		EsperApplication esperManager = new EsperApplication();
		esperManager.run();
	}

	public void run() {
		epsServiceProvider = EPServiceProviderManager.getDefaultProvider();
		epsServiceProvider.getEPAdministrator().getConfiguration().addEventType(DronePositionNotification.class);
		DroneHomeListener droneHomeListener = new DroneHomeListener();
		EPStatement epsStatement = epsServiceProvider.getEPAdministrator().createEPL(droneHomeListener.getQuery());
		epsStatement.addListener(droneHomeListener);
		DroneSimulationManager droneSimulationManager = new DroneSimulationManager(epsServiceProvider);
		droneSimulationManager.run();
	}
}
