package stoll.quirin.shop;
//Author: Quirin Stoll
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * Servlet implementation class CreateOrder
 */
@WebServlet("/createorder")
public class CreateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    
	    String quantity = request.getParameter("quantity");
	    HttpSession session = request.getSession(); 
	    List<Order> ordersSession = (List<Order>) session.getAttribute("orders");
        List<Order> orders = new ArrayList<>();
        if(ordersSession != null){           
            orders.addAll(ordersSession);
        }
        
        if(request.getParameterMap().containsKey("completed")){
            int user  = Integer.valueOf(request.getParameter("user"));
            if(orders.size() > 0){
                sendOrder(orders, user);
            }
            session.invalidate();
            request.setAttribute("confirmed", "Bestellung wurde abgeschickt");
        }else{
            if(!quantity.isEmpty()){
                Order order = new Order();
                String[] aProduct = request.getParameter("product").split(";");
                order.setArticleId(aProduct[0]);
                order.setProduct(aProduct[1]);
                order.setAmount(Integer.valueOf(quantity));
                orders.add(order);
            }
            session.setAttribute("orders", orders);
            request.setAttribute("orders", orders);
        }
        // Forward to JSP
        final RequestDispatcher dispatcher = request.getRequestDispatcher("create_order_form.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject = "webshop_orders";
    public void sendOrder(List<Order> orders, int user){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection;
        try {
            connection = connectionFactory.createConnection();       
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(subject);
            MessageProducer producer = session.createProducer(destination);
            Random r = new Random();
            int number = r.nextInt(1000);
            String ordersMessage = "{\"messageName\" : \"orderReceivedMessage\",\"businessKey\" : \"order"+number+"\",\"processVariables\" : {\"user\": {\"value\":"+user+", \"type\": \"Integer\"}, \"product\":{\"value\":\""+orders.get(0).getProduct()+"\", \"type\": \"String\"},\"amount\":{\"value\":"+orders.get(0).getAmount()+", \"type\": \"Integer\"},\"article_id\":{\"value\":"+orders.get(0).getArticleId()+", \"type\": \"Integer\"}}}";
            TextMessage message = session.createTextMessage(ordersMessage);
            producer.send(message);
            connection.close();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
