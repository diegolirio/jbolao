/**
 * 
 */
app.controller('JogoListController', ['$routeParams', 'JogoService', 'CampeonatoService', 
                                      function($routeParams, JogoService, CampeonatoService) {

	var self = this;
	
	self.init = function() {
		CampeonatoService.findOne($routeParams.campeonatoId).then(function(resp) {
			self.campeonato = resp.data;
			return resp;
		}).then(function(respCampeonato) {
			JogoService.findByCampeonato(respCampeonato.data).then(function(resp) {
				self.jogos = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}

	self.iniciar = function(campeonato) {
		CampeonatoService.iniciar(campeonato).then(function(resp) {
			self.campeonato = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}

	/**
	 * Voltar para pendente
	 */
	self.voltarPendente = function(campeonato) {
		CampeonatoService.voltarPendente(campeonato).then(function(resp) {
			self.campeonato = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.init();
	
}]);
