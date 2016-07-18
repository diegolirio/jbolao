app.factory('CampeonatoService', ['$http', '$location', function($http, $location) {
	
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
	
	var _sendEmailRancking = function(campeonato) {
		var serverURL = 'http://'+$location.host();
		if($location.port() > 0) 
			serverURL += (':'+$location.port());
		return $http.put('/jbolao/api/campeonato/sendmailrancking/'+campeonato.id+'?serverURL='+serverURL);
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
	
		sendEmailRancking : _sendEmailRancking,
		
		deleteCampeonato : _deleteCampeonato
		
		
	}
	
}]);