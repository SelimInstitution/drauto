<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="ajax" uri="http://ajaxtags.sourceforge.net/tags/ajaxtags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<title>정부통합전산센터 서버관리업무지원시스템</title>
<link rel="stylesheet" href="<c:url value='/css/egovframework/drauto/drauto.css'/>" type="text/css">

	<script type="text/javascript" src="/net/sourceforge/ajaxtags/js/prototype.js"></script>
	<script type="text/javascript" src="/net/sourceforge/ajaxtags/js/scriptaculous/scriptaculous.js"></script>
	<script type="text/javascript" src="/net/sourceforge/ajaxtags/js/overlibmws/overlibmws.js"></script>
	<script type="text/javascript" src="/net/sourceforge/ajaxtags/js/ajaxtags.js"></script>
	<link type="text/css" rel="stylesheet" href="/net/sourceforge/ajaxtags/css/ajaxtags.css" />
	<link type="text/css" rel="stylesheet" href="/net/sourceforge/ajaxtags/css/displaytag.css" />

	<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery-1.4.2.min.js' />"></script>
	<script type="text/javaScript" language="javascript" defer="defer">
		var opertTyCode = '<c:out value="${param.opertTyCode}" />';
		var opertOdr = '<c:out value="${param.opertOdr}" />';
		var maxOpertOdr;
		var opertGroupId;

		window.onload = function() {
			selectDR(0, 0);
		}

		function selectDR(_opertOdr, _opertGroupId) {

			$
					.ajax({
						url : '<c:url value='/dr/selectDrList.do'/>?opertDiv=1',
						data : {
							opertOdr : _opertOdr,
							opertGroupId : _opertGroupId,
							opertTyCode : opertTyCode
						},
						dataType : 'json',
						success : function(data) {

							maxOpertOdr = data.maxOpertOdr;

							var select = $('#opertOdr');
							var options = select.attr('options');
							$('option', select).remove();

							$.each(data.opertOdrList, function(index, array) {
								options[options.length] = new Option(array['OPERT_ODR']);
							});

							var selectedOrd;
							if (_opertOdr == '' || _opertOdr == '0')
								selectedOrd = maxOpertOdr;
							else
								selectedOrd = _opertOdr;

							$('#opertOdr').val(selectedOrd).attr('selected', 'selected');

							$("#lclasStttus1").removeClass(); $("#lclasStttus1").addClass(data.lclasStttus1);
							$("#lclasStttus2").removeClass(); $("#lclasStttus2").addClass(data.lclasStttus2);
							$("#lclasStttus3").removeClass(); $("#lclasStttus3").addClass(data.lclasStttus3);
							$("#lclasStttus4").removeClass(); $("#lclasStttus4").addClass(data.lclasStttus4);
							$("#lclasStttus5").removeClass(); $("#lclasStttus5").addClass(data.lclasStttus5);
							$("#lclasStttus6").removeClass(); $("#lclasStttus6").addClass(data.lclasStttus6);
							$("#lclasStttus7").removeClass(); $("#lclasStttus7").addClass(data.lclasStttus7);

							$("#LI_26").removeClass(); $("#LI_26").addClass(data.LI_26);
							$("#LI_27").removeClass(); $("#LI_27").addClass(data.LI_27);
							$("#LI_28").removeClass(); $("#LI_28").addClass(data.LI_28);
							$("#LI_29").removeClass(); $("#LI_29").addClass(data.LI_29);
							$("#LI_30").removeClass(); $("#LI_30").addClass(data.LI_30);
							$("#LI_31").removeClass(); $("#LI_31").addClass(data.LI_31);
							$("#LI_32").removeClass(); $("#LI_32").addClass(data.LI_32);
							$("#LI_33").removeClass(); $("#LI_33").addClass(data.LI_33);
							$("#LI_34").removeClass(); $("#LI_34").addClass(data.LI_34);
							$("#LI_35").removeClass(); $("#LI_35").addClass(data.LI_35);
							$("#LI_36").removeClass(); $("#LI_36").addClass(data.LI_36);
							$("#LI_37").removeClass(); $("#LI_37").addClass(data.LI_37);
							$("#LI_38").removeClass(); $("#LI_38").addClass(data.LI_38);
							$("#LI_39").removeClass(); $("#LI_39").addClass(data.LI_39);
							$("#LI_40").removeClass(); $("#LI_40").addClass(data.LI_40);
							$("#LI_41").removeClass(); $("#LI_41").addClass(data.LI_41);
							$("#LI_42").removeClass(); $("#LI_42").addClass(data.LI_42);
							$("#LI_43").removeClass(); $("#LI_43").addClass(data.LI_43);
							$("#LI_44").removeClass(); $("#LI_44").addClass(data.LI_44);
							$("#LI_45").removeClass(); $("#LI_45").addClass(data.LI_45);
							$("#LI_46").removeClass(); $("#LI_46").addClass(data.LI_46);
							$("#LI_47").removeClass(); $("#LI_47").addClass(data.LI_47);
							$("#LI_48").removeClass(); $("#LI_48").addClass(data.LI_48);
							$("#LI_49").removeClass(); $("#LI_49").addClass(data.LI_49);
							$("#LI_50").removeClass(); $("#LI_50").addClass(data.LI_50);

							$("#A_26").removeClass(); $("#A_26").addClass(data.A_26);
							$("#A_27").removeClass(); $("#A_27").addClass(data.A_27);
							$("#A_28").removeClass(); $("#A_28").addClass(data.A_28);
							$("#A_29").removeClass(); $("#A_29").addClass(data.A_29);
							$("#A_30").removeClass(); $("#A_30").addClass(data.A_30);
							$("#A_31").removeClass(); $("#A_31").addClass(data.A_31);
							$("#A_32").removeClass(); $("#A_32").addClass(data.A_32);
							$("#A_33").removeClass(); $("#A_33").addClass(data.A_33);
							$("#A_34").removeClass(); $("#A_34").addClass(data.A_34);
							$("#A_35").removeClass(); $("#A_35").addClass(data.A_35);
							$("#A_36").removeClass(); $("#A_36").addClass(data.A_36);
							$("#A_37").removeClass(); $("#A_37").addClass(data.A_37);
							$("#A_38").removeClass(); $("#A_38").addClass(data.A_38);
							$("#A_39").removeClass(); $("#A_39").addClass(data.A_39);
							$("#A_40").removeClass(); $("#A_40").addClass(data.A_40);
							$("#A_41").removeClass(); $("#A_41").addClass(data.A_41);
							$("#A_42").removeClass(); $("#A_42").addClass(data.A_42);
							$("#A_43").removeClass(); $("#A_43").addClass(data.A_43);
							$("#A_44").removeClass(); $("#A_44").addClass(data.A_44);
							$("#A_45").removeClass(); $("#A_45").addClass(data.A_45);
							$("#A_46").removeClass(); $("#A_46").addClass(data.A_46);
							$("#A_47").removeClass(); $("#A_47").addClass(data.A_47);
							$("#A_48").removeClass(); $("#A_48").addClass(data.A_48);
							$("#A_49").removeClass(); $("#A_49").addClass(data.A_49);
							$("#A_50").removeClass(); $("#A_50").addClass(data.A_50);

							var tbl = '';
							var att;

							$
									.each(
											data.dsstrRecovryList,
											function(index, entry) {
												if (entry["OPERT_STTUS"] == 'ov_02') {
													att = '진행중';
												} else if (entry["OPERT_STTUS"] == 'ov_03') {
													att = '완료';
												} else if (entry["OPERT_STTUS"] == 'ov_04') {
													att = '오류';
												} else {
													att = '실행전';
												}

												tbl += "<tr class=\""+entry["OPERT_STTUS"]+"\"><td class=\"center\">"
														+ entry["OPERT_SN"]
														+ "</td><td class=\"center\">"
														+ entry["HOST_NM"]
														+ "</td><td class=\"left\">"
														+ entry["IP_ADRES"]
														+ "</td><td class=\"center\">"
														+ entry["EQPMN_NM"]
														+ "</td><td class=\"center\">"+att+"</td><td class=\"left\">"
														+ entry["UNIT_OPERT_NM"]
														+ "</td><td></td></tr>";
											});
							$('#unitOpertList').empty();
							$('#unitOpertList').append(tbl);
						}
					});
		}

		// 차수를 추가한다.
		function fnOpertOdrAdit() {
			if (!confirm('차수를 추가하시겠습니까?')) {
				return false();
			}

			$
					.ajax({
						url : '<c:url value='/dr/insertOpertOdr.do'/>?opertDiv=1&opertTyCode=DR0002&crtrId=<c:out value="${loginVO.id}" />',
						success : function(data) {
							if (data.insertAt == 'true') {
								alert('추가되었습니다.');
							}

							var odr;
							if (opertOdr != '')
								odr = opertOdr;
							else
								odr = maxOpertOdr;

							selectDR(odr, opertGroupId);
						}
					});
		}

		// 작업그룹 선택
		function checkOpertGroup(_opertGroupId) {
			$('#opertGroupNm').empty();
			$('#opertGroupNm').append($('#LI_'+_opertGroupId).text());
			opertGroupId = _opertGroupId;

			var odr;
			if (opertOdr != '')
				odr = opertOdr;
			else
				odr = maxOpertOdr;

			selectDR(odr, _opertGroupId);
		}

		var insertAt = '<c:out value="${insertAt}"/>';
		if (insertAt == 'true') {
			alert("추가되었습니다.");
		}

		// 차수를 선택한다.
		function fnChangeOdr() {
			opertGroupId = 0;
			
			opertOdr = $("#opertOdr > option:selected").val();
			$('#unitOpertList').empty();
			$('#opertGroupNm').empty();
			$('#opertGroupNm').append("제목");

			selectDR(opertOdr, 0);
		}

		function shMenu(num) {
			var curSta = document.getElementById('menu_s' + num).style.display;
			if (curSta != "none") {
				document.getElementById('menu_s' + num).style.display = "none";
			} else {
				//for(i=1;i<7;i++){
				//document.getElementById('menu_s' + i).style.display = "none";
				//}
				document.getElementById('menu_s' + num).style.display = "block";
			}
		}

		var refreshId = setInterval(function() {
			var odr;
			if (opertOdr != '')
				odr = opertOdr;
			else
				odr = maxOpertOdr;

			selectDR(odr, opertGroupId);
		}, 3000);

	</script>
