<%@ page language="java" contentType="text/html;charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>정부통합전산센터 서버관리업무지원시스템</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />" ></script>
<c:if test="${!empty messageOverlap}">	
	<script type="text/javaScript" language="javascript" defer="defer">
		<c:if test="${ipManageVO.overlapYn == 'N'}">
			alert("<c:out value='${messageOverlap}' />"); 
		</c:if>
	</script>
</c:if>
<c:if test="${!empty message}">	
	<script type="text/javaScript" language="javascript" defer="defer">
	jQuery(document).ready(function($) {
			var param = "?ipAdres="+document.ipManageView.ipAdres.value;
			param += "&searchIpAdres="+document.ipManageView.searchIpAdres.value;
			param += "&searchHostNm="+document.ipManageView.searchHostNm.value;
			param += "&searchEqpmnKnd="+document.ipManageView.searchEqpmnKnd.value;
			param += "&searchNtwkDiv="+document.ipManageView.searchNtwkDiv.value;
			param += "&pageIndex="+document.ipManageView.pageIndex.value;

			var actionUrl = "<c:url value='/ipm/selectIPMList.do'/>";
			
			opener.location.href = actionUrl + param;
			alert("<c:out value='${message}' />");
	});

		</script>
</c:if>
<script type="text/javaScript" language="javascript" defer="defer">
jQuery(document).ready(function($) {
	var expIpAdres = /^(1|2)?\d?\d([.](1|2)?\d?\d){3}$/;
	$("#updateBtn").bind("click",function() {
		if(!expIpAdres.test($("#subnetMask").val())){
			alert("잘못된 서브넷마스크 입니다.");	
			return;
		}
		document.ipManageView.action="/drauto/ipm/updateIPManage.do";
		document.ipManageView.submit();
	});
	
});

</script>



</head>


<body class="contPop">

<div class="PopupTop">
  <h1>IP 등록</h1> 
</div>

<!-- Contents start -->
<div class="Popup">         
<form name = "ipManageView" method="post" id="ipManageView" action="/drauto/ipm/updateIPManage.do" > 
<input type="hidden" name="overlapYn" id="overlapYn" value="<c:out value='${ipManageVO.overlapYn}'/>"/> 
<input type="hidden" name="regMode" id="regMode" value="u"/>
<input type="hidden" name="ipAdres" id="ipAdres" value="<c:out value='${ipManageVO.ipAdres}'/>"/>
<input type="hidden" name="searchIpAdres" id="searchIpAdres" value="<c:out value='${param.searchIpAdres}'/>"/>
<input type="hidden" name="searchHostNm" id="searchHostNm" value="<c:out value='${param.searchHostNm}'/>"/>
<input type="hidden" name="searchEqpmnKnd" id="searchEqpmnKnd" value="<c:out value='${param.searchEqpmnKnd}'/>"/>
<input type="hidden" name="searchNtwkDiv" id="searchNtwkDiv" value="<c:out value='${param.searchNtwkDiv}'/>"/>
<input type="hidden" name="pageIndex" id="pageIndex" value=<c:out value='${ipManageVO.pageIndex}'/> />
    
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
             <th class="left">서버 IP</th>
             <td><c:out value='${ipManageVO.ipAdres}'/></span></td>
             <th class="left">서브넷 마스크</th>
             <td><input type="text" name="subnetMask" id="subnetMask" maxlength="15" style="width:90%" value="<c:out value='${ipManageVO.subnetMask}'/>"/></td>          
           </tr>
           
           <tr>
             <th class="left">호스트명</th>
             <td><input type="text" name="hostNm" id="hostNm" style="width:90%" maxlength="50" value="<c:out value='${ipManageVO.hostNm}'/>"/></td>
             <th class="left">장비종류</th>
             <td>
               <input type="text" name="eqpmnKnd" id="eqpmnKnd" style="width:90%" maxlength="50" value="<c:out value='${ipManageVO.eqpmnKnd}'/>"/>
             </td>
           </tr>
           
           <tr>
             <th class="left">용도</th>
             <td>
             <input type="text" name="prpos" id="prpos" style="width:90%" maxlength="50" value="<c:out value='${ipManageVO.prpos}'/>"/>
             </td>
             <th class="left">망구분</th>
             <td>
               <select name="ntwkDiv" id="ntwkDiv" style="width:90%"/>
               	 <option value="">선택</option>
                 <c:forEach var="divCodes" items="${divCode}">
                 	<option value="${divCodes.code}" <c:if test='${ipManageVO.ntwkDiv == divCodes.code}'>selected="selected"</c:if>>${divCodes.codeNm}</option>
                 </c:forEach>
               </select>  
              </td>
           </tr>           
         </table>
      </fieldset>
    </div>  
        
    <p class="hd">비고</p>
    <textarea name="rm" id="rm" style="width:99%" rows="8"><c:out value='${ipManageVO.rm}'/></textarea>
     
	<div class="Fbt">
     <span class="btn_pack bt01"><button id="updateBtn" type="button">수정</button></span>
     <span class="btn_pack bt01"><button type="button" onclick="window.close();">닫기</button></span>
    </div>
	</form>
</div>
<!--popup e-->

</body>
</html>
