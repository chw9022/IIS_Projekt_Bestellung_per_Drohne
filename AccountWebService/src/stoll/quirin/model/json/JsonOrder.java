package stoll.quirin.model.json;
//Author: Quirin Stoll
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class JsonOrder {
    private int client;
    private List<JSONOrdersPosition> ordersPositions;

    @Override
    public String toString() {
        return "JsonOrder [client=" + client + ", ordersPositions=" + ordersPositions + "]";
    }

    public List<JSONOrdersPosition> getOrdersPositions() {
        return ordersPositions;
    }

    public void setOrdersPositions(List<JSONOrdersPosition> ordersPositions) {
        this.ordersPositions = ordersPositions;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }
}
