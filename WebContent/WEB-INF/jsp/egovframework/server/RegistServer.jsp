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

<script language="javascript">
var insertAt = '<c:out value="${insertAt}"/>';
if (insertAt == 'true') {
	alert("저장되었습니다.");
	
	opener.location.href = '<c:url value='/server/serverList.do' />';
	//opener.window.location.reload();
}

var ip_dup = '<c:out value="${ipCount}"/>';
if (ip_dup != null && ip_dup > 0) {
	alert('이미 등록된 IP주소 입니다.');
}
function checkForm() {
	var expIpAdres = /^(1|2)?\d?\d([.](1|2)?\d?\d){3}$/;

	if (document.insert_os.ipAdres.value == '') {
		alert('IP 주소를 입력하세요.');
		return;
	}
	
	if (!expIpAdres.test(document.insert_os.ipAdres.value)) {
		alert('잘못된 IP 주소 입니다.');
		return;
	}
	
	document.insert_os.submit();
}

</script>
</head>


<body class="contPop">

<div class="PopupTop"><h1>서버 추가</h1> </div>

<form name="insert_os" method="post" action="<c:url value='/server/insertServer.do' />">
<!-- Contents start -->
<div class="Popup">         
      
    <div class="TBTop">
        <fieldset>
         <table width="100%" border="0" cellspacing="0" cellpadding="0">
         
        <colgroup>
            <col width="" />
            <col width="35%" />
            <col width="" />
            <col width="35%" />            
        </colgroup>    
                 
           <tr>
             <th class="left">IP주소(필수)</th>
             <td><input type="text" name="ipAdres" value='<c:out value="${param.ipAdres}" />' style="width:90%"/></td>
             <th class="left">OS</th>
             <td>
               <select name="osCode" id="#" style="width:90%"/>
                <c:if test="${!empty osList}">
                <c:forEach var="osList" items="${osList}" varStatus="status">
                 <option value="<c:out value="${osList.CODE}"/>" <c:if test="${param.osCode == osList.CODE}">selected</c:if>><c:out value="${osList.CODE_NM}"/></option>
                </c:forEach>
                </c:if>
               </select>                       
             </td>          
           </tr>
           
           <tr>
             <th class="left">OS 버전</th>
             <td><input type="text" name="osVer" value='<c:out value="${param.osVer}" />' style="width:90%"/></td>
             <th class="left">커널 버전</th>
             <td><input type="text" name="krnlVer" value='<c:out value="${param.krnlVer}" />' style="width:90%"/></td>
           </tr>
           
           <tr>
             <th class="left">호스트명</th>
             <td><input type="text" name="hostNm" value='<c:out value="${param.hostNm}" />' style="width:90%"/></td>
             <th class="left">장비명</th>
             <td><input type="text" name="eqpmnNm" value='<c:out value="${param.eqpmnNm}" />' style="width:90%"/></td>
           </tr>
           
           <tr>
             <th class="left">장비설명</th>
             <td colspan="3"><input type="text" name="eqpmnDc" value='<c:out value="${param.eqpmnDc}" />' style="width:96%"/></td>
           </tr>           
         </table>
      </fieldset>
    </div>	
       

<div class="Fbt" style="margin-top:15px">
<span class="btn_pack bt01"><button type="button" onclick="checkForm();">저장</button></span>
<span class="btn_pack bt01"><button type="button" onclick="window.close();">닫기</button></span>
</div>

</div>
<!--popup e-->
</form>



</body>
</html>
