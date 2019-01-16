// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.jpa.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iis.project.jpa.entities.Article;

/**
 * Session Bean implementation class ArticleService
 */
@Stateless
@LocalBean
public class ArticleService implements ArticleServiceLocal {
    
    @PersistenceContext
    EntityManager em;
    
    @Override
	public int getStockAmount(int id) {
		return em.find(Article.class, id).getStockAmount();
	}
	
    @Override
	public void setStockAmount(int id, int newStockAmount) {
	    em.find(Article.class, id).setStockAmount(newStockAmount);
	}

}