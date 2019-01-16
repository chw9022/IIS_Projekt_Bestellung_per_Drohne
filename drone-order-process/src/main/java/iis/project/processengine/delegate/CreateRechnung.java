//Author: Alexander Perlatov
package iis.project.processengine.delegate;

import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

import iis.project.jpa.entities.Order;
import iis.project.jpa.entities.OrderPosition;

public class CreateRechnung implements JavaDelegate {

    private static String ORDER_VARIABLE = "order";

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Map<String, Object> map = execution.getVariables();
        Order order = (Order) map.get(ORDER_VARIABLE);

        double rabatt = (double) map.get("rabatt_prozent");
        double gesamtprice = Math.round((double) map.get("rabatt_price") * 100.0) / 100.0;
        double endprice = Math.round(rabatt * gesamtprice * 100.0) / 100.0;
        String clientName = order.getClient().getFirstname();
        String clientLastname = order.getClient().getLastname();
        String list = getArticlesList(order);

        String msg = "Sehr geehrte Kunde " + clientName + " " + clientLastname + "\n\nSie haben bestellt:\n" + list
                + "\nInsgesamt beträgt: " + gesamtprice + " EUR. " + "\n\nzu Bezahlen ist: " + endprice + " EUR. "
                + getRabattText(rabatt);

        VariableMap map2 = Variables.createVariables();
        map2.putValue("msg", msg);
        execution.setVariables(map2);

    }

    private String getArticlesList(Order order) {
        List<OrderPosition> articles = order.getOrderPositions();

        String List = "";

        for (OrderPosition orderPosition : articles) {
            List += ("\"" + String.valueOf(orderPosition.getArticle().getName()) + "\"," + " "
                    + String.valueOf(orderPosition.getAmount()) + " Stück je "
                    + String.valueOf(orderPosition.getArticle().getPrice()) + " EUR.\n");
        }

        return List;
    }

    private String getRabattText(double rabatt) {

        String rabattText = "";

        if (rabatt != 1) {
            rabatt = (1 - rabatt) * 100;
            int a = (int) Math.ceil(rabatt);
            rabattText = " (inkl. " + a + "% Rabatt)";
        } else
            rabattText = "";
        return rabattText;

    }
}
