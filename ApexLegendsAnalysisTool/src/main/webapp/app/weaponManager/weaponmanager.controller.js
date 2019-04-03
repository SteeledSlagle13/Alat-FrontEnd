(function () {
    'use strict';

    angular.module('weaponManagerApp')
        .controller('WeaponController', WeaponController);

    WeaponController.$inject = ['$scope', 'WeaponService'];

    function WeaponController($scope, WeaponService) {
        var self = this;

        self.weapon={};
        self.weaponEdit = {};
        self.originalWeapon = {};
        self.weapons = [];

        self.edit = edit;
        self.newWeapon = newWeapon;
        self.remove = remove;
        self.reset = reset;
        self.selectWeapon = selectWeapon;
        self.submit = submit;

        function newWeapon() {
            self.weaponEdit = { id: null };
        }

        function selectWeapon(weapon) {
            self.weaponEdit = weapon;
            angular.copy(self.weaponEdit, self.originalWeapon);
            console.log(self.weaponEdit);
        }

        function fetchAllWeapons() {
            WeaponService.fetchAllWeapons()
                .then(
                    function (d) {
                        self.weapons = d.data;
                    },
                    function () {
                        console.error('Error fetching weapons');
                    }
                );
        }

        function createWeapon(weapon) {
            WeaponService.createWeapon(weapon)
                .then(
                    fetchAllWeapons,
                    function () {
                        console.error('Error creating weapon');
                    }
                );
        }

        function updateWeapon() {
            console.log('Updating weapon with id', self.weaponEdit.id);
            WeaponService.updateWeapon(self.weaponEdit, self.weaponEdit.id)
                .then(
                    fetchAllWeapons,
                    function () {
                        console.error('Error updating weapon');
                    }
                );
        }

        function deleteWeapon(id) {
            WeaponService.deleteWeapon(id)
                .then(
                    fetchAllWeapons,
                    function () {
                        console.error('Error deleting Weapon');
                    }
                );
            $('#weaponEditor').modal('hide');
        }

        function submit() {
            if (self.weaponEdit.id === null) {
                console.log('New Weapon', self.weaponEdit);
                createWeapon(self.weaponEdit);
            } else {
                updateWeapon();
                console.log('Update Weapon', self.weaponEdit.id);
            }
        }

        function edit(id) {
            for (var i = 0; i < self.weapons.length; i++) {
                if (self.weapons[i].id === id) {
                    self.weaponEdit = angular.copy(self.weapons[i]);
                    break;
                }
            }
        }

        function remove(id) {
            if (self.weaponEdit.id === id) {
                reset();
            }
            deleteWeapon(id);
        }

        function reset() {
            console.log('Reset weapon data.');
            angular.copy(self.originalWeapon, self.weaponEdit);
            $scope.weaponEditorForm.$setPristine(); //reset Form
        }

        fetchAllWeapons();

        //JQuery Event
        $('#weaponEditor').on('hidden.bs.modal', function (e) {
            console.log('modal is closed');
            $('.collapse').collapse('hide');
            reset();
        });

    }
})();