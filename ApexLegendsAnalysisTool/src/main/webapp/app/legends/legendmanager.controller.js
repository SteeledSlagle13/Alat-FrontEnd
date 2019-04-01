'use strict';

angular.module('legendManagerApp').controller('legendController', ['$scope', 'LegendService', function ($scope, LegendService) {
    var self = this;

    self.legend = {
        id:'',
        nickName:'',
        role:'',
        name:'',
        age:'',
        tacticalAbility:'',
        passiveAbility:'',
        ultimateAbility:'',
        imageSource:''
    };

    self.legends = [];

    fetchAllLegends();

    function fetchAllLegends() {
        LegendService.fetchAllLegends()
            .then(
                function (d) {
                    self.legends = d.data;
                },
                function (errResponse) {
                    console.error('Error fetching legends' + errResponse);
                }
            );
    }

    function createLegend(legend) {
        LegendService.createLegend(legend)
            .then(
                fetchAllLegends,
                function (errResponse) {
                    console.error('Error creating legends' + errResponse);
                }
            );
    }

    function deleteLegend(id) {
        LegendService.deleteLegend(id)
            .then(
                fetchAllLegends,
                function (errResponse) {
                    console.error('Error deleting Legends' + errResponse);
                }
            );
    }
}]);
