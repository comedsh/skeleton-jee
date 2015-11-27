<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<script type="text/javascript"src="/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript"src="/resources/javaScript/angular/angular.min.js"></script>
<div align="center" style="min-height: 200px;padding-top: 50px; padding-left: 50px; min-width: 400px;max-width: 990px;"
	ng-app="shoppingCartApp" ng-controller="shoppingCartListController">
	<!-- 
	<h2>JSTL填充</h2>
<c:choose>
	<c:when test="${shopCart != 'empty'}">
	<table width="100%">
	  <thead style="background-color: gray;color: white;">
  		<th align="left">
  		</th>
  		<th align="center">商品信息 </th>
  		<th align="left">单价/元 </th>
  		<th align="left">数量 </th>
  		<th align="left">金额/元</th>
  		<th align="left">操作 </th>
  	 </thead>
  	 <tbody>
  	 	<c:forEach items="${shopCartGroupList}" var="groupItem">
  	 	<tr>
		    <th align="left" colspan="6">
		    	<input type="checkbox" checked="checked">
		    	<strong>卖家：${groupItem.sellerName}</strong>  
		    <c:if test="${groupItem.discountStrategyDesc != ''}">
		    	<strong><font color="red">优惠策略：</font></strong>${groupItem.discountStrategyDesc}
		    </c:if>
		    </th>
		 </tr>
	    <c:forEach items="${groupItem.cartList}" var="item">
	    <tr>
	    <td align="left"><input type="checkbox" checked="checked"></td>
	    <td>
			<table>
			  <tr>
			    <td>
			    	<img alt="" src="${item.sku.url}">
			    </td>
			    <td>
			    	品牌:<strong>${item.sku.brand}</strong> <br>
			    	销售单位:<strong>${item.sku.unit}</strong><br>
			    	<strong>${item.sku.title}</strong>
			    </td>
			  </tr>
			</table>
		</td>
	    <td align="left">
	    	<strong>${item.cart.currentPrice}</strong><br>
	    	<strong><span style="text-decoration:line-through;">${item.cart.originalPrice}</span></strong>
	    </td>
	    <td>
	    	<a href="#" ng-click="reduce()">-</a>
	    	<input type="text" value="${item.cart.qty}" style="max-width: 40px;">
	    	<a href="#" ng-click="add()">+</a>
	    </td>
	    <td>
	    	<strong>${item.totalAmount}</strong><br>
	    	<strong><span style="text-decoration:line-through;">${item.totalOrignAmount}</span></strong>
	    </td>
	    <td>
	    	<a href="#">删除</a>
	    </td>
	    </tr>
	   </c:forEach>
	   </c:forEach>
  	</tbody>
  	<tfoot style="background-color: gray;color: white;">
	  	<th align="left">
	  		<input type="checkbox" checked="checked">全选
  		</th>
  		<th align="left">
  			<a href="#" style="color: white;cursor: pointer;">删除选择商品</a>
  		</th>
  		<th align="left">已选择20件商品 </th>
  		<th align="left">
  			<strong>商品总金额(不含运费)：</strong>￥2320.00<br>
  			<strong>优惠金额：</strong>￥520.00
  		</th>
  		<th align="left" colspan="2">
  			<a href="#">
  				<div style="background-color: red;color: white;min-width: 100px;min-height: 80px;" align="center">
  					<h2>去结算</h2>
  				</div>
  			</a>
  		</th>
	</tfoot>
	</table>
	</c:when>
	<c:otherwise>
		<h1>
		<strong>你的购物车严重饥饿！！！</strong>
		</h1>
	</c:otherwise>
