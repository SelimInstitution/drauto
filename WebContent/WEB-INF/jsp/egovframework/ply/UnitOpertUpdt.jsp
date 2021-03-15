<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>단위작업 수정</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">

<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />" ></script>
<script type="text/javaScript" language="javascript" defer="defer">
$(document).ready(function(){
	$('textarea[name=opertCn]').val($('textarea[name=opertCn]').val().replace(/<br\/>/g,'\r\n'));
});
	function loaded() {

		var updtResult = '<c:out value="${updtResult}"/>';
		var resultMsg = '<c:out value="${resultMsg}"/>';

		if(resultMsg == 'true'){
			alert("작업순번이 중복되어 변경하였습니다.");
		}		
		
		var param = "searchUseYn=Y";
		param += "&opertGroupNm="+document.unitOpertUpdt.opertGroupNm.value;
		param += "&checkOpertGroupId="+document.unitOpertUpdt.opertGroupId.value;
		param += "&checkUnitOpertId="+document.unitOpertUpdt.unitOpertId.value;
		param += "&checkIpAdres="+document.unitOpertUpdt.ipAdres.value;
		param += "&checkAcntId="+document.unitOpertUpdt.acntId.value;
		param += "&checkPrtclCode="+document.unitOpertUpdt.prtclCode.value;
		param += "&pageIndex="+document.unitOpertUpdt.pageIndex.value;

		if (updtResult > 0) {
			alert("수정되었습니다.");
			opener.unitOpertUpdt.submit();
			//opener.location.href = '<c:url value='/ply/opertManage.do' />?'+param;
			//opener.window.location.reload();
		}	
	}
	
	// 단위작업 저장
	function checkSubmit() {
	
		if (document.unitOpertUpdt.opertSn.value == '') {
			alert("작업순번을 선택하세요.");
			return false;
		}	
		if (document.unitOpertUpdt.opertCn.value == '') {
			alert("작업내용을 입력하세요.");
			return false;
		}
		
		var $textArea = $('textarea[name=opertCn]'), 
	    text = $textArea.html(), 
	    convertText = text.replace( /\n/gi, '<br/>');
		$textArea.val(convertText);
		
		document.unitOpertUpdt.submit();
	}

	function onlyNum(obj) {
		var str = obj.value;
		obj.value = str.replace(/[^0-9]/g, '');
	}	
</script>
</head>


<body onload="loaded();" class="contPop">

	<form name="unitOpertUpdt" method="post" action="<c:url value="${'/ply/updateUnitOpert.do'}" />">
	<input type="hidden" name="ipAdres" value="<c:out value="${unitOpertList.ipAdres}" />" />
	<input type="hidden" name="acntId" value="<c:out value="${unitOpertList.acntId}" />" />
	<input type="hidden" name="prtclCode" value="<c:out value="${unitOpertList.prtclCode}" />" />
	<input type="hidden" name="opertGroupId" value="<c:out value="${unitOpertList.opertGroupId}" />" />
	<input type="hidden" name="unitOpertId" value="<c:out value="${unitOpertList.unitOpertId}" />" />
	<input type="hidden" name="opertGroupNm" value="<c:out value="${param.opertGroupNm}"/>" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex}"/>" />
	<input type="hidden" name="updusrId" value="<c:out value="${loginVO.id}" />" />
	
	<div class="PopupTop">
		<h1>단위작업 수정</h1>
	</div>
	
	<div class="Popup">
		<div class="TBTop">
			<fieldset>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr>
						<th class="left" width="20%">서버 IP</th>
						<td><c:out value="${unitOpertList.ipAdres}" /></td>
						<th class="left" width="20%">계정 ID</th>
						<td width="30%"><c:out value="${unitOpertList.acntId}" /></td>
					</tr>
					<tr>
						<th class="left">프로토콜</th>
						<td><c:out value="${unitOpertList.prtclNm}" /></td>
						<th class="left">작업순번</th>
						<td><input type="text" name="opertSn" value="<c:out value="${unitOpertList.opertSn}" />" style="width:90%;ime-mode:disabled" 
						onkeyup="onlyNum(this);" onchange="onlyNum(this);" />
						<input type="hidden" name="opertSn_cp" value="<c:out value="${unitOpertList.opertSn}" />" />
						</td>
					</tr>

					<tr>
						<th class="left">단위작업명</th>
						<td colspan="3"><input type="text" name="unitOpertNm" value="<c:out value="${unitOpertList.unitOpertNm}" />" style="width:96%" /></td>
					</tr>
				</table>
			</fieldset>
		</div>

		<div class="TB_head">
			<p class="hd">단위작업 설명</p>
			<p class="buttonSet">
				<span class="text"><input name="executBfeCnfirmAt" type="checkbox" value="Y" <c:if test="${unitOpertList.executBfeCnfirmAt == 'Y'}">checked</c:if> />실행 전 확인 여부</span>
			</p>
			<textarea type="textarea" name="unitOpertDc" style="width: 99%" rows="8"><c:out value="${unitOpertList.unitOpertDc}" /></textarea>

			<p class="hd">작업내용</p>
			<textarea type="textarea" name="opertCn" style="width: 99%" rows="20"><c:out value="${unitOpertList.opertCn}" /></textarea>
		</div>

		<div class="Fbt">
			<span class="btn_pack bt01"><button type="button" onclick="checkSubmit();">저장</button></span>
			<span class="btn_pack bt01"><button type="button" onclick="javascript:window.close();">닫기</button></span>
		</div>

	</div>
	</form>
</body>
</html>