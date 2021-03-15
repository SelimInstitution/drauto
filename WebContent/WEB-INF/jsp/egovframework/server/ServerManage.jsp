<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<style type="text/css">
.dataTable tbody tr:hover td {background: #eeeeee;}
</style>

<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />"></script>
<script type="text/javaScript" language="javascript" defer="defer">

	var check_ip = '<c:out value="${param.checkIpAdres}"/>';
	var check_acnt_id = '<c:out value="${param.checkAcntId}"/>';
	var check_prtcl_code = '<c:out value="${param.checkPrtclCode}"/>';
	
	var deleteResult = '<c:out value="${deleteResult}" />';
	
	if (deleteResult > 0) {
		alert("삭제여부가 변경되었습니다.");
	}	

	function fnServerAdd() {
		window.open("<c:url value='/server/serverPopup.do' />", "spopup", "width=600, height=260, scroll=no");
	}
 
	function fnAcntAdd() {
		var param = "searchUseYn=N";
		param += "&ipAdres="+check_ip;
		param += "&o_ipAdres=<c:out value="${param.ipAdres}"/>";
		param += "&o_hostNm=<c:out value="${param.hostNm}"/>";
		param += "&o_osCode=<c:out value="${param.osCode}"/>";
		param += "&o_pageIndex="+document.serverList.pageIndex.value;
		
		if (check_ip == '') {
			alert("계정이 등록될 서버를 선택하세요.");
			return false;
		}	 
		window.open("<c:url value='/server/acntPopup.do' />?"+param, "apopup", "width=710, height=290, scroll=no");
	}
 
	function fnServerUpdt() {
		if (check_ip == '') {
			alert("수정할 서버를 선택하세요.");
			return false;
		}
		
		var param = "o_searchUseYn=Y";
		param += "&ipAdres="+check_ip;
		param += "&o_ipAdres=<c:out value="${param.ipAdres}"/>";
		param += "&o_hostNm=<c:out value="${param.hostNm}"/>";
		param += "&o_osCode=<c:out value="${param.osCode}"/>";
		param += "&o_checkIpAdres="+check_ip;
		param += "&o_checkAcntId="+check_acnt_id;
		param += "&o_prtclCode="+check_prtcl_code;
		param += "&o_pageIndex="+document.serverList.pageIndex.value;

		//window.open("<c:url value='/server/serverUpdtView.do' />?searchUseYn=N&ipAdres="+check_ip+"&checkIpAdres="+check_ip, "popup", "width=600, height=260, scroll=no");
		window.open("<c:url value='/server/serverUpdtView.do' />?"+param, "popup", "width=600, height=260, scroll=no");
	}
 
	function fnServerDeleteAtUpdt() {
		//var param = '&ipAdres='+document.searchServer.ipAdres.value+'&hostNm='+document.searchServer.hostNm.value+'&osCode='+document.searchServer.osCode.value;
		var search_param = "&searchUseYn=Y&ipAdres=<c:out value="${param.ipAdres}"/>&hostNm=<c:out value="${param.hostNm}"/>&osCode=<c:out value="${param.osCode}"/>";
		
		if (check_ip == '') {
			alert("삭제할 서버를 선택하세요.");
			return false;
		}
		if (!confirm(check_ip+' 의 삭제여부를 수정하시겠습니까?')) {
			return false;
		}
		location.href = '<c:url value="/server/updateServerDeleteAt.do" />?checkIpAdres='+check_ip+'&pageIndex='+document.serverList.pageIndex.value+search_param;
	} 
 
	function fnAcntDeleteAtUpdt() {
		var search_param = "&searchUseYn=Y&ipAdres=<c:out value="${param.ipAdres}"/>&hostNm=<c:out value="${param.hostNm}"/>&osCode=<c:out value="${param.osCode}"/>";
		
		if (check_ip == '' || check_acnt_id == '' || check_prtcl_code == '') {
			alert("삭제할 계정을 선택하세요.");
			return false;
		}
		if (!confirm(check_ip+', '+check_acnt_id+' 의 삭제여부를 수정하시겠습니까?')) {
			return false;
		}
		location.href = '<c:url value="/server/updateAcntDeleteAt.do" />?checkIpAdres='+check_ip+'&checkAcntId='+check_acnt_id+'&checkPrtclCode='+check_prtcl_code+'&pageIndex='+document.serverList.pageIndex.value+search_param;
	}
 
	function fnAcntUpdt() {
		if (check_ip == '' || check_acnt_id == '' || check_prtcl_code == '') {
			alert("수정할 계정을 선택하세요.");
			return false;
		}
		
		var param = "o_searchUseYn=Y";
		param += "&ipAdres="+check_ip;
		param += "&o_ipAdres=<c:out value="${param.ipAdres}"/>";
		param += "&o_hostNm=<c:out value="${param.hostNm}"/>";
		param += "&o_osCode=<c:out value="${param.osCode}"/>";
		param += "&o_checkIpAdres="+check_ip;
		param += "&o_checkAcntId="+check_acnt_id;
		param += "&o_prtclCode="+check_prtcl_code;
		param += "&acntId="+check_acnt_id;
		param += "&prtclCode="+check_prtcl_code;		
		param += "&o_pageIndex="+document.serverList.pageIndex.value;
		
		//window.open("<c:url value='/server/acntUpdtView.do' />?ipAdres="+check_ip+"&acntId="+check_acnt_id+"&prtclCode="+check_prtcl_code, "popup", "width=600, height=290, scroll=no");
		window.open("<c:url value='/server/acntUpdtView.do' />?"+param, "popup", "width=600, height=290, scroll=no");
	} 
 
	function server(obj, ip_adres) {
		var search_param = "&searchUseYn=Y&ipAdres=<c:out value="${param.ipAdres}"/>&hostNm=<c:out value="${param.hostNm}"/>&osCode=<c:out value="${param.osCode}"/>";
		check_ip = ip_adres;
		
		for (i=1; i<server_list.rows.length; i++) {
			if (obj == server_list.rows[i]) server_list.rows[i].bgColor = '#FFD277';
			else server_list.rows[i].bgColor = '';
		}
		
		location.href = "<c:url value='/server/serverList.do' />?checkIpAdres="+check_ip+search_param+"&pageIndex="+document.serverList.pageIndex.value;
	}
 
	 function acnt(obj, ip_adres, acnt_id, prtcl_code) {
		 check_ip = ip_adres;
		 check_acnt_id = acnt_id;
		 check_prtcl_code = prtcl_code;
		 
		 for (i=1; i<acnt_list.rows.length; i++) {
			 if (obj == acnt_list.rows[i]) acnt_list.rows[i].bgColor = '#FFD277';
			 else acnt_list.rows[i].bgColor = '';
		 }
	 } 

 	function serverLinkPage(pageNo){
 		var search_param = "?searchUseYn=Y&ipAdres=<c:out value="${param.ipAdres}"/>&hostNm=<c:out value="${param.hostNm}"/>&osCode=<c:out value="${param.osCode}"/>";
	    //document.serverList.searchCondition.value = "1";
	    document.serverList.pageIndex.value = pageNo;
	    document.serverList.action = "<c:url value='/server/serverList.do'/>"+search_param;
	    document.serverList.submit();
	}
</script>
</head>


<body>
	<form name="subCall" method="post" action="">
		<input type="hidden" name="searchUseYn" value="Y" />
		<input type="hidden" name="ipAdres" value="<c:out value="${param.ipAdres}"/>" />
		<input type="hidden" name="hostNm" value="<c:out value="${param.hostNm}"/>" />
		<input type="hidden" name="osCode" value="<c:out value="${param.osCode}"/>" />
		<input type="hidden" name="pageIndex" value="" />
		<input type="hidden" name="checkIpAdres" value="" />
		<input type="hidden" name="acntId" value="" />
		<input type="hidden" name="prtclCode" value="" />
		<input type="hidden" name="checkAcntId" value="" />
	</form>
    
	<div id="smbsright">
	<form name="searchServer" method="post" action="<c:url value='/server/serverList.do'/>">
		<div class="TBTop">
			<fieldset>		
				
					<table width="100%" border="0" cellspacing="0" cellpadding="0">	
    			
						<tr>
							<th class="right" width="80px">서버IP</th>
							<td width="120px"><input type="text" name="ipAdres" value="<c:out value="${param.ipAdres}"/>" style="width: 100%" maxlength="15" /></td>
							<th class="right" width="80px">호스트명</th>
							<td width="120px"><input type="text" name="hostNm" value="<c:out value="${param.hostNm}"/>" style="width:100%" /></td>
							<th class="right" width="80px">OS</th>
							<td width="200px">
                            <select name="osCode" id="#" style="width:100%" />
							<option value="" <c:if test="${param.osCode == null}">selected</c:if>>전체</option>
							<c:forEach var="osList" items="${osList}" varStatus="status">
							<option value="<c:out value="${osList.CODE}"/>"
							<c:if test="${param.osCode == osList.CODE}">selected</c:if>>
							<c:out value="${osList.CODE_NM}" /></option></c:forEach>
							</select></td>
                            <td style="left-margin: 3" rowspan="2"><input type="image" src="/drauto/images/egovframework/drauto/main/btn_search.gif" alt="검색" / onclick="submit();"></td>
						</tr>
						<input type="hidden" name="searchUseYn" value="Y" />
					</table>
					
			</fieldset>
		</div>
	</form>
    
		<!--왼쪽테이블 시작-->
		<form name="serverList" method="post" action="">
			<!-- <div class="table_left"> -->
			<input type="hidden" name="pageIndex"
				value="<c:if test="${empty serverVO.pageIndex }">1</c:if><c:if test="${!empty serverVO.pageIndex }"><c:out value='${serverVO.pageIndex}'/></c:if>">
				<div class="TB_head">
					<span class="hd">서버 (<c:out value="${serverTotCnt}" />)</span>
					<span class="buttonSet">
						<span class="btn_pack bt01"><button type="button" onclick="fnServerAdd();">추가</button></span> <span class="btn_pack bt01"><button type="button" onclick="fnServerUpdt();">수정</button></span> <span class="btn_pack bt01"><button type="button" onclick="fnServerDeleteAtUpdt();">삭제</button></span>
					</span>
				</div>
                
				<table class="dataTable" id="server_list">
					<thead>
						<tr>
							<th width="40">No</th>
							<th width="120">IP주소</th>
							<th>호스트명</th>
							<th>장비설명</th>
							<th width="">OS명</th>
							<th width="60">삭제여부</th>
						</tr>
					</thead>
					<tbody>
						<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
						<c:if test="${fn:length(serverList) == 0}">
							<tr>
								<td class="lt_text3" colspan="6" align="center"><spring:message code="common.nodata.msg" /></td>
							</tr>
						</c:if>
						<c:forEach var="serverList" items="${serverList}" varStatus="status">
							<tr ondblclick="fnServerUpdt()" onclick="server(this, '<c:out value="${serverList.ipAdres}"/>')"
								<c:if test="${param.checkIpAdres == serverList.ipAdres}">bgColor = '#FFD277'</c:if>>
                                <td class="center"><c:out value="${serverList.rnum}" /></td>
								<td class="left"><c:out value="${serverList.ipAdres}" /></td>
								<td class="left"><c:out value="${serverList.hostNm}" /></td>
								<td class="left"><c:out value="${serverList.eqpmnDc}" /></td>
								<td class="left"><c:out value="${serverList.osNm}" /></td>
								<td class="center"><c:out value="${serverList.deleteAt}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table> 
                
                <!--게시물 페이지 번호시작--> 
                <c:if test="${!empty serverVO.pageIndex }">
					<div align="center" class="boardNavigation">
						<div class="pagination">
							<ui:pagination paginationInfo="${serverPaginationInfo}" type="image" jsFunction="serverLinkPage" />
						</div>
					</div>
				</c:if> 
                <!--게시물 페이지 번호끝-->
		</form>
		<!-- </div> -->
		<!--왼쪽테이블 끝-->

		<!--오른쪽테이블 시작-->
		<form name="acntList" method="post" action="">
			<!-- <div class="table_right"> -->

			<div class="TB_head">
				<span class="hd">계정</span>
				<span class="buttonSet">
					<span class="btn_pack bt01"><button type="button" onclick="fnAcntAdd();">추가</button></span> <span class="btn_pack bt01"><button type="button" onclick="fnAcntUpdt();">수정</button></span> <span class="btn_pack bt01"><button type="button" onclick="fnAcntDeleteAtUpdt();">삭제</button></span>
				</span>
			</div>
			
			<table class="dataTable" id="acnt_list">
				<thead>
					<tr>
						<th width="40">No</th>
						<th width="120">IP주소</th>
						<th>계정ID</th>
						<th width="120">프토토콜종류</th>
						<th width="60">포트</th>
						<th width="60">삭제여부</th>
					</tr>
				</thead>
				<tbody>
					<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
					<c:if test="${fn:length(acntList) == 0}">
						<tr>
							<td class="lt_text3" colspan="6" align="center"><spring:message code="common.nodata.msg" /></td>
						</tr>
					</c:if>
					<c:forEach var="acntList" items="${acntList}" varStatus="status">
						<tr ondblclick="fnAcntUpdt();" onclick="acnt(this, '<c:out value="${acntList.ipAdres}"/>', '<c:out value="${acntList.acntId}"/>', '<c:out value="${acntList.prtclCode}"/>')"
							<c:if test="${param.checkAcntId == acntList.acntId}">bgColor = '#FFD277'</c:if>>
							<td class="center"><c:out value="${acntList.rnum}" /></td>
							<td class="left"><c:out value="${acntList.ipAdres}" /></td>
							<td class="left"><c:out value="${acntList.acntId}" /></td>
							<td class="left"><c:out value="${acntList.prtclNm}" /></td>
							<td class="left"><c:out value="${acntList.port}" /></td>
							<td class="center"><c:out value="${acntList.deleteAt}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- </div> -->
		</form>
		<!--오른쪽테이블 끝-->
	</div>
</body>
</html>