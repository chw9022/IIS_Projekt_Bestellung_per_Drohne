package stoll.quirin.beans;
//Author: Quirin Stoll
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import stoll.quirin.model.Article;

/**
 * Session Bean implementation class ArticleHibernateBean
 */
@Stateless
@LocalBean
public class ArticleHibernateBean implements ArticleHibernateBeanLocal {
    @PersistenceContext
    EntityManager em;
    /**
     * Default constructor. 
     */
    public ArticleHibernateBean() {
        // TODO Auto-generated constructor stub
    }
    
    public Article findArticle(int id){
        return em.find(Article.class, id);
    }
}
