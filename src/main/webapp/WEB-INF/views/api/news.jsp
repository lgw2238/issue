<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" >

	$(document).ready(function() {
	 	/* 최신 뉴스 크롤링 데이터 */
		getCurrentNewsList();
 
	});


	
	function getCurrentNewsList(){					
		$.ajax({
				async       : true,
				type        : "post",
				url         : "${pageContext.request.contextPath}/api/news/newsListAjax",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				data        : {},
				dataType    : "json",
				success     : function(json) {				
					var resultData = json.resultData;
					console.log("resultData:", resultData);
					drawUITable(resultData);

			},
			error       : function(data, status, error) {
				location.href = "${pageContext.request.contextPath}/error"
			},complete : function(){
				 
			}
		});
	}


	function drawUITable(resultData){
		 var title ="";
		 var titleLink = "";
		 var titlePhoto = "";
		 var htmlTag;
		 
		 if(resultData != null || resultData != ""){
		     for(var i=0; i<resultData.length; i++){
		    	 title = resultData[i].title;
		    	 titleLink = resultData[i].titleLink;
		    	 titlePhoto = resultData[i].titlePhotoLink;
	
		    	 /* 뉴스 리스트 테이블 TD 생성 */		    	
	    		 htmlTag += "<tr>"
	    	     htmlTag += "<td><img alt='" + titleLink + "' src='"+ titlePhoto +"'  id='eventImageInfo3'></td>";
	    		 htmlTag += "<td><a href='"+titleLink+"'>"+title+"</a></td>"		
	    		 htmlTag += "</tr>"
			 }
		 }
			$("#currnetNewsDiv").html(htmlTag);


	}



	
	
</script>

<html>
	<head>
		<title>${viewName}</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">
			 <%@ include file="/WEB-INF/views/layout/header.jsp" %>

				<!-- Banner -->
				<!-- Note: The "styleN" class below should match that of the header element. -->
					<section id="banner" class="style2">
						<div class="inner">
							<span class="image">
								<img src="images/pic07.jpg" alt="" />
							</span>
							<header class="major">
								<h1>${viewName}</h1>
							</header>
							<div class="content">
								<p>최신 뉴스를 보고 시사지식을 늘려봅시다. </p>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one">
								<div class="inner">
									<header class="major">
										<h2>최신 뉴스 리스트</h2>
										<table id="currnetNewsDiv"></table>
									</header>
									<p></p>
								</div>
							</section>

						<!-- Two -->
							<section id="two" class="spotlights">
								<section>
	<!-- 								<a href="generic.html" class="image">
										<img src="images/pic08.jpg" alt="" data-position="center center" />
									</a> -->
									<div class="content">
										<div class="inner">
											<!-- <ul class="actions">
												<li><a href="generic.html" class="button">Learn more</a></li>
											</ul> -->
										</div>
									</div>
								</section>
								<section>
									<a href="generic.html" class="image">
										<img src="images/pic09.jpg" alt="" data-position="top center" />
									</a>
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3></h3>
											</header>
											<p></p>
											<ul class="actions">
												<li><a href="generic.html" class="button">Learn more</a></li>
											</ul>
										</div>
									</div>
								</section>
								<section>
									<a href="generic.html" class="image">
										<img src="images/pic10.jpg" alt="" data-position="25% 25%" />
									</a>
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3></h3>
											</header>
											<p></p>
											<ul class="actions">
												<li><a href="generic.html" class="button">Learn more</a></li>
											</ul>
										</div>
									</div>
								</section>
							</section>

<!-- 						Three
							<section id="three">
								<div class="inner">
									<header class="major">
										<h2>Massa libero</h2>
									</header>
									<p>Nullam et orci eu lorem consequat tincidunt vivamus et sagittis libero. Mauris aliquet magna magna sed nunc rhoncus pharetra. Pellentesque condimentum sem. In efficitur ligula tate urna. Maecenas laoreet massa vel lacinia pellentesque lorem ipsum dolor. Nullam et orci eu lorem consequat tincidunt. Vivamus et sagittis libero. Mauris aliquet magna magna sed nunc rhoncus amet pharetra et feugiat tempus.</p>
									<ul class="actions">
										<li><a href="generic.html" class="button next">Get Started</a></li>
									</ul>
								</div>
							</section>
 -->
					</div>
			<!-- Footer -->
			<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
	</body>
</html>