package edu.ecm.blog.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tagCloud")
public class TagCloud {

	private List<String> tags = new ArrayList<String>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
	  return id;
	}

	public void setId(Long id) {
	  this.id = id;
	}


	public int size() {
		return tags.size();
	}

	public void add(String... tags) {
		if (tags == null) {
			return;
		}
		for (String tag : tags) {
			if ((this.tags.contains(tag) == false) && (tag != null) && (tag !="")) {
				this.tags.add(tag);
			}
		}
	}
	
	public boolean contains(String string) {
		return this.tags.contains(string);
	}
	
	
	public List top(int n) {
		
		if (n < 0) {
			return tags.subList(0, 0);
		}
		
		else if (tags.size() <= n) {
			return tags;
		}
		
		else return tags.subList(0, n);
	}
	
	
	public void shuffle() {
		Collections.shuffle(tags);
	}
	
	
}
