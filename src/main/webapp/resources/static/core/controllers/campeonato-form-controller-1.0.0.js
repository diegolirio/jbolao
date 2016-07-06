app.controller('CampeonatoFormController', ['$routeParams', 'CampeonatoService', 
                                            function($routeParams, CampeonatoService) {

	var self = this;

	self.init = function() {
		if($routeParams.id > 0) {
			CampeonatoService.findOne($routeParams.id).then(function(resp) {
				self.campeonato = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}
	}
	
	self.save = function(campeonato) {
		CampeonatoService.save(campeonato).then(function(resp) {
			self.campeonato = resp.data;
			alert("Gravado com sucesso!");
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
	}
	
	self.init();
	
}]);
