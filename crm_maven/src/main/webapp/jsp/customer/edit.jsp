<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/Manage.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	/* 回显时选中下拉框 */
	$(function(){
		/* 选中客户来源 */
		$("#custSource option[value='${custSource.dictId}']").prop("selected",true);
		/* 选中客户级别 */
		$("#custLevel option[value='${custLevel.dictId}']").prop("selected",true);
	});
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript">
    function modifyCustomerInfo(){
    	if(window.confirm("确认要修改吗?")){
    		$("#customerInfo").submit();
    	}
    }
</script>
</head>
<body>
<%-- <s:debug/> --%>
<form id="customerInfo" action="${pageContext.request.contextPath }/customer_modifyCustomerInfo" method="post">
		<!-- 隐藏字段 -->
        <input type="hidden" name="custId" value="${custId }">
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custName" value="${custName }">
								</td>
								<td>客户级别 ：</td>
								<td>
									<select id="custLevel" name="custLevel.dictId" style="WIDTH: 180px">
										<c:forEach items="${levelList}" var="baseDict">
											<option value="${baseDict.dictId }">${baseDict.dictItemName}</option>
										</c:forEach>
									</select>
								</td>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td>
									<select id="custSource" name="custSource.dictId" style="WIDTH: 180px">
										<c:forEach items="${sourceList}" var="baseDict">
											<option value="${baseDict.dictId }">${baseDict.dictItemName}</option>
										</c:forEach>
									</select>
								</td>
								<td>所属行业 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="custIndustry" value="${custIndustry }">
								</td>
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custPhone" value="${custPhone }">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custMobile" value="${custMobile }">
								</td>
							</TR>
							
							
							<tr>
								<td rowspan=2>
								<input type="button" value="保存" onclick="modifyCustomerInfo()">
								</td>
							</tr>
						</table>
					</td>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align="center" width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
