package iis.project.processengine.delegate;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import iis.project.jpa.entities.Order;
import iis.project.jpa.entities.OrderPosition;

public class CreateDummyDeliveryNote implements JavaDelegate {

    private static final String ORDER_VARIABLE = "order"; 
    private static final String DELIVERY_NOTE_VARIABLE = "deliveryNote";
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        
        Order order = (Order) execution.getVariable(ORDER_VARIABLE);

        String dummyDeliveryNote =  
                "\nAdresse: \n" + 
                order.getClient().getFirstname() + " " + order.getClient().getLastname() + "\n" +
                order.getClient().getStreet() + "\n" +
                order.getClient().getPlace() + "\n" +
                "\n" +
                "Bestellte Artikel: \n" + 
                getArticles(order) + 
                "\n" +
                "Gesamtgewicht der Ware: " + String.valueOf(getOverallWeightInKg(order)) + "kg";
        
        execution.setVariable(DELIVERY_NOTE_VARIABLE, dummyDeliveryNote);
        
        System.out.print(dummyDeliveryNote);
    }
    
    
    private String getArticles(Order order) {
        
        List<OrderPosition> orderPositions = order.getOrderPositions();
        String articles = "";
        
        for (OrderPosition orderPosition : orderPositions) {
            articles += String.valueOf(orderPosition.getAmount()) + " " + orderPosition.getArticle().getName() + "\n";
        }
        
        return articles;
    }
    
    
    private double getOverallWeightInKg(Order order) {
        
        List<OrderPosition> orderPositions = order.getOrderPositions();
        double overallWeightInKg = 0.0;
        
        for (OrderPosition orderPosition : orderPositions) {
            overallWeightInKg += orderPosition.getArticle().getWeightInKg();
        }
        
        return overallWeightInKg;
    }
}
