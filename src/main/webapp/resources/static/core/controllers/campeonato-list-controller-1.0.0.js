/**
 * 
 */
app.controller('CampeonatoListController', ['CampeonatoService', function(CampeonatoService) {

	var self = this;
	
	self.init = function() {
		CampeonatoService.findAll().then(function(resp) {
			self.campeonatos = resp.data;  
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.deleteCampeonato = function(campeonato) {
		console.log(JSON.stringify(campeonato));
		CampeonatoService.delete(campeonato).then(function() {
			var index = self.campeonatos.indexOf(campeonato);
			self.campeonatos.splice(index, 1);
			alert('Excluido com sucesso');
		}, function(error) {
			alert(JSON.stringify(error));
		});
	}
	
	self.init();
	
}]);
