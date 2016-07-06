
var app = angular.module('app', ['ngRoute']);

var SERVER_APP = '/jbolao';

app.config(['$routeProvider', '$httpProvider',  
            function($routeProvider, $httpProvider) {
	  
	$routeProvider
		.when('/', { templateUrl: SERVER_APP + '/campeonato/dashboard'})
		
		.when('/campeonato/:id', { templateUrl: SERVER_APP + '/campeonato/form'})
		.when('/campeonatos',    { templateUrl: SERVER_APP + '/campeonato/list'})
		
		.when('/jogos/por/campeonato/:campeonatoId', { templateUrl: SERVER_APP + '/jogo/list'})
		;

}]);  

