package stoll.quirin.model;
//Author: Quirin Stoll
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bills database table.
 * 
 */
@Entity
@Table(name="bills")
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Temporal(TemporalType.DATE)
	private Date billdate;

	//bi-directional many-to-one association to BillsPosition
	@OneToMany(mappedBy="bill")
	private List<BillsPosition> billsPositions;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="clientId", referencedColumnName="id", nullable=true)
	private Client client;

	public Bill() {
	}

	public Date getBilldate() {
		return this.billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public List<BillsPosition> getBillsPositions() {
		return this.billsPositions;
	}

	public void setBillsPositions(List<BillsPosition> billsPositions) {
		this.billsPositions = billsPositions;
	}

	public BillsPosition addBillsPosition(BillsPosition billsPosition) {
		getBillsPositions().add(billsPosition);
		billsPosition.setBill(this);

		return billsPosition;
	}

	public BillsPosition removeBillsPosition(BillsPosition billsPosition) {
		getBillsPositions().remove(billsPosition);
		billsPosition.setBill(null);

		return billsPosition;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}