'use strict';

angular.module('legendManagerApp').factory('LegendService', ['$http', function($http){

    var REST_SERVICE_URI = 'http://localhost:8085/ApexLegendsAnalysisTool/legend/';

    var factory = {
        fetchAllLegends: fetchAllLegends,
        createLegend: createLegend,
        deleteLegend:deleteLegend
    };

    return factory;

    function fetchAllLegends() {
        return $http.get(REST_SERVICE_URI);
    }

    function createLegend(legend) {
        console.log(legend.id + " " + legend.name);
        return $http.post(REST_SERVICE_URI, legend);
    }

    function deleteLegend(id) {
        return $http.delete(REST_SERVICE_URI+id);
    }
}]);