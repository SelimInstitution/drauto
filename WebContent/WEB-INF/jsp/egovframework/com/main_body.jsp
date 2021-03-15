<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%-- <link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">--%>
<title>서버관리업무지원시스템</title>
<script type="text/javascript">
var getContextPath = "${pageContext.request.contextPath}";
</script>
<script language="javascript" src="<c:url value='/js/egovframework/com/main.js' />"></script>
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
<style type="text/css">

#wrap { position:relative;  margin:0 15px 0 15px;  }

/* main images */
.intro_visual {position:relative; margin:84px 0 0 0; width:951px; height:449px; background:url(/drauto/images/egovframework/drauto/main/im_main_bg.gif) no-repeat;}


</style>
<body topmargin="0" leftmargin="0">
<div id="wrap">
<div id="container">

		<!--content  시작-->
		<div id="content">

			<p class="intro_visual"></p>


		</div>
		<!--content 끝-->
	</div>
</div>
</body>
</html>
