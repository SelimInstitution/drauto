<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>정부통합전산센터 서버관리업무지원시스템</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">

<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />" ></script>
<script type="text/javaScript" language="javascript" defer="defer">

	var check_opert_group_id = '<c:out value="${param.checkOpertGroupId}"/>';
	var check_ip_adres = '<c:out value="${param.checkIpAdres}"/>';
	var check_acnt_id = '<c:out value="${param.checkAcntId}"/>';
	var check_prtcl_code = '<c:out value="${param.checkPrtclCode}"/>';
	var check_unit_opert_id = '<c:out value="${param.checkUnitOpertId}"/>';
	var check_unit_opert_nm = '';
	
	var page_index = '<c:out value="${param.pageIndex}"/>';
	if (page_index == '') page_index = '1'; 
	
	var deleteResult = '<c:out value="${deleteResult}" />';

	if (deleteResult > 0) {
		alert("삭제여부가 변경되었습니다..");
		//window.location.reload();
	}

	// 페이지 이동
	function opertGroupLinkPage(pageNo){
		var search_param = "&searchUseYn=Y&opertGroupNm=<c:out value="${param.opertGroupNm}"/>";
		location.href = "<c:url value='/ply/opertManage.do' />?pageIndex="+pageNo+search_param;
	}
	
	// 작업그룹 리스트 클릭
	function opertGroup(obj, group_id) {
		check_opert_group_id = group_id;
		
		var search_param = "&searchUseYn=Y&opertGroupNm=<c:out value="${param.opertGroupNm}"/>";

		for (i=1; i<opert_group_list.rows.length; i++) {
			if (obj == opert_group_list.rows[i]) opert_group_list.rows[i].bgColor = '#FFD277';
			else opert_group_list.rows[i].bgColor = '';
		}
		$("#searchUseYn").val('<c:out value="${param.searchUseYn}" />');
		$("#pageIndex").val(page_index);
		$("#checkOpertGroupId").val(check_opert_group_id);
		
		$("form[name=searchOpertGroup]").submit();
		
		<%--//location.href = "<c:url value='/ply/opertManage.do' />?checkOpertGroupId="+check_opert_group_id+"&opertGroupNm="+encodeURIComponent(document.searchOpertGroup.opertGroupNm.value)+"&searchUseYn=<c:out value="${param.searchUseYn}" />&pageIndex="+page_index;--%>
	}
	
	// 작업그룹 추가 화면
	function fnOpertGroupAdit() {
		window.open("<c:url value='/ply/opertGroupAditView.do' />", "opertGroupAditView", "width=600, height=540, scroll=no");
	}
	
	// 작업그룹 수정
	function fnOpertGroupUpdt() {
		var param = "searchUseYn=N";
		param += "&o_opertGroupNm=<c:out value="${param.opertGroupNm}"/>";
		param += "&opertGroupId="+check_opert_group_id;
		param += "&unitOpertId="+check_unit_opert_id;
		param += "&pageIndex="+page_index;
		
		if (check_opert_group_id == '') {
			alert("수정할 작업그룹을 선택하세요.");
			return false;
		}
		window.open("<c:url value='/ply/updateOpertGroupView.do' />?"+param, "popup", "width=600, height=540, scroll=no");
	}
	
	// 작업그룹 삭제
	function fnOpertGroupDelete() {
		var search_param = "&searchUseYn=Y&opertGroupNm=<c:out value="${param.opertGroupNm}"/>&checkOpertGroupId=<c:out value="${param.checkOpertGroupId}"/>&pageIndex="+page_index;
		
		if (check_opert_group_id == '') {
			alert("삭제할 작업그룹을 선택하세요.");
			return false;
		}
		
		if (!confirm('삭제여부를 수정하시겠습니까?')) {
			return false;
		}
		location.href = "<c:url value='/ply/deleteOpertGroup.do' />?opertGroupId="+check_opert_group_id+search_param;
	}
	
	// 단위작업 리스트 클릭
	function unitOpert(obj, ip_adres, acnt_id, prtcl_code, opert_group_id, unit_opert_id, unit_opert_nm) {
		check_ip_adres = ip_adres;
		check_acnt_id = acnt_id;
		check_prtcl_code = prtcl_code;
		check_opert_group_id = opert_group_id;
		check_unit_opert_id = unit_opert_id;
		check_unit_opert_nm = unit_opert_nm;

		for (i=1; i<unit_opert_list.rows.length; i++) {
			if (obj == unit_opert_list.rows[i]) unit_opert_list.rows[i].bgColor = '#FFD277';
			else unit_opert_list.rows[i].bgColor = '';
		}
	}
	
	// 단위작업 추가 화면
	function fnUnitOpertAdit() {
		var param = "searchUseYn=N";
		param += "&opertGroupNm=<c:out value="${param.opertGroupNm}"/>";
		param += "&opertGroupId="+check_opert_group_id;
		param += "&pageIndex="+page_index;
		
		if (check_opert_group_id == '') {
			alert("단위작업이 추가될 작업그룹을 선택하세요.");
			return false;
		}
		window.open("<c:url value='/ply/unitOpertAditView.do' />?"+param, "unitOpertAditView", "width=600, height=690, scroll=no");
	}
	
	// 단위작업 수정
	function fnUnitOpertUpdt() {
		var param = "searchUseYn=N";
		param += "&opertGroupNm=<c:out value="${param.opertGroupNm}"/>";
		param += "&opertGroupId="+check_opert_group_id;
		param += "&unitOpertId="+check_unit_opert_id;
		param += "&pageIndex="+page_index;
		
		if (check_opert_group_id == '') {
			alert("작업그룹과 수정할 단위작업을 선택하세요.");
			return false;
		}		
		if (check_unit_opert_id == '') {
			alert("수정할 단위작업을 선택하세요.");
			return false;
		}
		window.open("<c:url value='/ply/updateUnitOpertView.do' />?"+param, "popup", "width=600, height=690, scroll=no");
	} 
	
	// 단위작업 삭제
	function fnUnitOpertDelete() {
		var search_param = "&searchUseYn=Y&opertGroupNm=<c:out value="${param.opertGroupNm}"/>&pageIndex="+page_index;
		
		if (check_opert_group_id == '') {
			alert("작업그룹과 삭제할 단위작업을 선택하세요.");
			return false;
		}		

		if (check_unit_opert_id == '') {
			alert("삭제할 단위작업을 선택하세요.");
			return false;
		}
		
		 if (!confirm(check_unit_opert_nm+' 의 삭제여부를 수정하시겠습니까?')) {
			 return false;
		 }
		 
		 var param = "ipAdres="+check_ip_adres;
		 param += "&checkIpAdres="+check_ip_adres;
		 param += "&acntId="+check_acnt_id;
		 param += "&checkAcntId="+check_acnt_id;
		 param += "&prtclCode="+check_prtcl_code;
		 param += "&checkPrtclCode="+check_prtcl_code;
		 param += "&opertGroupId="+check_opert_group_id;
		 param += "&unitOpertId="+check_unit_opert_id;
		 param += "&checkOpertGroupId="+check_opert_group_id;
		 param += "&checkUnitOpertId="+check_unit_opert_id+search_param;
		
		location.href = "<c:url value='/ply/deleteUnitOpert.do' />?"+param;
	}
