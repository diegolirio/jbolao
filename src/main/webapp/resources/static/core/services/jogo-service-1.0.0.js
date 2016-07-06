app.factory('JogoService', ['$http', function($http) {
	
	var _findByCampeonato = function(campeonato) {
		return $http.get('/jbolao/api/jogo/findbycampeonato/'+campeonato.id);//, campeonato);
	}	
	
	var _findOne = function(id) {
		return $http.get('/jbolao/api/jogo/findone/'+id);
	}
	
	var _save = function(jogo) {
		return $http.post('/jbolao/api/jogo/save', jogo);
	}	

	var _delete = function(jogo) {
		return $http.delete('/jbolao/api/jogo/delete', jogo);
	}
	
	return {
		
		findByCampeonato : _findByCampeonato,
		
		findOne : _findOne,
		
		save : _save,
		
		delete : _delete
		
	}
	
}]);