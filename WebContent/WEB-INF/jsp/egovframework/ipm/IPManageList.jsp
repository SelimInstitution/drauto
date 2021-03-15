<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>정부통합전산센터 서버관리업무지원시스템</title>
<link rel="stylesheet"
	href="<c:url value='/css/egovframework/drauto/drauto.css'/>"
	type="text/css">
	<style type="text/css">
.dataTable tbody tr:hover td {
	background: #eeeeee;
}
</style>
	<script type="text/javascript"
		src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />"></script>

	<c:if test="${!empty message}">
		<script type="text/javaScript" language="javascript" defer="defer">
			alert("<c:out value='${message}' />");
		</script>
	</c:if>
	<script type="text/javaScript" language="javascript" defer="defer">
		var check_ip = '';
		jQuery(document)
				.ready(
						function($) {
							$("#insertBtn").bind(
									"click",
									function() {
										window.open(
												"/drauto/ipm/registIPManage.do",
												"ip관리등록",
												"width=800, height=400",
												"scrollbars=no");
									});

							$("#updateBtn")
									.bind(
											"click",
											function() {
												if (check_ip == '') {
													alert("수정할 IP를 선택하세요");
													return false;
												}

												var param = "&searchIpAdres=" + document.searchForm.searchIpAdres.value;
												param += "&searchHostNm=" + document.searchForm.searchHostNm.value;
												param += "&searchEqpmnKnd=" + document.searchForm.searchEqpmnKnd.value;
												param += "&searchNtwkDiv=" + document.searchForm.searchNtwkDiv.value;
												param += "&pageIndex=" + document.searchForm.pageIndex.value;

												var url = "/drauto/ipm/modifyIPManage.do?ipAdres=" + check_ip + param;
												window.open(url, "ip관리수정", "width=800, height=400", "scrollbars=no");
											});

							$("#searchBtn").bind("click", function() {
								$("#pageIndex").val(1);
							});

							$("#deleteBtn").bind(
											"click",
											function() {
												if (check_ip == '') {
													alert("삭제할 IP를 선택하세요");
													return false;
												}
												if (confirm(check_ip + "을(를) 삭제 하시겠습니까?")) {
													$("#ipAdres").val(check_ip);
													document.searchForm.action = "/drauto/ipm/deleteIPManage.do"
													document.searchForm.submit();
												}
											});
							$("#pingBtn").bind(
									"click",
									function() {
										document.searchForm.action = "<c:url value='/ipm/pingCheck.do'/>";
										document.searchForm.submit();
									});
						});

		function choiceIp(obj, ipAdres) {
			check_ip = ipAdres;

			for (i = 1; i < server_list.rows.length; i++) {
				if (obj == server_list.rows[i])
					server_list.rows[i].bgColor = '#ffd277';
				else
					server_list.rows[i].bgColor = '';
			}
		}

		function fn_select_list(pageIndex) {
			actionUrl = "<c:url value='/ipm/selectIPMList.do'/>";
			document.searchForm.pageIndex.value = pageIndex;
			document.searchForm.action = actionUrl;
			document.searchForm.submit();
		}

		function fn_dbclick_update() {
			var url = "/drauto/ipm/modifyIPManage.do?ipAdres=" + check_ip;
			window.open(url, "ip관리수정", "width=800, height=400", "scrollbars=no");
		}
		
	</script>
</head>


