app.controller('CampeonatoFormController', ['CampeonatoService', function(CampeonatoService) {

	var self = this;
	
	self.save = function(campeonato) {
		//campeonato.status = "EDICAO"; 
		//campeonato.id = 0; 
		console.log(campeonato);
		CampeonatoService.save(campeonato).then(function(resp) {
			self.campeonato = resp.data;
			alert("Gravado com sucesso!");
		}, function(error) {
			alert(error.data);
		});
	}
	
}]);
