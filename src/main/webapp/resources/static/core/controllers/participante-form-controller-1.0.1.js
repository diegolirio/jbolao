app.controller('ParticipanteFormController', ['$routeParams', '$location', 'ParticipanteService',
                                            function($routeParams, $location, ParticipanteService) {

	var self = this;

	self.init = function() {
		if($routeParams.id > 0) {
			ParticipanteService.findOne($routeParams.id).then(function(resp) {
				self.participante = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		} 
		self.next = '#'+$location.search().next; 
	}
	
	self.save = function(participante) {
		ParticipanteService.save(participante).then(function(resp) {
			self.participante = resp.data;
			alert("Gravado com sucesso!"); 
			$location.path($location.search().next+"/"+self.participante.id);
		}, function(error) {
			alert(JSON.stringify(error.data));
		});
	}

	self.init();
	
}]);
