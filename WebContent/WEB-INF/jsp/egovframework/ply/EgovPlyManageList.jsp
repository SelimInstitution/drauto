<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>정부통합전산센터 서버관리업무지원시스템</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />" ></script>
<script type="text/javaScript" language="javascript" defer="defer">
	var xx;
	
	function fnOpertGrp() {
	    grpCode = searchForm.grpCode.value;
	    searchForm.gpcode.value = grpCode;
	    document.searchForm.pageIndex.value = 1;
	    document.searchForm.action = "<c:url value='/ply/selectOpertGrpList.do'/>";
	    document.searchForm.submit();
	}
	
	
	//결과보기

	function fnResultPop() {
		var userid = document.groupForm.userid.value;
		var opertGrpId = document.unitForm.opertGrpId.value;
		var unitOpert = document.unitForm.unitOpert.value;
		var ip = document.unitForm.ip.value;
		var acntId = document.unitForm.acntId.value;
		var prtcl = document.unitForm.prtcl.value;
		var execut = document.unitForm.executdt.value;
		var opertExecutDt = document.unitForm.opertGrpExecutdt.value;
		var enddt = document.unitForm.enddt.value;
		var nextrow = document.unitForm.rn.value;
		//alert("opertGrpId="	+ opertGrpId + "&unitOpert=" + unitOpert + "&ip=" + ip + "&acntId=" + acntId + "&prtcl=" + prtcl + "&userid=" + userid+ "resultPop"+opertGrpId);
		if(opertExecutDt =="" && execut == ""){
			alert("작업 결과가 없습니다.");
			return false;
		}
		window.open("<c:url value='/ply/playSamplePopup.do'/>?opertGrpId="
				+ opertGrpId + "&unitOpert=" + unitOpert + "&ip=" + ip
				+ "&acntId=" + acntId + "&prtcl=" + prtcl + "&userid=" + userid,
				"resultPop"+opertGrpId+unitOpert, "width=800, height=650");
	}


	//실행
	
	function fnPlyExe() {

		var userid = document.unitForm.userid.value;
		var opertGrpId 	 = '<c:out value="${unitfirst.OPERT_GROUP_ID}"/>';
		var unitOpert 	 = '<c:out value="${unitfirst.UNIT_OPERT_ID}"/>';
		var ip 			 = '<c:out value="${unitfirst.IP_ADRES}"/>';
		var acntId 		 = '<c:out value="${unitfirst.ACNT_ID}"/>';
		var prtcl 		 = '<c:out value="${unitfirst.PRTCL_CODE}"/>';
		var unitnm 		 = '<c:out value="${unitfirst.UNIT_OPERT_NM}"/>';
		var opertCn 	 = '<c:out value="${unitfirst.OPERT_CN}"/>';
		var execut 		 = '<c:out value="${unitfirst.EXECUT_DT}"/>';
		var enddt        = '<c:out value="${unitfirst.END_DT}"/>';
		var executCnfirm = '<c:out value="${unitfirst.EXECUT_BFE_CNFIRM_AT}"/>';
		var nextrow 	 = '<c:out value="${unitfirst.RN}"/>';
		var prtclNm 	 = '<c:out value="${unitfirst.PRTCL_NM}"/>';
		document.unitForm.opertCn.value = document.unitForm.opertCn.value.replace('<br/>','\n');
		if($("input[name=chk[]]:checkbox:checked").length == 0){
			alert("단위작업 체크박스를 선택하세요.");
			return false;
		} 

		//alert(unitOpert);
		document.unitForm.action = "<c:url value='/ply/playSample.do'/>";
		document.unitForm.submit();
		
	}

	function fnOpertUnit(opertGrpId, no) {
		document.groupForm.opertGrpId.value = opertGrpId;
		document.groupForm.chkId.value = no;
		document.groupForm.action = "<c:url value='/ply/selectUnitOpertListList.do'/>";
		document.groupForm.submit();

	}

	// 작업그룹 TR 선택 시
	function server(obj, GrpId) {
		var grpNm = searchForm.grpNm.value;
		var grpCode = searchForm.grpCode.value;

		document.groupForm.grpNm.value = grpNm;
		document.groupForm.grpCode.value = grpCode;
		document.groupForm.opertGrpId.value = GrpId;
		document.groupForm.gpcode.value = grpCode;
		
		document.searchForm.gpcode.value = document.groupForm.gpcode.value;
		
	    for (i = 1; i < grp_list.rows.length; i++) {
			if (obj == grp_list.rows[i])
				grp_list.rows[i].bgColor = '#eeeeee';
			else
				grp_list.rows[i].bgColor = '';
		}

	    document.groupForm.action = "<c:url value='/ply/selectUnitOpertListList.do'/>";
	    document.groupForm.submit();	

	}

	// 단위작업 TR 선택 시
	function serverUnit(obj, GrpId, unitId, ip, acntId, prtcl, unitNm, opertCn,
			execut, enddt, executCnfirm, rn, prtclNm, opertNm) {
		document.unitForm.opertGrpId.value = GrpId;
		document.unitForm.unitOpert.value = unitId;
		document.unitForm.ip.value = ip;
		document.unitForm.acntId.value = acntId;
		document.unitForm.prtcl.value = prtcl;
		document.unitForm.unitnm.value = unitNm;
		document.unitForm.opertCn.value = opertCn;
		document.unitForm.executdt.value = execut;
		document.unitForm.enddt.value = enddt;
		document.unitForm.executCnfirm.value = executCnfirm;
		document.unitForm.rn.value = rn;
		document.unitForm.prtclNm.value = prtclNm;
		document.unitForm.opertNm.value = opertNm;

		for (i = 1; i < unit_list.rows.length; i++) {
			if (obj == unit_list.rows[i])
				unit_list.rows[i].bgColor = '#ffd277';
			else
				unit_list.rows[i].bgColor = '';
		}

		//location.href = "<c:url value='/ply/selectUnitOpertListList.do'/>?opertGrpId="+GrpId;
	}

	//새로고침
	function reloading() {
		window.location.reload();
	}

	//실행취소
	function fnCancl() {

		document.unitForm.action = "<c:url value='/ply/cancel.do'/>";
		document.unitForm.submit();
	}
	
 	function serverLinkPage(pageNo){
	    grpCode = searchForm.grpCode.value;
	    searchForm.gpcode.value = grpCode;
	    document.searchForm.pageIndex.value = pageNo;
	    document.searchForm.action = "<c:url value='/ply/selectOpertGrpList.do'/>";
	    document.searchForm.submit();
	}	
 	
 	function winClose(){

		var userid = '<c:out value="${loginVO.id}"/>';
		var opertGrpId 	 = '<c:out value="${unitfirst.OPERT_GROUP_ID}"/>';
		var unitOpert 	 = '<c:out value="${unitfirst.UNIT_OPERT_ID}"/>';
		var ip 			 = '<c:out value="${unitfirst.IP_ADRES}"/>';
		var acntId 		 = '<c:out value="${unitfirst.ACNT_ID}"/>';
		var prtcl 		 = '<c:out value="${unitfirst.PRTCL_CODE}"/>';
		var unitnm 		 = '<c:out value="${unitfirst.UNIT_OPERT_NM}"/>';
		var opertCn 	 = '<c:out value="${unitfirst.OPERT_CN}"/>';
		var execut 		 = '<c:out value="${unitfirst.EXECUT_DT}"/>';
		var enddt        = '<c:out value="${unitfirst.END_DT}"/>';
		var executCnfirm = '<c:out value="${unitfirst.EXECUT_BFE_CNFIRM_AT}"/>';
		var nextrow 	 = '<c:out value="${unitfirst.RN}"/>';
		var prtclNm 	 = '<c:out value="${unitfirst.PRTCL_NM}"/>';
		
 		if("${executCnt}" > 0) {
 
 		} else {
 			window.open("<c:url value='/ply/playSamplePopup.do'/>?opertGrpId="
 					+ opertGrpId + "&unitOpert=" + unitOpert + "&ip=" + ip
 					+ "&acntId=" + acntId + "&prtcl=" + prtcl + "&userid=" + userid,
 					"resultPop"+opertGrpId+unitOpert, "width=800, height=650");	
 		}
 	}
	
	<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
	<c:if test="${!empty executCnt}">winClose();</c:if>
