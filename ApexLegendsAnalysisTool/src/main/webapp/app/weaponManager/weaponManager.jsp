<!DOCTYPE html>
<html>
<jsp:include page="/app/layout/header.jsp"></jsp:include>
<jsp:include page="/app/layout/navbar.jsp"></jsp:include>
<body>
	<div class="container" id="weaponContainer" ng-app="weaponManagerApp"
		ng-controller="WeaponController as ctrl">
		<div class="row justify-content-center">
			<div class="col-sm-3" style="padding: 2%;"
				ng-repeat="weapon in ctrl.weapons">
				<a class="card border-primary" style="width: 12rem;"
					data-toggle="modal" data-target="#weaponEditor"
					ng-click="ctrl.selectWeapon(weapon)" ng-model="weapon">
					<div class="card-body">
						<button type="button" class="btn btn-outline-primary btn-sm"
							ng-click="ctrl.remove(weapon.id)">Delete</button>
					</div> <img class="card-img" ng-src="{{weapon.imageSource}}">

					<div class="card-body">
						<h5 class="card-title" id="weaponName">{{weapon.name.toUpperCase()}}</h5>
						<p class="card-text">
							Type : <span class="badge badge-light" id="weaponType">{{weapon.type.toUpperCase()}}</span>
						</p>
					</div>
				</a>
			</div>
			<div class="col-sm-3" style="padding: 2%;">
				<div class="card border-primary" style="width: 12rem;"
					ng-model="weaponEdit">
					<a data-toggle="modal" data-target="#weaponEditor"
						ng-click="ctrl.newWeapon()"><img class="card-img"
						src="/ApexLegendsAnalysisTool/app/images/addIcon.png"></a>
					<!-- 				<div class="card-body"> -->
					<!-- 					<h5 class="card-title">Add A New Weapon</h5> -->
					<!-- 				</div> -->
				</div>
			</div>
		</div>
		<!-- Modal -->
		<jsp:include page="/app/weaponManager/weaponManagerModal.jsp"></jsp:include>
	</div>
	<jsp:include page="/app/layout/footer.jsp"></jsp:include>
</body>
</html>