</c:choose>
 -->
	<table width="100%">
	  <thead style="background-color: gray;color: white;">
  		<th align="left">
  		</th>
  		<th align="center">商品信息 </th>
  		<th align="left">单价/元 </th>
  		<th align="left">数量 </th>
  		<th align="left">金额/元</th>
  		<th align="left">操作 </th>
  	 </thead>
  	 <tbody ng-repeat="groupItem in shopCartGroups">
  	 	<tr ng-bind="groupIndex=$index" style="display:none"></tr>
  	 	<tr>
		    <th align="left" colspan="6">
		    	<input type="checkbox" checked="checked">
		    	<strong>卖家：{{groupItem.sellerName}}</strong>  
		    	<strong><font color="red">优惠策略：</font></strong>{{groupItem.discountStrategyDesc}}
		    </th>
		 </tr>
	    <tr ng-repeat="item in groupItem.cartList">
	    <td align="left"><input type="checkbox" checked="checked"></td>
	    <td>
			<table>
			  <tr>
			    <td>
			    	<a href="/product/{{item.sku.id}}" target="_blank">
			    		<img alt="" src="{{item.sku.url}}">
			    	</a>
			    </td>
			    <td>
			    	品牌:<strong>{{item.sku.brand}}</strong> <br>
			    	销售单位:<strong>{{item.sku.unit}}</strong><br>
			    	<strong>{{item.sku.title}}</strong>
			    </td>
			  </tr>
			</table>
		</td>
	    <td align="left">
	    	<strong>{{item.cart.currentPrice}}</strong><br>
	    	<strong><span style="text-decoration:line-through;">{{item.cart.originalPrice}}</span></strong>
	    </td>
	    <td>
	    	<a href="#" ng-click="reduce(groupIndex,$index)">-</a>
	    	<input type="text" value="{{item.cart.qty}}"  style="max-width: 40px;">
	    	<a href="#" ng-click="add(groupIndex,$index)">+</a>
	    </td>
	    <td>
	    	<strong>{{item.totalAmount}}</strong><br>
	    	<strong><span style="text-decoration:line-through;">{{item.totalOrignAmount}}</span></strong>
	    </td>
	    <td>
	    	<a href="#" ng-click="del(groupIndex,$index)">删除</a>
	    </td>
	    </tr>
  	</tbody>
  	<tfoot style="background-color: gray;color: white;">
	  	<th align="left">
	  		<input type="checkbox" checked="checked">全选
  		</th>
  		<th align="left">
  			<a href="#" style="color: white;cursor: pointer;">删除选择商品</a>
  		</th>
  		<th align="left">已选择{{selectSkuCount}}件商品 </th>
  		<th align="left">
  			<strong>商品总金额(不含运费)：</strong>￥{{totalOrignAmount}}<br>
  			<strong>优惠金额：</strong>￥{{totalAmount}}
  		</th>
  		<th align="left" colspan="2">
  			<a href="#">
  				<div style="background-color: red;color: white;min-width: 100px;min-height: 80px;" align="center">
  					<h2>去结算</h2>
  				</div>
  			</a>
  		</th>
	</tfoot>
	</table>
</div>

<script type="text/javascript">
   angular.module('shoppingCartApp', [])
      .controller('shoppingCartListController', function($scope,$http) {      	
   	 
   	   $scope.init = function() {
           $scope.shopCartGroups = ${shopCartJson};
       };
       $scope.initAmount = function() {
           $scope.totalOrignAmount = 0.0000;
           $scope.totalAmount = 0.0000;
           $scope.selectSkuCount = 0;
           angular.forEach($scope.shopCartGroups, function(data){
        	   $scope.selectSkuCount += data.cartList.length;
        	   $scope.totalOrignAmount = $scope.totalOrignAmount + data.totalOrignAmount;
        	   $scope.totalAmount = $scope.totalAmount + data.totalAmount;
           });
       };
       $scope.initData = function(data) {
    	   $scope.shopCartGroups = data;
    	   $scope.initAmount();
       }
       $scope.init();
       $scope.initAmount();
       
   	   $scope.reduce =function(groupIndex, index){
   		   //alert("reduce "+groupIndex+" "+index);
   		   if($scope.shopCartGroups[groupIndex].cartList[index].cart.qty > 0) {
   				$scope.shopCartGroups[groupIndex].cartList[index].cart.qty = $scope.shopCartGroups[groupIndex].cartList[index].cart.qty - 1;
	   			$http({
		   			method:'PUT',
		   			url:"/shoppingCart/add",
		   			params:{pid: $scope.shopCartGroups[groupIndex].cartList[index].cart.skuId, num: $scope.shopCartGroups[groupIndex].cartList[index].cart.qty}
	   			}).success(function(data){
	   				$scope.initData(data);
	   			});
   		   }
   	   }
       $scope.add =function(groupIndex, index){
    	  //alert("add "+groupIndex+" "+index);
    	   $scope.shopCartGroups[groupIndex].cartList[index].cart.qty = $scope.shopCartGroups[groupIndex].cartList[index].cart.qty + 1;
    	   $http({
	   			method:'PUT',
	   			url:"/shoppingCart/add",
	   			params:{pid: $scope.shopCartGroups[groupIndex].cartList[index].cart.skuId, num: $scope.shopCartGroups[groupIndex].cartList[index].cart.qty}
  			}).success(function(data){
  				$scope.initData(data);
   			});
   	   } 
       $scope.del =function(groupIndex, index){
    	   //alert("del "+groupIndex+" "+index);
    	   $http({
	   			method:'GET',
	   			url:"/shoppingCart/del",
	   			params:{"sid": $scope.shopCartGroups[groupIndex].cartList[index].cart.id}
  			}).success(function(data){
  				$scope.initData(data);
   			});
  	   } 
      });
</script>