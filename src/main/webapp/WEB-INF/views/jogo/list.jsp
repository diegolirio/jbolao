<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="JogoListController as jCtrl">
	  <h1>
	  	{{jCtrl.campeonato.nome}} 
	  	<small class="mui--text-subhead">( {{jCtrl.campeonato.descricao}} )</small>
	  	<button class="mui-btn mui-btn--small mui-btn--danger" 
	  			ng-click="jCtrl.iniciar(jCtrl.campeonato)"
	  			ng-show="jCtrl.campeonato.status == 'EDICAO'">Iniciar</button>
	  	<button class="mui-btn mui-btn--small mui-btn--danger" 
	  			ng-click="jCtrl.voltarPendente(jCtrl.campeonato)"
	  			ng-show="jCtrl.campeonato.status == 'EM_ANDAMENTO'">Voltar para Pendente</button>
	  </h1>
	  
	  <h3 class="mui--text-right">
	  	Jogos
	  	<a href="#/jogo/0/campeonato/{{jCtrl.campeonato.id}}" class="mui-btn mui-btn--small mui-btn--primary mui-btn--fab">+</a>
	  </h3>
		
	  <a href="#/jogo/{{j.id}}/campeonato/{{jCtrl.campeonato.id}}" ng-repeat="j in jCtrl.jogos">	
		  <div class="mui-panel mui-col-md-6 mui--text-center">
			<span class="mui-col-md-4 mui--text-headline ">{{j.timeA}}</span> 
			<span class="mui-col-md-1" ng-hide="j.status == 'EDICAO'">{{j.resultadoA}}</span> 
			<span class="mui-col-md-1">X</span> 
			<span class="mui-col-md-1" ng-hide="j.status == 'EDICAO'">{{j.resultadoB}}</span> 
			<span class="mui-col-md-4 mui--text-headline">{{j.timeB}}</span>
		  </div>	
	  </a>	
	  
</div>
