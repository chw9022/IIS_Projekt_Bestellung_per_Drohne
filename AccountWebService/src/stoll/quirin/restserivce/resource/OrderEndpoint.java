package stoll.quirin.restserivce.resource;
//Author: Quirin Stoll
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import stoll.quirin.beans.ArticleHibernateBeanLocal;
import stoll.quirin.beans.ClientHibernateBeanLocal;
import stoll.quirin.beans.OrderHibernateBeanLocal;
import stoll.quirin.model.Client;
import stoll.quirin.model.Order;
import stoll.quirin.model.OrdersPosition;
import stoll.quirin.model.json.JSONOrdersPosition;
import stoll.quirin.model.json.JsonOrder;

@RequestScoped
@Path("/orders")
@Produces({ "application/json" })
@Consumes({ "application/xml", "application/json" })
public class OrderEndpoint {
    @EJB
    OrderHibernateBeanLocal accountBeanLocal;
    @Inject
    ArticleHibernateBeanLocal articleHibernateBean;
    @Inject
    ClientHibernateBeanLocal clientHibernateBean;
    @POST
    @Path("/createorder")
    public Response create(final JsonOrder jsonOrder) {
        Order order = new Order();
        order.setOrderdate(new Date());
        List<OrdersPosition> ordersPositions  = new ArrayList<>();
        for(JSONOrdersPosition jsonOp:jsonOrder.getOrdersPositions()){;
            OrdersPosition op = new OrdersPosition();
            op.setArticle(articleHibernateBean.findArticle(jsonOp.getArticleId()));
            op.setAmount(jsonOp.getAmount());
            op.setOrder(order);
            ordersPositions.add(op);
        }
        order.setOrdersPositions(ordersPositions);
        Client c = clientHibernateBean.findClient(jsonOrder.getClient());
        order.setClient(c);       
        accountBeanLocal.insertOrder(order);
        //return Response.ok(order).build();
        return Response.ok("hhhuse").build();
    }
    
    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") final int id) {
        accountBeanLocal.deleteOrder(accountBeanLocal.findOrder(id));
        return Response.noContent().build();
    }
}
