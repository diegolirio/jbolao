<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="ApostasJogoController as ajCtrl">
	
	  <h1>
	  	{{ajCtrl.jogo.campeonato.descricao}} 
	  	<small class="mui--text-subhead">( {{ajCtrl.jogo.campeonato.nome}} )</small>
	  </h1>
	  <hr/>	 

	  <div class="mui-row mui--text-right">
  	  	  <a href="#/jogos/{{ajCtrl.jogo.campeonato.id}}" class="mui-btn mui-btn--small">Jogos</a>
		  <a ng-show="(usuarioLogged.id == 1 || usuarioLogged.id == ajCtrl.jogo.campeonato.presidente.id)" 
			   ng-href="#/jogo/{{ajCtrl.jogo.id}}/campeonato/{{ajCtrl.jogo.campeonato.id}}?next=/apostas_por_jogo/{{ajCtrl.jogo.campeonato.id}}" 
			   class="mui-btn mui-btn--small mui-btn--primary">
				Alterar	
		   </a>  	  	  
	  </div>		
		  
<!-- 	  <div class="mui-row"> -->
<!-- 		  <div class="mui-panel mui-col-md-12 mui--text-center"> -->
<!-- 			<div class="mui-row">  -->
<!-- 				<span class="mui-col-md-4 mui--text-headline ">{{ajCtrl.jogo.timeA}}</span>  -->
<!-- 				<span class="mui-col-md-1" ng-hide="j.status == 'EDICAO'">{{ajCtrl.jogo.resultadoA}}</span>  -->
<!-- 				<span class="mui-col-md-1">X</span>  -->
<!-- 				<span class="mui-col-md-1" ng-hide="j.status == 'EDICAO'">{{ajCtrl.jogo.resultadoB}}</span>  -->
<!-- 				<span class="mui-col-md-4 mui--text-headline">{{ajCtrl.jogo.timeB}}</span> -->
<!-- 			</div> -->
<!-- 		  </div>		   -->
<!-- 	  </div> -->
	  	  
	  <div class="mui-panel mui-col-xs-12 mui-col-md-12 ">
		<span class="mui--hidden-xs mui-col-md-4 mui--text-caption">Participante</span> 
		<span class="mui-col-xs-3 mui-col-md-2 mui--text-title mui--text-center">{{ajCtrl.jogo.timeA}}</span> 
		<span class="mui-col-xs-1 mui-col-md-1 mui--text-title mui--text-center">
			<span ng-hide="ajCtrl.jogo.status == 'EDICAO'">{{ajCtrl.jogo.resultadoA}}</span>
		</span> 
		<span class="mui-col-xs-1 mui-col-md-1 mui--text-caption mui--text-center">X</span> 
		<span class="mui-col-xs-1 mui-col-md-1 mui--text-title mui--text-center">
			<span ng-hide="ajCtrl.jogo.status == 'EDICAO'">{{ajCtrl.jogo.resultadoB}}</span>
		</span> 
		<span class="mui-col-xs-3 mui-col-md-2 mui--text-title mui--text-center">{{ajCtrl.jogo.timeB}}</span> 
	  </div>	
	  
	  <div class="mui-panel mui-col-md-12" ng-repeat="a in ajCtrl.apostas">  
		<span class="mui-col-md-6 mui--text-title">
			{{a.inscricao.participante.nome}}
			<span class="mui--text-subhead mui--text-center mui--text-accent" ng-show="a.jogo.status != 'EDICAO'">+{{ a.pontos }}</span>
		</span> 
		<span class="mui-col-md-1 mui--text-title mui--text-center mui--text-danger">{{ a.jogo.campeonato.status != 'EDICAO' ? a.resultadoA : '' }}</span> 
		<span class="mui-col-md-1 mui--text-caption mui--text-center">X</span> 
		<span class="mui-col-md-1 mui--text-title mui--text-center mui--text-danger">{{ a.jogo.campeonato.status != 'EDICAO' ? a.resultadoB : '' }}</span> 
	  </div>	
	  	
</div>
