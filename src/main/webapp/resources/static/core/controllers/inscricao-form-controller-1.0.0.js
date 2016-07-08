app.controller('InscricaoFormController', ['$scope', '$routeParams', '$location', 'InscricaoService', 'ParticipanteService',
                                            function($scope, $routeParams, $location, InscricaoService, ParticipanteService) {

	var self = this;

	self.init = function() {
		self.inscricao = {};
		self.inscricao.campeonato = {};
		self.inscricao.campeonato.id = $routeParams.campeonatoId;
		// busca todos participantes para o autocomplete
	    self.participantes = [];
	    self.inscricao.participante = null;
	    ParticipanteService.findAll().then(function(resp) {
	    	self.participantes = resp.data;
	    }, function(error) {
	    	alert(JSON.stringify(error));
	    });
	    self.previousPage = '#'+$location.search().next; 
	    self.nextPage = $location.search().next;
	} 
	
	self.save = function(inscricao) {
		InscricaoService.save(inscricao).then(function(resp) {
			self.inscricao = resp.data;
			alert("Gravado com sucesso!");
			$location.url($location.search().next); 
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
	}

    self.aposSelecionarParticipante = function (selected) {
        if (selected) {
        	self.inscricao.participante = selected.originalObject;
        }
    }
    
	self.init();
	
}]);
