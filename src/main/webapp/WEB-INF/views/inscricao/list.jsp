<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="InscricaoListController as ilCtrl">
	
	  <h1>
	  	{{ilCtrl.campeonato.nome}} 
	  	<small class="mui--text-subhead">( {{ilCtrl.campeonato.descricao}} )</small>
	  	
<!-- 	  	<button class="mui-btn mui-btn--small mui-btn--danger"  -->
<!-- 	  			ng-click="jCtrl.iniciar(jCtrl.campeonato)" -->
<!-- 	  			ng-show="jCtrl.campeonato.status == 'EDICAO'">Iniciar</button> -->
<!-- 	  	<button class="mui-btn mui-btn--small mui-btn--danger"  -->
<!-- 	  			ng-click="jCtrl.voltarPendente(jCtrl.campeonato)" -->
<!-- 	  			ng-show="jCtrl.campeonato.status == 'EM_ANDAMENTO'">Voltar para Pendente</button> -->
	  </h1>
	  <hr/>	
	  
	  <div class="mui-col-md-8">
		  <h3>
		  	Participantes
		  	<a href="#/inscricao/0/campeonato/{{ilCtrl.campeonato.id}}" class="mui-btn mui-btn--small mui-btn--primary mui-btn--fab">+</a>
		  </h3>
	  </div>
<!-- 	  <div class="mui-col-md-4 mui--text-right"> -->
<!--   	  	  <a href="#/participantes/por/campeonato/{{jCtrl.campeonato.id}}" class="mui-btn mui-btn--small">Participantes</a> -->
<!-- 	  </div>		 -->
	  <br/>	
	  
	  <div class="mui-panel mui-col-md-12 ">
		<span class="mui-col-md-1 mui--text-title mui--text-center">Col.</span> 
		<span class="mui-col-md-4 mui--text-title ">Participante</span> 
	  </div>	
	  <a href="#/inscricao/{{i.id}}/campeonato/{{ilCtrl.campeonato.id}}" ng-repeat="i in ilCtrl.inscricoes">	
		  <div class="mui-panel mui-col-md-12">  
			<span class="mui-col-md-1 mui--text-headline mui--text-center">{{ i.colocacao > 0 ? i.colocacao : $index+1}}º</span> 
			<span class="mui-col-md-4 mui--text-headline ">{{i.participante.nome}}</span> 
		  </div>	
	  </a>	
	  
</div>