</head>


<body>
	<div id="dr_wrap">
		<!--탑메뉴 시작-->
		<div id="dr_header">
			<h1>
				<img src="/drauto/images/egovframework/drauto/main/dr_tit.gif" alt="DR 작업현황" onclick="ajax();" />
			</h1>
			<ul class="gnb">
				<li id="lclasStttus1" class="fix0"><span class="tit">01 기타 소프트웨어</span></li>
				<li id="lclasStttus2" class="fix0"><span class="tit">02 WEB 가동</span></li>
				<li id="lclasStttus3" class="fix0"><span class="tit">03 WAS 가동</span></li>
				<li id="lclasStttus4" class="fix0"><span class="tit">04 DB 가동</span></li>
				<li id="lclasStttus5" class="fix0"><span class="tit">05 서버변경작업</span></li>
				<li id="lclasStttus6" class="fix0"><span class="tit">06 방화벽</span></li>
				<li id="lclasStttus7" class="fix0"><span class="tit">07 네트워크</span></li>
			</ul>
		</div>
		<!--탑메뉴 끝-->

		<table width="99%" border="0" cellspacing="0" cellpadding="0">
  		<tr>
   		 <td width="300" valign="top">
		<!-- left start -->
    		<div class="dr_left">
				<h2>작업진행현황</h2> 
					<select id="opertOdr" name="opertOdr" onChange="fnChangeOdr();"  style="width:140px">
						<option></option>
					</select> <span class="btn_pack bt01"><button type="button" onclick="fnOpertOdrAdit()">차수 추가</button></span>
				
		
				<!-- Left start -->
				<div class="submenu">
					<ul class="menu">
						<li>
							<div id="menu_m1" onclick="shMenu(1);">
								<a id="menu_ma1" class="">기타소프트웨어</a>
							</div>
							<div id="menu_s1">
								<ul>
									<li id="LI_26"><a href="javascript:checkOpertGroup('26');" id="A_26">멜일서버 가동</a></li>
									<li id="LI_27"><a href="javascript:checkOpertGroup('27');" id="A_27">아큐브 가동</a></li>
									<li id="LI_28"><a href="javascript:checkOpertGroup('28');" id="A_28">대급지금</a></li>
									<li id="LI_29"><a href="javascript:checkOpertGroup('29');" id="A_29">인증데몬가동</a></li>
									<li id="LI_30"><a href="javascript:checkOpertGroup('30');" id="A_30">연계모듈가동</a></li>
								</ul>
							</div>
						</li>
						<li>
							<div id="menu_m2" onclick="shMenu(2);">
								<a id="menu_ma2" class="">WEB가동</a>
							</div>
							<div id="menu_s2">
								<ul>
									<li id="LI_31"><a href="javascript:checkOpertGroup('31');" id="A_31">공지사항 제거 서비스 오픈</a></li>
									<li id="LI_32"><a href="javascript:checkOpertGroup('32');" id="A_32">webtob 가동</a></li>
									<li id="LI_33"><a href="javascript:checkOpertGroup('33');" id="A_33">iPlanet 웹서버 가동</a></li>
								</ul>
							</div>
						</li>						
						<li>
							<div id="menu_m3" onclick="shMenu(3);">
								<a id="menu_ma3" class="">WAS가동</a>
							</div>
							<div id="menu_s3">
								<ul>
									<li id="LI_34"><a href="javascript:checkOpertGroup('34');" id="A_34">로그인 프로그램 재기동</a></li>
									<li id="LI_35"><a href="javascript:checkOpertGroup('35');" id="A_35">오라클10gAs가동</a></li>
									<li id="LI_36"><a href="javascript:checkOpertGroup('36');" id="A_36">jeus가동</a></li>
									<li id="LI_37"><a href="javascript:checkOpertGroup('37');" id="A_37">manag-server가동</a></li>
									<li id="LI_38"><a href="javascript:checkOpertGroup('38');" id="A_38">admin-server가동</a></li>
								</ul>
							</div>
						</li>						
						<li>
							<div id="menu_m4" onclick="shMenu(4);">
								<a id="menu_ma4" class="">DB가동</a>
							</div>
							<div id="menu_s4">
								<ul>
									<li id="LI_39"><a href="javascript:checkOpertGroup('39');" id="A_39">오라클기동</a></li>
									<li id="LI_40"><a href="javascript:checkOpertGroup('40');" id="A_40">리스너기동</a></li>
								</ul>
							</div>
						</li>
						<li>
							<div id="menu_m5" onclick="shMenu(5);">
								<a id="menu_ma5" class="">서버변경작업</a>
							</div>
							<div id="menu_s5">
								<ul>
									<li id="LI_41"><a href="javascript:checkOpertGroup('41');" id="A_41">스토리지 마운트</a></li>
									<li id="LI_42"><a href="javascript:checkOpertGroup('42');" id="A_42">vfstab/fstab</a></li>
									<li id="LI_43"><a href="javascript:checkOpertGroup('43');" id="A_43">hosts/netconf 변경</a></li>
									<li id="LI_44"><a href="javascript:checkOpertGroup('44');" id="A_44">group 변경</a></li>
									<li id="LI_45"><a href="javascript:checkOpertGroup('45');" id="A_45">default router 변경</a></li>
									<li id="LI_46"><a href="javascript:checkOpertGroup('46');" id="A_46">passwd변경</a></li>
									<li id="LI_47"><a href="javascript:checkOpertGroup('47');" id="A_47">ip 변경</a></li>
								</ul>
							</div>
						</li>
						<li>
							<div id="menu_m6" onclick="shMenu(6);">
								<a id="menu_ma6" class="">방화벽</a>
							</div>
							<div id="menu_s6">
								<ul>
									<li id="LI_48"><a href="javascript:checkOpertGroup('48');" id="A_48">실시간 수작업이 필요</a></li>
								</ul>
							</div>
						</li>
						<li>
							<div id="menu_m7" onclick="shMenu(7);">
								<a id="menu_ma7" class="">네트워크</a>
							</div>
							<div id="menu_s7">
								<ul>
									<li id="LI_49"><a href="javascript:checkOpertGroup('49');" id="A_49">라우팅 설정</a></li>
									<li id="LI_50"><a href="javascript:checkOpertGroup('50');" id="A_50">VLAN 설정</a></li>
								</ul>
							</div>
						</li>
						
						
					</ul>

				</div>
			</div>
    </td>
    <!-- left end -->
      
    <!-- right start -->
    <td valign="top">     
    <div class="dr_right">

				<h3 id="opertGroupNm">제목</h3>

				<table class="dataTable">
					<thead>
						<tr>
							<th width="30">순번</th>
							<th width="150">호스트명</th>
							<th width="100">IP</th>
							<th>장비명</th>
							<th width="80">작업상태</th>
							<th>단위작업명</th>
							<th>오류내용</th>
						</tr>
					</thead>

					<tbody id="unitOpertList">

					</tbody>
				</table>

			</div>
    </td>
    <!-- right end -->   

</tr>
</table>

</div>
</body>
</html>