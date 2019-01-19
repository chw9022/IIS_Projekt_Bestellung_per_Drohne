package stoll.quirin.model;
//Author: Quirin Stoll
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the clienttype database table.
 * 
 */
@Entity
@Table(name="clienttype")
@NamedQuery(name="Clienttype.findAll", query="SELECT c FROM Clienttype c")
public class Clienttype implements Serializable {
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

    private String name;

	public Clienttype() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}