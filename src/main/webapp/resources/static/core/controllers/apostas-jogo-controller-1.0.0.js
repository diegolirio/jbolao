/**
 * 
 */
app.controller('ApostasJogoController', ['$routeParams', 'ApostaService', 'JogoService',
                                       function($routeParams, ApostaService, JogoService) {

	var self = this;
	
	self.init = function() {
		JogoService.findOne($routeParams.jogoId).then(function(resp) {
			self.jogo = resp.data;
			return resp;
		}).then(function(respJogo) {
			ApostaService.findByJogo(respJogo.data).then(function(resp) {
				self.apostas = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	//self.getStatusDescription = function(status) {
	//	return JogoService.getStatusDescription(status);
	//}

	self.init();
	
}]);
