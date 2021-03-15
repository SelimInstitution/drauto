<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>정부통합전산센터 서버관리업무지원시스템</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">
<script type="text/javaScript" language="javascript" defer="defer">
function drPop() {

	window.open("<c:url value='/dr/selectDrfList.do'/>?opertDiv=<c:out value="${param.opertDiv}" />&opertTyCode=<c:out value="${param.opertTyCode}" />",	"drPop", "width=1100, height=650, resizable=yes, scrollbars=yes");
	//window.open("<c:url value='/dr/selectDrList.do'/>",	"drPop", "width=1100, height=650, resizable=yes");
	//location.href = "<c:url value='/ply/executBfeCnfirm.do'/>?opertGrpId="+opertGrpId+"&unitOpert="+unitOpert+"&ip="+ip+"&acntId="+acntId+"&prtcl="+prtcl;
}

window.onload = function() {
	drPop();
}
</script>
</head>


<body>
DR작업현황
</body>
</html>