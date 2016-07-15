app.factory('ApostaService', ['$http', function($http) {
	
	var _findByInscricao = function(inscricao) {
		return $http.get('/jbolao/api/aposta/findbyinscricao/'+inscricao.id);//, campeonato);
	}	
	
	var _findOne = function(id) {
		return $http.get('/jbolao/api/aposta/findone/'+id);
	}

	var _findByJogo = function(jogo) {
		return $http.get('/jbolao/api/aposta/findbyjogo/'+jogo.id);
	}		
	
	var _findByCampeonatoAndJogoRodadaOrderByInscricao = function(campeonato, rodada) {
		return $http.get('/jbolao/api/aposta/findbycampeonatoandjogorodada/'+campeonato.id+'/'+rodada);
	}		

	var _findByCampeonatoAndJogoRodadaInOrderByInscricao = function(campeonato, rodadas) {
		var rodadasParam = "";
		for(var i = 0; i <= rodadas.length-1; i++) {
			rodadasParam += rodadas[i]+";";
		} 
		return $http.get('/jbolao/api/aposta/findbycampeonatoandjogorodadain/'+campeonato.id+"?rodadas="+rodadasParam);
	}		

	var _findByCampeonatoAndJogoStatus = function(campeonato, status) {
		return $http.get('/jbolao/api/aposta/findbycampeonatoandjogostatus/'+campeonato.id+'/'+status);
	}		
	
	var _save = function(aposta) {
		return $http.post('/jbolao/api/aposta/save', aposta);
	}	
	
	return {
		
		findByInscricao : _findByInscricao,
		
		findByJogo : _findByJogo,
		
		findByCampeonatoAndJogoRodadaOrderByInscricao : _findByCampeonatoAndJogoRodadaOrderByInscricao,
	
		findByCampeonatoAndJogoRodadaInOrderByInscricao : _findByCampeonatoAndJogoRodadaInOrderByInscricao,
		
		findByCampeonatoAndJogoStatus : _findByCampeonatoAndJogoStatus,
		
		findOne : _findOne,
		
		save : _save,
		
	}
	
}]);