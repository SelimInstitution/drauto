<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
 /**
  * @Class Name : EgovServerManage_Main.jsp
  * @Description : ServerManage Main Page
  * @Modification Information
  * @
  * @  수정일         수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2012.02.02 최장성              최초 생성
  *
  *
  */

%>

<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ServerManage Main frame</title>
</head>
<frameset rows="70,*" frameborder="0" >
	<frame src="<c:url value='/sysmng/svm/serverManageSearch.do' />" scrolling="no" name="server_top" marginwidth="0" marginheight="0">
	<frameset cols="50%,50%" frameborder="0">
		<frame src="<c:url value='/sysmng/svm/selectServerList.do' />" scrolling="no" name="server_left" marginwidth="0" marginheight="0">
		<frame src="<c:url value='/sysmng/svm/selectServerList.do' />" scrolling="no" name="server_right" marginwidth="0" marginheight="0">
	</frameset>
</frameset>
</html>
