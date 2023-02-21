<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 <script type="text/javascript">


$(document).ready(function() {
	getTourDataList();
});
	
	function getTourDataList(){
		 var areaCode = $("#inputLocalValue").val();
		 
			$.ajax({
				async       : true,
				type        : "post",
				url         : "${pageContext.request.contextPath}/api/tourist/touristDataAjax",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				data        : {				
					 areaCode:areaCode	
					},
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
		 var standardAddr = "";
		 var detailAddr = "";
		 var imageSrc = "";
		 var zipcode = "";
		 var tel = "";
		 var htmlTag ="";
		 htmlTag += "<table>" 
		 htmlTag += "<colgroup>"
		 htmlTag += "<col style='width:20%;'/>"
	     htmlTag += "<col style='width:80%;'/>"
/* 	 	 htmlTag += "<col style='width:15%;'/>"
	     htmlTag += "<col style='width:20%;'/>"
		 htmlTag += "<col style='width:15%;'/>"   	   
		 htmlTag += "<col style='width:15%;'/>" */
		 htmlTag += "<col />"
		 htmlTag += "</colgroup>"  	   
		 htmlTag += "<thead>"  	
		 htmlTag += "<tr style='width:1040px;'>"   
		 htmlTag += "<th>이미지</th>" 
		 htmlTag += "<th>관광지 정보</th>"
/* 	     htmlTag += "<th>주소</th>"
		 htmlTag += "<th>상세주소</th>"
		 htmlTag += "<th>우편번호</th>"
		 htmlTag += "<th>전화번호</th>"   */ 
		 htmlTag += "</tr>"   	   
		 htmlTag += "</thead>"  		
		 if(resultData != null || resultData != "" || resultData != "undefined"){
		     for(var i=0; i<resultData.length; i++){
		    	 title = resultData[i].title;
		    	 standardAddr = resultData[i].standardAddr;
		    	 detailAddr = resultData[i].detailAddr;
		    	 imageSrc = resultData[i].firstimage;
		    	 zipcode = resultData[i].zipcode;
		    	 tel = resultData[i].telNum;  				
				/*  htmlTag += "<tbody>"	 */		
				 htmlTag += "<tr>"	
				 htmlTag += "<td colspan='1'>"							 	 
	  			 htmlTag += "<span><img src='"+ imageSrc +"' id='naverTourImg' style='width:300px; height:300px;'></span>";
	  			 htmlTag += "</td>"	
	  			 htmlTag += "<td colspan='5' style='vertical-align:top;''>"		
	  			 htmlTag += "<span><li>관광지이름⇒   "+title+"</li></span>"	
	  			 htmlTag += "<span><li>주소⇒    "+standardAddr+"</li></span>"	
	  			 htmlTag += "<span><li>상세주소⇒   "+detailAddr+"</li></span>"	
	  			 htmlTag += "<span><li>우편번호⇒   "+zipcode+"</li></span>"	
	  			 htmlTag += "<span><li>전화번호⇒   "+tel+"</li></span>"	
	  			 htmlTag += "</td>"	
	  			 htmlTag += "</tr>"	
	  			/*  htmlTag += "</tbody>" */
	  			 
			     }	
			 }
		    htmlTag += "</table>"
			$("#tourListDiv").html(htmlTag);
	
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
							    <i class="fa-sharp fa-solid fa-location-dot"></i>
								<p>최적의 관광 명소를 찾아드립니다. </p>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">
						<!-- One -->
							<section id="one">
								<div class="inner">
									<header class="major">
										<h2>관광명소 조회</h2>
									</header>
									<table style="width:500px;">
										<tbody>
										<tr>
											<td>
												<select name="demo-category" id="inputLocalValue" title="검색항목 선택"  style="width:300px;">
						                            <option value="" selected>전체</option>
						                            <c:forEach items="${areaCodeList}" var="areaCodeObj">
						                            <option value="${areaCodeObj.areaCode}">${areaCodeObj.areaNm}</option>
						                            </c:forEach>																							
												</select>	
											</td>
											<td>
											<div class="buttonBox">
												<span>
													<input type="submit" value="조회" class="primary" onclick="javascript:getTourDataList();"/>
												</span>
											</div>		
											</td>		
										</tr>	
													
										</tbody>										
									</table>	
								</div>
							</section>

						<!-- Two -->
							<section id="two" class="spotlights">
								<section>
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3>관광지 리스트</h3>
												<table id="tourListDiv" style="width:1140px;"></table>
												<p></p>
											</header>										
										</div>
									</div>
								</section>
								<section>
									<!-- <div class="content">
										<div class="inner">
											<header class="major">
												<h3></h3>
											</header>
										</div>
									</div> -->
							<!-- 		
								</section>
								<section>
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3></h3>
											</header>																		
										</div>
									</div>
								</section>
							</section>
							 -->
<!-- 
						Three
							<section id="three">
								<div class="inner">
									<header class="major">
										<h2>Massa libero</h2>
									</header>
								</div>
							</section>
 -->
					</div>
			<!-- Footer -->
			<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
	</body>
</html>