</script> 
</head>


<body>
	<div id="smbsright">
	<form name="searchOpertGroup" method="post" action="<c:url value='/ply/opertManage.do' />">
	<input type="hidden" name="searchUseYn" value="Y" />
	<input type="hidden" name="pageIndex" value="1" />
	<input type="hidden" name="checkOpertGroupId" id="checkOpertGroupId" value="0" />
		<div class="TBTop">
			<fieldset>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
           	<tr>
            <th width="80px" class="right">작업그룹명</th>
				<td><input type="text" name="opertGroupNm" value="<c:out value="${param.opertGroupNm}" />" style="width:98%" /></td>
				<td><input type="image"	src="/drauto/images/egovframework/drauto/main/btn_search.gif" alt="검색" onclick="javascript:document.searchOpertGroup.submit();"/></td>
			</tr>
         	</table>
			</fieldset>
		</div>
	</form>

		<div class="TB_head">
			<span class="hd">작업그룹 (<c:out value="${opertGroupListTotCnt}"/>)</span>
			<span class="buttonSet">
				<span class="btn_pack bt01"><button type="button" onclick="fnOpertGroupAdit();">추가</button></span>
				<span class="btn_pack bt01"><button type="button" onclick="fnOpertGroupUpdt();">수정</button></span>
				<span class="btn_pack bt01"><button type="button" onclick="fnOpertGroupDelete();">삭제</button></span>
			</span>
		</div>

		<table class="dataTable" id="opert_group_list">

			<thead>
				<tr>
					<th width="40">NO</th>
					<th>작업그룹명</th>
					<th>작업그룹 설명</th>
					<th width="40">삭제</th>
					<th width="100">생성자</th>
					<th width="150">생성일자</th>
				</tr>
			</thead>
			
			<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(opertGroupList) == 0}">
				<tr>
					<td class="lt_text3" colspan="6" align="center"><spring:message code="common.nodata.msg" /></td>
				</tr>
			</c:if>
			<c:forEach var="opertGroupList" items="${opertGroupList}" varStatus="status">
				<tr onclick="opertGroup(this, <c:out value="${opertGroupList.opertGroupId}"/>)" 
				    ondblclick="fnOpertGroupUpdt();" <c:if test="${param.checkOpertGroupId == opertGroupList.opertGroupId}">bgColor = '#FFD277'</c:if>>
					<td class="center"><c:out value="${opertGroupList.rnum}"/></td>
					<td><c:out value="${opertGroupList.opertGroupNm}"/></td>
					<td><c:out value="${opertGroupList.opertGroupDc}"/></td>
					<td class="center"><c:out value="${opertGroupList.deleteAt}"/></td>
					<td class="center"><c:out value="${opertGroupList.crtrId}"/></td>
					<td class="center"><c:out value="${opertGroupList.creatDt}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<!--게시물 페이지 번호시작-->        
		<c:if test="${!empty opertGroupVO.pageIndex }">
		<div align="center" class="boardNavigation">
			<div class="pagination">
				<ui:pagination paginationInfo = "${opertGroupPaginationInfo}" type="image" jsFunction="opertGroupLinkPage"/>
			</div>
		</div>
		</c:if>
		<!--게시물 페이지 번호끝-->

		<div class="TB_head">
			<span class="hd">단위작업 (<c:out value="${unitOpertListTotCnt}"/>)</span>
			<span class="buttonSet">
				<span class="btn_pack bt01"><button type="button" onclick="fnUnitOpertAdit()">추가</button></span>
				<span class="btn_pack bt01"><button type="button" onclick="fnUnitOpertUpdt();">수정</button></span>
				<span class="btn_pack bt01"><button type="button" onclick="fnUnitOpertDelete();">삭제</button></span>
			</span>
		</div>


		<table class="dataTable" id="unit_opert_list">
			<thead>
				<tr>
					<th width="40">순번</th>
					<th>단위작업명</th>
					<th>단위작업명 설명</th>
					<th width="100">서버 IP</th>
					<th width="100">계정ID</th>
					<th width="40">확인</th>
					<th width="40">삭제</th>
					<th width="100">생성자</th>
					<th width="150">생성일자</th>
				</tr>
			</thead>
			<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(unitOpertList) == 0}">
				<tr>
					<td class="lt_text3" colspan="9" align="center"><spring:message code="common.nodata.msg" /></td>
				</tr>
			</c:if>
			<c:forEach var="unitOpertList" items="${unitOpertList}" varStatus="status">
				<tr ondblclick="fnUnitOpertUpdt();"
					<c:if test="${param.checkUnitOpertId == unitOpertList.unitOpertId}">bgColor = '#FFD277'</c:if>
				    onclick="unitOpert(this, '<c:out value="${unitOpertList.ipAdres}"/>', '<c:out value="${unitOpertList.acntId}"/>', '<c:out value="${unitOpertList.prtclCode}"/>', '<c:out value="${unitOpertList.opertGroupId}"/>', '<c:out value="${unitOpertList.unitOpertId}"/>', '<c:out value="${unitOpertList.unitOpertNm}" />');" >
					<td class="center"><c:out value="${unitOpertList.opertSn}" /></td>
					<td><c:out value="${unitOpertList.unitOpertNm}" /></td>
					<td><c:out value="${unitOpertList.unitOpertDc}" /></td>
					<td><c:out value="${unitOpertList.ipAdres}" /></td>
					<td><c:out value="${unitOpertList.acntId}" /></td>
					<td class="center"><c:out value="${unitOpertList.executBfeCnfirmAt}" /></td>
					<td class="center"><c:out value="${unitOpertList.deleteAt}" /></td>
					<td class="center"><c:out value="${unitOpertList.crtrId}" /></td>
					<td class="center"><c:out value="${unitOpertList.creatDt}" /></td>
				</tr>
			</c:forEach>

			</tbody>
		</table>

	</div>
</body>
</html>