<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">


	function makeExchangeTable(exchangeRateDataList){
	
			console.log(typeof exchangeRateDataList);
	
			/*환율 화면 생성*/
			var makeExchangeTableHtml = "" ;
	 		for(var i = 0; i< exchangeRateDataList.count; i++){
				if(exchangeRateDataList[i].billName != null){
					makeExchangeTableHtml += "<tr>"; 
					makeExchangeTableHtml += "<td>" +exchangeRateDataList[i].curName+ "</td>"
				    makeExchangeTableHtml += "<td>" +exchangeRateDataList[i].billName+ "</td>"
				    makeExchangeTableHtml += "<td>" +exchangeRateDataList[i].sendTax+ "</td>"
				    makeExchangeTableHtml += "<td>" +exchangeRateDataList[i].receiveTax+ "</td>"
				    makeExchangeTableHtml += "<td>" +exchangeRateDataList[i].standatdTax+ "</td>"
				    makeExchangeTableHtml += "</tr>"; 
				}
			}
			console.log(makeExchangeTableHtml);
			$("#exchangeDataTable").append(makeExchangeTableHtml);
	   }

	function apiAjax(){
		$.ajax({
			async       : false,
			type        : "post",
			url         : "${pageContext.request.contextPath}/api/stock",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8", 
			dataType    : "json",
			data 		: {  gameIdList : gameContentsId
							,level3MenuId : $("#level3MenuId").val() },
			success     : function(json) {
	
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
		    	 htmlTag+="<td>"+bodySplit[1]+"</td>"	

		    	 if(bodySplit[1] == "JYP"){			    	 
			     }else{
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
		    	 
		    	 if(bodySplit[1] == "JYP"){		
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
										<h2>내 종목 시세 조회</h2>
									</header>
									<p></p>
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
									                <col style="width:10%;" />
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
										<div id="stockDiv">
										</div>
									</div>
								</section>
								<section>
<!-- 									<a href="generic.html" class="image">
										<img src="images/pic09.jpg" alt="" data-position="top center" />
									</a> -->
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3>환율 시세</h3>
											</header>
											<p></p>
											<ul class="actions">
												<div id="dataDiv">
													<table class="alt">
															<thead>
																<tr>
																	<th>국가</th>
																	<th>통화</th>
																	<th>송금 받을 때</th>
																	<th>송금 보낼 때</th>
																	<th>환율</th>
																</tr>
															</thead>
															<tbody id="exchangeDataTable">															
															</tbody>
													</table>																														
												</div>
											</ul>
										</div>
									</div>
								</section>
								<section>
<!-- 									<a href="generic.html" class="image">
										<img src="images/pic10.jpg" alt="" data-position="25% 25%" />
									</a> -->
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3>원자재 시세</h3>
											</header>
											<p></p>
											<!-- <ul class="actions">
												<li><a href="generic.html" class="button">Learn more</a></li>
											</ul> -->
										</div>
									</div>
								</section>
							</section>

						<!-- Three -->
							<section id="three">
								<div class="inner">
									<header class="major">
										<h2></h2>
									</header>
									<p></p>
									<!-- <ul class="actions">
										<li><a href="generic.html" class="button next">Get Started</a></li>
									</ul> -->
								</div>
							</section>

					</div>
			<!-- Footer -->
			<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
	</body>
</html>