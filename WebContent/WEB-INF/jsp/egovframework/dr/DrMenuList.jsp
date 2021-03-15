<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>정부통합전산센터 서버관리업무지원시스템</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">

<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />" ></script>
<script type="text/javaScript" language="javascript" defer="defer">

	var opertOdr = '<c:out value="${param.opertOdr}" />';
	
	function checkOpertGroup(opertGroupId) {

		parent.location.href = "<c:url value='/dr/selectDrList.do'/>?opertOdr="+opertOdr+"&opertGroupId="+opertGroupId;
	}
</script>

</head>


<body>
<!-- Left start -->
<div class="iframe">
<ul class="menu">
  <li><a href="">네트워크</a>
    <ul>
      <li class="<c:out value="${LI_57}" />"><a href="javascript:checkOpertGroup('57');" class="<c:out value="${A_57}" />">VLAN 설정</a></li>
      <li class="<c:out value="${LI_58}" />"><a href="javascript:checkOpertGroup('58');" class="<c:out value="${A_58}" />">라우팅 설정</a></li>
    </ul>
  </li>
  
  <li><a href="">방화벽</a>
  <ul>
      <li class="<c:out value="${LI_59}" />"><a href="javascript:checkOpertGroup('59');" class="<c:out value="${A_59}" />">실시간 수작업이 필요</a></li>
    </ul>
  </li>
  
  <li><a href="" class="select">서버변경작업</a>
  <ul>
      <li class="<c:out value="${LI_60}" />"><a href="javascript:checkOpertGroup('60');" class="<c:out value="${A_60}" />">ip 변경</a></li>
      <li class="<c:out value="${LI_61}" />"><a href="javascript:checkOpertGroup('61');" class="<c:out value="${A_61}" />">passwd변경</a></li>  
      <li class="<c:out value="${LI_62}" />"><a href="javascript:checkOpertGroup('62');" class="<c:out value="${A_62}" />">defaultrouter 변경</a></li>      
      <li class="<c:out value="${LI_63}" />"><a href="javascript:checkOpertGroup('63');" class="<c:out value="${A_63}" />">group 변경</a></li>      
      <li class="<c:out value="${LI_64}" />"><a href="javascript:checkOpertGroup('64');" class="<c:out value="${A_64}" />">hosts(sun)/netconf(HP) 변경</a></li>      
      <li class="<c:out value="${LI_65}" />"><a href="javascript:checkOpertGroup('65');" class="<c:out value="${A_65}" />">vfstab(sun)/fstab(HP)</a></li>      
      <li class="<c:out value="${LI_66}" />"><a href="javascript:checkOpertGroup('66');" class="<c:out value="${A_66}" />">스토리지 마운트</a></li>                              
    </ul>
  </li>
  
  <li><a href="">DB가동</a>
  <ul>
      <li class="<c:out value="${LI_67}" />"><a href="javascript:checkOpertGroup('67');" class="<c:out value="${A_67}" />">리스너기동</a></li>
      <li class="<c:out value="${LI_68}" />"><a href="javascript:checkOpertGroup('68');" class="<c:out value="${A_68}" />">오라클기동</a></li>      
    </ul>
  </li>
  
  <li><a href="">WAS가동</a>
  <ul>
      <li class="<c:out value="${LI_69}" />"><a href="javascript:checkOpertGroup('69');" class="<c:out value="${A_69}" />">admin-server가동</a></li>
      <li class="<c:out value="${LI_70}" />"><a href="javascript:checkOpertGroup('70');" class="<c:out value="${A_70}" />">manag-server가동</a></li>  
      <li class="<c:out value="${LI_71}" />"><a href="javascript:checkOpertGroup('71');" class="<c:out value="${A_71}" />">jeus가동</a></li>
      <li class="<c:out value="${LI_72}" />"><a href="javascript:checkOpertGroup('72');" class="<c:out value="${A_72}" />">오라클10gAs가동</a></li>    
      <li class="<c:out value="${LI_73}" />"><a href="javascript:checkOpertGroup('73');" class="<c:out value="${A_73}" />">로그인 프로그램 재기동</a></li>                    
    </ul>
  </li>  

  <li><a href="">WEB가동</a>
  <ul>
      <li class="<c:out value="${LI_74}" />"><a href="javascript:checkOpertGroup('74');" class="<c:out value="${A_74}" />">iPlanet 웹서버 가동</a></li>
      <li class="<c:out value="${LI_75}" />"><a href="javascript:checkOpertGroup('75');" class="<c:out value="${A_75}" />">webtob 가동</a></li> 
      <li class="<c:out value="${LI_76}" />"><a href="javascript:checkOpertGroup('76');" class="<c:out value="${A_76}" />">공지사항 제거 서비스 오픈</a></li>            
    </ul>
  </li>  
  
  <li><a href="">기타소프트웨어</a>
  <ul>
      <li class="<c:out value="${LI_77}" />"><a href="javascript:checkOpertGroup('77');" class="<c:out value="${A_77}" />">연계모듈가동</a></li>
      <li class="<c:out value="${LI_78}" />"><a href="javascript:checkOpertGroup('78');" class="<c:out value="${A_78}" />">인증데몬가동</a></li>      
      <li class="<c:out value="${LI_79}" />"><a href="javascript:checkOpertGroup('79');" class="<c:out value="${A_79}" />">대급지금</a></li>
      <li class="<c:out value="${LI_80}" />"><a href="javascript:checkOpertGroup('80');" class="<c:out value="${A_80}" />">아큐브 가동</a></li>      
      <li class="<c:out value="${LI_81}" />"><a href="javascript:checkOpertGroup('81');" class="<c:out value="${A_81}" />">멜일서버 가동</a></li>                  
    </ul>
  </li>        
</ul>

</div>
<!-- Left end -->
  
</body>
</html>