package edu.ecm.blog.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.ecm.blog.domain.Post;

public class PostService {

	@Inject
	private SessionFactory sessionFactory;

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

		criteria.setFirstResult(pageIndex * pageSize);
		criteria.setMaxResults(pageSize);

		List<Post> posts = criteria.list();
		
		session.close();
		
		return posts;
	}

	public int count() {
		Session session = sessionFactory.openSession();

		Long count = (Long) session.createQuery("select count(*) from Post")
				.uniqueResult();

		session.close();

		return count.intValue();

	}

	

}
