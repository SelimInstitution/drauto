<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%
 /**
  * @Class Name : EgovLoginUsr.jsp
  * @Description : Login 인증 화면
  * @Modification Information
  * @
  * @  수정일         수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.03.03    박지욱          최초 생성
  *   2011.09.25    서준식          사용자 관리 패키지가 미포함 되었을때에 회원가입 오류 메시지 표시
  *   2011.10.27    서준식          사용자 입력 탭 순서 변경
  *  @author 공통서비스 개발팀 박지욱
  *  @since 2009.03.03
  *  @version 1.0
  *  @see
  *
  *  Copyright (C) 2009 by MOPAS  All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<link rel="stylesheet" href="/drauto/css/egovframework/drauto/drautologin.css" type="text/css">

<title>정부통합전산센터 서버관리업무지원시스템</title>
<script type="text/javaScript" language="javascript">

function actionLogin() {
    if (document.loginForm.id.value =="") {
        alert("아이디를 입력하세요");
    } else if (document.loginForm.password.value =="") {
        alert("비밀번호를 입력하세요");
    } else {
    	document.loginForm.action="/drauto/drauto/login/drautoLogin.do";
        document.loginForm.submit();
    }
}

function userInsertRequest() {
	window.open("/drauto/uss/umt/EgovMberSbscrbView.do", "DrAuto", "width=450, height=280");
}

function fnInit() {
	
// 	document.loginForm.id.focus();
	var message = document.loginForm.message.value;
    if (message != "") {
        alert(message);
    }
}

</script>
</head>
<body onLoad="fnInit();">
  <%-- 
	<c:if test="${loginVO != null}">
		<jsp:forward page="/sym/mnu/mpm/EgovMainMenuHome.do"/>
	</c:if>
--%>
	 <form name="loginForm" method="post" action="">
	<!--<form name="loginForm" action ="<c:url value='/drauto/login/drautoLogin.do'/>" method="post">-->	
	<input type="hidden" name="message" value="${message}">
	<input name="userSe" type="hidden" value="GNR"/>
	<input name="rdoSlctUsr" type="hidden" value="GNR"/>
    <input name="j_username" type="hidden"/>
	<div class="smbslogin">
	<h2 class="login-tit"><img src="/drauto/images/egovframework/drauto/login/im_login_tit.gif" width="495" height="94" alt="NCIA 서버관리업무 지원시스템로그인" /></h2>
	<fieldset>
		<legend>로그인</legend>
		<input type="hidden" name="ReturnUrl" value="" />
		<p class="id">
		<label for="login-id"><img src="/drauto/images/egovframework/drauto/login/im_login_id.gif" alt="아이디" /></label> 
		<input id="login-id" type="text" class="input1" name="id" title="아이디"  maxlength="15" />
		</p>
	
		<p class="pw">
		<label for="login-pw"><img src="/drauto/images/egovframework/drauto/login/im_login_pw.gif" alt="비밀번호" /></label>
		<input id="login-pw" type="password" class="input1" name="password" title="비밀번호"  maxlength="10" />
		</p>
	
		<p class="login-ok"><a href="#LINK" onClick="actionLogin();"><input type="image" src="/drauto/images/egovframework/drauto/login/btn_login.gif" width="80" height="41" alt="로그인"  /></a></p>
		<p class="login-join"><a href="#" onClick="userInsertRequest();"><input type="image" src="/drauto/images/egovframework/drauto/login/btn_login_join.gif" width="120" height="28" alt="사용자신청"  /></a></p>
	</fieldset>

	</div>
	</form>
</body>
</html>


