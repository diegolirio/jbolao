/**
 * 
 */
app.controller('CampeonatoDashboardCrontroller', ['$route', '$location', 'CampeonatoService', 'UsuarioSessionService',
                                                  function($route, $location, CampeonatoService, UsuarioSessionService) {

	var self = this;
	
	self.init = function() {
		
		CampeonatoService.findAll().then(function(resp) {
			self.campeonatos = resp.data;  
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.enterCampeonato = function(campeonato) {
		UsuarioSessionService.setCampeonatoSession(campeonato).then(function(resp) {
			$location.path('/classificacao/'+campeonato.id); 
			$route.reload();
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.init();
	
}]);
