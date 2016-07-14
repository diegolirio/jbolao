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
	
	self.getStatusDescription = function(status) {
		return JogoService.getStatusDescription(status);
	}
	
	self.init();
	
}]);
