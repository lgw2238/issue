<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src='https://openweathermap.org/themes/openweathermap/assets/vendor/owm/js/d3.min.js'></script>
<script src="https://kit.fontawesome.com/17b5a91918.js" crossorigin="anonymous"></script>
<script type="text/css" src="${pageContext.request.contextPath}/assets/css/weather.css"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/d3.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/korea.js"></script> --%>

<script type="text/javascript" >


$(document).ready(function() {
 	/* 당일 글로벌 날씨 데이터 */
	getWeatherDataList();
	drawMap('#container');
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
					url         : "https://api.openweathermap.org/data/2.5/weather",
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

function openWeatherModal(data){
    var data = data;
	console.log("data:", data);
	/*  $.ajax({
			async       : true,
			type        : "POST",
			url         : "${pageContext.request.contextPath}/api/weather/weatherApiData",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			data        : {
					data: data
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
	}); */
}


//지도 그리기
function drawMap(target) {
    var width = 1400; //지도의 넓이
    var height = 700; //지도의 높이
    var initialScale = 5500; //확대시킬 값
    var initialX = -11900; //초기 위치값 X
    var initialY = 4050; //초기 위치값 Y
    var labels;

    var projection = d3.geo
        .mercator()
        .scale(initialScale)
        .translate([initialX, initialY]);
    var path = d3.geo.path().projection(projection);
    var zoom = d3.behavior
        .zoom()
        .translate(projection.translate())
        .scale(projection.scale())
        .scaleExtent([height, 800 * height])
        .on('zoom', zoom);
   		
   		
    var svg = d3
        .select(target)
        .append('svg')
        .attr('width', width + 'px')
        .attr('height', height + 'px')
        .attr('id', 'map')
        .attr('class', 'map');
/*         .on('click', openWeatherModal); */
 		
	
    var states = svg
        .append('g')
        .attr('id', 'states')
        .attr('onclick', 'states')
        .call(zoom);
		
    states
        .append('rect')
        .attr('class', 'background')
        .attr('width', width + 'px')
        .attr('height', height + 'px')

    //geoJson데이터를 파싱하여 지도그리기
    d3.json('${pageContext.request.contextPath}/assets/js/korea.json', function(json) {
        states
            .selectAll('path') //지역 설정
            .data(json.features)
            .enter()
            .append('path')          
            .attr('d', path)
            .attr('onclick', function(d) {
                return 'javascript:openWeatherModal("'+d.properties.name_eng+'");';
            })            
            .attr('id', function(d) {
                return 'path-' + d.properties.name_eng;
            })

        labels = states
            .selectAll('text')
            .data(json.features) //라벨표시
            .enter()
            .append('text')
            .attr('transform', translateTolabel)
            .on('id', function(d) {
                return 'label-' + d.properties.name_eng;
            })
            .attr('text-anchor', 'middle')
            .attr('dy', '.35em')
            .text(function(d) {
                return d.properties.name;
            });

    });

    //텍스트 위치 조절 - 하드코딩으로 위치 조절을 했습니다.
    function translateTolabel(d) {
        var arr = path.centroid(d);
        
        if (d.properties.code == 31) {
            //서울 경기도 이름 겹쳐서 경기도 내리기
            arr[1] +=
                d3.event && d3.event.scale
                    ? d3.event.scale / height + 20
                    : initialScale / height + 20;
        } else if (d.properties.code == 34) {
            //충남은 조금 더 내리기
            arr[1] +=
                d3.event && d3.event.scale
                    ? d3.event.scale / height + 10
                    : initialScale / height + 10;
        }
        return 'translate(' + arr + ')';
    }

    function zoom() {
        projection.translate(d3.event.translate).scale(d3.event.scale);
        states.selectAll('path').attr('d', path);
        labels.attr('transform', translateTolabel);
    }
    

}



</script>

<html>
	<head>
		<title>${viewName}</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/favicon/favicon.ico">
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
												<option value="Tokyo">Tokyo</option>											
												<option value="Beijing">Beijing</option>
											    <option value="Sydney">Sydney</option>	
											    <option value="Paris">Paris</option>
												<option value="london">London</option>																							
												<option value="Washington">Washington</option>
												<option value="los angeles">LA</option>
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
												 <div id="container"></div>
												 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/weather.css" />
<!-- 											<ul class="actions">
												<li><a href="generic.html" class="button">Learn more</a></li>
											</ul> -->
										</div>
									</div>
								</section>

					</div>

			<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
	</body>
</html>