// #######################################
// Author: Felix Ziegner
// #######################################
package iis.project.jpa.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import iis.project.jpa.entities.Article;

public class Articles {
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Bestellung_per_Drohne");
	EntityManager entityManager = emFactory.createEntityManager();

	public void addArticle(Article article) {
		entityManager.persist(article);
	}

	public void deleteArticle(Article article) {
		entityManager.remove(article);
	}

	public Article findById(int articleId) {
		return entityManager.find(Article.class, articleId);
	}

	public List<Article> findByName(String articleName) {
		final Query query = entityManager
				.createQuery("SELECT a from Article as a WHERE (0 < LOCATE(:articleName, a.name))");
		query.setParameter("articleName", articleName);
		return query.getResultList();
	}

	public List<Article> getArticles() {
		Query query = entityManager.createQuery("SELECT a from Article as a");
		return query.getResultList();
	}
}