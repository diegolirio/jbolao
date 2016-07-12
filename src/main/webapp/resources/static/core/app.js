
var app = angular.module('app', ['ngRoute', 'angucomplete-alt']);

var SERVER_APP = '/jbolao';

app.config(['$routeProvider', '$httpProvider',  
            function($routeProvider, $httpProvider) {
	  
	$routeProvider
	    // public
		.when('/', { templateUrl: SERVER_APP + '/campeonato/dashboard'})
		.when('/classificacao/:campeonatoId', { templateUrl: SERVER_APP + '/inscricao/rancking'})
		.when('/jogos/:campeonatoId',  		  { templateUrl: SERVER_APP + '/jogo/list'})
		.when('/aposta/:inscricaoId', 	  	  { templateUrl: SERVER_APP + '/aposta/list'})
		.when('/simulacao/:campeonatoId', 	  { templateUrl: SERVER_APP + '/campeonato/simulacao'})
		.when('/login', 	  				  { templateUrl: SERVER_APP + '/login'})
		
		// private
		.when('/campeonato/:id', { templateUrl: SERVER_APP + '/campeonato/form'})
		.when('/jogo/:id/campeonato/:campeonatoId',  { templateUrl: SERVER_APP + '/jogo/form'})
		.when('/aposta/edit/:id', { templateUrl: SERVER_APP + '/aposta/form'})
		
		//.when('/campeonatos',    { templateUrl: SERVER_APP + '/campeonato/list'})
		//.when('/jogos/por/campeonato/:campeonatoId', { templateUrl: SERVER_APP + '/jogo/list'})

		//.when('/inscricoes/por/campeonato/:campeonatoId', { templateUrl: SERVER_APP + '/inscricao/list'})
		.when('/inscricao/:id/campeonato/:campeonatoId',  { templateUrl: SERVER_APP + '/inscricao/form'})
		.when('/inscricao/:id/campeonato/:campeonatoId/:participante',  { templateUrl: SERVER_APP + '/inscricao/form'})

		.when('/participante/:id/campeonato/:campeonatoId', { templateUrl: SERVER_APP + '/participante/form'})
		
		;

}]);  

