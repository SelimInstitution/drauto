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

							$("#LI_1").removeClass(); $("#LI_1").addClass(data.LI_1);
							$("#LI_2").removeClass(); $("#LI_2").addClass(data.LI_2);
							$("#LI_3").removeClass(); $("#LI_3").addClass(data.LI_3);
							$("#LI_4").removeClass(); $("#LI_4").addClass(data.LI_4);
							$("#LI_5").removeClass(); $("#LI_5").addClass(data.LI_5);
							$("#LI_6").removeClass(); $("#LI_6").addClass(data.LI_6);
							$("#LI_7").removeClass(); $("#LI_7").addClass(data.LI_7);
							$("#LI_8").removeClass(); $("#LI_8").addClass(data.LI_8);
							$("#LI_9").removeClass(); $("#LI_9").addClass(data.LI_9);
							$("#LI_10").removeClass(); $("#LI_10").addClass(data.LI_10);
							$("#LI_11").removeClass(); $("#LI_11").addClass(data.LI_11);
							$("#LI_12").removeClass(); $("#LI_12").addClass(data.LI_12);
							$("#LI_13").removeClass(); $("#LI_13").addClass(data.LI_13);
							$("#LI_14").removeClass(); $("#LI_14").addClass(data.LI_14);
							$("#LI_15").removeClass(); $("#LI_15").addClass(data.LI_15);
							$("#LI_16").removeClass(); $("#LI_16").addClass(data.LI_16);
							$("#LI_17").removeClass(); $("#LI_17").addClass(data.LI_17);
							$("#LI_18").removeClass(); $("#LI_18").addClass(data.LI_18);
							$("#LI_19").removeClass(); $("#LI_19").addClass(data.LI_19);
							$("#LI_20").removeClass(); $("#LI_20").addClass(data.LI_20);
							$("#LI_21").removeClass(); $("#LI_21").addClass(data.LI_21);
							$("#LI_22").removeClass(); $("#LI_22").addClass(data.LI_22);
							$("#LI_23").removeClass(); $("#LI_23").addClass(data.LI_23);
							$("#LI_24").removeClass(); $("#LI_24").addClass(data.LI_24);
							$("#LI_25").removeClass(); $("#LI_25").addClass(data.LI_25);

							$("#A_1").removeClass(); $("#A_1").addClass(data.A_1);
							$("#A_2").removeClass(); $("#A_2").addClass(data.A_2);
							$("#A_3").removeClass(); $("#A_3").addClass(data.A_3);
							$("#A_4").removeClass(); $("#A_4").addClass(data.A_4);
							$("#A_5").removeClass(); $("#A_5").addClass(data.A_5);
							$("#A_6").removeClass(); $("#A_6").addClass(data.A_6);
							$("#A_7").removeClass(); $("#A_7").addClass(data.A_7);
							$("#A_8").removeClass(); $("#A_8").addClass(data.A_8);
							$("#A_9").removeClass(); $("#A_9").addClass(data.A_9);
							$("#A_10").removeClass(); $("#A_10").addClass(data.A_10);
							$("#A_11").removeClass(); $("#A_11").addClass(data.A_11);
							$("#A_12").removeClass(); $("#A_12").addClass(data.A_12);
							$("#A_13").removeClass(); $("#A_13").addClass(data.A_13);
							$("#A_14").removeClass(); $("#A_14").addClass(data.A_14);
							$("#A_15").removeClass(); $("#A_15").addClass(data.A_15);
							$("#A_16").removeClass(); $("#A_16").addClass(data.A_16);
							$("#A_17").removeClass(); $("#A_17").addClass(data.A_17);
							$("#A_18").removeClass(); $("#A_18").addClass(data.A_18);
							$("#A_19").removeClass(); $("#A_19").addClass(data.A_19);
							$("#A_20").removeClass(); $("#A_20").addClass(data.A_20);
							$("#A_21").removeClass(); $("#A_21").addClass(data.A_21);
							$("#A_22").removeClass(); $("#A_22").addClass(data.A_22);
							$("#A_23").removeClass(); $("#A_23").addClass(data.A_23);
							$("#A_24").removeClass(); $("#A_24").addClass(data.A_24);
							$("#A_25").removeClass(); $("#A_25").addClass(data.A_25);

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
						url : '<c:url value='/dr/insertOpertOdr.do'/>?opertDiv=1&opertTyCode=DR0001&crtrId=<c:out value="${loginVO.id}" />',
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
				<li id="lclasStttus1" class="fix0"><span class="tit">01 네트워크</span></li>
				<li id="lclasStttus2" class="fix0"><span class="tit">02 방화벽</span></li>
				<li id="lclasStttus3" class="fix0"><span class="tit">03 서버변경작업</span></li>
				<li id="lclasStttus4" class="fix0"><span class="tit">04 DB 가동</span></li>
				<li id="lclasStttus5" class="fix0"><span class="tit">05 WAS 가동</span></li>
				<li id="lclasStttus6" class="fix0"><span class="tit">06 WEB 가동</span></li>
				<li id="lclasStttus7" class="fix0"><span class="tit">07 기타 소프트웨어</span></li>
			</ul>
		</div>
		<!--탑메뉴 끝-->

		<table width="99%" border="0" cellspacing="0" cellpadding="0">
  		<tr>
   		 <td width="300">
		<!-- left start -->
    		<div class="dr_left">
				<h2>작업진행현황 </h2>
					<select id="opertOdr" name="opertOdr" onChange="fnChangeOdr();" style="width:140px">
						<option></option>
					</select><span class="btn_pack bt01"><button type="button" onclick="fnOpertOdrAdit()">차수 추가</button></span>
				
			
				<!-- Left start -->
				<div class="submenu">
					<ul class="menu">
						<li>
							<div id="menu_m1" onclick="shMenu(1);">
								<a id="menu_ma1" class="">네트워크</a>
							</div>
							<div id="menu_s1">
								<ul>
									<li id="LI_1"><a href="javascript:checkOpertGroup('1');" id="A_1">VLAN 설정</a></li>
									<li id="LI_2"><a href="javascript:checkOpertGroup('2');" id="A_2">라우팅 설정</a></li>
								</ul>
							</div>
						</li>

						<li>
							<div id="menu_m2" onclick="shMenu(2);">
								<a id="menu_ma2" class="">방화벽</a>
							</div>
							<div id="menu_s2">
								<ul>
									<li id="LI_3"><a href="javascript:checkOpertGroup('3');" id="A_3">실시간 수작업이 필요</a></li>
								</ul>
							</div>
						</li>

						<li>
							<div id="menu_m3" onclick="shMenu(3);">
								<a id="menu_ma3" class="">서버변경작업</a>
							</div>
							<div id="menu_s3">
								<ul>
									<li id="LI_4"><a href="javascript:checkOpertGroup('4');" id="A_4">ip 변경</a></li>
									<li id="LI_5"><a href="javascript:checkOpertGroup('5');" id="A_5">passwd변경</a></li>
									<li id="LI_6"><a href="javascript:checkOpertGroup('6');" id="A_6">defaultrouter 변경</a></li>
									<li id="LI_7"><a href="javascript:checkOpertGroup('7');" id="A_7">group 변경</a></li>
									<li id="LI_8"><a href="javascript:checkOpertGroup('8');" id="A_8">hosts/netconf 변경</a></li>
									<li id="LI_9"><a href="javascript:checkOpertGroup('9');" id="A_9">vfstab/fstab</a></li>
									<li id="LI_10"><a href="javascript:checkOpertGroup('10');" id="A_10">스토리지 마운트</a></li>
								</ul>
							</div></li>

						<li>
							<div id="menu_m4" onclick="shMenu(4);">
								<a id="menu_ma4" class="">DB가동</a>
							</div>
							<div id="menu_s4">
								<ul>
									<li id="LI_11"><a href="javascript:checkOpertGroup('11');" id="A_11">리스너기동</a></li>
									<li id="LI_12"><a href="javascript:checkOpertGroup('12');" id="A_12">오라클기동</a></li>
								</ul>
							</div>
						</li>

						<li>
							<div id="menu_m5" onclick="shMenu(5);">
								<a id="menu_ma5" class="">WAS가동</a>
							</div>
							<div id="menu_s5">
								<ul>
									<li id="LI_13"><a href="javascript:checkOpertGroup('13');" id="A_13">admin-server가동</a></li>
									<li id="LI_14"><a href="javascript:checkOpertGroup('14');" id="A_14">manag-server가동</a></li>
									<li id="LI_15"><a href="javascript:checkOpertGroup('15');" id="A_15">jeus가동</a></li>
									<li id="LI_16"><a href="javascript:checkOpertGroup('16');" id="A_16">오라클10gAs가동</a></li>
									<li id="LI_17"><a href="javascript:checkOpertGroup('17');" id="A_17">로그인 프로그램 재기동</a></li>
								</ul>
							</div>
						</li>

						<li>
							<div id="menu_m6" onclick="shMenu(6);">
								<a id="menu_ma6" class="">WEB가동</a>
							</div>
							<div id="menu_s6">
								<ul>
									<li id="LI_18"><a href="javascript:checkOpertGroup('18');" id="A_18">iPlanet 웹서버 가동</a></li>
									<li id="LI_19"><a href="javascript:checkOpertGroup('19');" id="A_19">webtob 가동</a></li>
									<li id="LI_20"><a href="javascript:checkOpertGroup('20');" id="A_20">공지사항 제거 서비스 오픈</a></li>
								</ul>
							</div>
						</li>

						<li>
							<div id="menu_m7" onclick="shMenu(7);">
								<a id="menu_ma7" class="">기타소프트웨어</a>
							</div>
							<div id="menu_s7">
								<ul>
									<li id="LI_21"><a href="javascript:checkOpertGroup('21');" id="A_21">연계모듈가동</a></li>
									<li id="LI_22"><a href="javascript:checkOpertGroup('22');" id="A_22">인증데몬가동</a></li>
									<li id="LI_23"><a href="javascript:checkOpertGroup('23');" id="A_23">대급지금</a></li>
									<li id="LI_24"><a href="javascript:checkOpertGroup('24');" id="A_24">아큐브 가동</a></li>
									<li id="LI_25"><a href="javascript:checkOpertGroup('25');" id="A_25">멜일서버 가동</a></li>
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