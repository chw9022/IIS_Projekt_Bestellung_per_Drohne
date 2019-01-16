// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.jpa.services;

import javax.ejb.Local;

@Local
public interface ArticleServiceLocal {
    
    // Getter
    int getStockAmount(int id);
    
    // Setter
    void setStockAmount(int id, int newStockAmount);
}
