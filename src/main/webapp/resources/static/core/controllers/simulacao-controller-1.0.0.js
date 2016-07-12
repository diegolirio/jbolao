/**
 * 
 */
app.controller('SimulacaoCrontroller', ['$routeParams', 'CampeonatoService', 'JogoService', 'InscricaoService', 'ApostaService',
                                        'SimuladorCommon',
                                        function($routeParams, CampeonatoService, JogoService, InscricaoService, ApostaService,
                                        		SimuladorCommon) {

	var self = this;
	
	self.init = function() {
		// Busca campeonato
		CampeonatoService.findOne($routeParams.campeonatoId).then(function(resp) {
			self.campeonato = resp.data;  
			return resp; 
		}).then(function(campeonatoResp) {
			// Busca jogos pendentes (em edição) 
			self.index = -1;
			JogoService.findByCampeonatoAndStatus(self.campeonato, 'EDICAO').then(function(resp) {
				self.jogos = resp.data;
				return resp;
			}).then(function(jogoResp) {
				if(self.jogos.length > 0) {
					ApostaService.findByCampeonatoAndJogoStatus(self.campeonato, 'EDICAO').then(function(resp) {
						self.apostas = resp.data;
					}).then(function(apostaResp) {
						InscricaoService.findByCampeonato(self.campeonato).then(function(resp) {
							self.inscricoes = resp.data;
							self.inscricoesRanckingReal = [];
							for(var i = 0; i <= self.inscricoes.length-1; i++) {
								self.inscricoesRanckingReal.push({"id": self.inscricoes[i].id, "pontos": self.inscricoes[i].pontos});
							}
							self.setIndex(0);
						}, function(error) {
							alert(JSON.stringify(error));
						});
					}, function(error) {
						alert(JSON.stringify(error));
					});
				}	
			}, function(error) {
				alert(error.data);
			});			
			// Busca qtde de jogos Realizados
			JogoService.countByCampeonatoAndamentoAndFinalizado(campeonatoResp.data).then(function(resp) {
				self.countJogos = resp.data.countJogos;
			}, function(error) { 
				alert('Erro ao pegar quantidade de Jogos: \n' + JSON.stringify(error));
			});
			 
		}, function(error) {
			alert(JSON.stringify(error));
		});		
	}
	
	var newInscricao = function(inscricao) {
		var inscricaoNew = {};
		inscricaoNew.id = inscricao.id;
		inscricaoNew.pontos = inscricao.pontos;
		inscricaoNew.participante = {};
		inscricaoNew.participante.nome = inscricao.participante.nome;
		inscricaoNew.pontosSomados = inscricao.pontosSomados;
		inscricaoNew.jogoResultadoA = inscricao.jogoResultadoA;
		inscricaoNew.jogoResultadoB = inscricao.jogoResultadoB;
		return inscricaoNew;
	}
	
	var reordenarRanking = function() {
		var inscricoesOrder = [];
		for(var i = 0; i <= self.inscricoes.length-1; i++) {
			self.inscricoes[i].order = false; 
		}		
		
		var insc_maoir = {};
		insc_maoir.pontos = -1;
		
		for(var i = 0; i <= self.inscricoes.length-1; i++) { // loop para setar colocacao
			
			
			for(var i_maior in self.inscricoes) { // pega o primeiro ao ultimo
				if(self.inscricoes[i_maior].order == false) {
					if(self.inscricoes[i_maior].pontos > insc_maoir.pontos) {
						insc_maoir = self.inscricoes[i_maior];
					}
					console.log(self.inscricoes[i_maior].participante.nome + ' - ' + self.inscricoes[i_maior].pontos + 
							' | Maior: ' + insc_maoir.pontos + ' - ' + insc_maoir.participante.nome);					
				}
			}
			
			for(var i_add = 0; i_add <= self.inscricoes.length-1; i_add++) { // Add o primeiro ao ultimo
				console.log(self.inscricoes[i_add]);
				if(self.inscricoes[i_add].id == insc_maoir.id) {
					console.log("============ Push: " + self.inscricoes[i_add].participante.nome + " ==============");		
					self.inscricoes[i_add].order = true;
					self.inscricoes[i_add].colocacao = i;
					inscricoesOrder.push(newInscricao(insc_maoir));
					insc_maoir = {};
					insc_maoir.pontos = -1;
				}
			}
			console.log(" ---------------------------------------------------------------------- ");
		}
		console.log(" Init order ");
		// Colocar em ordem de classificacao
		for(var aux in inscricoesOrder) {
			self.inscricoes[aux].id = inscricoesOrder[aux].id;
			self.inscricoes[aux].campeonato = inscricoesOrder[aux].campeonato;
			self.inscricoes[aux].participante.nome = inscricoesOrder[aux].participante.nome;
			self.inscricoes[aux].colocacao = inscricoesOrder[aux].colocacao;
			self.inscricoes[aux].pontos = inscricoesOrder[aux].pontos;
			self.inscricoes[aux].pontosSomados = inscricoesOrder[aux].pontosSomados;
			self.inscricoes[aux].jogoResultadoA = inscricoesOrder[aux].jogoResultadoA;
			self.inscricoes[aux].jogoResultadoB = inscricoesOrder[aux].jogoResultadoB;
		}
	}
	
	var getVencedor = function(rA, rB) {
		if(rA > rB)
			return 'A';
		if(rA < rB)
			return 'B';
		return 'E';
	}	
	
	var getIndexApostaByInscricaoAndJogo = function(jogo, inscricao) {
		for(var i in self.apostas) {
			if(self.apostas[i].jogo.id == jogo.id && self.apostas[i].inscricao.id == inscricao.id) 
				return i;
		}
		return null; 
	}

	var getPontosApostaSimulacaoPorInscricao = function(inscricao) {
		var pontos = 0;
		for(var i in self.apostas) {
			if(self.apostas[i].inscricao.id == inscricao.id && self.apostas[i].calculado == true)
				pontos += self.apostas[i].pontos;
		} 
		return pontos;
	}
	
	self.recalcular = function() {
		self.jogos[self.index].vencedor = getVencedor(self.jogos[self.index].resultadoA, self.jogos[self.index].resultadoB);
		for(var ir in self.inscricoesRanckingReal) {
			for(var is = 0; is <= self.inscricoes.length-1; is++) {
				
				if(self.inscricoes[is].id != self.inscricoesRanckingReal[ir].id)  
					continue;
				
				var apostaIndex = getIndexApostaByInscricaoAndJogo(self.jogos[self.index], self.inscricoes[is]);
				self.apostas[apostaIndex].calculado = true;
				self.apostas[apostaIndex].vencedor = getVencedor(self.apostas[apostaIndex].resultadoA, self.apostas[apostaIndex].resultadoB);
				
				// calcula pontos
				if(SimuladorCommon.acertouPlacar(self.apostas[apostaIndex], self.jogos[self.index]) == true) 
					self.apostas[apostaIndex].pontos = 8;
				else 
					if(SimuladorCommon.acertouVencedorUmResultado(self.apostas[apostaIndex], self.jogos[self.index]) == true) 
						self.apostas[apostaIndex].pontos = 5;
				else 
					if(SimuladorCommon.acertouVencedor(self.apostas[apostaIndex], self.jogos[self.index]) == true) 
						self.apostas[apostaIndex].pontos = 3;
				else
					if(SimuladorCommon.acertouSomenteUmResultado(self.apostas[apostaIndex], self.jogos[self.index]) == true) 
						self.apostas[apostaIndex].pontos = 1;
				else 
					self.apostas[apostaIndex].pontos = 0;				
				
				var ps = getPontosApostaSimulacaoPorInscricao(self.inscricoes[is]);
				self.inscricoes[is].pontosSomados = ps;				
				self.inscricoes[is].pontos = self.inscricoesRanckingReal[ir].pontos + self.inscricoes[is].pontosSomados;
			}
		}
		self.jogos[self.index].calculado = true;
		reordenarRanking();
	}
	
	var populaResultadoParticipanteVisual = function(jogo, aposta) {
		for (var ii in self.inscricoes) {
			for(var ai in self.apostas) {
				if(self.apostas[ai].jogo.id == jogo.id && 
				   self.apostas[ai].inscricao.id == self.inscricoes[ii].id) {
					self.inscricoes[ii].jogoResultadoA = self.apostas[ai].resultadoA;
					self.inscricoes[ii].jogoResultadoB = self.apostas[ai].resultadoB;
				}
			}
		}
	}
	
	self.setIndex = function(i) {
		self.index = i;
		if(!self.jogos[self.index].calculado) {
			self.recalcular();
			populaResultadoParticipanteVisual(self.jogos[self.index]);
		}
	}
	
	self.init();
	
}]);
