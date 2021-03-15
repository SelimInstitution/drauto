<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>단위작업 추가</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">

<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />" ></script>
<script type="text/javaScript" language="javascript" defer="defer">

	var check_ip_adres = '<c:out value="${param.ipAdres}" />';
	var check_acnt_id = '<c:out value="${param.acntId}" />';
	var check_prtcl_code = '<c:out value="${param.prtclCode}" />';
	
	function loaded() {
		var insertAt = '<c:out value="${insertAt}"/>';
		var resultMsg = '<c:out value="${resultMsg}"/>';
		if(resultMsg == 'true'){
			alert("작업순번이 중복되어 변경하였습니다.");
		}
		if (insertAt == 'true') {
			alert("저장되었습니다.");
			$("#checkOpertGroupId",opener.document).val(document.unitOpertAdit.opertGroupId.value);	
			opener.searchOpertGroup.submit();
			/* var param = "searchUseYn=Y";
			param += "&opertGroupNm="+document.unitOpertAdit.opertGroupNm.value;
			param += "&checkOpertGroupId="+document.unitOpertAdit.opertGroupId.value;
			param += "&pageIndex="+document.unitOpertAdit.pageIndex.value;
		
			opener.location.href = '<c:url value='/ply/opertManage.do' />?'+param; */
			//opener.window.location.reload();
		}	
	}

	// IP 선택
	function checkIpAdres(ipAdres) {
		var param = "&opertGroupNm="+document.unitOpertAdit.opertGroupNm.value;
		param += "&pageIndex="+document.unitOpertAdit.pageIndex.value;
		
		check_ip_adres = ipAdres;
		location.href = "<c:url value="${'/ply/unitOpertAditView.do'}" />?opertGroupId=<c:out value="${param.opertGroupId}" />&ipAdres="+ipAdres+param;
	}
	
	// 계정 선택
	function checkAcntId(acntId) {
		var param = "&opertGroupNm="+document.unitOpertAdit.opertGroupNm.value;
		param += "&pageIndex="+document.unitOpertAdit.pageIndex.value;
		check_acnt_id = acntId;
		location.href = "<c:url value="${'/ply/unitOpertAditView.do'}" />?opertGroupId=<c:out value="${param.opertGroupId}" />&ipAdres="+check_ip_adres+"&acntId="+acntId+param;
	}
	
	// 프로토콜 선택
	function checkPrtclCode(prtclCode) {
		check_prtcl_code = prtclCode;
	}
	
	// 단위작업 저장
	function checkSubmit() {
		if (check_ip_adres == '') {
			alert("IP를 선택하세요.");
			return false;
		}
		if (check_acnt_id == '') {
			alert("계정 ID를 선택하세요.");
			return false;
		}
		if (check_prtcl_code == '') {
			alert("프로토콜을 선택하세요.");
			return false;
		}
		if (document.unitOpertAdit.opertSn.value == '') {
			alert("작업순번을 선택하세요.");
			return false;
		}
		if (document.unitOpertAdit.opertCn.value == '') {
			alert("작업내용을 입력하세요.");
			return false;
		}

		document.unitOpertAdit.submit();
	}
	
	function onlyNum(obj) {
		var str = obj.value;
		obj.value = str.replace(/[^0-9]/g, '');
	}
</script>
</head>


<body onload="loaded();" class="contPop">
	<form name="unitOpertAdit" method="post" action="<c:url value="${'/ply/insertUnitOpert.do'}" />">
	<input type="hidden" name="opertGroupId" value="<c:out value="${param.opertGroupId}" />" />
	<input type="hidden" name="opertGroupNm" value="<c:out value="${param.opertGroupNm}"/>" />
	<input type="hidden" name="pageIndex" value="<c:out value="${param.pageIndex}"/>" />	
	<input type="hidden" name="crtrId" value="<c:out value="${loginVO.id}" />" />
	
	<div class="PopupTop">
		<h1>단위작업 추가</h1>
	</div>
	
	<div class="Popup">
		
		<div class="TBTop">
			<fieldset>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr>
						<th class="left" width="20%">서버 IP</th>
						<td>
							<select name="ipAdres" id="#" style="width: 90%" onchange="checkIpAdres(this.options[this.selectedIndex].value);" />
								<option value="">선택</option>
								<c:forEach var="ipAdresList" items="${ipAdresList}" varStatus="status">
								<option value="<c:out value="${ipAdresList.IP_ADRES}" />" <c:if test="${param.ipAdres == ipAdresList.IP_ADRES}">selected</c:if>><c:out value="${ipAdresList.IP_ADRES}" /></option>
								</c:forEach>
							</select>
						</td>
						<th class="left" width="20%">계정 ID</th>
						<td>
							<select name="acntId" id="#" style="width: 90%" onchange="checkAcntId(this.options[this.selectedIndex].value);" />
								<option value="">선택</option>
								<c:forEach var="acntList" items="${acntList}" varStatus="status">
								<option value="<c:out value="${acntList.ACNT_ID}" />" <c:if test="${param.acntId == acntList.ACNT_ID}">selected</c:if>><c:out value="${acntList.ACNT_ID}" /></option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th class="left">프로토콜</th>
						<td>
							<select name="prtclCode" id="#" style="width: 90%" onchange="checkPrtclCode(this.options[this.selectedIndex].value);" />
								<option value="">선택</option>
								<c:forEach var="prtclList" items="${prtclList}" varStatus="status">
								<option value="<c:out value="${prtclList.PRTCL_CODE}" />"><c:out value="${prtclList.PRTCL_NM}" /></option>
								</c:forEach>
							</select>
						</td>
						<th class="left">작업순번</th>
						<td><input type="text" name="opertSn" style="width: 90%; ime-mode:disabled" onkeyup="onlyNum(this);" onchange="onlyNum(this);"/></td>
					</tr>

					<tr>
						<th class="left">단위작업명</th>
						<td colspan="3"><input type="text" name="unitOpertNm" style="width: 95%" /></td>
					</tr>
				</table>
			</fieldset>
		</div>

		<div class="TB_head">
			<p class="hd">단위작업 설명</p>
			<p class="buttonSet">
				<span class="text"><input name="executBfeCnfirmAt" type="checkbox" value="Y" />실행 전 확인 여부</span>
			</p>
			<textarea name="unitOpertDc" style="width: 99%" rows="8"></textarea>

			<p class="hd">작업내용</p>
			<textarea name="opertCn" style="width: 99%" rows="20"></textarea>
		</div>

		<div class="Fbt">
			<span class="btn_pack bt01"><button type="button" onclick="checkSubmit();">저장</button></span>
			<span class="btn_pack bt01"><button type="button" onclick="javascrip:window.close();">닫기</button></span>
		</div>

	</div>
	</form>
</body>
</html>