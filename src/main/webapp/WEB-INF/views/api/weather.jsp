<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src='http://openweathermap.org/themes/openweathermap/assets/vendor/owm/js/d3.min.js'></script>
<script src="https://kit.fontawesome.com/17b5a91918.js" crossorigin="anonymous"></script>
<script>window.myWidgetParam ? window.myWidgetParam : window.myWidgetParam = [];  window.myWidgetParam.push({id: 1,cityid: '1835848',appid: '46b55a9f61cc588200575a3dda8e3069',units: 'metric',containerid: 'openweathermap-widget-1',  });
(
function() {
	var script = document.createElement('script');script.async = true;script.charset = "utf-8";
	script.src = "//openweathermap.org/themes/openweathermap/assets/vendor/owm/js/weather-widget-generator.js";
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(script, s);  
	})
	(
);</script>
<script type="text/javascript" >


$(document).ready(function() {
 	/* 당일 글로벌 날씨 데이터 */
	getWeatherDataList();

});


	function getWeatherDataList(){	
//"${pageContext.request.contextPath}/api/weather/weatherListAjax"
		var location = {
		        '01' : 'fas fa-sun',
		        '02' : 'fas fa-cloud-sun',
		        '03' : 'fas fa-cloud',
		        '04' : 'fas fa-cloud-meatball',
		        '09' : 'fas fa-cloud-sun-rain',
		        '10' : 'fas fa-cloud-showers-heavy',
		        '11' : 'fas fa-poo-storm',
		        '13' : 'far fa-snowflake',
		        '50' : 'fas fa-smog'
		      };	

	     var city = $("#inputCiryValue").val();
	     console.log("city:", city);
	     var appid = "46b55a9f61cc588200575a3dda8e3069";
			 $.ajax({
					async       : true,
					type        : "get",
					url         : "http://api.openweathermap.org/data/2.5/weather",
					contentType : "application/x-www-form-urlencoded;charset=UTF-8",
					data        : {
						q:city,
						appid:appid,
						units:"metric"
						},
					dataType    : "json",
					success     : function(json) {				
						var resultData = json.resultData;
						console.log("json:", json);
						drawUITableWithWeather(json);
	
				},
				error       : function(data, status, error) {
					location.href = "${pageContext.request.contextPath}/error"
				},complete : function(){
					 
				}
			});
		}


	function drawUITableWithWeather(resp){
		divInit();
		var weatherIcon = {
			    '01' : 'fas fa-sun',
			    '02' : 'fas fa-cloud-sun',
			    '03' : 'fas fa-cloud',
			    '04' : 'fas fa-cloud-meatball',
			    '09' : 'fas fa-cloud-sun-rain',
			    '10' : 'fas fa-cloud-showers-heavy',
			    '11' : 'fas fa-poo-storm',
			    '13' : 'far fa-snowflake',
			    '50' : 'fas fa-smog'
			};
		
	        var $Icon = (resp.weather[0].icon).substr(0,2);
	        var $weather_description = resp.weather[0].main;
	        var $Temp = Math.floor(resp.main.temp) + 'º';
	        var $humidity = '습도&nbsp;&nbsp;&nbsp;&nbsp;' + resp.main.humidity+ ' %';
	        var $wind = '바람&nbsp;&nbsp;&nbsp;&nbsp;' +resp.wind.speed + ' m/s';
	        var $city =  resp.name;
	        var $cloud = '구름&nbsp;&nbsp;&nbsp;&nbsp;' + resp.clouds.all +"%";
	        var $temp_min = '최저 온도&nbsp;&nbsp;&nbsp;&nbsp;' + Math.floor(resp.main.temp_min) + 'º';
	        var $temp_max = '최고 온도&nbsp;&nbsp;&nbsp;&nbsp;' + Math.floor(resp.main.temp_max) + 'º';
	        
	        $('.weather_icon').append('<i class="' + weatherIcon[$Icon] +' fa-5x" style="height : 120px; width : 120px;"></i>');
	        $('.weather_description').prepend($weather_description);
	        $('.current_temp').prepend($Temp);
	        $('.humidity').prepend($humidity);
	        $('.wind').prepend($wind);
	        $('.city').append($city);
	        $('.cloud').append($cloud);
	        $('.temp_min').append($temp_min);
	        $('.temp_max').append($temp_max);          


	}

