// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.jpa.webservices;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import iis.project.jpa.services.ArticleService;

@WebService
public class UpdateStockAmount {
    
    @Inject
    ArticleService articleService;
    
    @WebMethod
    public synchronized void updateStockAmount(int articleId, int newStockAmount) {
        
        if (articleService.getStockAmount(articleId) > newStockAmount) {
            articleService.setStockAmount(articleId, newStockAmount);
        }
        else {
            System.err.println("ERROR: newStockAmount >= stockAmount");
        }
    }
}
