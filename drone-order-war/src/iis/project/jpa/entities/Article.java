// #######################################
// Author: Felix Ziegner
// #######################################
package iis.project.jpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "articles")
@XmlRootElement(name = "article")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "weightInKg")
	private double weightInKg;

	@Column(name = "price")
	private double price;

	@Column(name = "stockAmount")
	private int stockAmount;

	@XmlElement
	public int getId() {
		return id;
	}
	
    public void setId(int id) {
        this.id = id;
    }

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public double getweightInKg() {
		return weightInKg;
	}

	public void setweightInKg(double weightInKg) {
		this.weightInKg = weightInKg;
	}

	@XmlElement
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@XmlElement
	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}
}