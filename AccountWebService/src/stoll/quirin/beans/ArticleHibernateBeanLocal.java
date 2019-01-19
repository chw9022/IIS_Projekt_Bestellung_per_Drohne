package stoll.quirin.beans;
//Author: Quirin Stoll
import javax.ejb.Local;

import stoll.quirin.model.Article;

@Local
public interface ArticleHibernateBeanLocal {
    public Article findArticle(int id);
}
