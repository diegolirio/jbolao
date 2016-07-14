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
 
	var _finalizeEdicaoAposta = function(inscricao) {
		return $http.put('/jbolao/api/inscricao/finalizeedicaoaposta/'+inscricao.id);
	}	
	
	var _sendEmailApostasForParticipantes = function(campeonato) {
		return $http.post('/jbolao/api/inscricao/sendemailapostasforparticipantes/'+campeonato.id);
	}
	
	var _findByIdAndCodigoEdicaoApostas = function(id, codigoEdicaoApostas) {
		return $http.get('/jbolao/api/inscricao/findbyidandcodigoedicaoapostas/'+id+'/'+codigoEdicaoApostas);
	}
	
	var _deleteInscricao = function(inscricao) {
		return $http.delete('/jbolao/api/inscricao/delete/'+inscricao.id);
	}
	
	return {
		
		findByCampeonato : _findByCampeonato,
		
		findByParticipante : _findByParticipante,
		
		findOne : _findOne,
		
		save : _save,

		finalizeEdicaoAposta : _finalizeEdicaoAposta,

		sendEmailApostasForParticipantes : _sendEmailApostasForParticipantes,		
	
		findByIdAndCodigoEdicaoApostas : _findByIdAndCodigoEdicaoApostas,
		
		deleteInscricao : _deleteInscricao
		
	}
	
}]);