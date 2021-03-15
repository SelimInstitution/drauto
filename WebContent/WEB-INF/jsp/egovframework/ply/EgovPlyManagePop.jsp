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
<title><c:out value="${list_pop.UNIT_OPERT_NM}"/>결과보기</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">

<script type="text/javascript">
var check_time = ${check_time}; // 3초 마다 새로고침 시간 
var intervalID;

function change_iframe() {
	//alert("1");
	
	var nextrow = reFrame.document.areaform.nextrow.value;

	var ip_n = reFrame.document.areaform.ip.value;
	var acntId_n = reFrame.document.areaform.acntid.value;
	var prtcl_n = reFrame.document.areaform.prtcl.value;
	var prtcl_nm = reFrame.document.areaform.prtclNm.value;
	var opertGrpId_n = reFrame.document.areaform.opert.value;
	var unitOpert_n = reFrame.document.areaform.unit.value;
	var opertcn_n = reFrame.document.areaform.opertcn.value;
	var opertsn_n = reFrame.document.areaform.opertsn.value;
	var enddt_n = reFrame.document.areaform.enddt_n.value; // next 팝업을 띄우기 위한 종료시간
	var enddt = reFrame.document.areaform.enddt.value; // 실행전 확인 confirm 처리를 위한 종료시간
	var opertnm = reFrame.document.areaform.opertnm.value;
	var executcnfrm = reFrame.document.areaform.executcnfrm.value;
	var userid = reFrame.document.areaform.userid.value;
	var enddt_nn = "";
	var nextrow_n = "";
	//alert("enddt_n::>>>>"+enddt_n+"nextrow:::>>>"+nextrow);
	if(nextrow != "" && enddt_n != ""){
		//alert("nextrow:::>>>"+nextrow_n);
		//alert("1");
		window.open("<c:url value='/ply/playSamplePopup.do'/>?opertGrpId="
				+ opertGrpId_n + "&unitOpert=" + unitOpert_n + "&ip=" + ip_n
				+ "&acntId=" + acntId_n + "&prtcl=" + prtcl_n + "&userid=" + userid,
				"resultPop"+opertnm, "width=800, height=650");
		clearInterval(intervalID);
	} else if(nextrow == "" && enddt_n != ""){
		//alert("2");
		clearInterval(intervalID);
	} else  {
		//alert("3");
		var opert_executdt = document.listForm.opert_executdt.value;
		var frame_href = "/drauto/ply/playTexArea.do?opertGrpId=${param.opertGrpId}&unitOpert=${param.unitOpert}&ip=${param.ip}&acntId=${param.acntId}&prtcl=${param.prtcl}&userid="+userid+"&opert_executdt="+opert_executdt;
		reFrame.location.href = frame_href;
	}
	
} 
intervalID = setInterval("change_iframe()",check_time);

	function change_time(){
		var time = document.listForm.rser.value * 1000;
		document.listForm.check_time.value = time;
		
	    document.listForm.action = "<c:url value='/ply/playSamplePopup.do'/>";
	    document.listForm.submit();	
	}


	function executCnfirm() {
		//alert("load");
		var executCnfirm = document.listForm.executCnfirm.value;
		var enddt        = document.listForm.enddt.value; 
		var load         = document.listForm.load.value;
		
		if(load != "unload") {
			if (executCnfirm == "Y") {
				if (enddt == null || enddt == "") {
					if (confirm("실행전 확인작업을 완료하시겠습니까?")) {
					    document.listForm.action = "<c:url value='/ply/executBfeCnfirm.do'/>";
					    document.listForm.submit();	
					} else {
						alert("취소되었습니다.");
					}
				}
			}
	    }	
	}

	
	window.onload = function() {
		executCnfirm();
	}
	
	function stop_time(){
		clearInterval(intervalID);
	}
</script>
</head>