<body>

	<div id="smbsright">
		<form name="searchForm" id="searchForm" method="post" action="/drauto/ipm/selectIPMList.do">
			<input type="hidden" name="ipAdres" id="ipAdres" />
			<input type="hidden" name="pageIndex" id="pageIndex" value=<c:out value='${ipManageVO.pageIndex}'/> />

			<div class="TBTop">

				<fieldset>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
			           <tr>
			            <th width="80px" class="right">서버IP</th>
							<td width="120px"><input type="text" name="searchIpAdres" value="${ipManageVO.searchIpAdres}" /></td>
							<th width="80px" class="right">호스트명</th>
							<td width="120px"><input type="text" name="searchHostNm" value="<c:out value='${ipManageVO.searchHostNm}'/>" /></td>
							<th width="80px" class="right">장비종류</th>
							<td width="120px"><input type="text" name="searchEqpmnKnd" value="<c:out value='${ipManageVO.searchEqpmnKnd}'/>"></td>
							<th width="80px" class="right">망구분</th>
							<td width="150px"><select name="searchNtwkDiv" id="searchNtwkDiv" style="width: 100%" />
									<option value="">전체</option>
									<c:forEach var="divCodes" items="${divCode}">
									<option value="${divCodes.code}" <c:if test='${ipManageVO.searchNtwkDiv == divCodes.code}'>selected="selected"</c:if>>${divCodes.codeNm}</option>
									</c:forEach> 
								</select></td>
							<td><input type="image" id="searchBtn" src="/drauto/images/egovframework/drauto/main/btn_search.gif" alt="검색" /></td>
						</tr>
					</table>
				</fieldset>
			</div>

			<div class="TB_head">
				<span>
				 <span class="btn_pack bt01"><button type="button" id="pingBtn" onclick="pingCheck();">PING 확인</button></span>
				</span>
				<p class="buttonSet">
					<span class="btn_pack bt01"><button type="button" id="insertBtn">추가</button></span> 
					<span class="btn_pack bt01"><button type="button" id="updateBtn">수정</button></span> 
					<span class="btn_pack bt01"><button type="button" id="deleteBtn">삭제</button></span>
				</p>
			</div>
			<table class="dataTable" id="server_list">
				<colgroup>
					<col width="40px" />
					<col width="90px" />
					<col width="90px" />
					<col width="" />
					<col width="" />
					<col width="" />
					<col width="70px" />
					<col width="100px" />
					<col width="85px" />
					<col width="40px" />
				</colgroup>

				<thead>
					<tr>
						<th>순번</th>
						<th>IP</th>
						<th>서브넷 마스크</th>
						<th>호스트명</th>
						<th>장비종류</th>
						<th>용도</th>
						<th>망구분</th>
						<th>생성자</th>
						<th>생성일자</th>
						<th>PING결과</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="IPManage" items="${resultList}">
						<tr
							onclick="choiceIp(this,'<c:out value="${IPManage.ipAdres}"/>');"
							ondblclick="fn_dbclick_update();">
							<td class="center"><c:out value="${IPManage.rnum}" /></td>
							<td class="center"><c:out value="${IPManage.ipAdres}" /></td>
							<td class="center"><c:out value="${IPManage.subnetMask}" /></td>
							<td class=""><c:out value="${IPManage.hostNm}" /></td>
							<td class=""><c:out value="${IPManage.eqpmnKnd}" /></td>
							<td class=""><c:out value="${IPManage.prpos}" /></td>
							<td class="center"><c:out value="${IPManage.ntwkDiv}" /></td>
							<td class="center"><c:out value="${IPManage.crtrNm}" /></td>
							<td class="center"><c:out value="${IPManage.creatDt}" /></td>
							<td class="center"><c:if test="${IPManage.alive == 'Y'}"><img src="<c:url value='/images/egovframework/drauto/ipm/ic_y.gif' />"  border="0"></c:if>
							<c:if test="${IPManage.alive == 'N'}"><img src="<c:url value='/images/egovframework/drauto/ipm/ic_n.gif' />"  border="0"></c:if></td>
						</tr>
					</c:forEach>
					<c:if test="${fn:length(resultList) == 0}">
						<tr>
							<td class="lt_text3 center" nowrap colspan="10"><spring:message code="common.nodata.msg" />
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<div align="center" class="boardNavigation">
				<div align="center" class="pagination">
					<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_select_list" />
				</div>
			</div>

		</form>
	</div>
</body>
</html>