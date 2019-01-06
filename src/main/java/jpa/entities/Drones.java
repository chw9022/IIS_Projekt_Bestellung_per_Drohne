// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Drones
 *
 */
@Entity
@Table(name = "drones")
public class Drones implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    @Enumerated(EnumType.ORDINAL)
    private DroneStatus status;

	public Drones() {
	}

	public int getId() {
		return this.id;
	}

    public DroneStatus getStatus() {
        return status;
    }

    public void setStatus(DroneStatus status) {
        this.status = status;
    }
}