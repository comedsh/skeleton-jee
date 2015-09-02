<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div style="margin:10px 10px 10px 10px">

	<div>hi, I'm home <span style="color:red">body</span></div>
	
	<div>&nbsp;</div>
	
	
	<div> the Spittles have been added as below, </div>
	<div>
		
		<div style="border:2px solid green;padding:10px 10px 10px 10px">
				
			<div style="border-bottom:2px solid green;margin-bottom:4px"> This part is addressed for the <span style="font-weight:600;color:blue">Restful</span> </div>
			
			<c:forEach var="spittle" items="${spittles}" >
		
				<div>
		
					<s:url value="/spittle/{id}" var="rest_url">
						<s:param name="id" value="${spittle.id}" />
					</s:url>
		
					<span style="color:gray;margin-right:4px">at the time:</span><span style="margin-right:20px"><fmt:formatDate value="${spittle.time}" pattern="yyyy-HH-dd hh:mm:ss"/></span>
		
					<span style="color:gray;margin-right:4px">user:</span><span>${spittle.username}</span>
					
					<span style="margin-right:4px"> <a href="${rest_url}">查看</a></span>
					
					<span style="margin-right:4px"> 删除 </span>		
		
				</div>
		
			</c:forEach>
		
		</div>
		
		<div>
		
		
		</div>
		
	
	</div>
	
</div>	