</script>
</head>


<body>

<div id="smbsright">
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>
	<form name="searchForm" method="post" action="<c:url value='/ply/selectOpertGrpList.do'/>">
	<div class="TBTop">
		<fieldset>		 
		 <input type="hidden" name="pageIndex" value="<c:if test="${empty plyVO.pageIndex }">1</c:if><c:if test="${!empty plyVO.pageIndex }"><c:out value='${plyVO.pageIndex}'/></c:if>">
		  <input type="hidden" name="gpcode" />			
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
           <tr>
            <th width="80px" class="right">작업그룹명</th>
			<td><input name="grpNm" type="text" style="width: 90%" value="${plyVO.grpNm}" /></td>
			<th width="120px" class="right">작업그룹 종류</th>
			<td width="150px"><select name="grpCode" id="#" style="width: 150px" />
						<option value="" <c:if test="${param.gpcode == null}">selected</c:if>>전체</option>
					<c:forEach var="grpCodeList" items="${grpCodeList}" varStatus="status">
						<option value="<c:out value="${grpCodeList.CODE}"/>"
							<c:if test="${param.gpcode == grpCodeList.CODE}">selected</c:if>>
							<c:out value="${grpCodeList.CODE_NM}" />
						</option>
					</c:forEach></td>			
			<td><input type="image" src="/drauto/images/egovframework/drauto/main/btn_search.gif" alt="검색" onclick="fnOpertGrp(); return false;" /></td>
			</tr>
         </table>	
		</fieldset>
	</div>
	</form>

	<div class="TB_head">
		<span class="hd">작업그룹</span>
		<span class="buttonSet">
			<span class="btn_pack bt01"><button type="button" onclick="fnPlyExe(); return false;">실행</button></span>
			<span class="btn_pack bt01"><button type="button" onclick="fnCancl(); return false;">실행취소</button></span>
		</span>
	</div>
