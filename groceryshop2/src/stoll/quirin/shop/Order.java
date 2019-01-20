package stoll.quirin.shop;
//Author: Quirin Stoll
public class Order {
    @Override
    public String toString() {
        return "{'articleId':" + articleId + ", 'amount':" + amount+"}";
    }
    private static final long serialVersionUID = 1L;
    private String articleId;
    private Integer amount;
    private String product;
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public String getArticleId() {
        return articleId;
    }
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Integer getAmount() {
        return this.amount;
    }
}
