package stoll.quirin.beans;
//Author: Quirin Stoll
import javax.ejb.Local;

import stoll.quirin.model.Client;

@Local
public interface ClientHibernateBeanLocal {
    public Client findClient(int id);
}
