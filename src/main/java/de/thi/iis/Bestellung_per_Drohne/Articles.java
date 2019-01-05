// #######################################
// Author: Felix Ziegner
// #######################################
package de.thi.iis.Bestellung_per_Drohne;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Articles {
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("GroceryShopPersistence");
	EntityManager entityManager = emFactory.createEntityManager();

	public void addArticle(Article article) {
		entityManager.persist(article);
	}

	public void deleteArticle(Article article) {
		entityManager.remove(article);
	}

	public Article findById(int articleId) {
		final Query query = entityManager.createQuery("SELECT a from Article as a WHERE a.id = :articleId");
		query.setParameter("articleId", articleId);
		List<Article> result = query.getResultList();
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

	public List<Article> findByName(String articleName) {
		final Query query = entityManager
				.createQuery("SELECT a from Article as a WHERE (0 < LOCATE(:articleName, a.name))");
		query.setParameter("articleName", articleName);
		return query.getResultList();
	}

	public List<Article> getArticles() throws Exception {
		Query query = entityManager.createQuery("SELECT a from Article as a");
		return query.getResultList();
	}
}