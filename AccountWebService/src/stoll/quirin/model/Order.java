package stoll.quirin.model;
//Author: Quirin Stoll
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	

	@Temporal(TemporalType.DATE)
	private Date orderdate;


	//bi-directional many-to-one association to OrdersPosition
	@OneToMany(mappedBy="order", cascade=CascadeType.PERSIST)
	private List<OrdersPosition> ordersPositions;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="clientId", referencedColumnName="id")
	private Client client;

	public Order() {
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public List<OrdersPosition> getOrdersPositions() {
		return this.ordersPositions;
	}

	public void setOrdersPositions(List<OrdersPosition> ordersPositions) {
		this.ordersPositions = ordersPositions;
	}

	public OrdersPosition addOrdersPosition(OrdersPosition ordersPosition) {
		getOrdersPositions().add(ordersPosition);
		ordersPosition.setOrder(this);

		return ordersPosition;
	}

	public OrdersPosition removeOrdersPosition(OrdersPosition ordersPosition) {
		getOrdersPositions().remove(ordersPosition);
		ordersPosition.setOrder(null);

		return ordersPosition;
	}

	public Client getClient() {
		return this.client;
	}

	@Override
    public String toString() {
        return "Order [id=" + id + ", orderdate=" + orderdate + ", ordersPositions=" + ordersPositions + ", client="
                + client + "]";
    }

    public void setClient(Client client) {
		this.client = client;
	}

}