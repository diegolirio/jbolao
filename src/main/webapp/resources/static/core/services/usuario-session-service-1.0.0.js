app.factory('UsuarioSessionService', ['$http', function($http) {
	
	var _getUsuarioSession = function() {
		return $http.get('/jbolao/api/usuariosession/get/usuario');
	}

	var _getCampeonatoSession = function() {
		return $http.get('/jbolao/api/usuariosession/get/campeonato');
	}
	
	var _setCampeonatoSession = function(campeonato) {
		return $http.post('/jbolao/api/usuariosession/set/campeonato', campeonato);
	}
	
	var _login = function(usuario) {
		return $http.post('/jbolao/api/usuariosession/login', usuario);
	}
	
	var _logout = function() {
		return $http.get('/jbolao/api/usuariosession/logout');
	}
	
	return {
			
		getUsuarioSession : _getUsuarioSession,

		getCampeonatoSession : _getCampeonatoSession,
		
		setCampeonatoSession : _setCampeonatoSession,
		
		login : _login, 
		
		logout : _logout
		
	}
	
}]);