package edu.ecm.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ecm.blog.domain.Post;

@Service
public interface PostService {

	public void save(Post post);

	public void delete(Long id);

	public List<Post> find(int pageIndex, int pageSize);

	public int count();

	public Post findBySlug(String slug);
	
	public Post findById(Long id);

}