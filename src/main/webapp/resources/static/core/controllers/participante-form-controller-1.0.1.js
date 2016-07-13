app.controller('ParticipanteFormController', ['$routeParams', '$location', '$window', 'ParticipanteService', 
                                              'InscricaoService', 'CampeonatoService',
                                            function($routeParams, $location, $window, ParticipanteService, 
                                            		 InscricaoService, CampeonatoService) {

	var self = this;

	self.init = function() {
		self.previousPage = '#'+$location.search().next;
		if($routeParams.id > 0) {
			ParticipanteService.findOne($routeParams.id).then(function(resp) {
				self.participante = resp.data;
				return resp;
			}).then(function(participanteResp) {
				InscricaoService.findByParticipante(self.participante).then(function(resp) {
					self.inscricaoList = resp.data;
					console.log(self.inscricaoList);
					self.jaInscrito = self.inscricaoList != null && self.inscricaoList != undefined && self.inscricaoList.length > 0;
				}, function(error) {
					alert(JSON.stringify(error));
				});
			}, function(error) {
				alert(JSON.stringify(error));
			});
		} 
		
		CampeonatoService.findOne($routeParams.campeonatoId).then(function(resp) {
			self.campeonato = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
		
	}
	
	var _save = function(participante, nextPage) {
		ParticipanteService.save(participante).then(function(resp) {
			self.participante = resp.data;
			return resp;
		}).then(function(participanteResp) {
			if(!self.jaInscrito) { 
				var inscricao = {};
				inscricao.participante = participanteResp.data;
				inscricao.campeonato = self.campeonato;
				InscricaoService.save(inscricao).then(function(resp) {
					alert("Gravado e Inscrito com sucesso!");
					if(nextPage != null) 
						$location.url(nextPage);
					else
						self.participante = {};
				}, function(error) {
					alert(JSON.stringify(error)); 
				});
			} else {
				alert("Alterado com sucesso!");
				if(nextPage != null) 
					$location.url(nextPage);
				else
					self.participante = {};				
			}
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
		$window.document.getElementById('idNome').focus();
	}
	
	self.save = function(participante) {
		_save(participante, $location.search().next);
	}

	self.saveAndAddNew = function(participante) {
		_save(participante, null);
	}
	
	self.init();
	
}]);
