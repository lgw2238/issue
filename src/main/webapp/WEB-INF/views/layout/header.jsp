<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
				<!-- Header -->
					<header id="header" class="alt">
						<a href="/" class="logo"><strong>ISSUE</strong> <span>By LGW</span></a>
						<nav>
							<a href="#menu">Menu</a>
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">
						<ul class="links">
							<li><a href="weather">Weather API</a></li>
							<li><a href="stock">Stock API</a></li>
							<li><a href="tourist">Tourist API</a></li>
							<li><a href="news">News API</a></li>
						</ul>
						<ul class="actions stacked">
							<li><a href="${pageContext.request.contextPath}/about" class="button primary fit">About Me</a></li>
							<li><a href="#" class="button fit">Log In</a></li>
						</ul>
					</nav>