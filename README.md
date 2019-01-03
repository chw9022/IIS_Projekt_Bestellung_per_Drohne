# IIS Projekt Bestellung per Drohne

## Configuration of database connection

- create database and tables
- start wildfly server
- goto http://localhost:9990/console/App.html
- goto Configuration -> Subsystems -> Datasources -> NON-XA
- press "ADD" button
- choose "MySQL Datasource"
- configure as following:
  ```
  Name: MySqlGroceryShop
  JNDI Name: java:jboss/datasources/groceryshop
  connection url: jdbc:mysql://localhost:3306/groceryshop
  ```
- select driver
  ![MariaDB Driver](https://i.imgur.com/rR4iW4w.png)
- check config
  ![MariaDB Config](https://i.imgur.com/6o9Uu45.png)

### Example code

... for inserting an article into DB

``` Java
package de.thi.iis.Bestellung_per_Drohne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GroceryShopPersistence {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("GroceryShopPersistence");
		EntityManager entityManager = emFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Article article1 = new Article();
		article1.setName("Schokolade");
		article1.setWeight(8.2);
		article1.setPrice(5.1);
		article1.setAmount(2);
		entityManager.persist(article1);
		entityManager.getTransaction().commit();
		entityManager.clear();
	}
}
```