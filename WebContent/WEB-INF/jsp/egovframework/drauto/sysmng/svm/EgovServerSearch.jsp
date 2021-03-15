<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
 /**
  * @Class Name : EgovServerManage.java
  * @Description : EgovServerManage List 화면
  * @Modification Information
  * @
  * @  수정일                     수정자                    수정내용
  * @ -------       --------    ---------------------------
  * @ 2012.02.03    최장성              최초 생성
  *
  *
  */
%>

<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/css/egovframework/com/cmm/com.css' />" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/button.css' />" type="text/css">
<title>서버관리</title>

<script type="text/javaScript" language="javascript" defer="defer">
<!--

function fncServerList(){
    document.searchForm.action = "<c:url value='/sysmng/svm/selectServerList.do'/>";
    document.searchForm.target = "server_left";
    document.searchForm.submit();
}

function press() {
    if (event.keyCode==13) {
    	fncServerList();
    }
}

-->
</script>
</head>

<body>
<DIV id="main">

<table border="0">
  <tr>
    <td width="700">

<form name="searchForm" action="" method="post">
<table width="100%" cellpadding="8" class="table-search" border="0">
 <tr>
  <td width="10%">서버 IP</td>
  <td width="35%">: <input name="S_IP_ADRES" type="text" value="" size="25" maxlength="15" title="서버 IP" onkeypress="press();" /></td>
  <td width="10%">장비명</td>
  <td width="35%">: <input name="S_EQPMN_NM" type="text" value="" size="25" maxlength="200" title="장비명" onkeypress="press();" /></td>
  <th width="10%"></th>
 </tr>
 <tr>
  <td>OS</td>
  <td>:
   <select name="S_OS_CODE" id="S_OS_CODE" title="OS">
  	<option value="">전체</option>
   	<c:forEach var="s_option" items="${os_result}">
   	 <option value="<c:out value='${s_option.code}'/>"><c:out value='${s_option.codeNm}'/></option>
   	</c:forEach>
   </select>
  </td>
  <td>프로토콜</td>
  <td>:
   <select name="S_PRTCL_KIND_CODE" id="S_PRTCL_KIND_CODE" title="프로토콜">
  	<option value="">전체</option>
   	<c:forEach var="s_option" items="${prtcl_result}">
   	 <option value="<c:out value='${s_option.code}'/>"><c:out value='${s_option.codeNm}'/></option>
   	</c:forEach>
   </select>

  <th>
   <table border="0" cellspacing="0" cellpadding="0">
    <tr>
     <!-- 검색 -->
     <td><span class="button"><a href="#LINK" onclick="javascript:fncServerList()"><spring:message code="button.search" /></a></span>&nbsp;</td>
    </tr>
   </table>
  </th>
 </tr>
</table>
<input type="hidden" name="pageIndex" value="1"/>
</form>
</td>
</tr>
</table>
</div>
</body>
</html>
