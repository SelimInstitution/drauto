<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>작업그룹 추가 및 수정</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">

<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />" ></script>
<script type="text/javaScript" language="javascript" defer="defer">

	var insertAt = '<c:out value="${insertAt}"/>';
	if (insertAt == 'true') {
		alert("저장되었습니다.");
		opener.location.href = '<c:url value='/ply/opertManage.do' />';
		//opener.window.location.reload();
	}

	function checkSave() {
		if (document.opertGroupAdit.opertGroupNm.value == '') {
			alert("작업그룹명을 입력하세요.");
			return false;
		}
		
		document.opertGroupAdit.submit();
	}
</script> 
</head>


<body class="contPop">
	<form name="opertGroupAdit" method="post" action="<c:url value='/ply/insertOpertGroup.do' />">
	<input type="hidden" name="crtrId" value="<c:out value="${loginVO.id}"/>">
	
	<div class="PopupTop">
		<h1>IP 등록</h1>
	</div>

	<!-- Contents start -->
	<div class="Popup">

		<div class="TBTop">
			<fieldset>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th class="left" width="20%">작업그룹종류</th>
						<td>
							<select name="opertGroupKindCode" id="#" style="width: 90%" />
								<option value="">선택</option>
								<c:forEach var="opertGroupKindList" items="${opertGroupKindList}" varStatus="status">
								<option value="<c:out value="${opertGroupKindList.CODE}" />"><c:out value="${opertGroupKindList.CODE_NM}" /></option>
								</c:forEach>
							</select>
						</td>					
					</tr>
					<tr>
						<th  class="left">작업그룹명</th>
						<td class="left"><input type="text" name="opertGroupNm" value="<c:out value="${param.opertGroupNm}" />" style="width: 90%" /></td>
					</tr>
				</table>
			</fieldset>
		</div>

		<p class="hd">작업그룹설명</p>
		<textarea name="opertGroupDc" style="width: 99%" rows="20"><c:out value="${param.opertGroupDc}" /></textarea>

		<div class="Fbt">
			<span class="btn_pack bt01"><button type="button" onclick="checkSave();">저장</button></span>
			<span class="btn_pack bt01"><button type="button" onclick="javascript:window.close();">닫기</button></span>
		</div>

	</div>
	<!--popup e-->
	</form>
</body>
</html>