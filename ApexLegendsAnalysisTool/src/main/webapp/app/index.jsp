<!DOCTYPE html>
<html>
<jsp:include page="/app/layout/header.jsp"></jsp:include>
<body>
	<!-- Nav Bar -->
	<jsp:include page="/app/layout/navbar.jsp"></jsp:include>
	<section class="jumbotron">
		<div class="title left">
			<h1>Apex Legends Loadout Analysis Tool</h1>
		</div>
	</section>
	<section class="jumbotron jumbotron-fluid banner wraith">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-9 col-md-6 col-lg-8"></div>
				<div class="col-sm-3 col-md-6 col-lg-4">
					<p style="font-size: 32px;">
						This tool was designed by SS0113 to help <br>Legends compare
						different Loadouts.
					</p>
					<img
						src="/ApexLegendsAnalysisTool/app/images/legends/pathfinderIcon.png"
						height="350">
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="/app/layout/footer.jsp"></jsp:include>
</body>
</html>