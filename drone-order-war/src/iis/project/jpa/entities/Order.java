// #######################################
// Author: Felix Ziegner
// #######################################
package iis.project.jpa.entities;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "orders")
@XmlRootElement(name = "order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	private List<OrderPosition> orderPositions = new ArrayList<OrderPosition>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientId")
	private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "droneId")
	private Drone drone;
	
	@Column(name = "orderdate")
	private Date orderdate;
	
	@Column(name = "closed_at")
	private Date closed_at;

	@XmlElement
	public int getId() {
		return id;
	}

	@XmlElement
	public List<OrderPosition> getOrderPositions() {
		return orderPositions;
	}

	public void addOrderPosition(OrderPosition orderPosition) {
		this.orderPositions.add(orderPosition);
	}

	@XmlElement
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@XmlElement
	public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    @XmlElement
	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	@XmlElement
	public Date getClosed_at() {
		return closed_at;
	}

	public void setClosed_at(Date closed_at) {
		this.closed_at = closed_at;
	}

	public void closeOrder() {
		if (this.closed_at == null) {
			this.closed_at = new Date();
		}
	}
}