<body class="contPop">
<form name="listForm" action="" method="post">
<input type="hidden" name="check_time" value='<c:out value="${check_time}"/>'/>
<input type="hidden" name="executCnfirm" value='<c:out value="${list_pop.EXECUT_BFE_CNFIRM_AT}"/>'/>
<input type="hidden" name="enddt" value='<c:out value="${list_pop.enddt}"/>'/>
<input type="hidden" name="load" value='<c:out value="${unload}"/>'/>
<input type="hidden" name="prtcl" value='<c:out value="${list_pop.PRTCL_CODE}"/>'/>
<input type="hidden" name="opertGrpId" value='<c:out value="${list_pop.OPERT_GROUP_ID}"/>'/>
<input type="hidden" name="unitOpert" value='<c:out value="${list_pop.UNIT_OPERT_ID}"/>'/>
<input type="hidden" name="opert_executdt" value='<c:out value="${list_pop.OPERT_GROUP_EXECUT_DT}"/>'/>
<input type="hidden" name="userid" value="<c:out value="${loginVO.id}"/>"> 
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
             <th class="left">작업그룹명</th>
             <td><input type="text" name="opertGrpNm" style="width:90%" value='<c:out value="${list_pop.OPERT_GROUP_NM}"/>'/></td>
             <th class="left">IP 주소</th>
             <td><input type="text" name="ip" style="width:90%" value='<c:out value="${list_pop.IP_ADRES}"/>'/></td>          
           </tr>
           
           <tr>
             <th class="left">계정 ID</th>
             <td><input type="text" name="acntId" style="width:90%" value='<c:out value="${list_pop.ACNT_ID}"/>'/></td>
             <th class="left">프로토콜 종류</th>
             <td><input type="text" name="prtclNm" style="width:90%" value='<c:out value="${list_pop.PRTCL_NM}"/>'/></td>
           </tr>  
           
           <tr>
             <th class="left">단위작업명</th>
             <td><input type="text" name="unitOpertNm" style="width:90%" value='<c:out value="${list_pop.UNIT_OPERT_NM}"/>'/></td>
             <th class="left">작업내용</th>
             <td><input type="text" name="opertCn" style="width:90%" value='<c:out value="${list_pop.OPERT_CN}"/>'/></td>
           </tr>  
           <tr>
             <th class="left">재조회</th>
             <td colspan="3"><input type="text" name="rser" style="width:38%" value='<c:out value="${time_interval}"/>'/>
             <span class="btn_pack bt01"><button type="button" onclick="change_time(); return false;">재조회</button></span>
             <span class="btn_pack bt01"><button type="button" onclick="stop_time(); return false;">정지</button></span>
             </td>
           </tr>                               
         </table>
      </fieldset>
    </div>  
        
    
    <p class="hd">실행결과</p>
	<iframe src="/drauto/ply/playTexArea.do?opertGrpId=<c:out value="${list_pop.OPERT_GROUP_ID}"/>&unitOpert=<c:out value="${list_pop.UNIT_OPERT_ID}"/>&ip=<c:out value="${list_pop.IP_ADRES}"/>&acntId=<c:out value="${list_pop.ACNT_ID}"/>&prtcl=<c:out value="${list_pop.PRTCL_CODE}"/>
	&userid=<c:out value="${loginVO.id}"/>&opert_executdt=<c:out value="${list_pop.OPERT_GROUP_EXECUT_DT}"/>" scrolling="auto" noresize name="reFrame"
	width="100%" height="400" id="reFrame" allowTransparency="true" frameborder="0" style="border:#CCCCCC solid 1px"></iframe>    
	<div class="Fbt">
    	<span class="btn_pack bt01"><button type="button" onclick="window.close();">닫기</button></span>
    </div>

</div>
<!--popup e-->
</form>
</body>
</html>
<script type="text/javascript">

	//var reFrame = document.getElementById("reFrame");
	//alert(reFrame);
	reFrame.scrollTop="350";
</script>