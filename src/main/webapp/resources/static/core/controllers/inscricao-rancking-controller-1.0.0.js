/**
 * 
 */
app.controller('InscricaoRanckingController', ['$routeParams', '$location', 'CampeonatoService', 
                                               'InscricaoService', 'JogoService', 'ApostaService',
                                           function($routeParams, $location, CampeonatoService, 
                                        		   InscricaoService, JogoService, ApostaService) {

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
		return inscricao.pontos * 100 / (self.countJogos * 8);
	}
	
	var countTotalPontosByInscricao = function(inscricao) {
		var pontos = 0;
		for(var i in self.apostasFilter) {
			if(inscricao.id == self.apostasFilter[i].inscricao.id) {
				pontos += self.apostasFilter[i].pontos;
			}
		}
		return pontos;
	}
	
	self.executaFiltro = function(filtro) {
		//ApostaService.executeFilter(filtro).then(function(resp) {
		//	self.apostas = resp.data;
		//}, function(error) { 
		//	alert(JSON.stringify(error));
		//});
		ApostaService.findByJogoRodadaOrderByInscricaoId(filtro.rodada).then(function(resp) {
			self.apostasFilter = resp.data;
			return resp;
		}).then(function(apostaResp) {
			self.inscricoesFilter = [];
			var id = -1;
			for(var i in self.apostasFilter) {
				if(self.apostasFilter[i].inscricao.id != id) {
					inscr = {};
					inscr.id = self.apostasFilter[i].inscricao.id;
					inscr.participante = self.apostasFilter[i].inscricao.participante;
					inscr.pontos = countTotalPontosByInscricao(inscr);
					self.inscricoesFilter.push(inscr);
					console.log(self.inscricoesFilter);
				}
			}
			self.filter = 'RANCKING_FILTER';
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.init();
	
}]);
