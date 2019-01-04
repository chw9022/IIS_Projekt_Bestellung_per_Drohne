// #######################################
// Author: Felix Ziegner
// #######################################
package de.thi.iis.Bestellung_per_Drohne;

import java.util.Date;
import java.util.List;

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
	@OneToMany(mappedBy = "order")
	private List<OrderPosition> orderPositions;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientId")
	private Client client;
	@Column(name = "orderdate")
	private Date orderdate;
}