/**
 * 
 */
app.controller('CampeonatoDashboardCrontroller', ['$route', '$location', 'CampeonatoService', 'UsuarioSessionService',
                                                  function($route, $location, CampeonatoService, UsuarioSessionService) {

	var self = this;
	
	self.TODOS = 0;
	self.MEUS = 1;
	
	self.init = function() {
		self.findAll();
	}
	
	self.enterCampeonato = function(campeonato) {
		UsuarioSessionService.setCampeonatoSession(campeonato).then(function(resp) {
			//$location.path('/classificacao/'+campeonato.id); 
			//$route.reload();
			window.location.href = '/jbolao/#/classificacao/'+campeonato.id;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}

	self.findAll = function() {
		CampeonatoService.findAll().then(function(resp) {
			self.campeonatos = resp.data;  
			self.showCampeonatos = self.TODOS;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.meusCampeonatos = function(usuario) {
		CampeonatoService.findByPresidente(usuario).then(function(resp) {
			self.campeonatos = resp.data;
			self.showCampeonatos = self.MEUS;
		}, function(error) {
			alert(error);
		});
	}
	
	self.btnShowCampeonatos = function(usuario) {
		if(self.showCampeonatos == self.TODOS)
			self.meusCampeonatos(usuario);
		else
			self.findAll();
	}
	
	self.init();
	
}]);
