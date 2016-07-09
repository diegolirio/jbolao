/**
 * 
 */
app.controller('InscricaoListController', ['$routeParams', '$location', 'CampeonatoService', 'InscricaoService', 'JogoService',
                                           function($routeParams, $location, CampeonatoService, InscricaoService, JogoService) {

	var self = this;
	 
	self.init = function() {
		self.location = $location;
		CampeonatoService.findOne($routeParams.campeonatoId).then(function(resp) {
			self.campeonato = resp.data;
			return resp;
		}).then(function(respCampeonato) {
			JogoService.countByCampeonatoAndamentoAndFinalizado(respCampeonato.data).then(function(resp) {
				self.countJogos = resp.data.countJogos;
			}, function(error) { 
				alert('Erro ao pegar quantidade de Jogos: \n' + JSON.stringify(error));
			});
			return respCampeonato;
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
	
	self.calcPercent = function(inscricao) {
		//<!-- TOTAL_JOGOS = todos os jogos daquele campeonato onde Status != EDICAO  --> 
		//<!-- Calculo = TOTAL_JOGOS * PONTO_MAXIMO_8 * 100 / pontos_participante  -->
		if(inscricao.pontos == 0) 
			return 0;
		return self.countJogos * 8 * 100 / inscricao.pontos;
	}
	
	self.init();
	
}]);