function divInit(){
	  $('.weather_icon').empty();
      $('.weather_description').empty();
      $('.current_temp').empty();
      $('.humidity').empty();
      $('.wind').empty();
      $('.city').empty();
      $('.cloud').empty();
      $('.temp_min').empty();
      $('.temp_max').empty();

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

				<!-- Header -->
				<%@ include file="/WEB-INF/views/layout/header.jsp" %>

				<!-- Banner -->
				<!-- Note: The "styleN" class below should match that of the header element. -->
					<section id="banner" class="style2">
						<div class="inner">
							<span class="image">
								<img src="${pageContext.request.contextPath}/images/test.jpg" alt="" />
								<%-- <img src="${pageContext.request.contextPath}/images/pic07.jpg" alt="" /> --%>
							</span>
							<header class="major">
								<h1>${viewName}</h1>
							</header>
							<div class="content">
								<i class="fa-solid fa-cloud"></i>
								<p>빠르고 간편하게 전세계 도시들의 날씨를 조회할 수 있습니다.</p>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one">
								<div class="inner">
									<header class="major">
										<h2>글로벌 도시 날씨 조회</h2>
									</header>
									<table id="globalDiv" style="width:500px;">
									<tbody>
									<td>
										<span>
											<select name="demo-category" id="inputCiryValue" style="width:300px;">
												<option value="">- 도시 날씨 -</option>
												<option value="Seoul" selected="selected">Seoul</option>
												<option value="london">London</option>
												<option value="Tokyo">Tokyo</option>
												<option value="Beijing">Beijing</option>
												<option value="Washington">Washington</option>
												<option value="San Francisco">San Francisco</option>												
											</select>								
										</span>
										<td>
											<div class="buttonBox">
												<span>
													<input type="submit" value="조회" class="primary" onclick="javascript:getWeatherDataList();"/>
												</span>
											</div>		
										</td>		
									</td>		
									</tbody>
										
									</table>								
									<%-- <p>현재 계신 동네의 온도는 ${localWeather.fcstValue}℃ 입니다. </p> --%>
									 	<div style="background-color : rgb(101, 178, 255); padding : 10px; color : #fff; height : 220px; width: 450px;">
										    <div style="float : left; margin : 40px 0px 0px 30px;">
										        <div class="weather_icon"></div>
										    </div><br>											
										    <div style="float : right; margin : 0px 0px 0px 40px; font-size : 12pt">
										            <div class="temp_min"></div>
										            <div class="temp_max"></div>
										            <div class="humidity"></div>
										            <div class="wind"></div>
										            <div class="cloud"></div>
										    </div>
										    <div style="float : right; margin-top : -45px;">
										        <div class="current_temp" style="font-size : 50pt"></div>
										        <div class="weather_description" style="font-size : 20pt"></div>
										        <div class="city" style="font-size : 13pt"></div>
										    </div>
										</div> 
								</div>
							</section>

						<!-- Two -->
							<section id="two" class="spotlights">
								<section>
								<%-- 	<a href="generic.html" class="image">
										<img src="${pageContext.request.contextPath}/images/pic08.jpg" alt="" data-position="center center" />
									</a> --%>
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3>전국 주요도시 현 시각 날씨</h3>
											</header>
<!-- 											<ul class="actions">
												<li><a href="generic.html" class="button">Learn more</a></li>
											</ul> -->
										</div>
									</div>
								</section>
								<section>					
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3>Rhoncus magna</h3>
											</header>
											<p>Nullam et orci eu lorem consequat tincidunt vivamus et sagittis magna sed nunc rhoncus condimentum sem. In efficitur ligula tate urna. Maecenas massa sed magna lacinia magna pellentesque lorem ipsum dolor. Nullam et orci eu lorem consequat tincidunt. Vivamus et sagittis tempus.</p>
											<!-- <ul class="actions">
												<li><a href="generic.html" class="button">Learn more</a></li>
											</ul> -->
										</div>
									</div>
								</section>
								<section>								
									<div class="content">
										<div class="inner">
											<header class="major">
												<h3>Sed nunc ligula</h3>
											</header>
											<p>Nullam et orci eu lorem consequat tincidunt vivamus et sagittis magna sed nunc rhoncus condimentum sem. In efficitur ligula tate urna. Maecenas massa sed magna lacinia magna pellentesque lorem ipsum dolor. Nullam et orci eu lorem consequat tincidunt. Vivamus et sagittis tempus.</p>
<!-- 											<ul class="actions">
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
										<h2>Massa libero</h2>
									</header>
									<p>Nullam et orci eu lorem consequat tincidunt vivamus et sagittis libero. Mauris aliquet magna magna sed nunc rhoncus pharetra. Pellentesque condimentum sem. In efficitur ligula tate urna. Maecenas laoreet massa vel lacinia pellentesque lorem ipsum dolor. Nullam et orci eu lorem consequat tincidunt. Vivamus et sagittis libero. Mauris aliquet magna magna sed nunc rhoncus amet pharetra et feugiat tempus.</p>
<!-- 									<ul class="actions">
										<li><a href="generic.html" class="button next">Get Started</a></li>
									</ul> -->
								</div>
							</section>

					</div>

			<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
	</body>
</html>