<form name="groupForm" action="<c:url value='/ply/selectOpertGrpList.do'/>" method="post">
<input type="hidden" name="opertGrpId" value="<c:out value="${grpId}"/>" />
<input type="hidden" name="chkId" />
<input type="hidden" name="userid" value="<c:out value="${loginVO.id}"/>" /> 
<input type="hidden" name="exe" value="execut" /> 
<input type="hidden" name="ip" value="" />
<input type="hidden" name="acntId" value="" />
<input type="hidden" name="prtcl" value="" />
<input type="hidden" name="chk_val[]" />
<input type="hidden" name="grpNm" />
<input type="hidden" name="grpCode" />
<input type="hidden" name="gpcode" />
<input type="hidden" name="pageIndex"
	value="<c:if test="${empty plyVO.pageIndex }">1</c:if><c:if test="${!empty plyVO.pageIndex }"><c:out value='${plyVO.pageIndex}'/></c:if>" />
	<table class="dataTable" id="grp_list">
		<colgroup>
			<col width="40" />
			<col width="400" />
			<col width="" />
		</colgroup>

		<thead>
			<tr>
				<th>NO</th>
				<th>작업그룹명</th>
				<th>작업그룹설명</th>
			</tr>
		</thead>
		<tbody>
		 <%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
		 <c:if test="${fn:length(grplist) == 0}">
		 <tr>
		 <td class="lt_text3" colspan="4" align="center">
			<spring:message code="common.nodata.msg" />
		 </td>
		 </tr>
		 </c:if>		
			<c:forEach var="grp" items="${grplist}" varStatus="status">			
			<tr  onclick="server(this, '<c:out value="${grp.opertGrpId}"/>')" <c:if test="${grp.opertGrpId == grpId}">bgcolor="#ffd277"</c:if>>
				<td class="center"><c:out value="${grp.rn}"/></td>
				<td class="left">
					<c:out value="${grp.opertGrpNm}"/>
				</td>
				<td class="left"><c:out value="${grp.opertGrpDc}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
<!--게시물 페이지 번호시작--> 
	<c:if test="${!empty plyVO.pageIndex }">
		<div align="center" class="boardNavigation">
			<div class="pagination">
				<ui:pagination paginationInfo="${plyPaginationInfo}"
					type="image" jsFunction="serverLinkPage" />
			</div>
		</div>
	</c:if> 
<!--게시물 페이지 번호끝-->
	<div class="TB_head">
		<span class="hd">단위작업</span>
		<span class="buttonSet">
			<span class="btn_pack bt01"><a onclick="fnResultPop(); return false;">결과보기</a></span> 
		</span>
	</div>

