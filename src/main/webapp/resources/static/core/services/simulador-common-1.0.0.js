/**
 * 
 */
app.factory('SimuladorCommon', function() {
	
	
	var _acertouPlacar = function(aposta, jogo) {
		if(aposta.resultadoA == jogo.resultadoA && 
		   aposta.resultadoB == jogo.resultadoB) 
			return true;
		return false;
	}
	
	var _acertouVencedorUmResultado = function(aposta, jogo) {
		if((aposta.resultadoA == jogo.resultadoA || 
			aposta.resultadoB == jogo.resultadoB) &&
		   aposta.vencedor == jogo.vencedor)
			return true;
		return false;
	}	
		
	var _acertouVencedor = function(aposta, jogo) {
		if(aposta.resultadoA != jogo.resultadoA && 
		   aposta.resultadoB != jogo.resultadoB &&
		   aposta.vencedor == jogo.vencedor)
			return true;
		return false;
	}	
	
	var _acertouSomenteUmResultado = function(aposta, jogo) {
		if((aposta.resultadoA == jogo.resultadoA || 
		    aposta.resultadoB == jogo.resultadoB) &&
		   aposta.vencedor != jogo.vencedor)
			return true;
		return false;
	}	
	
	return {
		
		acertouPlacar : _acertouPlacar,
		
		acertouVencedorUmResultado : _acertouVencedorUmResultado,

		acertouVencedor : _acertouVencedor,
		
		acertouSomenteUmResultado : _acertouSomenteUmResultado
		
	}
	
});