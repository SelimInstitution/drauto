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
  * @ 2012.02.02    최장성              최초 생성
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

function fnServerInsert() {
    location.replace("<c:url value='/sysmng/svm/EgovServerInsert.do'/>");
}

function fnServerUpdate() {
    location.replace("<c:url value='/sysmng/svm/EgovServerUpdate.do'/>");
}

function fnServerDelete() {
	if(confirm("삭제하시겠습니까?")) {
		document.listForm.action = "<c:url value='/sysmng/svm/EgovServerDelete.do'/>";
		document.listForm.submit();
	}
}

function linkPage(pageNo){
    document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/sysmng/svm/selectServerList.do'/>";
    document.listForm.submit();
}

function fnInit(){
    document.searchForm.action = "<c:url value='/sysmng/svm/selectServerList.do'/>";
    document.searchForm.target = "server_right";
    document.searchForm.submit();
}

-->
</script>

</head>

<body onLoad="fnInit();">
<div id="border">

<table border="0" width="100%">
  <tr>
    <td>

<form:form name="listForm" action="${pageContext.request.contextPath}/sysmng/svm/selectServerList.do" method="post">
<table width="100%" cellpadding="8" class="table-search" border="0">
 <tr>
  <td width="40%" class="title_left">
   <img src="<c:url value='/images/egovframework/com/cmm/icon/tit_icon.gif' />" width="16" height="16" hspace="3" align="middle" alt="제목아이콘이미지">&nbsp;서버 관리</td>
  <td width="60%" align="right">
   <table border="0" cellspacing="0" cellpadding="0">
    <tr>
     <!-- 등록 -->
     <td><span class="button"><a href="#LINK" onclick="javascript:fncServerList()"><spring:message code="button.create" /></a></span>&nbsp;</td>
     <!-- 수정 -->
     <td><span class="button"><a href="#LINK" onclick="javascript:fncServerList()"><spring:message code="button.update" /></a></span>&nbsp;</td>
     <!-- 삭제 -->
     <td><span class="button"><a href="#LINK" onclick="javascript:fncServerList()"><spring:message code="button.delete" /></a></span>&nbsp;</td>
    </tr>
   </table>
  </td>
 </tr>
</table>
<table width="100%" cellpadding="8" class="table-line" summary="서버관리에  관한 테이블입니다.서버IP, 장비명, 장비설명, OS명, 서버삭제여부의 내용을 담고 있습니다.">
 <thead>
  <tr>
    <th class="title" width="15%" scope="col" nowrap="nowrap">서버 IP</th>
    <th class="title" width="25%" scope="col" nowrap="nowrap">장비명</th>
    <th class="title" width="40%" scope="col" nowrap="nowrap">장비설명</th>
    <th class="title" width="15%" scope="col" nowrap="nowrap">OS명</th>
    <th class="title" width="5%" scope="col" nowrap="nowrap">상태</th>
  </tr>
 </thead>
 <tbody>
  <%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
 <c:if test="${fn:length(resultList) == 0}">
 <tr>
 <td class="lt_text3" colspan="5">
	<spring:message code="common.nodata.msg" />
 </td>
 </tr>
 </c:if>
 <c:forEach var="server" items="${resultList}">
  <tr <c:if test="${server.rn == server.rowNo}">class="tr_bgcolor"</c:if> onClick="">
    <td class="lt_text3" nowrap="nowrap"><c:out value="${server.ip_adres}"/></td>
    <td class="lt_text" nowrap="nowrap"><c:out value="${server.eqpmn_nm}"/></td>
    <td class="lt_text" nowrap="nowrap"><c:out value="${server.eqpmn_dc}"/></td>
    <td class="lt_text3" nowrap="nowrap"><c:out value="${server.os_nm}"/></td>
    <td class="lt_text3" nowrap="nowrap"><c:out value="${server.delete_at}"/></td>
    <input type="hidden" name="<c:out value='${serverVO.rn}'/>_rn" value="<c:out value='${serverVO.rn}'/>"/>
    <input type="hidden" name="<c:out value='${serverVO.rn}'/>_ip_adres" value="<c:out value='${server.ip_adres}'/>"/>
  </tr>
 </c:forEach>
 </tbody>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="10"></td>
  </tr>
</table>

<c:if test="${!empty serverVO.pageIndex }">
<div align="center">
    <div>
        <ui:pagination paginationInfo = "${paginationInfo}"
            type="image"
            jsFunction="linkPage"
            />
    </div>
    <div align="right">
        <input type="text" name="message" value="<c:out value='${message}'/>" size="30" readonly="readonly" title="메시지"/>
    </div>
</div>
</c:if>
<input type="hidden" name="rowNo" value="<c:out value='${serverVO.rowNo}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${serverVO.pageIndex}'/>"/>
<input type="hidden" name="S_IP_ADRES" value="<c:out value='${serverVO.ip_adres}'/>"/>
<input type="hidden" name="S_EQPMN_NM" value="<c:out value='${serverVO.eqpmn_nm}'/>"/>
<input type="hidden" name="S_OS_CODE" value="<c:out value='${serverVO.os_code}'/>"/>
<input type="hidden" name="S_PRTCL_KIND_CODE" value="<c:out value='${serverVO.prtcl_kind_code}'/>"/>
</form:form>
</td>
</tr>
</table>
</div>
</body>
</html>
