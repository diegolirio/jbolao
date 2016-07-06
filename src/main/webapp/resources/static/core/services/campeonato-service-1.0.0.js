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

	var _delete = function(campeonato) {
		return $http.delete('/jbolao/api/campeonato/delete', campeonato);
	}
	
	return {
		
		findAll : _findAll,
		
		findOne : _findOne,
		
		save : _save,
		
		delete : _delete
		
	}
	
}]);