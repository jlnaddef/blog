package edu.ecm.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
   @RequestMapping("/hello")
   public String hello(Model model) {
      model.addAttribute("name", "Steven");
      
      return "hello";
   }
}
