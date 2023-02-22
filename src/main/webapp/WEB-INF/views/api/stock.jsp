<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">
 
</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">



$(document).ready(function() {
	stockApi("KOSPI");
	exchangeApi();
	jisuApi();
});

	function jisuApi(){
		$.ajax({
			async       : false,
			type        : "post",
			url         : "${pageContext.request.contextPath}/api/stock/jisuListAjax",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8", 
			dataType    : "json",
			data 		: {   },
			success     : function(json) {
						var resultData = json.resultData;
						console.log("jisuData:", resultData);
						drawScreenForJisu(resultData);
			},
			error : function(data, status, error) {
				location.href = "${pageContext.request.contextPath}/error"
				} 
			});			
		}	


	function exchangeApi(){
		$.ajax({
			async       : false,
			type        : "post",
			url         : "${pageContext.request.contextPath}/api/stock/exchangeListAjax",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8", 
			dataType    : "json",
			data 		: {   },
			success     : function(json) {
						console.log("exChangejson:", json);
						var resultData = json.resultData;
						drawScreenForExchange(resultData);
			},
			error : function(data, status, error) {
				location.href = "${pageContext.request.contextPath}/error"
				} 
			});			
		}	

	
	function stockApi(parameter){
		console.log(parameter);
		$.ajax({
			async       : false,
			type        : "post",
			url         : "${pageContext.request.contextPath}/api/stock/stockListAjax",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8", 
			dataType    : "json",
			data 		: {
				stockType:parameter
			},
			success     : function(json) {
				console.log("json:",json);
				var resultData = json.resultData;
				if(json != null || json != ""){
					drawScreen(resultData);
				}else{
					alert("데이터 조회에 실패하였습니다.");
				}
					
			},
			error : function(data, status, error) {
				location.href = "${pageContext.request.contextPath}/error"
				} 
			});			
	}	


	function drawScreen(resultData){		
		 var htmlTag = "";
		 var bodySplit = "";
		 if(resultData != null || resultData != ""){
			 /* 전체 data for문 */ 
		     for(var i=0; i<resultData.length; i++){
		    	 body = resultData[i].stockBody;
		    	 bodySplit = body.split('|'); 
		    	  
				 htmlTag+="<tr>"
		    	 htmlTag+="<td>"+bodySplit[0]+"</td>"	
		    	 if(bodySplit[1] == "JYP" || bodySplit[1] == "CJ"){		
		    		 htmlTag+="<td>"+bodySplit[1].concat(bodySplit[2])+"</td>"   	 
			     }else{
			    	 htmlTag+="<td>"+bodySplit[1]+"</td>"	
			    	 htmlTag+="<td>"+bodySplit[2]+"</td>"	
				 }		    	 		    	 
		    	 htmlTag+="<td>"+bodySplit[3]+"</td>"
		    	 htmlTag+="<td>"+bodySplit[4]+"</td>"
		    	 htmlTag+="<td>"+bodySplit[5]+"</td>"
		    	 htmlTag+="<td>"+bodySplit[6]+"</td>"
		    	 htmlTag+="<td>"+bodySplit[7]+"</td>"
		    	 htmlTag+="<td>"+bodySplit[8]+"</td>"
		    	 htmlTag+="<td>"+bodySplit[9]+"</td>"
		    	 htmlTag+="<td>"+bodySplit[10]+"</td>"
		    	 htmlTag+="<td>"+bodySplit[11]+"</td>"
		    	 
		    	 if(bodySplit[1] == "JYP" || bodySplit[1] == "CJ"){		
		    		 htmlTag+="<td>"+bodySplit[12]+"</td>"	    	 
			     }else{
			    	
				 }
		    	 htmlTag+="</tr>"    			   			    	     
		     }
		 }else{
			 
		}	
		if(resultData[0].stockType == "KOSPI"){
			$("#stockMajor").text("KOSPI 상위 종목(20)");
		}else if(resultData[0].stockType == "KOSDAQ"){
			$("#stockMajor").text("KOSDAQ 상위 종목(20)");
		}else{
			$("#stockMajor").text("KOSPI 상위 종목(20)");
		}	
		$("#stockInfoTable").html(htmlTag);		
	}


	function drawScreenForExchange(resultData){
		console.log("drawScreenForExchange:", resultData);
		 var exchangeTag = "";
		 var bodySplit = "";
		 if(resultData != null || resultData != ""){
			 /* 전체 data for문 */ 
		     for(var i=0; i<resultData.length; i++){
		    	 body = resultData[i].exchangeBody;
		    	 
		    	 bodySplit = body.split('|'); 
    			 exchangeTag+="<tr>"
        	     if(bodySplit[0] =="일본"){
        	    	 exchangeTag+="<td>"+bodySplit[0].concat(bodySplit[1]+bodySplit[2])+"</td>"		
        	    	 exchangeTag+="<td>"+bodySplit[3]+"(원)</td>"
        	    	 if(bodySplit[4].includes("전일대비상승")){
        	    		 exchangeTag+="<td>"+bodySplit[4].replace("전일대비상승", "+")+"</td>"	
            	   	 }else if(bodySplit[4].includes("전일대비하락")){
            	   		 exchangeTag+="<td>"+bodySplit[4].replace("전일대비하락", "-")+"</td>"	
                	 }else{

                     }
        			
        			 exchangeTag+="<td>"+bodySplit[5]+"</td>"	
        	     }else{
        			 exchangeTag+="<td>"+bodySplit[0].concat(bodySplit[1])+"</td>"			
        			 exchangeTag+="<td>"+bodySplit[2]+"(원)</td>"
        			 if(bodySplit[3].includes("전일대비상승")){
        	    		 exchangeTag+="<td>"+bodySplit[3].replace("전일대비상승", "+")+"</td>"	
            	   	 }else if(bodySplit[3].includes("전일대비하락")){
            	   		 exchangeTag+="<td>"+bodySplit[3].replace("전일대비하락", "-")+"</td>"	
                	 }else{
                		 exchangeTag+="<td>"+bodySplit[3]+"</td>"
                     }
        			 
        			 exchangeTag+="<td>"+bodySplit[4]+"</td>"

            	 }

	    		 exchangeTag+="</tr>"
		     }

		 }
		 $("#exchangeDataTable").html(exchangeTag);		

	}




	function drawScreenForJisu(resultData){
		console.log("drawScreenForJisu:", resultData);
		 var jisuTag = "";
		 var bodySplit = "";
		 var imgSrc = "";
		 var count = 0;
		 if(resultData != null || resultData != ""){
			 /* 전체 data for문 */ 
		     for(var i=0; i<resultData.length; i++){
		    	 body = resultData[i].jisuDataBody;
		    	 imgSrc = resultData[i].imgLink;
		    	 count = body.split('|').length;
		    	 bodySplit = body.split('|'); 


		    	 
		    	 jisuTag+="<div class='innerBox'>"
	    		 jisuTag+="<tr>"
		    		 
				 if(count == 6){
					 jisuTag+="<td>"+bodySplit[0]+"         ";
	    		     if(imgSrc != null){
	    		    	 jisuTag+= "<img src='"+ imgSrc +"'  id='jisuimg'></td>";
	        		 }
	    		     jisuTag+="<td>"+bodySplit[1]+"</td>"
	    		     jisuTag+="<td>"+bodySplit[2]+"</td>"
	    		     jisuTag+="<td>"+bodySplit[3]+"</td>"
	    		     jisuTag+="<td>"+bodySplit[4]+"</td>"
	    		     jisuTag+="<td>"+bodySplit[5]+"</td>"
	    		     if(bodySplit[0] != "KOSPI" && bodySplit[0] != "KOSDAQ"){
	    		    	 jisuTag+="<td>"+bodySplit[6]+"</td>"
					 }
					 
				 }else if(count == 7){
					 jisuTag+="<td>"+bodySplit[0]+"</td>"
	    		     if(imgSrc != null){
	    		    	 jisuTag+= "<td><img src='"+ imgSrc +"'  id='jisuimg'></td>";
	        		 }
	    		     jisuTag+="<td>"+bodySplit[1]+"</td>"
	    		     jisuTag+="<td>"+bodySplit[2]+"</td>"
	    		     jisuTag+="<td>"+bodySplit[3].concat(bodySplit[4])+"</td>"
	    		     jisuTag+="<td>"+bodySplit[5]+"</td>"
	    		     jisuTag+="<td>"+bodySplit[6]+"</td>"
	    		     
				 }else if(count == 8){
					 jisuTag+="<td>"+bodySplit[0].concat(bodySplit[1])+"</td>"
	    		     if(imgSrc != null){
	    		    	 jisuTag+= "<td><img src='"+ imgSrc +"'  id='jisuimg'></td>";
	        		 }
	    		     jisuTag+="<td>"+bodySplit[2]+"</td>"
	    		     jisuTag+="<td>"+bodySplit[3]+"</td>"
	    		     jisuTag+="<td>"+bodySplit[4].concat(bodySplit[5])+"</td>"
	    		     jisuTag+="<td>"+bodySplit[6]+"</td>"
	    		     jisuTag+="<td>"+bodySplit[7]+"</td>"

				 }

    		     jisuTag+="</tr>"
    			 jisuTag+="</div>"
        	   
		     }
		 }
		 $("#JisuTable").html(jisuTag);		

	}
