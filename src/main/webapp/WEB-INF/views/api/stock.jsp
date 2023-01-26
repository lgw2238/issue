<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
var exchangeRateDataList = "${exchangeRateDataList}";
	$(document).ready(function() {
		makeExchangeTable(exchangeRateDataList);	
	});

	
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
			if(json.resultCode == "F") {
				alert(json.resultMsg);
				return;
			}
			else {
				if(json.resultCode == "S"){
					$("#paginationTag").html(json.paginationTag);
					$("#totalCount").html("총 " + json.totalCount + " 건");
					commonCallbackFunction(json.resultCode, json.resultMsg, json.resultData);
					if( modalYn != null && modalYn != undefined ){
						closePopup('D');
					}						
				}
			}

			$("#bbsId").val("");
		},
		error : function(data, status, error) {
			location.href = "${pageContext.request.contextPath}/error"
			} 
		});			
	}	
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
								<p>모든 Data는 현시간 기준 (5분 간격) 으로 조회됩니다.  </p>
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
									<a href="generic.html" class="image">
										<img src="images/pic08.jpg" alt="" data-position="center center" />
									</a>
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3>글로벌 지수  시세</h3>
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
										<img src="images/pic09.jpg" alt="" data-position="top center" />
									</a>
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
<!-- 															<tfoot>
																<tr>
																	<td colspan="2"></td>
																	<td>100.00</td>
																</tr>
															</tfoot> -->
														</table>																														
												</div>
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
												<h3>원자재 시세</h3>
											</header>
											<p></p>
											<ul class="actions">
												<li><a href="generic.html" class="button">Learn more</a></li>
											</ul>
										</div>
									</div>
								</section>
							</section>

						<!-- Three -->
							<section id="three">
								<div class="inner">
									<header class="major">
										<h2>Massa libero</h2>
									</header>
									<p></p>
									<ul class="actions">
										<li><a href="generic.html" class="button next">Get Started</a></li>
									</ul>
								</div>
							</section>

					</div>
			<!-- Footer -->
			<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
	</body>
</html>