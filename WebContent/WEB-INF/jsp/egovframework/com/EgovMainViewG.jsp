<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="egovframework.com.cmm.util.EgovUserDetailsHelper" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>정부통합전산센터 서버관리업무지원시스템</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drautohead.css'/>" type="text/css">
</head>
<script language="javascript" src="/js/egovframework/main.js"></script>
<script type="text/javascript">
	function fn_egov_headPageMove(menuNo, url){
		document.selectOne.menuNo.value=menuNo;
		document.selectOne.chkURL.value=url;
	    document.selectOne.action = "<c:url value='/sym/mnu/mpm/EgovMainMenuIndex.do'/>";
	    document.selectOne.submit();
	}
	
	

	function actionLogout()
	{
		//document.selectOne.action = "<c:url value='/uat/uia/actionLogout.do'/>";
		document.selectOne.action = "<c:url value='/drauto/login/drautoLogout.do'/>";
		document.selectOne.submit();
		//top.document.location.href = "<c:url value='/j_spring_security_logout'/>";
	}
	
	function chk_all(val) {

		var arr_chk = document.getElementsByName("chk");

			if (val == "Y") {

				for(i=0;i< arr_chk.length; i++) {
					arr_chk[i].checked =true;
				}
			}
			else if(val == "N") {
				for(i=0;i< arr_chk.length; i++) {
					arr_chk[i].checked =false;
				}
			}

	}	
</script>
<body>

 <div class="accessibility">
	<p><a href="#content">메뉴 건너뛰기</a></p>
</div>
<div id="smbswrap">
<form name="selectOne">
<input name="menuNo" type="hidden" />
<input name="chkURL" type="hidden" />
	<!--header 시작-->
	<div id="smbsheader">
		<h1><a href="<c:url value='/sym/mnu/mpm/EgovMainMenuHome.do' />" target="_top"><img src="<c:url value='/images/egovframework/drauto/main/im_logo.gif' />" alt="NCIA 서버관리업무지원시스템" /></a></h1>

		<h2 class="blind">대메뉴</h2>
			<ul class="gnb">
				<!--  <li><a href="<c:url value='/sym/mnu/mpm/EgovMainMenuHome.do' />" target="_top">HOME</a></li>-->
				<c:forEach var="result" items="${list_headmenu}" varStatus="status">
				   <li><a href="javascript:fn_egov_headPageMove('<c:out value="${result.menuNo}"/>','<c:out value="${result.chkURL}"/>')"><c:out value="${result.menuNm}"/></a></li>
                </c:forEach>				
			</ul>

		<h3 class="blind">로그인 정보</h3>
			<ul class="user">
				<li class="name">${loginVO.name} 님</li>
				<li class="date">로그인하셨습니다.</li>
				<% if(EgovUserDetailsHelper.isAuthenticated()) { %>
				<li class="btn"><a href="javascript:actionLogout();"><img src="<c:url value='/images/egovframework/drauto/main/bt_logout.gif' />" alt="로그아웃" /></a></li>
				<% } %>
			</ul>
	</div>
	<hr />
	<!--header 끝-->
	</form>


	<div id="smbsheadcon">
			<p class="intro_visual"><img src="/drauto/images/egovframework/drauto/main/im_main_bg.gif" alt="대표이미지" /></p>
	</div>


	<!--footer 시작-->
	<div id="smbsfooter">
		<p class="copyright"><img src="<c:url value='/images/egovframework/drauto/main/im_copy.gif' />" alt="copyright(c) 2012 national computing & information agency all rights researved." /></p>
	</div>
</div>
</body>
</html>



