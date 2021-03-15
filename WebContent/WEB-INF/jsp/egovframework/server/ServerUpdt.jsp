<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
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

<script language="javascript">

function loaded() {
	var updtResult = '<c:out value="${updtResult}" />';
	
	if (updtResult > 0) {
		alert("수정되었습니다.");
	
		//opener.location.href = '<c:url value='/server/serverList.do' />';
		
		var param = "searchUseYn="+document.update_server.o_searchUseYn.value;
		param += "&ipAdres="+document.update_server.o_ipAdres.value;
		param += "&hostNm="+document.update_server.o_hostNm.value;
		param += "&osCode="+document.update_server.o_osCode.value;
		param += "&checkIpAdres="+document.update_server.o_checkIpAdres.value;
		param += "&checkAcntId="+document.update_server.o_checkAcntId.value;
		param += "&prtclCode="+document.update_server.o_prtclCode.value;
		param += "&pageIndex="+document.update_server.o_pageIndex.value;
		
		

		opener.location.href = '<c:url value='/server/serverList.do' />?'+param;
		//opener.window.location.reload();
	}
}

function checkForm() {
	document.update_server.submit();
}

</script>
</head>


<body class="contPop" onload="loaded();">

<div class="PopupTop"><h1>서버 수정</h1> </div>

<form name="update_server" method="post" action="<c:url value='/server/updateServer.do' />">

<input type="hidden" name="o_searchUseYn" value="<c:out value="${param.o_searchUseYn}"/>" />
<input type="hidden" name="o_ipAdres" value="<c:out value="${param.o_ipAdres}"/>" />
<input type="hidden" name="o_hostNm" value="<c:out value="${param.o_hostNm}"/>" />
<input type="hidden" name="o_osCode" value="<c:out value="${param.o_osCode}"/>" />
<input type="hidden" name="o_checkIpAdres" value="<c:out value="${param.o_checkIpAdres}"/>" />
<input type="hidden" name="o_checkAcntId" value="<c:out value="${param.o_checkAcntId}"/>" />
<input type="hidden" name="o_prtclCode" value="<c:out value="${param.o_prtclCode}"/>" />
<input type="hidden" name="o_pageIndex" value="<c:out value="${param.o_pageIndex}"/>" />

<!-- Contents start -->
<div class="Popup">         
      
    <div class="TBTop">
        <fieldset>
         <table width="100%" border="0" cellspacing="0" cellpadding="0">
         
        <colgroup>
            <col width="" />
            <col width="30%" />
            <col width="" />
            <col width="30%" />            
        </colgroup>    
                 
           <tr>
             <th class="left">IP주소(필수)</th>
             <td><c:out value="${serverList.ipAdres}"/><input type="hidden" name="ipAdres" value="<c:out value="${serverList.ipAdres}"/>" /></td>
             <th class="left">OS</th>
             <td>
               <select name="osCode" id="#" style="width:90%"/>
                <c:if test="${!empty osList}">
                <c:forEach var="osList" items="${osList}" varStatus="status">
                 <option value="<c:out value="${osList.CODE}"/>" <c:if test="${serverList.osCode == osList.CODE}">selected</c:if>><c:out value="${osList.CODE_NM}"/></option>
                </c:forEach>
                </c:if>
               </select>                       
             </td>          
           </tr>
           
           <tr>
             <th class="left">OS 버전</th>
             <td><input type="text" name="osVer" value='<c:out value="${serverList.osVer}"/>' style="width:90%"/></td>
             <th class="left">커널 버전</th>
             <td><input type="text" name="krnlVer" value='<c:out value="${serverList.krnlVer}"/>' style="width:90%"/></td>
           </tr>
           
           <tr>
             <th class="left">호스트명</th>
             <td><input type="text" name="hostNm" value='<c:out value="${serverList.hostNm}"/>' style="width:90%"/></td>
             <th class="left">장비명</th>
             <td><input type="text" name="eqpmnNm" value='<c:out value="${serverList.eqpmnNm}"/>' style="width:90%"/></td>
           </tr>
           
           <tr>
             <th class="left">장비설명</th>
             <td colspan="3"><input type="text" name="eqpmnDc" value='<c:out value="${serverList.eqpmnDc}"/>' style="width:96%"/></td>
           </tr>          
         </table>
      </fieldset>
    </div>	
       

<div class="Fbt" style="margin-top:15px">
<span class="btn_pack bt01"><button type="button" onclick="checkForm();">수정</button></span>
<span class="btn_pack bt01"><button type="button" onclick="window.close();">닫기</button></span>
</div>

</div>
<!--popup e-->
</form>



</body>
</html>
