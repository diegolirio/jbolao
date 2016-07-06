
var app = angular.module('app', ['ngRoute']);

var SERVER_APP = '/jbolao';

app.config(['$routeProvider', '$httpProvider',  
            function($routeProvider, $httpProvider) {
	  
	$routeProvider
		.when('/', { templateUrl: SERVER_APP + '/campeonato/dashboard'})
		;

}]);  

