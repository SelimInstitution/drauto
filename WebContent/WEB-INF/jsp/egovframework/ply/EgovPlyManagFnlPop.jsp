<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>최종결과보기</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">
<script type="text/javascript">

</script>
</head>


<body class="contPop">
<form name="listForm" action="" method="post">
<input type="hidden" name="check_time"/>
<div class="PopupTop">
  <h1>결과보기</h1> 
</div>

<!-- Contents start -->
<div class="Popup">         
      
    <div class="TBTop">
        <fieldset>
         <table width="100%" border="0" cellspacing="0" cellpadding="0">
         
        <colgroup>
            <col width="" />
            <col width="38%" />
            <col width="" />
            <col width="38%" />            
        </colgroup>        
         
           <tr>
             <th>작업그룹명</th>
             <td><input type="text" name="opertGrpId" style="width:90%" value='<c:out value="${param.opertGrpId}"/>'/></td>
             <th>IP 주소</th>
             <td><input type="text" name="ip" style="width:90%" value='<c:out value="${param.ip}"/>'/></td>          
           </tr>
           
           <tr>
             <th>계정 ID</th>
             <td><input type="text" name="acntId" style="width:90%" value='<c:out value="${param.acntId}"/>'/></td>
             <th>프로토콜 종류</th>
             <td><input type="text" name="prtcl" style="width:90%" value='<c:out value="${param.prtcl}"/>'/></td>
           </tr>  
           
           <tr>
             <th>단위작업 ID</th>
             <td><input type="text" name="unitOpert" style="width:90%" value='<c:out value="${param.unitOpert}"/>'/></td>
             <th>작업내용</th>
             <td><input type="text" name="opertCn" style="width:90%" value='<c:out value="${param.opertCn}"/>'/></td>
           </tr>  
                              
         </table>
      </fieldset>
    </div>  
        
    
    <p class="hd">실행결과</p>
	<iframe src="/drauto/ply/playTexArea.do?opertGrpId=<c:out value="${param.opertGrpId}"/>&unitOpert=<c:out value="${param.unitOpert}"/>&ip=<c:out value="${param.ip}"/>&acntId=<c:out value="${param.acntId}"/>&prtcl=<c:out value="${param.prtcl}"/>" scrolling="auto" noresize frameborder=no name="reFrame"
	width="100%" height="350" id="reFrame"></iframe>    
	<div class="Fbt">
    	<span class="btn_pack bt01"><button type="button" onclick="window.close();">닫기</button></span>
    </div>

</div>
<!--popup e-->
</form>
</body>
</html>
