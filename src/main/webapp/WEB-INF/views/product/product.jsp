<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>商品详情</title>
	<style type="text/css">

/* box */
.box {
	width: 610px;
	margin: 100px auto;
}

.tb-pic a {
	display: table-cell;
	text-align: center;
	vertical-align: middle;
}

.tb-pic a img {
	vertical-align: middle;
}

.tb-pic a {
	*display: block;
	*font-family: Arial;
	*line-height: 1;
}

.tb-thumb {
	margin: 10px 0 0;
	overflow: hidden;
}

.tb-thumb li {
	background: none repeat scroll 0 0 transparent;
	float: left;
	height: 42px;
	margin: 0 6px 0 0;
	overflow: hidden;
	padding: 1px;
}

.tb-s310, .tb-s310 a {
	height: 310px;
	width: 310px;
}

.tb-s310, .tb-s310 img {
	max-height: 310px;
	max-width: 310px;
}

.tb-s310 a {
	*font-size: 271px;
}

.tb-s40 a {
	*font-size: 35px;
}

.tb-s40, .tb-s40 a {
	height: 40px;
	width: 40px;
}

.tb-booth {
	border: 1px solid #CDCDCD;
	position: relative;
	z-index: 1;
}

.tb-thumb .tb-selected {
	background: none repeat scroll 0 0 #C30008;
	height: 40px;
	padding: 2px;
}

.tb-thumb .tb-selected div {
	background-color: #FFFFFF;
	border: medium none;
}

.tb-thumb li div {
	border: 1px solid #CDCDCD;
}

div.zoomDiv {
	z-index: 999;
	position: absolute;
	top: 0px;
	left: 0px;
	width: 200px;
	height: 200px;
	background: #ffffff;
	border: 1px solid #CCCCCC;
	display: none;
	text-align: center;
	overflow: hidden;
}

div.zoomMask {
	position: absolute;
	background: url("images/mask.png") repeat scroll 0 0 transparent;
	cursor: move;
	z-index: 1;
}
</style>
	<script type="text/javascript"src="/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript"src="/resources/javaScript/angular/angular.min.js"></script>
	<script type="text/javascript"src="/resources/javaScript/JQuery/jquery.imagezoom.js"></script>
</head>
<body>

  <div ng-app="productApp" ng-controller="productController">
  <table>
		<tr>
			<td>
				<div class="box" >

	<div class="tb-booth tb-pic tb-s310">
		<a href="images/01.jpg"><img src="images/01_mid.jpg" alt="美女" rel="images/01.jpg" class="jqzoom" /></a>
	</div>

	<ul class="tb-thumb" id="thumblist" > 	  
	      <li ng-repeat="item in picItems">	        
			<div class="tb-pic tb-s40"><a href="#" ng-click="imgClick()">
			  <img  src="{{item.url}}" mid="{{item.url}}" big="{{item.url}}"></a>
		    </div>
		  </li>    
	
	</ul>
	
</div>

		</td>
			<td rowspan="10">
				<div>${product.name}&nbsp;&nbsp;&nbsp;&nbsp;累计销量{{stock.saledCount}}:&nbsp;&nbsp;&nbsp;累计评价：{{comment.comtotal}}</div>
				<div>价格：￥${product.salePrice}</div>
				<div>品牌:${product.brand}</div>
				<div>配送方式:由丰华神州发货  并提供售后服务</div>
				<div>数量:<input id="min" name="" type="button" value="-" ng-click="reduce()">
<input id="num" name="num" type="text" value="1" readonly="true" ng-model="nums">
<input id="add" name="" type="button" value="+" ng-click="add()">
</div>
				<div>库存：{{stock.stockAvailability}}</div>
				<div>
					<input type="button" value="立即购买" />&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="button" value="加入购物车" />
				</div>
			</td>
			<tr>
	</table>
  </div>

	

	<script type="text/javascript">

	   angular.module('productApp', [])
       .controller('productController', function($scope,$http) {      	
    	 
    	   var id = ${product.id};

    	   $scope.getPro =  function(url,callback){
    		  $http.get(url).success(function(data){ 
    			  callback(data);
            });
    	   };
    	   $scope.getPro("/productPic/"+id,function(data){
    		   $scope.picItems=data.items;
    	   });	 
    	   
    	  
    	   
    	   $scope.getPro("/stock/"+id,function(data){
    		   $scope.stock=data;
    	   });
    	   $scope.getPro("/comment/"+id,function(data){
    		   $scope.comment=data;
    	   });
    	  
    	   $scope.imgClick = function(){
    			alert("s");
    		/* 	alert(angular.element(this).parents("li"));
    			angular.element(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
    			angular.element(".jqzoom").attr('src',$j(this).find("img").attr("mid"));
    			angular.element(".jqzoom").attr('rel',$j(this).find("img").attr("big")); */
    	   };
    	   
    	   $scope.reduce =function(){
    		   $scope.nums =  $scope.reduce -1;
    	   }
    	   
           $scope.add =function(){
        	   $scope.nums =  $scope.nums +1;
    	   }
    	   
       });
	   
	 
	var $j = jQuery.noConflict();
		$j(document).ready(function(){

			/* $j(".jqzoom").imagezoom();  */
		/* 	alert("ss");
			$j("#thumblist li a").click(function(){
				alert("s");
				$j(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
				$j(".jqzoom").attr('src',$j(this).find("img").attr("mid"));
				$j(".jqzoom").attr('rel',$j(this).find("img").attr("big"));
			}); */
			
			
		}); 
	</script>
</body>
</html>