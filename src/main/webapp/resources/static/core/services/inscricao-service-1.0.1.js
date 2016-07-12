app.factory('InscricaoService', ['$http', function($http) {
	
	var _findByCampeonato = function(campeonato) {
		return $http.get('/jbolao/api/inscricao/findbycampeonato/'+campeonato.id);//, campeonato);
	}	
	
	var _findOne = function(id) {
		return $http.get('/jbolao/api/inscricao/findone/'+id);
	}
	
	var _save = function(inscricao) {
		return $http.post('/jbolao/api/inscricao/save', inscricao);
	}	
 
	var _delete = function(inscricao) {
		return $http.delete('/jbolao/api/inscricao/delete', inscricao);
	}
	
	return {
		
		findByCampeonato : _findByCampeonato,
		
		findOne : _findOne,
		
		save : _save,

		delete : _delete
		
	}
	
}]);