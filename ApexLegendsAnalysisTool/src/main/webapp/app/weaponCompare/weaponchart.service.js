'use strict';

angular.module('WeaponChartApp').factory('GetWeaponService', ['$http', function($http){

    var REST_SERVICE_URI = 'http://localhost:8086/ApexLegendsAnalysisTool/weapon/';

    var factory = {
        fetchAllWeapons: fetchAllWeapons,
    };

    return factory;

    function fetchAllWeapons() {
        return $http.get(REST_SERVICE_URI);
    }
}]);