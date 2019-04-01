<!DOCTYPE html>
<html>
<jsp:include page="/app/layout/header.jsp"></jsp:include>
<body>
	<jsp:include page="/app/layout/navbar.jsp"></jsp:include>
	<div>
		<h1 class="text-center">Weapons</h1>
	</div>
	<div class="container" id="appContainer" ng-app="WeaponChartApp"
		ng-controller="WeaponChartController as ctrl">
		<div class="row justify-content-center">
			<div class="col-sm-3">
				<div class="card border-primary">
					<div class="card-header border-primary">
						<h5 class="text-center">{{weapon1.name.toUpperCase()}}</h5>
					</div>
					<img class="card-img-bottom" ng-src="{{weapon1.imageSource}}">
					<div class="card-body">
						<p class="card-text">Type : {{weapon1.type.toUpperCase()}}</p>
						<p>DPS : {{weapon1.lowDps}}-{{weapon1.highDps}}</p>
						<div class="row">
							<div class="col">
								<select class="custom-select" ng-model="weapon1"
									data-dropup-auto="false" ng-change="ctrl.onChange()"
									ng-options="x.name.toUpperCase() for x in weapons | orderBy : 'name'"></select>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-5"></div>
			<div class="col-sm-3">
				<div class="card border-primary">
					<div class="card-header border-primary">
						<h5 class="text-center">{{weapon2.name.toUpperCase()}}</h5>
					</div>
					<img class="card-img-bottom" ng-src="{{weapon2.imageSource}}">
					<div class="card-body">
						<p class="card-text">Type : {{weapon2.type.toUpperCase()}}</p>
						<p>DPS : {{weapon2.lowDps}}-{{weapon2.highDps}}</p>
						<div class="row">
							<div class="col">
								<select class="custom-select" ng-model="weapon2"
									data-dropup-auto="false" ng-change="ctrl.onChange()"
									ng-options="x.name.toUpperCase() for x in weapons | orderBy : 'name'"></select>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-5">
				<div class="card border-primary">
					<canvas id="myChart" width="770" height="385"
						style="display: block; width: 770px; height: 385px;"></canvas>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/app/layout/footer.jsp"></jsp:include>
</body>
</html>