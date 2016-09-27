/**
 * 
 */
var app = angular.module('app', ['ngRoute']);

app.IS_MOBILE = false;
app.SERVER_APP = '/bolao';
app.SERVER_APP_MOBILE = 'http://bolao-diegolirio.rhcloud.com/bolao';

app.config(['$routeProvider', function($routeProvider) {
	
	var loadView = function(view) {
		if(app.IS_MOBILE) return '.' + view + '.html';
		return app.SERVER_APP + view;
	}	
	
	$routeProvider
		.when('/',                            {templateUrl: loadView('/dashboard') })
		.when('/classificacao/:campeonatoId', {templateUrl: loadView('/inscricao/classificacao') })
		;
	
}]);