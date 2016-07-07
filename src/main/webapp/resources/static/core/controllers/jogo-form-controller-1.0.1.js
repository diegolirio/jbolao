app.controller('JogoFormController', ['$routeParams', 'JogoService', 
                                            function($routeParams, JogoService) {

	var self = this;

	self.init = function() {
		if($routeParams.id > 0) {
			JogoService.findOne($routeParams.id).then(function(resp) {
				self.jogo = resp.data;
				self.campeonato = self.jogo.campeonato;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		} else {
			self.jogo = {};
			self.jogo.campeonato = {};
			self.jogo.campeonato.id = $routeParams.campeonatoId;
			self.jogo.resultadoA = 0;
			self.jogo.resultadoB = 0;
		}
	}
	
	self.save = function(jogo) {
		JogoService.save(jogo).then(function(resp) {
			self.jogo = resp.data;
			alert("Gravado com sucesso!");
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
	}

	self.start = function(jogo) {
		JogoService.start(jogo).then(function(resp) {
			self.jogo = resp.data;
			alert("Jogo Iniciado!");
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
	}

	self.backToEdit = function(jogo) {
		JogoService.backToEdit(jogo).then(function(resp) {
			self.jogo = resp.data;
			alert("Jogo retornado para Pendente!");
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
	}

	self.finalize = function(jogo) {
		JogoService.finalize(jogo).then(function(resp) {
			self.jogo = resp.data;
			alert("Jogo Finalizado com sucesso!");
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
	}

	self.backToInProccess = function(jogo) {
		JogoService.backToInProccess(jogo).then(function(resp) {
			self.jogo = resp.data;
			alert("Jogo Retornado com sucesso para Em Andamento!");
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
	}
	
	self.init();
	
}]);
