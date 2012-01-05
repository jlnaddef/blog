package edu.ecm.blog.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.ecm.blog.Author;
import edu.ecm.blog.Post;

public class PostService {
	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Post post) {
		Session session = sessionFactory.openSession();

	    session.save(post);

	    session.close();
	}

	public void delete(Long id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete from Post where id=:id");
		query.setLong("id", id);
		query.executeUpdate();
		session.close();
	}

	public List<Post> find(int pageIndex, int pageSize) {
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Post.class);
		
		criteria.setFirstResult(pageIndex*pageSize);
		criteria.setMaxResults(pageSize);
		
		
		return criteria.list();
	}

	public int count() {
		Session session = sessionFactory.openSession();
		
		Long count = (Long) session.createQuery("select count(*) from Post").uniqueResult();
		
		
		session.close();
		
		return count.intValue();
		
	}

	
}
