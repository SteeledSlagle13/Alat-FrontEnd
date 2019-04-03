<!DOCTYPE html>
<html>
<jsp:include page="/app/layout/header.jsp"></jsp:include>
<body>
	<jsp:include page="/app/layout/navbar.jsp"></jsp:include>
	<div>
		<h2 class="text-center" style="padding: 12px;">Legends</h2>
	</div>
	<div class="container" id="legendContainer" ng-app="legendManagerApp"
		ng-controller="legendController as ctrl">
		<div class="row">
			<div class="col-xl" style="padding: 2%;"
				ng-repeat="legend in ctrl.legends">
				<a class="card border-primary" style="width: 12rem;"  href="http://www.google.com">
					<img class="card-img-top" height="225px"
						ng-src="{{legend.imageSource}}">
					<div class="card-body">
						<h3 class="card-title" id="legendName">{{legend.nickName}}</h3>
						<p class="card-text">
							Role : <span class="badge badge-light" id="legendRole">{{legend.role}}</span>
						</p>
					</div>
				</a>
			</div>
		</div>
	</div>
	<jsp:include page="/app/layout/footer.jsp"></jsp:include>
</body>
</html>