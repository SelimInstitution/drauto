<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>작업그룹 수정</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">

<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />" ></script>
<script type="text/javaScript" language="javascript" defer="defer">

	function loaded() {
		var updtResult = '<c:out value="${updtResult}" />';
		
		var param = "searchUseYn=Y";
		param += "&opertGroupNm="+document.updateOpertGroup.o_opertGroupNm.value;
		param += "&opertGroupId="+document.updateOpertGroup.opertGroupId.value;
		param += "&checkOpertGroupId="+document.updateOpertGroup.opertGroupId.value;
		param += "&pageIndex="+document.updateOpertGroup.pageIndex.value;		
		
		if (updtResult > 0) {
			alert("수정되었습니다.");
			opener.location.href = "<c:url value='/ply/opertManage.do' />?"+param;
			//opener.window.location.reload();
		}
	}
	
	function updateCheck() {
		if (document.updateOpertGroup.opertGroupNm.value == '') {
			alert("작업그룹명을 입력하세요.");
			return false;
		}
		
		document.updateOpertGroup.submit();
	}
</script>
</head>


<body class="contPop" onload="loaded();">
	<form name="updateOpertGroup" method="post" action="<c:url value='/ply/updateOpertGroup.do' />">
	<input type="hidden" name="opertGroupId" value="<c:out value="${opertGroupList.opertGroupId}" />" />
	<input type="hidden" name="o_opertGroupNm" value="<c:out value="${param.o_opertGroupNm}"/>" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex}"/>" />
	<input type="hidden" name="updusrId" value="<c:out value="${loginVO.id}" />" />
	<div class="PopupTop">
		<h1>작업그룹 수정</h1>
	</div>

	<div class="Popup">

		<div class="TBTop">
			<fieldset>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th  class="left" width="20%">작업그룹종류</th>
						<td>
							<select name="opertGroupKindCode" id="#" style="width: 90%" />
								<option value="">선택</option>
								<c:forEach var="opertGroupKindList" items="${opertGroupKindList}" varStatus="status">
								<option value="<c:out value="${opertGroupKindList.CODE}" />" <c:if test="${opertGroupKindList.CODE == opertGroupList.opertGroupKindCode}">selected</c:if>><c:out value="${opertGroupKindList.CODE_NM}" /></option>
								</c:forEach>
							</select>
						</td>					
					</tr>				
					<tr>
						<th class="left">작업그룹명</th>
						<td class="left"><input type="text" name="opertGroupNm" value="<c:out value="${opertGroupList.opertGroupNm}" />" style="width: 90%" /></td>
					</tr>
				</table>
			</fieldset>
		</div>

		<p class="hd">작업그룹설명</p>
		<textarea name="opertGroupDc" style="width: 99%" rows="20"><c:out value="${opertGroupList.opertGroupDc}" /></textarea>

		<div class="Fbt">
			<span class="btn_pack bt01"><button type="button" onclick="updateCheck();">수정</button></span>
			<span class="btn_pack bt01"><button type="button" onclick="javascript:window.close();">닫기</button></span>
		</div>

	</div>
	</form>

</body>
</html>
