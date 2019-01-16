// #######################################
// Author: Felix Ziegner
// #######################################
package iis.project.jpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "orders_position")
@XmlRootElement(name = "orderposition")
public class OrderPosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "articleId")
	private Article article;
	@Column(name = "amount")
	private int amount;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId")
	private Order order;

	@XmlElement
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@XmlElement
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@XmlElement
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@XmlElement
	public int getId() {
		return id;
	}
}