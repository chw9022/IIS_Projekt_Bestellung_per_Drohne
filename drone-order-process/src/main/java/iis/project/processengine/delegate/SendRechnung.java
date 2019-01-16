//Author: Alexander Perlatov
package iis.project.processengine.delegate;

import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import iis.project.jms.JMSManager;

public class SendRechnung implements JavaDelegate {

    public static String QUEUE_KUNDE = "kunde";

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Ich bin der Sender!");

        Map<String, Object> SendOrder = execution.getVariables();
        String msg = (String) SendOrder.get("msg");

        JMSManager jmsKunde = new JMSManager();
        jmsKunde.sendMessage(msg, QUEUE_KUNDE);

    }

}
