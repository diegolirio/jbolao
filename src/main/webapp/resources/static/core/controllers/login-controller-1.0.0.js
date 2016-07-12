app.controller('LoginController', ['$routeParams', '$location', '$window', 'UsuarioSessionService', 
                                   function($routeParams, $location, $window, UsuarioSessionService) {

	var self = this;

	self.init = function() {
		
	}
	
	self.login = function(usuario) {
		UsuarioSessionService.login(usuario).then(function(resp) {
			self.usuario = resp.data;
			//$location.url("/");
			window.location.href = "/jbolao";
		}, function(error) {
			//if(error.status == 401)
				alert("Usuario ou senha incorreto");
				self.usuario.senha = "";
			//else 
			//	alert(JSON.stringify(error.data));
		});
	}	
		
	self.init();
	
}]);
