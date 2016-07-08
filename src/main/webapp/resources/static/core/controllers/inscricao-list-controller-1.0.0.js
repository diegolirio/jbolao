/**
 * 
 */
app.controller('InscricaoListController', ['$routeParams', '$location', 'CampeonatoService', 'InscricaoService', 
                                           function($routeParams, $location, CampeonatoService, InscricaoService) {

	var self = this;
	 
	self.init = function() {
	
		self.location = $location;
		
		CampeonatoService.findOne($routeParams.campeonatoId).then(function(resp) {
			self.campeonato = resp.data;
			return resp;
		}).then(function(respCampeonato) {
			InscricaoService.findByCampeonato(respCampeonato.data).then(function(resp) {
				self.inscricoes = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.init();
	
}]);
