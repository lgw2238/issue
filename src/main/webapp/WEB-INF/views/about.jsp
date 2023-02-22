<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<style>


.fullInfoDiv{
        width: 100%;
        height: 300px;
        border: 1px solid white;

}
.infoDivleft{
		width: 50%;
        float: left;
        box-sizing: border-box;      
		height:300px;
		border: 1px solid white;
		text-align: center;
}

.infoDivRight{
        width: 50%;
        float: right;
        box-sizing: border-box;        
        height:300px;
        border: 1px solid white;
        text-align: center;
}



</style>

<html>
	<head>
		<title>About Me</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/favicon.ico">
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
				<!-- Main -->
					<div id="main" class="alt">

						<!-- One -->
							<section id="one">
								<div class="inner">
									<header class="major">
										<h1><i class="fa-solid fa-user"></i>&nbsp;ABOUT ME</h1>										
									</header>
									<h2>Web Developer(Back End)</h2>
									<div class="fullInfoDiv">
									<%-- <span class="image main"><img src="${pageContext.request.contextPath}/images/pic11.jpg" alt="" /></span>	 --%>		
										<div class="infoDivleft" >
											<p></p>
											<h3><i class="fa-solid fa-signature"></i>&nbsp;Full Name : 임 건우</h3>	
											<h3><i class="fa-solid fa-cake-candles"></i>&nbsp;Birth: 1993.12.31</h3>	
											<h3><i class="fa-solid fa-school"></i>&nbsp;Education : 수원대학교 (동양어문학과)</h3>					
										</div>
										<div class="infoDivRight">
											<p></p>
											<h3><i class="fa-solid fa-phone"></i>&nbsp;Phone: 010 - 2041 - 2238</h3>	
											<h3><i class="fa-solid fa-envelope"></i>&nbsp;Email: lgw2236@gmail.com </h3>	
											<h3><i class="fa-brands fa-github"></i>&nbsp;<a href="https://github.com/lgw2238">Git : https://github.com/lgw2238</a></h3>		
										</div>	
									</div>
								</div>								
							</section>	
							<section id="two" class="spotlights">
							 	<div class="inner"> 
									<header class="major">
										<h1>SKILLS</h1>
									</header>	
									<div id="skillsDiv">
										<ul id="IDE">
											<h3><i class="fa-solid fa-list"></i>&nbsp;IDE, DB TOOL</h3>										
											<img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=for-the-badge&logo=Eclipse IDE&logoColor=white">	
											<img src="https://img.shields.io/badge/MobaXterm-000000?style=for-the-badge&logo=MobaXterm&logoColor=white">	
											<img src="https://img.shields.io/badge/Dbeaver-964b00?style=for-the-badge&logo=Dbeaver&logoColor=white">												
										</ul>
										<ul id="STACK">
											<h3><i class="fa-solid fa-list"></i>&nbsp;STACK</h3>
											<img src="https://img.shields.io/badge/Java-3776AB?style=for-the-badge&logo=Javascript&logoColor=white"> 
											<img src="https://img.shields.io/badge/Javascript-F7DF1E?style=for-the-badge&logo=Javascript&logoColor=white"> 
											<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white">	
											<img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white">	
											<img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white">	
											<img src="https://img.shields.io/badge/node.js-339933?style=for-the-badge&logo=node.js&logoColor=white">		
											<img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white">	
																																
										</ul>
										<ul id="db">
											<h3><i class="fa-solid fa-list"></i>&nbsp;DB</h3>
											<img src="https://img.shields.io/badge/Mysql-4479A1?style=for-the-badge&logo=Mysql&logoColor=white"> 
											<img src="https://img.shields.io/badge/MariaDb-4479A1?style=for-the-badge&logo=MariaDb&logoColor=white"> 
										</ul>
										<ul id="infra">
											<h3><i class="fa-solid fa-list"></i>&nbsp;INFRA</h3>
											<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white">
											<img src="https://img.shields.io/badge/GitLab-FC6D26?style=for-the-badge&logo=GitLab&logoColor=white">
											<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
											<img src="https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=Jenkins&logoColor=white">
											<img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=Redis&logoColor=white">
											<img src="https://img.shields.io/badge/Amazon AWS-232F3E?style=for-the-badge&logo=Amazon AWS&logoColor=white">
											<img src="https://img.shields.io/badge/FileZilla-BF0000?style=for-the-badge&logo=FileZilla&logoColor=white">																												
										</ul>									
									</div>
								</div>
							</section>
							<section id="three" class="spotlights">
								<div class="inner">
									<header class="major">
										<h1>Certificate</h1>
									</header>								
									<h3> SQLD | 취득일: 2021.12.17 </h3>
									<h3> 정보처리기사 필기  | 취득일 : 2022.03.05</h3>
								</div>	
							</section>
							
							<section id="four" class="spotlights">
								<div class="inner">
									<header class="major">
										<h1>Carrer</h1>
									</header>								
									<h2>현 이지에이스 재직 : 2021.06.07 ~ NOW	</h2>
								</div>	
							</section>
					</div>
				

				<!-- Footer -->
				<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
<!-- 					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon brands alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon brands alt fa-facebook-f"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon brands alt fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon brands alt fa-github"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon brands alt fa-linkedin-in"><span class="label">LinkedIn</span></a></li>
							</ul>
							<ul class="copyright">
								<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</footer>

			</div>

		Scripts
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
 -->
	</body>
</html>