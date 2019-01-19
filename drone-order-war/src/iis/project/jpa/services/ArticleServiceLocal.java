// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.jpa.services;

import javax.ejb.Local;

@Local
public interface ArticleServiceLocal {
    int getStockAmount(int id);
    void setStockAmount(int id, int newStockAmount);
}
