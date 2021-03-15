<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>IP 등록</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />" ></script>

<c:if test="${!empty messageOverlap}">	
	<script type="text/javaScript" language="javascript" defer="defer">
			alert("<c:out value='${messageOverlap}' />");
	</script>
</c:if>
<script type="text/javaScript" language="javascript" defer="defer">
var expIpAdres = /^(1|2)?\d?\d([.](1|2)?\d?\d){3}$/;
jQuery(document).ready(function($) {
	
	$("#insertBtn").bind("click",function() {
		if($("#overlapYn").val() == "N"){
			if(!expIpAdres.test($("#ipAdres").val())){
				alert("잘못된 IP주소입니다.");	
				return;
			}
			if(!expIpAdres.test($("#subnetMask").val())){
				alert("잘못된 서브넷마스크 입니다.");	
				return;
			}
			
			if($("#inputIpAdres").val()==$("#ipAdres").val()){
				document.ipManageView.action="/drauto/ipm/isnertIPManage.do";
				document.ipManageView.submit();
			}else{
				alert("변경되었거나 중복된 서버IP입니다. \n다시 입력 후 중복확인 바랍니다.");	
			}
		}else{
			
			alert("서버IP를 입력 후 중복확인을 하셔야 합니다.");
		}
	});
	
	$("#overlapBtn").bind("click",function() {
		
		if($("#ipAdres").val()!=""){
			if(expIpAdres.test($("#ipAdres").val())){
		  		document.ipManageView.action="/drauto/ipm/overlapIP.do";
		  		document.ipManageView.submit();
			}else{
				alert('잘못된 IP 주소 입니다.');
			}
		}else{
			alert("IP를 입력해 주세요.");
		}
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
<form name = "ipManageView" id="ipManageView" method="post" action="/drauto/ipm/isnertIPManage.do" >
<input type="hidden" name="overlapYn" id="overlapYn" value="<c:out value='${ipManageVO.overlapYn}'/>"/>
<input type="hidden" name="regMode" id="regMode" value="i"/>  
<input type="hidden" name="inputIpAdres" id="inputIpAdres" value="<c:out value='${ipManageVO.ipAdres}'/>"/>    
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
             <td><input type="text" name="ipAdres" id="ipAdres" style="width:60%"  maxlength="15" value="<c:out value='${ipManageVO.ipAdres}'/>"/> <span class="btn_pack bt01"><button type="button" id="overlapBtn">중복확인</button></span></td>
             <th class="left">서브넷 마스크</th>
             <td><input type="text" name="subnetMask" id="subnetMask"  style="width:90%"  maxlength="15" value="<c:out value='${ipManageVO.subnetMask}'/>"/></td>          
           </tr>
           
           <tr>
             <th class="left">호스트명</th>
             <td><input type="text" name="hostNm" id="hostNm" style="width:90%" maxlength="50"  value="<c:out value='${ipManageVO.hostNm}'/>"/></td>
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
	<span class="btn_pack bt01"><button id="insertBtn" type="button">저장</button></span>
	<span class="btn_pack bt01"><button type="button" onclick="window.close();">닫기</button></span>
    </div>
	</form>
</div>
<!--popup e-->

</body>
</html>
