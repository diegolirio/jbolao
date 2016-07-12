<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="JogoListController as jCtrl">
	
	  <h1>
	  	{{jCtrl.campeonato.nome}} 
	  	<small class="mui--text-subhead">( {{jCtrl.campeonato.descricao}} )</small>
	  	<button class="mui-btn mui-btn--small mui-btn--danger" 
	  			ng-click="jCtrl.iniciar(jCtrl.campeonato)"
	  			ng-show="usuarioLogged && jCtrl.campeonato.status == 'EDICAO'">Iniciar</button>
	  	<button class="mui-btn mui-btn--small mui-btn--danger" 
	  			ng-click="jCtrl.voltarPendente(jCtrl.campeonato)"
	  			ng-show="usuarioLogged && jCtrl.campeonato.status == 'EM_ANDAMENTO'">Voltar para Pendente</button>
	  </h1>
	  <hr/>	
	  
	  <div class="mui-row">
		  <div class="mui-col-md-8">
			  <h3>
			  	Jogos
			  	<a ng-href="#/jogo/0/campeonato/{{jCtrl.campeonato.id}}"
			  	   ng-show="usuarioLogged" 
			  	   class="mui-btn mui-btn--small mui-btn--primary mui-btn--fab">+</a>
			  </h3>
		  </div>
		  <div class="mui-col-md-4 mui--text-right">
	  	  	  <a href="#/classificacao/{{jCtrl.campeonato.id}}" class="mui-btn mui-btn--small">Classificação</a>
		  </div>		
	  </div>	
	  
	  <div class="mui-row">
<!-- 		  <a href="#/jogo/{{j.id}}/campeonato/{{jCtrl.campeonato.id}}" ng-repeat="j in jCtrl.jogos">	 -->
		  <a href="#/apostas_por_jogo/{{j.id}}" ng-repeat="j in jCtrl.jogos">
			  <div class="mui-panel mui-col-md-6 mui--text-center">
				<div class="mui-row">
					<span class="mui-col-md-4 mui--text-headline ">{{j.timeA}}</span> 
					<span class="mui-col-md-1"><span ng-hide="j.status == 'EDICAO'">{{j.resultadoA}}</span></span> 
					<span class="mui-col-md-1">X</span> 
					<span class="mui-col-md-1"><span ng-hide="j.status == 'EDICAO'">{{j.resultadoB}}</span></span> 
					<span class="mui-col-md-4 mui--text-headline">{{j.timeB}}</span>
				</div>
				<br/>
				<div class="mui-row">
			  		<span class="mui--text-caption">
			  			Rodada: {{j.rodada}} | {{jCtrl.getStatusDescription(j.status)}}
			  		</span>
			    </div>
				
			  </div>	
		  </a>	
	  </div>

	  <div class="mui-row">
	  	<h4 ng-show="!jCtrl.jogos.length">Não há jogos cadastrados</h4>
	  </div>

</div>
