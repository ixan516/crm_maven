<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function modifyLinkmanById(lkmId){
		location.href="${pageContext.request.contextPath}/linkman_queryLinkmanById?lkmId="+lkmId;
	}
	
	/* 删除联系人 */
	function delLinkmanById(lkmId){
		if(window.confirm("确认删除吗?")){
			location.href="${pageContext.request.contextPath}/linkman_delLinkmanById?lkmId="+lkmId;
		}
	}
	/* 跳转到指定页面 */
    function to_page(pageNumber){
		if(pageNumber!=null){
			//将传过来的pageNum赋值给input标签
			document.getElementById("pageNumber").value=pageNumber;
		}
		document.getElementById("customerForm").submit();
	}
</script>
<script type="text/javascript">
	$(function(){
		/* 选中客户来源下拉选 */
		$("#customerList option[value='${customer.custId}']").prop("selected",true);
		/* 选中每页显示的纪录数 */
		$("#pageSize option[value='${pageSize}']").prop("selected",true);
	});
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</head>
<body>
	<%-- <s:debug/> --%>
	<form id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/linkman_queryAllLinkmanForPage"
		method=post>
		
		<table cellSpacing=0 cellPadding=0 width="98%" border=0>
			<tbody>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</tbody>
		</table>
		<table cellSpacing=0 cellPadding=0 width="98%" border=0>
			<tbody>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<table cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</table>
						<table borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<tbody>
								<TR>
									<TD height=25>
										<table cellSpacing=0 cellPadding=2 border=0>
											<tbody>
												<TR>
													<TD>联系人名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="lkmName" id="lkmName"></TD>
													<td>所属客户 ：</td>
													<td>
														<select id="customerList" name="customer.custId" style="WIDTH: 180px">
															<option value="">---请选择---</option>
															<c:forEach items="${customerList}" var="customer">
																<option value="${customer.custId}">${customer.custName}</option>
															</c:forEach>
														</select>
													</td>
													<TD><input class=button id=sButton2 type="submit" value="筛选 "></TD>
												</TR>
											</tbody>
										</table>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<table id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<tbody>
												<TR style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<td>联系人名称</td>
													<td>所属客户</td>
													<td>性别</td>
													<td>手机</td>
													<td>电话</td>
													<td>邮箱</td>
													<td>职位</td>
													<td>操作</td>
												</TR>
												<c:forEach items="${pageBean.result}" var="linkman">
												<tr
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<td>${linkman.lkmName}</td>
													<td>${linkman.customer.custName}</td>
													<td>
														<c:if test="${linkman.lkmGender=='male'}">男</c:if>
														<c:if test="${linkman.lkmGender=='female'}">女</c:if>
													</td>
													<td>${linkman.lkmMobile}</td>
													<td>${linkman.lkmPhone}</td>
													<td>${linkman.lkmEmail}</td>
													<td>${linkman.lkmPosition}</td>
													
													<TD>
													<a href="javascript:void(0);" onclick="modifyLinkmanById('${linkman.lkmId}')">修改</a>
													&nbsp;&nbsp;
													<a href="javascript:void(0);" onclick="delLinkmanById('${linkman.lkmId}')">删除</a>
													</td>
												</tr>
												</c:forEach>
											</tbody>
										</table>
									</TD>
								</TR>
								
								<TR>
									<TD>
			<c:if test="${not empty pageBean }">
			<div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
				<span id=pagelink>
					每页显示
					<select name="pageSize" id="pageSize">
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="5">5</option>
					</select>
					条
					<!-- 前一页 -->
					<c:choose>
						<c:when test="${pageBean.pageNumber == 1 }">
							[<A href="javascript:void(0)">前一页</A>]
						</c:when>
						<c:otherwise>
							[<A href="javascript:to_page(${pageBean.pageNumber-1})">前一页</A>]
						</c:otherwise>
					</c:choose>
					<B>${pageBean.pageNumber}</B>
					
					<!-- 后一页 -->
					<c:choose>
						<c:when test="${pageBean.pageNumber == pageBean.totalPage }">
							[<A href="javascript:void(0)">后一页</A>]
						</c:when>
						<c:otherwise>
							[<A href="javascript:to_page(${pageBean.pageNumber+1})">后一页</A>]
						</c:otherwise>
					</c:choose>
					到
					<input type="text" size="3" id="pageNumber" name="pageNumber" />
					页
					
					<input type="button" value="Go" onclick="to_page()"/>
					[<B>${pageBean.totalRecord }</B>]条记录,第[<B>${pageBean.pageNumber}</B>]页/共[<B>${pageBean.totalPage}</B>]页
				</span>
			</div>
			</c:if>
		</TD>
		<!-- 分页结束 -->
								</tr>
							</tbody>
						</table>
					</td>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</tbody>
		</table>
		<table cellSpacing=0 cellPadding=0 width="98%" border=0>
			<tbody>
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
