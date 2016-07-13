app.factory('InscricaoService', ['$http', function($http) {
	
	var _findByCampeonato = function(campeonato) {
		return $http.get('/jbolao/api/inscricao/findbycampeonato/'+campeonato.id);//, campeonato);
	}	

	var _findByParticipante = function(participante) {
		return $http.get('/jbolao/api/inscricao/findbyparticipante/'+participante.id);
	}	
	
	var _findOne = function(id) {
		return $http.get('/jbolao/api/inscricao/findone/'+id);
	}
	
	var _save = function(inscricao) {
		return $http.post('/jbolao/api/inscricao/save', inscricao);
	}	
 
	var _deleteInscricao = function(inscricao) {
		return $http.delete('/jbolao/api/inscricao/delete/'+inscricao.id);
	}
	
	return {
		
		findByCampeonato : _findByCampeonato,
		
		findByParticipante : _findByParticipante,
		
		findOne : _findOne,
		
		save : _save,

		deleteInscricao : _deleteInscricao
		
	}
	
}]);