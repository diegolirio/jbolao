app.factory('UsuarioSessionService', ['$http', function($http) {
	
	var _getUsuarioSession = function() {
		return $http.get('/jbolao/api/usuariosession/get/usuario');
	}

	var _getCampeonatoSession = function() {
		return $http.get('/jbolao/api/usuariosession/get/campeonato');
	}
	
	var _setCampeonatoSession = function(campeonato) {
		//return $http.post('/jbolao/api/usuariosession/set/campeonato', campeonato);
		return $http.post('/jbolao/api/usuariosession/set/campeonato/'+campeonato.id);
	}
	
	var _login = function(usuario) {
		return $http.post('/jbolao/api/usuariosession/login', usuario);
	}
	
	var _logout = function() {
		return $http.get('/jbolao/api/usuariosession/logout');
	}
	
	var _isUsuarioAdmin = function(usuario) {
		if(usuario.id == 1) 
			return true;
		return false;
	}
	
	var _isUsuarioAdminOrUsuarioPresidente = function(usuario, campeonato) {
		if(usuario.id == 1 || usuario.id == campeonato.presidente.id) 
			return true;
		return false;
	}
	
	return {
			
		getUsuarioSession : _getUsuarioSession,

		getCampeonatoSession : _getCampeonatoSession,
		
		setCampeonatoSession : _setCampeonatoSession,
		
		login : _login, 
		
		logout : _logout
		
	}
	
}]);