</script>
<html>
	<head>
		<title>${viewName}</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/favicon.ico">
		<noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">
		
		<!-- Wrapper -->
			<div id="wrapper">
			
			<!-- Header -->
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
								<p>Stock data는 현재 일시 기준 (네이버 증권/주식시세)으로 조회됩니다.  </p>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one">
								<div class="inner">
									<header class="major">									
										<h2>글로벌 지수</h2>
										</header>
										<table>
												<colgroup>	
									                <col style="width:25%;" />
									                <col style="width:10%;" />
									                <col style="width:25%;" />
									                <col style="width:15%;" />
									                <col style="width:15%;" />
									                <col style="width:10%;" />
									                <col />
									            </colgroup>
											<thead>
												<tr>
													<th scope="col">지수명</th>
													<th scope="col">기준일자</th>
													<th scope="col">지수</th>
													<th scope="col">상승여부</th>
													<th scope="col">상승포인트</th>
													<th scope="col">상승률</th>
												</tr>
											</thead>
										<tbody id="JisuTable"></tbody>
										</table>
								</div>
							</section>

						<!-- Two -->
							<section id="two" class="spotlights">
								<section>
									<div class="buttonBox">
										<span >
											<input type="submit" value="KOSPI" class="primary" onclick="javascript:stockApi('KOSPI');" style="float: left; width:150px; height:100px;"/>
											<input type="submit" value="KOSDAC" class="primary" onclick="javascript:stockApi('KOSDAQ');" style="float: left; width:150px; height:100px;"/>
										</span>
									</div>	
									<div class="content" style="width:100%;">
										<div class="inner">
											<header class="major">
												<h3 id="stockMajor"></h3>
											</header>
											<table >
												<colgroup>	
									                <col style="width:2%;" />
									                <col style="width:*;" />
									                <col style="width:7%;" />
									                <col style="width:9%;" />
									                <col style="width:7%;" />
									                <col style="width:8%;" />
									                <col style="width:8%;" />
									                <col style="width:8%;" />
									                <col style="width:10%;" />
									                <col style="width:8%;" />
									                <col style="width:8%;" />
									                <col style="width:8%;" />
									                <col />
									            </colgroup>
											<thead>
												<tr>
													<th scope="col">NO</th>
													<th scope="col">종목명</th>
													<th scope="col">현재가</th>
													<th scope="col">전일비</th>
													<th scope="col">등락률</th>
													<th scope="col">액면가</th>
													<th scope="col">시가총액</th>
													<th scope="col">상장주식수</th>
													<th scope="col">외국인비율</th>
													<th scope="col">거래량</th>
													<th scope="col">PER</th>
													<th scope="col">ROE</th>
												</tr>
											</thead>
											<tbody id="stockInfoTable">
											</tbody>
											</table>
										</div>
									</div>
								</section>	
							</section>					
									<div class="content">
										<div class="inner">
											<header class="major">
												<h2>환율 시세</h2>
											</header>
												<div id="dataDiv">
													<table class="rate_table_info" >
													<colgroup>
													<col width="160px">
													<col width="100px">
													<col width="142px">
													<col width="146px">
													</colgroup>
													<thead>
													<tr>
													<th scope="col" class="col1">
														<span>국가/통화명</span>
													</th>
													<th scope="col" class="col2">
														<span>매매기준환율</span>
													</th>
													<th scope="col" class="col3">
														<span>전일대비</span>
													</th>
													<th scope="col" class="col4">
														<span>등락률</span>
													</th>
													</thead>
													<tbody id="exchangeDataTable">																												
													</tbody>
													</table>																														
												</div>
											</div>
										</div>
									</div>
<!-- 							<section>
								<div class="content">
									<div class="inner">
										<header class="major">
											<h3>원자재 시세</h3>
										</header>
										<p></p>
									</div>
								</div>
							</section> -->

	
						<!-- Three -->
							<section id="three">
								<div class="inner">
								<!-- 	<header class="major">
										<h2></h2>
									</header>
									<p></p>			 -->			
								</div>
							</section> 

			<!-- Footer -->
			<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
	</body>
</html>