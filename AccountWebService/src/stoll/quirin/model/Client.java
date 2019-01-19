package stoll.quirin.model;
//Author: Quirin Stoll
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the clients database table.
 * 
 */
@Entity
@Table(name="clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String firstname;

	private String lastname;

	private String place;

	private String street;
	
	//bi-directional many-to-one association to Order
	/*@OneToMany(mappedBy="client")
	private List<Order> orders;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="client",fetch = FetchType.EAGER)
	private List<Bill> bills;*/

	//bi-directional many-to-one association to Clienttype
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="clienttype", referencedColumnName="id")
	private Clienttype clienttypeBean;

	public Client() {
	}

	public String getFirstname() {
		return this.firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setFirstname(String firstname) {
    	this.firstname = firstname;
    }

    public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	/*public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setClient(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setClient(null);

		return order;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setClient(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setClient(null);

		return bill;
	}*/

	public Clienttype getClienttypeBean() {
		return this.clienttypeBean;
	}

	public void setClienttypeBean(Clienttype clienttypeBean) {
		this.clienttypeBean = clienttypeBean;
	}
}