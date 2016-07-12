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
		console.log(pontos);  
		return pontos;
	}

	var _clearPontuacaoInscricaoFilter = function() {
		for(var ii in self.inscricoesFilter) {
			self.inscricoesFilter[ii].pontos = 0;
			self.inscricoesFilter[ii].acertoPlacar = 0;
			self.inscricoesFilter[ii].acertoVencedorUmResultado = 0;
			self.inscricoesFilter[ii].acertoVencedor = 0;
			self.inscricoesFilter[ii].acertoSomenteUmResultado = 0;
			self.inscricoesFilter[ii].errouTudo = 0;
			self.inscricoesFilter[ii].jogos = 0;
		}
	}
	

	var _newInscricao = function(inscricao) {
		var inscricaoNew = {};
		inscricaoNew.id = inscricao.id;
		inscricaoNew.pontos = inscricao.pontos; 
		inscricaoNew.participante = {};
		inscricaoNew.participante.nome = inscricao.participante.nome;
		inscricaoNew.pontosSomados = inscricao.pontosSomados;
		//inscricaoNew.jogoResultadoA = inscricao.jogoResultadoA;
		//inscricaoNew.jogoResultadoB = inscricao.jogoResultadoB;
		return inscricaoNew;
	}
	
	var _reordenarRanking = function() {
		var inscricoesOrder = [];
		for(var i = 0; i <= self.inscricoesFilter.length-1; i++) {
			self.inscricoesFilter[i].order = false; 
		}		
		
		var insc_maoir = {};
		insc_maoir.pontos = -1;
		
		for(var i = 0; i <= self.inscricoesFilter.length-1; i++) { // loop para setar colocacao
			
			
			for(var i_maior in self.inscricoesFilter) { // pega o primeiro ao ultimo
				if(self.inscricoesFilter[i_maior].order == false) {
					if(self.inscricoesFilter[i_maior].pontos > insc_maoir.pontos) {
						insc_maoir = self.inscricoesFilter[i_maior];
					}
					console.log(self.inscricoesFilter[i_maior].participante.nome + ' - ' + self.inscricoesFilter[i_maior].pontos + 
							' | Maior: ' + insc_maoir.pontos + ' - ' + insc_maoir.participante.nome);					
				}
			}
			
			for(var i_add = 0; i_add <= self.inscricoesFilter.length-1; i_add++) { // Add o primeiro ao ultimo
				console.log(self.inscricoesFilter[i_add]);
				if(self.inscricoesFilter[i_add].id == insc_maoir.id) {
					console.log("============ Push: " + self.inscricoesFilter[i_add].participante.nome + " ==============");		
					self.inscricoesFilter[i_add].order = true;
					self.inscricoesFilter[i_add].colocacao = i;
					inscricoesOrder.push(_newInscricao(insc_maoir));
					insc_maoir = {};
					insc_maoir.pontos = -1;
				}
			}
			console.log(" ---------------------------------------------------------------------- ");
		}
		console.log(" Init order ");
		// Colocar em ordem de classificacao
		for(var aux in inscricoesOrder) {
			self.inscricoesFilter[aux].id = inscricoesOrder[aux].id;
			self.inscricoesFilter[aux].campeonato = inscricoesOrder[aux].campeonato;
			self.inscricoesFilter[aux].participante.nome = inscricoesOrder[aux].participante.nome;
			self.inscricoesFilter[aux].colocacao = inscricoesOrder[aux].colocacao;
			self.inscricoesFilter[aux].pontos = inscricoesOrder[aux].pontos;
			self.inscricoesFilter[aux].pontosSomados = inscricoesOrder[aux].pontosSomados;
			self.inscricoesFilter[aux].jogoResultadoA = inscricoesOrder[aux].jogoResultadoA;
			self.inscricoesFilter[aux].jogoResultadoB = inscricoesOrder[aux].jogoResultadoB;
		}
	}
	
	
	self.executaFiltro = function(filtro) {
		ApostaService.findByCampeonatoAndJogoRodadaOrderByInscricao(self.campeonato, filtro.rodada).then(function(resp) {
			self.apostasFilter = resp.data;
			return resp;
		}).then(function(apostaResp) {
			InscricaoService.findByCampeonato(self.campeonato).then(function(resp) {
				self.inscricoesFilter = resp.data;
				_clearPontuacaoInscricaoFilter();
			}).then(function(inscricaoResp) {
				for(var ii in self.inscricoesFilter) {
					self.inscricoesFilter[ii].pontos = countTotalPontosByInscricao(self.inscricoesFilter[ii]);
				}
				_reordenarRanking();
				self.filter = 'RANCKING_FILTER';
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.init();
	
}]);
