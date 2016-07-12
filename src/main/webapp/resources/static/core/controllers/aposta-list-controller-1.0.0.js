/**
 * 
 */
app.controller('ApostaListController', ['$routeParams', 'InscricaoService', 'ApostaService', 'JogoService',
                                       function($routeParams, InscricaoService, ApostaService, JogoService) {

	var self = this;
	
	self.init = function() {
		InscricaoService.findOne($routeParams.inscricaoId).then(function(resp) {
			self.inscricao = resp.data;
			return resp;
		}).then(function(respInscricao) {
			ApostaService.findByInscricao(respInscricao.data).then(function(resp) {
				self.apostas = resp.data;
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
