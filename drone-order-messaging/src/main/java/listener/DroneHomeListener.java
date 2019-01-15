// #######################################
// Author: Felix Ziegner
// #######################################
package listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import custom.JMSManager;
import message.DroneHomeMessage;

public class DroneHomeListener implements UpdateListener {

	public String getQuery() {
		return "select * from DronePositionNotification match_recognize (partition by droneId"
				+ " measures A as event1, B as event2 pattern (A B) define A as A.isHome = false,"
				+ " B as B.isHome = true)";
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		JMSManager jmsManager = new JMSManager();
		DroneHomeMessage dhm = new DroneHomeMessage(1);
		try {
			jmsManager.sendMessage(dhm, "messages-to-camunda");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
