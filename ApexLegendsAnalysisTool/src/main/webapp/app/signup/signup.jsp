<!DOCTYPE html>
<html>
<jsp:include page="/app/layout/header.jsp"></jsp:include>
<body>
	<jsp:include page="/app/layout/navbar.jsp"></jsp:include>
	<div class="row justify-content-end">
		<div class="col-sm-3 m-5">
			<div class="card border-primary">
				<div class="card-body">
					<h3>Sign-up</h3>
					<p>${errorMessage}</p>
				</div>
				<div class="card-body">
					<form name="signupForm" ng-app="registerApp"
						ng-controller="signupController as ctrl"
						ng-submit="ctrl.checkUser(ctrl.user.username)">
						<input type="hidden" ng-model="ctrl.user.id" />
						<div class="form-row">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Required</div>
								</div>
								<input required type="text" class="form-control"
									id="inlineFormInputGroup" placeholder="Username"
									name="username" ng-model="ctrl.user.username">
							</div>
						</div>
						<div class="form-row">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Required</div>
								</div>
								<input required type="text" class="form-control"
									id="inlineFormInputGroup" placeholder="Email"
									name="email" ng-model="ctrl.user.email">
							</div>
						</div>
						<div class="form-row">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Required</div>
								</div>
								<input required type="text" class="form-control"
									id="inlineFormInputGroup" placeholder="Password"
									name="password" ng-model="ctrl.user.password">
							</div>
						</div>
						<div class="form-row">
							<div class="input-group mb-2">
								<input type="text" class="form-control" placeholder="Address"
									name="address" ng-model="ctrl.user.address">
							</div>
						</div>
						<div class="form-row">
							<div class="input-group mb-2">
								<button type="submit" class="btn btn-outline-primary">Submit</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/app/layout/footer.jsp"></jsp:include>
</body>
</html>