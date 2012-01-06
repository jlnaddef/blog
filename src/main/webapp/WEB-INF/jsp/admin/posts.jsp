<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
        <link rel="stylesheet" href="/css/style.css" type="text/css" media="screen" charset="utf-8">
   </head>
   <body>
           <div id="header">
               <span class="title"><a href="/index">Mon blog</a></span>
           </div>
           
          
          
           
           <div id="posts">
           
           		<a href="/admin/form"> Nouveau </a> 
           		
           		</br>
           		</br>
           
           		<c:forEach var="post" items="${posts}">           		
	               <div class="post">
	                   <span class="title"><a href ="/admin/post/${post.id}">${post.title}</a></span>
	                   <span class="post"><a href="/admin/post/${post.id}/delete">Supprimer Post</a></span>
	               </div>
               </c:forEach>
           </div>
           
           <div id="right">
               <div class="tagcloud">
                   <span class="title">Les tags</span>
                   <ul>
                       
                   </ul>
               </div>
               
               <div class="latest">
                   <span class="title">Les billets récents</span>
                   <ul>
                       
                   </ul>
               </div>
           </div>
           
           
   </body>
</html>