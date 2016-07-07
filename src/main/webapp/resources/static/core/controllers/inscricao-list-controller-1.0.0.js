/**
 * 
 */
app.controller('InscricaoListController', ['$routeParams', 'CampeonatoService', 'InscricaoService', 
                                           function($routeParams, CampeonatoService, InscricaoService) {

	var self = this;
	
	self.init = function() {
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
