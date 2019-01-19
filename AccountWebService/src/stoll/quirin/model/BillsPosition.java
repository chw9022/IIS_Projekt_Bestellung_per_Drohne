package stoll.quirin.model;
//Author: Quirin Stoll
import java.io.Serializable;
import javax.persistence.*;

import stoll.quirin.model.Article;


/**
 * The persistent class for the bills_position database table.
 * 
 */
@Entity
@Table(name="bills_position")
@NamedQuery(name="BillsPosition.findAll", query="SELECT b FROM BillsPosition b")
public class BillsPosition implements Serializable {
	private static final long serialVersionUID = 1L;

	private int amount;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    //bi-directional many-to-one association to Article
    @ManyToOne
    @JoinColumn(name="articleId", referencedColumnName="id")
    private Article article;
	//bi-directional many-to-one association to Bill
	@ManyToOne
	@JoinColumn(name="billId", referencedColumnName="id")
	private Bill bill;

	public BillsPosition() {
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

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}