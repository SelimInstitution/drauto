<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<%
 /**
  * @Class Name : EgovMainMenuIndex.jsp
  * @Description : MainMenuIndex Page
  * @Modification Information
  * @
  * @  수정일         수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.03.10    이용          최초 생성
  *
  *  @author 공통서비스 개발팀 이용
  *  @since 2009.03.10
  *  @version 1.0
  *  @see
  *  ?vStartP=<c:out value="${result.menuNo}"/> <c:out value="${result.chkURL}"/>
  */

%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>정부통합전산센터 서버관리업무지원시스템</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">
<script language="javascript">
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
</head>


<body>

<div class="accessibility">
	<p><a href="#content">메뉴 건너뛰기</a></p>
</div>
<hr />

<div id="smbswrap">


	<!--header 시작-->
		<tiles:insertAttribute name="header" />
	<hr />
	<!--header 끝-->

<div id="smbscontainer">

		<!--content  시작-->
	<div id="smbscontent">

		<!--왼쪽메뉴 시작-->

			<tiles:insertAttribute name="menu" />

		<hr />
		<!--왼쪽메뉴 끝-->	
		
<!--content  시작-->
		<!-- body 시작 -->
		<div id="smbsright">
			<tiles:insertAttribute name="body" />
		</div>
		<!-- body 끝 -->
<!--content 끝-->

	</div>
</div>

	<!--footer 시작-->
		<tiles:insertAttribute name="footer" />
	<!--footer 끝-->

</body>
</html>