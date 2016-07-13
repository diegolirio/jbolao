app.factory('CampeonatoService', ['$http', function($http) {
	
	var _findAll = function() {
		return $http.get('/jbolao/api/campeonato/findall');
	}	
	
	var _findOne = function(id) {
		return $http.get('/jbolao/api/campeonato/findone/'+id);
	}
	
	var _save = function(campeonato) {
		return $http.post('/jbolao/api/campeonato/save', campeonato);
	}	
	
	var _start = function(campeonato) {
		return $http.put('/jbolao/api/campeonato/start', campeonato);
	}
	
	var _backToModeEdit = function(campeonato) {
		return $http.put('/jbolao/api/campeonato/backtomodeedit', campeonato);
	}
	
	var _deleteCampeonato = function(campeonato) {
		return $http.delete('/jbolao/api/campeonato/delete/'+campeonato.id);
	}

	return {
		
		findAll : _findAll,
		
		findOne : _findOne,
		
		save : _save,
		
		iniciar : _start,

		voltarPendente : _backToModeEdit,

		deleteCampeonato : _deleteCampeonato
		
		
	}
	
}]);