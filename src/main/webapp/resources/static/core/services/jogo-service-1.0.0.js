app.factory('JogoService', ['$http', function($http) {
	
	var _findByCampeonato = function(campeonato) {
		return $http.get('/jbolao/api/jogo/findbycampeonato/'+campeonato.id);//, campeonato);
	}	
	
	var _findOne = function(id) {
		return $http.get('/jbolao/api/jogo/findone/'+id);
	}
	
	var _findByCampeonatoAndStatus = function(campeonato, status) {
		return $http.get('/jbolao/api/jogo/findbycampeonatoandstatus/'+campeonato.id+'/'+status);
	}

	var _findDistinctRodadaByCampeonato = function(campeonato, status) {
		return $http.get('/jbolao/api/jogo/finddistinctrodadabycampeonato/'+campeonato.id);
	}
	
	var _save = function(jogo) {
		return $http.post('/jbolao/api/jogo/save', jogo);
	}	

	var _start = function(jogo) {
		return $http.put('/jbolao/api/jogo/start', jogo);
	}	

	var _backToEdit = function(jogo) {
		return $http.put('/jbolao/api/jogo/backtoedit', jogo);
	}	

	var _finalize = function(jogo) {
		return $http.put('/jbolao/api/jogo/finalize', jogo);
	}	
	
	var _backToInProccess = function(jogo) {
		return $http.put('/jbolao/api/jogo/backtoinproccess', jogo);
	}	
	
	var _getStatusDescription = function(status) {
		if(status == 'EDICAO') return "Pendente";
		if(status == 'EM_ANDAMENTO') return "Em Andamento";
		if(status == 'FINALIZADO') return "Finalizado";
	}

	var _countByCampeonatoAndamentoAndFinalizado = function(campeonato) {
		return $http.get('/jbolao/api/jogo/countjogosemandamentofinalizado/'+campeonato.id);
	}
	
	var _deleteJogo = function(jogo) {
		return $http.delete('/jbolao/api/jogo/delete/'+jogo.id);
	}
	
	return {
		
		findByCampeonato : _findByCampeonato,
		
		findOne : _findOne,
	
		findByCampeonatoAndStatus : _findByCampeonatoAndStatus,
	
		findDistinctRodadaByCampeonato : _findDistinctRodadaByCampeonato,
		
		save : _save,
 
		start : _start,

		backToEdit : _backToEdit,

		finalize : _finalize,

		backToInProccess : _backToInProccess,
		
		getStatusDescription : _getStatusDescription,
	
		countByCampeonatoAndamentoAndFinalizado : _countByCampeonatoAndamentoAndFinalizado,
		
		deleteJogo : _deleteJogo
		
	}
	
}]);