package stoll.quirin.model;
//Author: Quirin Stoll
import java.io.Serializable;
import javax.persistence.*;

import stoll.quirin.model.Article;


/**
 * The persistent class for the orders_position database table.
 * 
 */
@Entity
@Table(name="orders_position")
@NamedQuery(name="OrdersPosition.findAll", query="SELECT o FROM OrdersPosition o")
public class OrdersPosition implements Serializable {
	private static final long serialVersionUID = 1L;

	private int amount;

	//bi-directional many-to-one association to Article
    @ManyToOne
    @JoinColumn(name="articleId", referencedColumnName="id")
    private Article article;
    
	public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderId", referencedColumnName="id")
	private Order order;

	public OrdersPosition() {
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}