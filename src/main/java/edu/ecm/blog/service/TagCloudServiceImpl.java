package edu.ecm.blog.service;

import java.util.List;
import javax.inject.Inject;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.ecm.blog.domain.Post;
import edu.ecm.blog.util.TagCloud;

@Service
public class TagCloudServiceImpl implements TagCloudService {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public TagCloud buildTagCloud() {
        Session session = sessionFactory.getCurrentSession();

        TagCloud tagCloud = new TagCloud();

        @SuppressWarnings("unchecked")
        List<Post> posts = session.createCriteria(Post.class).list();

        for (Post post : posts) {
            tagCloud.add(StringUtils.split(post.getTags(), ","));
        }

        return tagCloud;
    }

}