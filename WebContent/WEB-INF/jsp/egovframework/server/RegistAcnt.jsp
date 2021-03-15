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

	$(function() {
		$("#port").numeric(); //영문과 숫자중 숫자만 받는다.
	});

	var insertAt = '<c:out value="${insertAt}"/>';

	function loaded() {
		var param = "searchUseYn=Y";
		param += "&checkIpAdres="+document.insert_acnt.ipAdres.value;
		param += "&ipAdres="+document.insert_acnt.o_ipAdres.value;
		param += "&hostNm="+document.insert_acnt.o_hostNm.value;
		param += "&osCode="+document.insert_acnt.o_osCode.value;
		param += "&pageIndex="+document.insert_acnt.o_pageIndex.value;
		
		if (insertAt == 'true') {
			alert("저장되었습니다.");
			
			opener.location.href = '<c:url value='/server/serverList.do' />?'+param;
			//opener.window.location.reload();
		}
	}

	// 계정 중복 확인
	var acnt_dup = '<c:out value="${acntDplct}"/>';
	if (acnt_dup != null && acnt_dup == 'true') {
		alert('이미 등록된 계정 입니다.');
	}

	// 계정 등록
	function checkForm() {
		var f = document.insert_acnt;
	
		if (f.ipAdres.value == '') {
			alert("IP 주소가 선택되지 않았습니다.\\n창을 닫은 후 서버를 선택하고 다시 추가해주세요.");
			return false;
		}
		
		if (f.acntId.value == '') {
			alert("계정 ID를 입력하세요.");
			return false;
		}
		
		if (f.prtclCode.value == '') {
			alert("프로토콜 종류를 선택하세요.");
			return false;
		}
		
		if (f.password.value != f.passwordCnfirm.value) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		
		document.insert_acnt.submit();
	}
	
	function onlyNum(obj) {
		var str = obj.value;
		obj.value = str.replace(/[^0-9]/g, '');
	}	

</script>

</head>


<body class="contPop" onload="loaded();">

<div class="PopupTop"><h1>계정 추가</h1> </div>

<form name="insert_acnt" method="post" action="<c:url value='/server/insertAcnt.do' />">
<input type="hidden" name="o_ipAdres" value="<c:out value="${param.o_ipAdres}" />" />
<input type="hidden" name="o_hostNm" value="<c:out value="${param.o_hostNm}" />" />
<input type="hidden" name="o_osCode" value="<c:out value="${param.o_osCode}" />" />
<input type="hidden" name="o_pageIndex" value="<c:out value="${param.o_pageIndex}" />" />

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
             <th class="left">IP주소 <font color="red">*</font></th>
             <td><c:out value="${param.ipAdres}" /><input type="hidden" name="ipAdres" value="<c:out value="${param.ipAdres}" />" style="width:90%"/></td>
             <th class="left">계정ID <font color="red">*</font></th>
             <td><input type="text" name="acntId" style="width:90%"/></td>          
           </tr>
           
           <tr>
             <th class="left">프로토콜종류 <font color="red">*</font></th>
             <td>
               <select name="prtclCode" id="#" style="width:90%"/>
               <c:forEach var="prtclList" items="${prtclList}" varStatus="status">
                 <option value="<c:out value="${prtclList.CODE}"/>"><c:out value="${prtclList.CODE_NM}"/></option>
               </c:forEach>
               </select>                         
             </td>
             <th class="left">포트</th>
             <td><input type="text" name="port" id="port" style="width:90%;ime-mode:disabled" onkeyup="onlyNum(this);" onchange="onlyNum(this);" /></td>
           </tr>
           
           <tr>
             <th class="left">비밀번호</th>
             <td><input type="password" name="password" style="width:90%"/></td>
             <th class="left">비밀번호 확인</th>
             <td><input type="password" name="passwordCnfirm" style="width:90%"/></td>             
           </tr>         
           
           <tr>
             <th class="left">프롬프트</th>
             <td colspan="3"><input type="text" name="prompt" style="width:96%"/></td>
           </tr>              
           
           <tr>
             <th class="left">설명</th>
             <td colspan="3"><input type="text" name="dc" style="width:96%"/></td>
           </tr>              
         </table>
      </fieldset>
    </div>	
       

<div class="Fbt"><span class="btn_pack bt01"><button type="button" onclick="checkForm();">저장</button></span>
<span class="btn_pack bt01"><button type="button" onclick="window.close();">닫기</button></span>
</div>
</form>
</div>
<!--popup e-->




</body>
</html>
