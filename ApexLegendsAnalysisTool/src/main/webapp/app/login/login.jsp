<!DOCTYPE html>
<html>
<jsp:include page="/app/layout/header.jsp"></jsp:include>
<body>
	<jsp:include page="/app/layout/navbar.jsp"></jsp:include>
	<div class="row justify-content-end">
		<div class="col-sm-3 m-5">
			<div class="card border-primary">
				<div class="card-body">
					<h3>Login</h3>
					<p>${errorMessage}</p>
				</div>
				<div class="card-body">
					<form name="loginForm">
						<div class="form-row">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">@</div>
								</div>
								<input type="text" class="form-control"
									id="inlineFormInputGroup" placeholder="Username"
									name="username">
							</div>
						</div>
						<div class="form-row">
							<div class="input-group mb-2">
								<input type="password" class="form-control"
									placeholder="Password" name="password">
							</div>
						</div>
						<div class="form-row">
							<div class="input-group mb-2">
								<button type="submit" class="btn btn-outline-primary"
									formmethod="post">Login</button>
							</div>
						</div>
						<div class="form-row">
							Not registered?<a href="/ApexLegendsAnalysisTool/signup">Sign
								Up!</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/app/layout/footer.jsp"></jsp:include>
</body>
</html>