/**
 * 
 */
app.controller('ApostaListController', ['$routeParams', '$location', 'InscricaoService', 'ApostaService', 'JogoService',
                                       function($routeParams, $location, InscricaoService, ApostaService, JogoService) {

	var self = this;
	
	self.init = function() {
		InscricaoService.findOne($routeParams.inscricaoId).then(function(resp) {
			self.inscricao = resp.data;
			return resp;
		}).then(function(respInscricao) {
			ApostaService.findByInscricao(respInscricao.data).then(function(resp) {
				self.apostas = resp.data;
				for(var i =0; i <= self.apostas.length-1; i++) {
					self.btnConcluir = true; break;
				}	
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}, function(error) {
			alert(JSON.stringify(error));
		});
		self.nextPage = $location.search().next;
	}
	
	self.saveAposta = function(aposta) {
		ApostaService.save(aposta).then(function(resp) {
			console.log(resp.data);
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.deleteInscricao = function(inscricao) {
		InscricaoService.deleteInscricao(inscricao).then(function(resp) {
			$location.url($location.search().next ? $location.search().next : '/classificacao/'+inscricao.campeonato.id);
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.getStatusDescription = function(status) {
		return JogoService.getStatusDescription(status);
	}

	self.init();
	
}]);
