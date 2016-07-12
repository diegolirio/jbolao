<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="ApostaListController as alCtrl">
	
	  <h1>
	  	{{alCtrl.inscricao.campeonato.descricao}} 
	  	<small class="mui--text-subhead">( {{alCtrl.inscricao.campeonato.nome}} )</small>
	  </h1>
	  <hr/>	
	  
	  <div class="mui-col-md-8">
		  <h3>
		  	Aposta - {{alCtrl.inscricao.participante.nome}}
		  </h3>
	  </div>
	  <div class="mui-col-md-4 mui--text-right">
  	  	  <a href="#/classificacao/{{alCtrl.inscricao.campeonato.id}}" class="mui-btn mui-btn--small">Classificação</a>
	  </div>		
	  <br/>	

	  <div class="mui-panel mui-col-md-12 mui--text-center">
		<div class="mui-row">
			<span class="mui-col-md-9 mui--text-title ">Jogo</span> 
			<span class="mui-col-md-3 mui--text-title">Aposta</span>
		</div>		
	  </div>	  
	  	
	  <div class="mui-panel mui-col-md-12 mui--text-center" ng-repeat="a in alCtrl.apostas">
		<div class="mui-row">
			<span class="mui-col-md-1 mui--text-subhead mui--text-center mui--text-danger mui--text-center">#{{ a.jogo.rodada }}</span>
			<span class="mui-col-md-2 mui--text-headline ">{{a.jogo.timeA}}</span> 
			<span class="mui-col-md-1"><span ng-hide="a.jogo.status == 'EDICAO'">{{a.jogo.resultadoA}}</span></span> 
			<span class="mui-col-md-1">X</span>  
			<span class="mui-col-md-1"><span ng-hide="a.jogo.status == 'EDICAO'">{{a.jogo.resultadoB}}</span></span> 
			<span class="mui-col-md-2 mui--text-headline">{{a.jogo.timeB}}</span>
			<span class="mui-col-md-3 mui--text-headline">
				<a href="#/aposta/edit/{{a.id}}" ng-show="usuarioLogged && a.jogo.status == 'EDICAO'">{{a.resultadoA}} X {{a.resultadoB}}</a>
				<span ng-show="!usuarioLogged && alCtrl.inscricao.campeonato.alteraApostaAntesJogo == false || a.jogo.status != 'EDICAO'">{{a.resultadoA}} X {{a.resultadoB}}</span>
				<span class="mui--text-subhead mui--text-center mui--text-accent mui--text-center">+{{ a.pontos }}</span>
			</span>
		</div>
	  </div>	
</div>
