// #######################################
// Author: Felix Ziegner
// #######################################
package de.thi.iis.Bestellung_per_Drohne;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Archivable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	private List<OrderPosition> orderPositions = new ArrayList<OrderPosition>();
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "clientId")
	private Client client;
	@Column(name = "orderdate")
	private Date orderdate;

	public List<OrderPosition> getOrderPositions() {
		return orderPositions;
	}

	public void addOrderPosition(OrderPosition orderPosition) {
		this.orderPositions.add(orderPosition);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public int getId() {
		return id;
	}
}