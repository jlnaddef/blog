package edu.ecm.blog.service;

import javax.inject.Inject;
import junit.framework.Assert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import edu.ecm.blog.domain.Post;
import edu.ecm.blog.util.TagCloud;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TagCloudServiceTest {

    @Inject
    private SessionFactory sessionFactory;

    @Inject
    private TagCloudService tagCloudService;

    @After
    public void cleanDb() {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from Post").executeUpdate();

        transaction.commit();

        session.close();
    }

    @Test
    public void buildTagCloud() {
        saveSomePosts();

        TagCloud tagCloud = tagCloudService.buildTagCloud();

        Assert.assertEquals(5, tagCloud.size());
        Assert.assertTrue(tagCloud.contains("java"));
        Assert.assertTrue(tagCloud.contains("python"));
        Assert.assertTrue(tagCloud.contains("nodejs"));
    }

    private void saveSomePosts() {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(buildPost("java,cobol"));
        session.save(buildPost("java,python"));
        session.save(buildPost("ruby,python"));
        session.save(buildPost("nodejs"));

        transaction.commit();

        session.close();
    }

    private Post buildPost(String tags) {
        Post post = new Post();

        post.setTitle("test title");
        post.setTags(tags);

        return post;
    }
}