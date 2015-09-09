<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<div style="margin:10px 10px 10px 10px">

	<div>hi, I'm home <span style="color:red">body</span></div>
	
	<div>&nbsp;</div>
	
	<div style="margin-buttom:4px"> This part is addressed for the <span style="font-weight:600;color:blue">Restful</span> </div>
	
	<div>
		
		<div style="border:2px solid green;padding:10px 10px 10px 10px">
				
			<div style="border-bottom:2px solid green;margin-buttom:4px">1. all spittles are listed as below, </div>	
			
			<table>
			
			<c:forEach var="spittle" items="${spittles}" >
			  
			  <s:url value="/spittle/{id}" var="spittle_rest_url">
				 <s:param name="id" value="${spittle.id}" />
			  </s:url>
					  
			  <tr>
				<td>
					<span style="color:gray;margin-right:4px">at the time:</span><span style="margin-right:20px"><fmt:formatDate value="${spittle.time}" pattern="yyyy-HH-dd hh:mm:ss"/></span>
				</td>
				<td>
					<span style="color:gray;margin-right:4px">user:</span><span>${spittle.username}</span>
				</td>
				<td valign="middle">	
					<span style="margin-right:4px;"><a href="${spittle_rest_url}" target="_blank">查看</a></span>
				</td>
				<td valign="middle">	
					<span style="margin-right:4px;">
						<sf:form method="delete" modelAttribute="spittle" action="${spittle_rest_url}">
							<a href="javascript:void(document.getElementById('spittle').submit())">删除</a>
						</sf:form>
					</span>
				</td>		
			  </tr>			
			</c:forEach>
			
			</table>
			
			<div style="border-bottom:2px solid green;margin-buttom:4px;margin-top:10px">2. To add a new Spittle, </div>
			
			<div style="margin-left:16px;margin-buttom:4px;margin-top:10px">2.1 Using method POST, </div>
			
			<sf:form method="POST"  action="/spittle" modelAttribute="spittle"> 
			
			<table width = 700 >	
				<tr>
					<td align="right">Username: </td> <td><sf:input path="username" size="15" maxlength="15" /> <sf:errors path="username" cssClass="error" /></td>
				</tr>	
				<tr>
					<td align="right">Add your Spittle words:</td> <td><sf:input path="text" size="30"/> <sf:errors path="text" cssClass="error" /></td>
				</tr>				
				<tr>
					<td colspan=2 align="center"><input name="commit" type="submit" value="add Spittle" /></td>
				</tr>
			</table>	
			
			</sf:form>	
			
			<div style="margin-left:16px;margin-buttom:4px;margin-top:10px">2.2 Using method PUT, </div>
			<div style="margin-left:40px;margin-buttom:4px;margin-top:10px">PUT 主要是用于做 update 使用</div>
			
										
		</div>
		
		<div>
		
		
		</div>
		
	
	</div>
	
</div>	