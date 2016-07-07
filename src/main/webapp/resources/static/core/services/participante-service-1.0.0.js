app.factory('ParticipanteService', ['$http', function($http) {
	
	var _findOne = function(id) {
		return $http.get('/jbolao/api/participante/findone/'+id);
	}

	var _findAll = function() {
		return $http.get('/jbolao/api/participante/findall');
	}
	
	var _save = function(participante) {
		console.log(participante);
		return $http.post('/jbolao/api/participante/save', participante);
	}	
 
	var _delete = function(participante) {
		return $http.delete('/jbolao/api/participante/delete', participante);
	}
	
	return {
				
		findOne : _findOne,
		
		findAll : _findAll,
		
		save : _save,

		delete : _delete
		
	}
	
}]);