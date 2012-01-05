package edu.ecm.util.hibernate;

import java.util.List;

import junit.framework.Assert;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ecm.blog.Author;
import edu.ecm.blog.Post;



public class HibernateTest {
	
	private SessionFactory sessionFactory;
	
	@Before
	public void createSessionFactory() {
	   Configuration configuration = new Configuration();
	   
	   
	   configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
	   configuration.setProperty("hibernate.connection.url", "jdbc:derby:target/testdb;create=true");
	   configuration.setProperty("hibernate.connection.driver_class", "org.apache.derby.jdbc.EmbeddedDriver");
	   configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

	   configuration.addAnnotatedClass(Author.class);
	   configuration.addAnnotatedClass(Post.class);
	   
	   sessionFactory = configuration.buildSessionFactory();
	}
	
	@Test
	public void saveAuthor() {
	    Author author = new Author();

	    author.setName("Harpo Marx");
	    author.setEmail("harpo.marx@gmail.com");

	    
		Session session = sessionFactory.openSession();

	    session.save(author);

	    session.close();
	}
	
	@Test
	public void findAuthor() {
		saveAuthor();
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Author where name = :name");
		
		query.setString("name", "Harpo Marx");
		
		List authors = query.list();
		
		session.close();
		
		Assert.assertEquals(1, authors.size());
		Assert.assertEquals("Harpo Marx", ((Author) authors.get(0)).getName());
	}
	
	
	
	
	@Test
	public void findAuthorCriteria() {
	    saveAuthor();

	    Session session = sessionFactory.openSession();

	    Criteria criteria = session.createCriteria(Author.class);

	    criteria.add(Restrictions.eq("name", "Harpo Marx"));

	    List authors = criteria.list();

	    session.close();

	    Assert.assertEquals(1, authors.size());
	    Assert.assertEquals("Harpo Marx", ((Author) authors.get(0)).getName());
	}
	
	@After
	public void cleanDb() {
	    Session session = sessionFactory.openSession();

	    Transaction transaction = session.beginTransaction();

	    session.createQuery("delete from Author").executeUpdate();

	    transaction.commit();

	    session.close();

	    sessionFactory.close();
	}

}
