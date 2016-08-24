/**
 * 
 */
app.controller('UsuarioSessionController', ['$scope', '$location', 'UsuarioSessionService', 
                                            function($scope, $location, UsuarioSessionService) {
	
	var self = this;
	
	self.init = function() {
		
		UsuarioSessionService.getUsuarioSession().then(function(resp) {
			if(resp.data != null && resp.data != undefined && resp.data != "null" && resp.data != "" && resp.data) {
				self.usuarioLogged = resp.data;
				$scope.usuarioLogged = self.usuarioLogged;
			}
		}, function(error) {
			alert(JSON.stringify(error));
		});
		
		UsuarioSessionService.getCampeonatoSession().then(function(resp) {
			$scope.campScope = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
		$scope.nextPage = $location.search().next;		
	}
	
	self.logout = function() {
		UsuarioSessionService.logout().then(function() {
			window.location.href = "/jbolao";
		}, function(error) {
			alert(error.data);
		});
	}	
	
	self.init();
	
}]);