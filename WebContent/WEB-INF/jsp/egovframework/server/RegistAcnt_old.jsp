<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
</head>


<body class="contPop">

<div class="PopupTop"><h1>계정 추가/삭제</h1> </div>

<!-- Contents start -->
<div class="Popup">         
      
    <div class="TBTop">
        <fieldset>
         <table width="100%" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <th>IP주소(필수)</th>
             <td><input type="text" name="ipAdres" style="width:90%"/></td>
             <th>계정ID(필수)</th>
             <td><input type="text" name="acntId" style="width:90%"/></td>          
           </tr>
           
           <tr>
             <th>프로토콜종류(필수)</th>
             <td>
             <form id="form2" name="form2" method="post" action="">
               <select name="prtclCode" id="#" style="width:90%"/>
                 <option>ㅇ</option>
                 <option>ㅇ</option>
               </select>            
             </form>             
             </td>
             <th>포트</th>
             <td><input type="text" name="port" style="width:90%"/></td>
           </tr>
           
           <tr>
             <th>비밀번호</th>
             <td><input type="text" name="password" style="width:90%"/></td>

           </tr>          
           
           <tr>
             <th>설명</th>
             <td colspan="3"><input type="text" name="dc" style="width:95%"/></td>
           </tr>              
         </table>
      </fieldset>
    </div>	
       

<div class="Fbt"><span class="btn_pack bt01"><button type="button">저장</button></span></div>

</div>
<!--popup e-->




</body>
</html>
