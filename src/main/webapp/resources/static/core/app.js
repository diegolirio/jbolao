
var app = angular.module('app', ['ngRoute', 'angucomplete-alt']);

var SERVER_APP = '/jbolao';

app.config(['$routeProvider', '$httpProvider',  
            function($routeProvider, $httpProvider) {
	  
	$routeProvider
		.when('/', { templateUrl: SERVER_APP + '/campeonato/dashboard'})
		
		.when('/campeonato/:id', { templateUrl: SERVER_APP + '/campeonato/form'})
		.when('/campeonatos',    { templateUrl: SERVER_APP + '/campeonato/list'})
		
		.when('/jogos/por/campeonato/:campeonatoId', { templateUrl: SERVER_APP + '/jogo/list'})
		.when('/jogo/:id/campeonato/:campeonatoId',  { templateUrl: SERVER_APP + '/jogo/form'})

		.when('/inscricoes/por/campeonato/:campeonatoId', { templateUrl: SERVER_APP + '/inscricao/list'})
		.when('/inscricao/:id/campeonato/:campeonatoId',  { templateUrl: SERVER_APP + '/inscricao/form'})
		.when('/inscricao/:id/campeonato/:campeonatoId/:participante',  { templateUrl: SERVER_APP + '/inscricao/form'})

		.when('/participante/:id/campeonato/:campeonatoId', { templateUrl: SERVER_APP + '/participante/form'})
		;

}]);  

