<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
 /**
  * @Class Name : EgovMainMenuIndex.jsp
  * @Description : MainMenuIndex Page
  * @Modification Information
  * @
  * @  수정일         수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2009.03.10    이용          최초 생성
  *
  *  @author 공통서비스 개발팀 이용
  *  @since 2009.03.10
  *  @version 1.0
  *  @see
  *  ?vStartP=<c:out value="${result.menuNo}"/> <c:out value="${result.chkURL}"/>
  */

%>

<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="refresh" content="0;url=#last">
<title>Menu Index frame</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">
</head>
<body>
<form name="areaform" action="" method="post">
<input type="hidden" name="ip" value='<c:out value="${list_pop.IP_ADRES}"/>'/>
<input type="hidden" name="acntid" value='<c:out value="${list_pop.ACNT_ID}"/>'/>
<input type="hidden" name="prtcl" value='<c:out value="${list_pop.PRTCL_CODE}"/>'/>
<input type="hidden" name="prtclNm" value='<c:out value="${list_pop.PRTCL_NM}"/>'/>
<input type="hidden" name="opert" value='<c:out value="${list_pop.OPERT_GROUP_ID}"/>'/>
<input type="hidden" name="unit" value='<c:out value="${list_pop.UNIT_OPERT_ID}"/>'/>
<input type="hidden" name="opertcn" value='<c:out value="${list_pop.OPERT_CN}"/>'/>
<input type="hidden" name="opertsn" value='<c:out value="${list_pop.OPERT_SN}"/>'/>
<input type="hidden" name="opertnm" value='<c:out value="${list_pop.UNIT_OPERT_NM}"/>'/>
<input type="hidden" name="executcnfrm" value='<c:out value="${list_pop.EXECUT_BFE_CNFIRM_AT}"/>'/>
<input type="hidden" name="excutdt" value='<c:out value="${list_pop.EXECUT_DT}"/>'/>
<input type="hidden" name="enddt" value='<c:out value="${list_pop.END_DT}"/>'/>
<input type="hidden" name="enddt_n" value='<c:out value="${list_next.END_DT}"/>'/>
<input type="hidden" name="nextrow" value='<c:out value="${list_next.NEXT_ROW}"/>'/>
<input type="hidden" name="userid" value='<c:out value="${loginVO.id}"/>'/>
</form>
<pre style="text-align:left; padding:10px">
<c:out value="${list_Ply.RESULT}"/>
</PRE>
<!--/textarea-->
<a name="last">
</body>
</html>