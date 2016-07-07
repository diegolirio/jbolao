app.controller('InscricaoFormController', ['$routeParams', '$location', 'InscricaoService', 'ParticipanteService',
                                            function($routeParams, $location, InscricaoService, ParticipanteService) {

	var self = this;

	self.init = function() {
		if($routeParams.id > 0) {
			InscricaoService.findOne($routeParams.id).then(function(resp) {
				self.inscricao = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		} else {
			self.inscricao = {};
			self.inscricao.campeonato = {};
			self.inscricao.campeonato.id = $routeParams.campeonatoId;
			console.log($location.search().participante_id);
			if($routeParams.participanteId > 0) {
				ParticipanteService.findOne($routeParams.participanteId).then(function(resp) {
					self.inscricao.participante = resp.data;
					console.log(self.inscricao.participante); 
				}, function(error) {
					alert(JSON.stringify(error));
				});
			}
		}
		
		// busca todos participantes para o autocomplete
	    self.participantes = [];
	    self.inscricao.participante = null;
	    ParticipanteService.findAll().then(function(resp) {
	    	self.participantes = resp.data;
	    }, function(error) {
	    	alert(JSON.stringify(error));
	    });
	    
	    // proxima pagina
		self.next = $location.url(); 
	}
	
	self.save = function(inscricao) {
		InscricaoService.save(inscricao).then(function(resp) {
			self.inscricao = resp.data;
			alert("Gravado com sucesso!");
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
