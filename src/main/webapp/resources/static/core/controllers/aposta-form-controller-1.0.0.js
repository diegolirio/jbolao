app.controller('ApostaFormController', ['$routeParams', '$location', 'ApostaService', 'JogoService',
                                            function($routeParams, $location, ApostaService, JogoService) {

	var self = this;

	self.init = function() {
		ApostaService.findOne($routeParams.id).then(function(resp) {
			self.aposta = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	var _save = function(aposta, nextPage) {
		ApostaService.save(aposta).then(function(resp) {
			self.aposta = resp.data;
			alert("Gravado com sucesso!");
			if(nextPage)
				$location.url(nextPage);
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
	}
	
	self.save = function(aposta) {
		_save(aposta, '/aposta/'+self.aposta.inscricao.id);
	}

	self.saveAndContinue = function(aposta) {
		_save(aposta, null);
	}
	
	self.getStatusDescription = function(status) {
		return JogoService.getStatusDescription(status);
	}

	self.init();
	
}]);
