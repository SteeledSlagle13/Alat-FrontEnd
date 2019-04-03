<div class="modal fade text-dark" id="weaponEditor" tabindex="-1"
	role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-dark" id=weaponEditorModal>{{ctrl.weaponEdit.name.toUpperCase()}}
					Editor</h5>
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="weaponEditorForm">
					<div class="form-group">
						<input hidden type="text" class="form-control" id="id"
							ng-model="ctrl.weaponEdit.id"
							placeholder="{{ctrl.weaponEdit.id}}">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="name"
							ng-model="ctrl.weaponEdit.name" placeholder="name">
					</div>
					<div class="form-group">
						<select class="form-control" name="type"
							ng-model="ctrl.weaponEdit.type">
							<option value="" selected disabled hidden>Weapon Type</option>
							<option value="assault rifle">Assault Rifle</option>
							<option value="light machine gun">Light Machine Gun</option>
							<option value="pistol">Pistol</option>
							<option value="shotgun">Shotgun</option>
							<option value="sub machine gun">Sub Machine Gun</option>
							<option value="sniper">Sniper</option>
						</select>
					</div>
					<div class="form-group">
						<button class="btn btn-primary" type="button"
							data-toggle="collapse" data-target="#imageSelect">
							Weapon Image</button>
					</div>
					<div class="collapse" id="imageSelect">
						<div class="form-group">
							<select class="image-picker">
								<option
									data-img-src="/ApexLegendsAnalysisTool/app/images/ar/ar.png">1</option>
								<option
									data-img-src="/ApexLegendsAnalysisTool/app/images/lmg/lmg.png">2</option>
								<option
									data-img-src="/ApexLegendsAnalysisTool/app/images/pistol/pistol.png">3</option>
								<option
									data-img-src="/ApexLegendsAnalysisTool/app/images/shotgun/shotgun.png">4</option>
								<option
									data-img-src="/ApexLegendsAnalysisTool/app/images/smg/smg.png">5</option>
								<option
									data-img-src="/ApexLegendsAnalysisTool/app/images/sniper/sniper.png">6</option>
							</select>
							<script type="text/javascript">
								$('.image-picker').imagepicker();
							</script>
						</div>
					</div>
					<div class="form-group">
						<input type="number" class="form-control" id="lowDps"
							ng-model="ctrl.weaponEdit.lowDps"
							placeholder="{{ctrl.weaponEdit.lowDps}}">
					</div>
					<div class="form-group">
						<input type="number" class="form-control" id="highDps"
							ng-model="ctrl.weaponEdit.highDps"
							placeholder="{{ctrl.weaponEdit.highDps}}">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"
					ng-click="ctrl.reset()">Close</button>
				<button type="submit" ng-click="ctrl.submit()"
					class="btn btn-primary">{{!ctrl.weaponEdit.id ? 'Add' :
					'Update'}}</button>
			</div>
		</div>
	</div>
</div>