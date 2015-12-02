<script type="text/javascript"
	src="/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
<script type="text/javascript"
	src="/resources/javaScript/angular/angular.min.js"></script>
<div align="center"
	style="min-height: 200px; padding-top: 50px; padding-left: 50px; min-width: 400px; max-width: 990px;"
	ng-app="buyerOrderList" ng-controller="buyerOrderListController">
	
	
	<table>
		<thead>
			<tr>
				<td>名称</td>
				<td>编号</td>
			</tr>
		</thead>
	<tbody ng-repeat="buyerOrder in buyerOrderList">
			<tr>
				<td>{{buyerOrder.createTime}}</td>
				<td>{{buyerOrder.deliveryMethod}}</td>
			</tr>
		</tbody>
	</table>

</div>
<script type="text/javascript">
	angular.module('buyerOrderList', []).controller('buyerOrderListController',function($scope, $http) {
			$scope.buyerOrderList = ${buyerOrderList};
			
	});
</script>