<form name="unitForm" action="" method="post">
	<input type="hidden" name="opertGrpId" value='<c:out value="${unitfirst.OPERT_GROUP_ID}"/>'> <!-- 작업그룹id -->
	<input type="hidden" name="unitOpert" value='<c:out value="${unitfirst.UNIT_OPERT_ID}"/>'> <!-- 단위작업id --> 
	<input type="hidden" name="ip" value='<c:out value="${unitfirst.IP_ADRES}"/>'> <!-- ip -->
	<input type="hidden" name="acntId" value='<c:out value="${unitfirst.ACNT_ID}"/>'> <!-- 계정ID -->
	<input type="hidden" name="prtcl" value='<c:out value="${unitfirst.PRTCL_CODE}"/>'>	<!-- 프로토콜 종류 --> 
	<input type="hidden" name="unitnm" value='<c:out value="${unitfirst.UNIT_OPERT_NM}"/>'>	<!-- 단위작업명 -->
	<input type="hidden" name="opertCn" value='<c:out value="${unitfirst.OPERT_CN}"/>'>	<!-- 작업내용 --> 
	<input type="hidden" name="opertGrpExecutdt" value='<c:out value="${unitfirst.OPERT_GROUP_EXECUT_DT}"/>'>	<!-- 작업그룹실행시간 -->
	<input type="hidden" name="executdt" value='<c:out value="${unitfirst.EXECUT_DT}"/>'>	<!-- 실행시간 -->
	<input type="hidden" name="enddt" value='<c:out value="${unitfirst.END_DT}"/>'>	<!-- 종료시간 --> 		
	<input type="hidden" name="executCnfirm" value='<c:out value="${unitfirst.EXECUT_BFE_CNFIRM_AT}"/>'>	<!-- 실행전확인여부 --> 
	<input type="hidden" name="rn" value='<c:out value="${unitfirst.RN}"/>'>	<!-- 순번 -->	
	<input type="hidden" name="prtclNm" value='<c:out value="${unitfirst.PRTCL_NM}"/>'>	<!-- 프로토콜 코드명 -->
	<input type="hidden" name="opertNm" value='<c:out value="${unitfirst.OPERT_GROUP_NM}"/>'>	<!-- 작업그룹명 -->	
	<input type="hidden" name="userid" value="<c:out value="${loginVO.id}"/>"> 
	<input type="hidden" name="exe" value="execut"> 
	<input type="hidden" name="msgchk">
<input type="hidden" name="pageIndex"
	value="<c:if test="${empty plyVO.pageIndex }">1</c:if><c:if test="${!empty plyVO.pageIndex }"><c:out value='${plyVO.pageIndex}'/></c:if>">	
	<table class="dataTable" id="unit_list">
		<colgroup>
			<col width="30" />
			<col width="40" />
			<col width="" />
			<col width="100" />
			<col width="70" />
			<col width="130" />
			<col width="130" />
			<col width="100" />
		</colgroup>
		<thead>
			<tr>
				<th>체크</th>
				<th>순번</th>
				<th>단위작업명</th>
				<th>서버</th>
				<th>계정ID</th>
				<th>실행일시</th>
				<th>종료일시</th>
				<th>실행전확인여부</th>				
			</tr>
		</thead>
		<tbody>
		 <%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
		 <c:if test="${fn:length(unitlist) == 0}">
		 <tr>
		 <td class="lt_text3" colspan="8" align="center">
			<spring:message code="common.nodata.msg" />
		 </td>
		 </tr>
		 </c:if>		
			<c:forEach var="unit" items="${unitlist}" varStatus="status">
			<tr onclick="serverUnit(this, '<c:out value="${unit.OPERT_GROUP_ID}"/>', '<c:out value="${unit.UNIT_OPERT_ID}"/>', '<c:out value="${unit.IP_ADRES}"/>',
			'<c:out value="${unit.ACNT_ID}"/>', '<c:out value="${unit.PRTCL_CODE}"/>', '<c:out value="${unit.UNIT_OPERT_NM}"/>', '<c:out value="${unit.OPERT_CN}"/>'
			, '<c:out value="${unit.EXECUT_DT}"/>', '<c:out value="${unit.END_DT}"/>', '<c:out value="${unit.EXECUT_BFE_CNFIRM_AT}"/>', '<c:out value="${unit.RN}"/>'
			, '<c:out value="${unit.PRTCL_NM}"/>', '<c:out value="${unit.OPERT_GROUP_NM}"/>')">
				<td class="center"><input id="chk" name="chk[]" type="checkbox" value='<c:out value="${unit.UNIT_OPERT_ID}"/>' <c:if test="${unit.UNIT_OPERT_ID == unit.UNIT_CHK}">checked="checked"</c:if>/></td>
				<td class="center"><c:out value="${unit.RN}" /></td>
				<td><c:out value="${unit.UNIT_OPERT_NM}" /></td>
				<td><c:out value="${unit.IP_ADRES}" /></td>
				<td><c:out value="${unit.ACNT_ID}" /></td>
				<td><c:out value="${unit.EXECUT_DT}" /></td>
				<td><c:out value="${unit.END_DT}" /></td>
				<td align="center"><c:out value="${unit.EXECUT_BFE_CNFIRM_AT}" /></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
</div>
</body>
</html>