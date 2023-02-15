<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Issue</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" /> 
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<a href="/" class="logo"><strong>ISSUE</strong> <span>By LGW</span></a>
						<nav>
							<a href="#menu">Menu</a>
						</nav>
					</header>

					<nav id="menu">
						<ul class="links">
							<li><a href="api/weather">Weather API</a></li>
							<li><a href="api/stock">Stock API</a></li>
							<li><a href="api/tourist">Tourist API</a></li>
							<li><a href="api/news">News API</a></li>
						</ul>
						<ul class="actions stacked">
							<li><a href="about" class="button primary fit">About Me</a></li>
							<!-- <li><a href="#" class="button fit">Log In</a></li> -->
						</ul>
					</nav> 

				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
						<span class="image">
							<img src="${pageContext.request.contextPath}/images/space.jpg" alt="" />
						</span>
							<header class="major">
								<h1>Hi!, Welcome Snack Issue</h1>
							</header>
							<div class="content">
								<p>What kind of issues are there today?</p>
								<ul class="actions">
									<li><a href="#one" class="button next scrolly">Get Started</a></li>
								</ul>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one" class="tiles">
								<article>
									<span class="image">
										<img src="${pageContext.request.contextPath}/images/test.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="api/weather" class="link">Weather API</a></h3>
										<p></p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="${pageContext.request.contextPath}/images/stock.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="api/stock" class="link"></a>Stock API</h3>
										<p></p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="${pageContext.request.contextPath}/images/tourist.png" alt="" />
									</span>
									<header class="major">
										<h3><a href="api/tourist" class="link">Tourist API</a></h3>
										<p></p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="${pageContext.request.contextPath}/images/news.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="api/news" class="link">News API</a></h3>
										<p></p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="${pageContext.request.contextPath}/images/velog_logo.png" alt="" />
									</span>
									<header class="major">
										<h3><a href="https://velog.io/@lgw2236" class="link">Velog</a></h3>
										<p>My velog</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="${pageContext.request.contextPath}/images/aboutme.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="about" class="link">About Me</a></h3>
										<p>LIM GEON WOO</p>
									</header>
								</article>
							</section>

						<!-- Two -->
							<section id="two">
							<!-- 	<div class="inner">
									<header class="major">
										<h2>Massa libero</h2>
									</header>
									<p>Nullam et orci eu lorem consequat tincidunt vivamus et sagittis libero. Mauris aliquet magna magna sed nunc rhoncus pharetra. Pellentesque condimentum sem. In efficitur ligula tate urna. Maecenas laoreet massa vel lacinia pellentesque lorem ipsum dolor. Nullam et orci eu lorem consequat tincidunt. Vivamus et sagittis libero. Mauris aliquet magna magna sed nunc rhoncus amet pharetra et feugiat tempus.</p>
									<ul class="actions">
										<li><a href="landing.html" class="button next">Get Started</a></li>
									</ul>
								</div> -->
							</section>

					</div>

				<!-- Contact -->
<!-- 					<section id="contact">
						<div class="inner">
							<section>
								<form method="post" action="#">
									<div class="fields">
										<div class="field half">
											<label for="name">Name</label>
											<input type="text" name="name" id="name" />
										</div>
										<div class="field half">
											<label for="email">Email</label>
											<input type="text" name="email" id="email" />
										</div>
										<div class="field">
											<label for="message">Message</label>
											<textarea name="message" id="message" rows="6"></textarea>
										</div>
									</div>
									<ul class="actions">
										<li><input type="submit" value="Send Message" class="primary" /></li>
										<li><input type="reset" value="Clear" /></li>
									</ul>
								</form>
							</section>
							<section class="split">
								<section>
									<div class="contact-method">
										<span class="icon solid alt fa-envelope"></span>
										<h3>Mail</h3>
											<span>lgw2236@gmail.com</span>
										<h1></h1><br />			
									</div>
								</section>	
								<section>
									<div class="contact-method">	
										<span class="icon brands alt fa-github"></span>
										<h3>Git</h3>
											<a href="https://github.com/lgw2238">https://github.com/lgw2238</a>		
									</div>								
								</section>
								<section>
									<div class="contact-method">
										<span class="icon solid alt fa-phone"></span>
										<h3>Phone</h3>
										<span>(010) 2041-2238 </span>
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon solid alt fa-home"></span>
										<h3>Address</h3>
										<span>1234 Somewhere Road #5432<br />
										Nashville, TN 00000<br />
										United States of America<br />
										</span>
									</div>
								</section>
							</section>
						</div>
					</section> -->

				<!-- Footer -->
<%-- 					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon brands alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon brands alt fa-facebook-f"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon brands alt fa-instagram"><span class="label">Instagram</span></a></li>
								<!-- <li><a href="#" class="icon brands alt fa-github"><span class="label">GitHub</span></a></li> -->
								<li><a href="#" class="icon brands alt fa-linkedin-in"><span class="label">LinkedIn</span></a></li>
							</ul>
							<ul class="copyright">
								<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script> --%>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
	</body>
</html>