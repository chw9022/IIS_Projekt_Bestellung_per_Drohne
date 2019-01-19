// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.processengine.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "droneLandedMessage")
public class DroneLandedMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private int droneId;

    public DroneLandedMessage() {
        super();
    }
    
    public DroneLandedMessage(int droneId) {
        super();
        this.droneId = droneId;
    }

    @XmlElement
    public int getDroneId() {
        return droneId;
    }

    public void setDroneId(int droneId) {
        this.droneId = droneId;
    }
}
