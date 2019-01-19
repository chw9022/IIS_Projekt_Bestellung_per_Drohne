// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Drone
 *
 */
@Entity
@Table(name = "drone")
public class Drone implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

    @Column(name = "available")
    private boolean available;

	public Drone() {
	}

	public int getId() {
		return id;
	}

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
