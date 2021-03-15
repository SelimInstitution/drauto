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

function loaded() {
	var updtResult = '<c:out value="${updtResult}" />';
	
	if (updtResult > 0) {
		alert("수정되었습니다.");
		
		var param = "searchUseYn="+document.update_acnt.o_searchUseYn.value;
		param += "&ipAdres="+document.update_acnt.o_ipAdres.value;
		param += "&hostNm="+document.update_acnt.o_hostNm.value;
		param += "&osCode="+document.update_acnt.o_osCode.value;
		param += "&checkIpAdres="+document.update_acnt.o_checkIpAdres.value;
		param += "&checkAcntId="+document.update_acnt.o_checkAcntId.value;
		param += "&checkPrtclCode="+document.update_acnt.o_prtclCode.value;
		param += "&pageIndex="+document.update_acnt.o_pageIndex.value;	
		
		opener.location.href = '<c:url value='/server/serverList.do' />?'+param;
		//opener.window.location.reload();
	}
}

function checkForm() {
	var f = document.update_acnt;

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
	
	document.update_acnt.submit();
}

function onlyNum(obj) {
	var str = obj.value;
	obj.value = str.replace(/[^0-9]/g, '');
}

</script>

</head>


<body class="contPop" onload="loaded();">

<div class="PopupTop"><h1>계정 수정</h1> </div>

<form name="update_acnt" method="post" action="<c:url value='/server/updateAcnt.do' />">

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
             <th class="left">IP주소 <font color="red">*</font></th>
             <td><c:out value="${param.ipAdres}" /><input type="hidden" name="ipAdres" value="<c:out value="${acntList.ipAdres}"/>" />
             </td>
             <th class="left">계정ID <font color="red">*</font></th>
             <td><c:out value="${acntList.acntId}"/><input type="hidden" name="acntId" value="<c:out value="${acntList.acntId}"/>" /></td>
           </tr>
           
           <tr>
             <th class="left">프로토콜 <font color="red">*</font></th>
             <td><c:out value="${acntList.prtclNm}"/><input type="hidden" name="prtclCode" value="<c:out value="${acntList.prtclCode}"/>" /></td>
             <th class="left">포트</th>
             <td><input type="text" name="port" class="numeric" value="<c:out value="${acntList.port}"/>" style="width:90%;ime-mode:disabled;" 
             onkeyup="onlyNum(this);" onchange="onlyNum(this);" /></td>
           </tr>
           
           <tr>
             <th class="left">비밀번호</th>
             <td><input type="password" name="password" value="<c:out value="${acntList.password}"/>" style="width:90%"/></td>
             <th class="left">비밀번호 확인</th>
             <td><input type="password" name="passwordCnfirm" value="<c:out value="${acntList.password}"/>" style="width:90%"/></td>             
           </tr>         
           
           <tr>
             <th class="left">프롬프트</th>
             <td colspan="3"><input type="text" value="<c:out value="${acntList.prompt}"/>" name="prompt" style="width:96%"/></td>
           </tr>              
           
           <tr>
             <th class="left">설명</th>
             <td colspan="3"><input type="text" name="dc" value="<c:out value="${acntList.dc}"/>" style="width:96%"/></td>
           </tr>              
         </table>
      </fieldset>
    </div>	
       

<div class="Fbt"><span class="btn_pack bt01"><button type="button" onclick="checkForm();">수정</button></span>
<span class="btn_pack bt01"><button type="button" onclick="window.close();">닫기</button></span>
</div>
</form>
</div>
<!--popup e-->




</body>
</html>
