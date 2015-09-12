<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<div style="padding:20px 20px 20px 20px">

	<div>hi, I'm home <span style="color:red">body</span></div>

	<!-- ========== start for restless introduction ============ -->

	<div>&nbsp;</div>

	<div style="margin-buttom:4px"> This part is addressed for the <span style="font-weight:600;color:red">Restless, &nbsp;&nbsp;&nbsp;&nbsp;该方式在我们的项目中是严格禁止使用的</span> </div>
	
	<div>
		
		<div style="border:2px solid green;padding:10px 10px 10px 10px">
				
			<div style="border-bottom:2px solid green;margin-buttom:4px">1. all spittles are listed as below, </div>	
			
			<table>
			
			<c:forEach var="spittle" items="${spittles}" >
					  
			  <tr>
				<td>
					<span style="color:gray;margin-right:4px">id:</span><span style="margin-right:20px">${spittle.id}</span>
				</td>
				<td>
					<span style="color:gray;margin-right:4px">at the time:</span><span style="margin-right:20px"><fmt:formatDate value="${spittle.time}" pattern="yyyy-HH-dd hh:mm:ss"/></span>
				</td>
				<td>
					<span style="color:gray;margin-right:4px">user:</span><span>${spittle.username}</span>
				</td>
				<td valign="middle">	
					<span style="margin-right:4px;"><a href="/spittle/getSpittle?id=${spittle.id}" target="_blank">查看</a></span>
				</td>
				<td valign="middle">	
					<span style="margin-right:4px;"><a href="/spittle/deleteSpittle?id=${spittle.id}">删除</a></span>
				</td>		
			  </tr>			
			</c:forEach>
			<!-- == PUT( Update ) 和 CREATE( Create ) 大致相同，这里不再赘述 -->
			</table>
		
		</div>
		
	</div>		
	
	<!-- ========== start for restful education ============ -->
	
	<div>&nbsp;</div>
	
	<div style="margin-buttom:4px"> This part is addressed for the <span style="font-weight:600;color:blue">Restful</span> </div>
	
	<div>
		
		<div style="border:2px solid green;padding:10px 10px 10px 10px">
				
			<div style="border-bottom:2px solid green;margin-buttom:4px">1. all spittles are listed as below, </div>	
			
			<table>
			
			<c:forEach var="spittle" items="${spittles}" >
			  
			  <s:url value="/spittle/{id}" var="spittle_rest_id_url">
				 <s:param name="id" value="${spittle.id}" />
			  </s:url>
			  
			  <s:url value="/spittle/{username}/spittles" var="spittle_rest_username_url">
				 <s:param name="username" value="${spittle.username}" />
			  </s:url>			  
					  
			  <tr>
				<td>
					<span style="color:gray;margin-right:4px">id:</span><span style="margin-right:20px">${spittle.id}</span>
				</td>
				<td>
					<span style="color:gray;margin-right:4px">at the time:</span><span style="margin-right:20px"><fmt:formatDate value="${spittle.time}" pattern="yyyy-HH-dd hh:mm:ss"/></span>
				</td>
				<td>
					<span style="color:gray;margin-right:4px">user:</span><span><a href="${spittle_rest_username_url}" target="_blank">${spittle.username}</a></span>
				</td>
				<td valign="middle">	
					<span style="margin-right:4px;"><a href="${spittle_rest_id_url}" target="_blank">查看</a></span>
				</td>
				<td valign="middle">	
					<span style="margin-right:4px;">
						<sf:form method="delete" modelAttribute="spittle" action="${spittle_rest_id_url}">
							<a href="javascript:void(document.getElementById('spittle').submit())">删除</a>
						</sf:form>
					</span>
				</td>		
			  </tr>			
			</c:forEach>
			
			</table>
			
			<!-- test for ajax invoke by angularjs-->
			
			<div ng-app="spittle_app"> <!-- ng-app 表示，该 div 部分（含子标签）归 angular 接管 -->
			
				<script src="/resources/angular/angular.js"></script>

				<script>
				angular.module("spittle_app", [])
					   .controller("SpittleController", function spittleController($scope, $http) {
						   									
						   									$scope.getSpittle = function(){
						   										
							   									var url="/spittle/1001";
							   									$http.get(url).success( function(spittle) {
							   										if(!spittle) alert("spittle 1001 get deleted ~, no information responsed")
							         								$scope.spittle = spittle;
							   									});
							   									
						   									}
														}
								  );
				</script>
				
				<div ng-controller="SpittleController">
				
				<div> <input type="button" value="ajax get 1001 by angular" ng-click="getSpittle()"/> </div>
				
				<table>
						  
				  <tr>
					<td>
						<span style="color:gray;margin-right:4px">id:</span><span style="margin-right:20px">{{spittle.id}}</span>
					</td>
					<td>
						<span style="color:gray;margin-right:4px">at the time:</span><span style="margin-right:20px">{{ spittle.time | date:"yyyy-MM-dd HH:mm:ss" }}</span>
					</td>
					<td>
						<span style="color:gray;margin-right:4px">user:</span><span>{{spittle.username}}</span>
					</td>
				  </tr>			
				
				</table>
				
				</div>			
			
			</div>			
			
			<div style="border-bottom:2px solid green;margin-buttom:4px;margin-top:10px">2. To add a new Spittle -> by Using method POST </div>
			
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
			
			<div style="border-bottom:2px solid green;margin-buttom:4px;margin-top:10px">3. To update a Spittle -> by Using method PUT </div>
			<div style="margin-left:18px;margin-buttom:4px;margin-top:10px">PUT 主要是用于做 update 使用</div>		
			
			<sf:form method="PUT"  action="/spittle/1001" modelAttribute="spittle"> 
			<div style="margin-left:18px;margin-buttom:4px;margin-top:10px">try to update the spittle 1001, with url path /spittle/1001 </div>	
			<table width = 700 >	
				<tr>
					<td align="right">Username: </td> <td><sf:input path="username" size="15" maxlength="15"/> <sf:errors path="username" cssClass="error" /></td>
				</tr>	
				<tr>
					<td align="right">Add your Spittle words:</td> <td><sf:input path="text" size="30"/> <sf:errors path="text" cssClass="error" /></td>
				</tr>				
				<tr>
					<td colspan=2 align="center"><input name="commit" type="submit" value="update Spittle" /></td>
				</tr>
			</table>	
			
			</sf:form>					
										
		</div>
		
		<div>
		
		
		</div>
		
	
	</div>
	
</div>	
