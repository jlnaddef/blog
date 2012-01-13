<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/css/style2.css" type="text/css"
	media="screen" charset="utf-8">
</head>
<body>
	<div id="header">
		<span class="title"><a href="/index">Mon blog</a></span>
	</div>

	<div id="post">
		<div class="post">

			
			<span class="date">${post.date }</span> - <span class="title">${post.title
				}</span>
			<p>${post.text}</p>
			<span class="tags">Tags : ${post.tags }</span> <span class="author">Auteur : ${post.author}</span>
			<br/>
			<br/>
			<span class="post"><a href="/admin/form/${post.id}"> Modifier </a></span>
		</div>
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