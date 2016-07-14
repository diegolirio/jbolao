/**
 * 
 */
app.controller('ApostaMyEditController', ['$routeParams', '$location', 'InscricaoService', 'ApostaService', 'JogoService',
                                         function($routeParams, $location, InscricaoService, ApostaService, JogoService) {

	var self = this;
	
	self.init = function() {
		InscricaoService.findByIdAndCodigoEdicaoApostas($routeParams.inscricaoId, $routeParams.codigoEdicaoApostas).then(function(resp) {
			self.inscricao = resp.data;
			console.log(self.inscricao);
			return resp;
		}).then(function(respInscricao) {
			if(self.inscricao == null || self.inscricao.campeonato.status != 'EDICAO') {
				alert("O Formulario de Edicao de Aposta encontra-se indisponivel, segue abaixo os possiveis motivos: \n\n-Sua aposta foi concluida. \n-Foi esgotado o prazo para Editar suas apostas. \n-Link pode ter sido desativado por motivos administrativos");
				$location.url("/");
				return;
			}
			ApostaService.findByInscricao(respInscricao.data).then(function(resp) {
				self.apostas = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}, function(error) {
			alert(JSON.stringify(error));
			alert("Erro ao buscar suas apostas, o formulário de Edição das apostas pode não estar mais disponivel");
			$location.url("/");
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
	
	self.concluirAposta = function(inscricao) {
		InscricaoService.finalizeEdicaoAposta(inscricao).then(function(resp) {
			$location.url('/aposta/'+resp.data.id);
		}, function(error) {
			alert('Erro ao Concluir Aposta: '+JSON.stringify(error));
		});
	}
		
	self.getStatusDescription = function(status) {
		return JogoService.getStatusDescription(status);
	}

	self.init();
	
}]);
