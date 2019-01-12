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
public class Drone implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private DroneStatus status;

	public Drone() {
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