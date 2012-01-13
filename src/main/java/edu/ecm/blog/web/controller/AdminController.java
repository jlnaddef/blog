package edu.ecm.blog.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ecm.blog.domain.Post;
import edu.ecm.blog.service.PostService;

@Controller
public class AdminController {

	@Inject
	private PostService postService;
	
	
	@RequestMapping("/admin/posts")
	public String posts(Model model) {
		model.addAttribute("posts", postService.find(0, 30));
		
		return "admin/posts";
	}
	
	@InitBinder
	public void binder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value = "/admin/post", method = RequestMethod.POST)
	public String post(@ModelAttribute("post") Post post, BindingResult bindingResult, Model model) {
		if (org.apache.commons.lang.StringUtils.isEmpty(post.getTitle())) {
		    bindingResult.rejectValue("title", "field.empty", "Le titre est obligatoire");

		    return "admin/form";
		}

		postService.save(post);

		return "redirect:/admin/posts";
	}
	

	@RequestMapping("/admin/form")
	public String post(Model model) {
		// on injecte un Post vierge dans le modèle
		model.addAttribute("post", new Post());
		
		return "admin/form";
	}
	
	@RequestMapping("/admin/post/{id}")
	public String post(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.findById(id));

		return "admin/post";
	}
	
	@RequestMapping("/admin/post/{id}/delete") 
	public String delete(@PathVariable Long id, Model model) {
		postService.delete(id);
		
		return "redirect:/admin/posts";
	}
	
	@RequestMapping("/admin/form/{id}")
	public String post2(@PathVariable Long id, Model model) {
	    // on injecte le post
	    model.addAttribute("post", postService.findById(id));

	    return "admin/form";
	}

	

}
