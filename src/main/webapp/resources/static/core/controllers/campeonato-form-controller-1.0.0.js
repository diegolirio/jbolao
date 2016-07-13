app.controller('CampeonatoFormController', ['$location', '$routeParams', 'CampeonatoService', 
                                            function($location, $routeParams, CampeonatoService) {

	var self = this;

	self.init = function() {
		if($routeParams.id > 0) {
			CampeonatoService.findOne($routeParams.id).then(function(resp) {
				self.campeonato = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}
		self.previousPage = '#'+$location.search().next;
		self.nextPage = $location.search().next;
	}
	
	self.save = function(campeonato) {
		CampeonatoService.save(campeonato).then(function(resp) {
			self.campeonato = resp.data;
			alert("Gravado com sucesso!");
			if($location.search().next)
				$location.url(self.nextPage); 
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
	}
	
	self.deleteCampeonato = function(campeonato) {
		if(campeonato.status != 'EDICAO') {
			alert('Para excluir é preciso que o campeonato esteje com Status Pendente!');
			return;
		}
		CampeonatoService.deleteCampeonato(campeonato).then(function(resp) {
			alert('Excluido com sucesso');
			$location.url('/');
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.init();
	
}]);
