app.factory('CampeonatoService', ['$http', function($http) {
	
	var _save = function(campeonato) {
		return $http.post('/jbolao/campeonato/save', campeonato);
	}
	
	
	return {
		
		save : _save
		
	}
	
}]);