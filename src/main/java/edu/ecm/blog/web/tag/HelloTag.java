package edu.ecm.blog.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {

	  private String name;

	  @Override
	  public void doTag() throws JspException, IOException {
	    getJspContext().getOut().print("Hello " + name + " from custom tag");
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	}