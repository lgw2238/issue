<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>	
 <%@ include file="/WEB-INF/views/common.jsp" %>
<script type="text/javascript" >


   function sendMail(){
	  alert("현재 메일 연동이 되어있지 않습니다. \n다음에 시도해주시기 바랍니다.");
	  return;
	  var sendName =  $("#name").val();
	  var sendEmail =  $("#email").val();
	  var sendMessage = $("#message").val();
	  console.log("=================================");
	  console.log("sendName:",sendName);
	  console.log("sendEmail:", sendEmail);
	  console.log("sendMessage:", sendMessage);
	  console.log("=================================");
			$.ajax({
				async       : false,
				type        : "post",
				url         : "${pageContext.request.contextPath}/sys/mail/sendMail",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				data        : { sendName:sendName, 
								sendEmail:sendEmail,
								sendMessage:sendMessage
							   },
				dataType    : "json",
				success     : function(json) {			
					alert("메일 전송이 완료 되었습니다.");
	
			},
			error       : function(data, status, error) {
				//alert('error.status =' + status + '\nerror.data =' + data + '\nerror.error ='+ error);
				alert('메일 전송에 실패 하였습니다 \n다시 시도해주시기 바랍니다.');
				location.href = "${pageContext.request.contextPath}/error"
			},complete : function(){
				
			}
		});

   }

   
    function init(){	   	
		  $("#name").val("");
		  $("#email").val("");
		  $("#message").val("");
	
	}



</script>
<form id="mailForm" name="mailForm" method="post">
	<input type="hidden" id="senderName" name="senderName" value="" />
	<input type="hidden" id="sendEmail" name="sendEmail" value="" />
	<input type="hidden" id="sendMessage" name="sendMessage" value="" />

</form>

				<section id="contact">
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
											<input type="text" name="email" id="email" value="nihao3634@naver.com"/>
										</div>
										<div class="field">
											<label for="message">Message</label>
											<textarea name="message" id="message" rows="6"></textarea>
										</div>
									</div>
									<ul class="actions">
										<li><input type="submit" onclick="javascript:sendMail();" value="Send Email" class="primary" /></li>
										<li><input type="reset" onclick="javascript:init();" value="Clear" /></li>
									</ul>
								</form>
							</section>
							<section class="split">
								<section>
									<div class="contact-method">
										<span class="icon brands alt fa-github"></span>
										<h3>Git</h3>
										<a href="https://github.com/lgw2238" class="">https://github.com/lgw2238</a>
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon solid alt fa-envelope"></span>
										<h3>Email</h3>
										<a href="mailto:lgw2236@gmail.com">lgw2236@gmail.com</a></br>
										<a href="mailto:nihao3634@naver.com">nihao3634@naver.com</a>
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
										<span>서울특별시 관악구 미성동<br />
										<br />
										</span>
									</div>
								</section>
							</section>
						</div>
					</section>
		<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon brands alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon brands alt fa-facebook-f"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon brands alt fa-instagram"><span class="label">Instagram</span></a></li>
								<!-- <li><a href="#" class="icon brands alt fa-github"><span class="label">GitHub</span></a></li> -->
								<li><a href="#" class="icon brands alt fa-linkedin-in"><span class="label">LinkedIn</span></a></li>
								<h4 style="text-align:right;">Forty by HTML5 UP html5up.net | @ajlkn </h4>
							</ul>
<!-- 							<ul class="copyright">
								<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul> -->
						</div>
							
					</footer>

			</div>

		<!-- Scripts --> <!-- 
			<script src="https://kit.fontawesome.com/17b5a91918.js" crossorigin="anonymous"></script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script> 
			<script src="${pageContext.request.contextPath}/assets/jquery-ui.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script> 
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script> 
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script> 
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>		
			 -->