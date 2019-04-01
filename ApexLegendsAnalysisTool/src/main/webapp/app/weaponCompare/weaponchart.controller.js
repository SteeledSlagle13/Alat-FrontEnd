'use strict';

angular.module('WeaponChartApp').controller('WeaponChartController', ['$scope', 'GetWeaponService', function ($scope, GetWeaponService) {
    var self = this;

    self.weapon = {
        id: null,
        name: '',
        type: '',
        imageSource: '',
        lowDps: '',
        highDps: '',
    };
    self.weapons = [];
    self.onChange = onChange;

    $scope.weapon1 = {};
    $scope.weapon2 = {};
    $scope.weapons = [];

    fetchAllWeapons();

    function onChange() {
        myChart.options.title.text = $scope.weapon1.name.toUpperCase() + ' vs. ' + $scope.weapon2.name.toUpperCase();

        myChart.data.datasets[0].label = $scope.weapon1.name.toUpperCase();
        myChart.data.datasets[0].data = [$scope.weapon1.clipSize, $scope.weapon1.bodyShot, $scope.weapon1.headShot, $scope.weapon1.reloadTime, $scope.weapon1.fireRate];
        
        myChart.data.datasets[1].label = $scope.weapon2.name.toUpperCase();
        myChart.data.datasets[1].data = [$scope.weapon2.clipSize, $scope.weapon2.bodyShot, $scope.weapon2.headShot, $scope.weapon2.reloadTime, $scope.weapon2.fireRate];
        
        myChart.update();
    }

    function fetchAllWeapons() {
        GetWeaponService.fetchAllWeapons()
            .then(
                function (d) {
                    self.weapons = d.data;
                    $scope.weapons = self.weapons;
                    $scope.weapon1 = self.weapons[0];
                    $scope.weapon2 = self.weapons[0];
                    self.onChange();
                },
                function (errResponse) {
                    console.error('Error fetching weapons');
                }
            );
    }

    var ctx = document.getElementById("myChart").getContext("2d");
    var myChart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: ['Clip Size', 'Body Shot', 'Head Shot', 'Reload Time', 'Fire Rate'],
            datasets: [{
                label: 'Weapon 1',
                data: [16, 13, 20, 1.9, 10],
                borderColor: '#FF0000',
                backgroundColor: 'rgba(255,0,0,0.5)',
                pointBackgroundColor: '#FF0000',
                pointHoverRadius: 8,
                pointRadius: 5
            }, {
                label: 'Weapon 2',
                data: [44, 17, 34, 2.8, 5],
                borderColor: '#FFFF00',
                backgroundColor: 'rgba(255,255,0,0.5)',
                pointBackgroundColor: '#FFFF00',
                pointHoverRadius: 8,
                pointRadius: 5
            }]
        },
        options: {
            title: {
                text: 'Weapon 1 vs Weapon 2',
                fontSize: 18,
                fontColor: '#FFFFFF',
                display: true
            },
            legend: {
                position: 'bottom',
                labels: {
                    padding: 20
                }
            },
            responsive: true,
            maintainAspectRatio: false,
            scale: {
                gridLines: {
                    color: '#FFFFFF'
                },
                angleLines: {
                    color: '#FFFFFF'
                },
                ticks: {
                    backdropColor: 'rgba(0,0,0,0)',
                    fontColor: '#FFFFFF',
                    beginAtZero: true
                }
            },
            elements: {
                point: {
                    pointStyle: 'circle'
                }
            },
            hover: {
                mode: 'nearest',
                intersect: false
            },
            tooltips: {
                mode: 'nearest',
                intersect: false
            }
        }
    });
}]);
