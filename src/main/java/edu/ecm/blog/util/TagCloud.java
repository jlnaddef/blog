package edu.ecm.blog.util;

import java.util.ArrayList;
import java.util.List;

public class TagCloud {

	private List<String> tags = new ArrayList<String>();


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
	
	//public TagCloud top(int n) {
		
		
		
	//}
	
	
}
