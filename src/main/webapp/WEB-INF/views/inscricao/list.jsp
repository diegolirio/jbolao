<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="InscricaoListController as ilCtrl">
	
	  <h1>
	  	{{ilCtrl.campeonato.nome}} 
	  	<small class="mui--text-subhead">( {{ilCtrl.campeonato.descricao}} )</small>
	  </h1>
	  <hr/>	
	  
	  <div class="mui-col-md-8">
		  <h3>
		  	Participantes
		  	<a ng-show="usuarioLogged" href="#/inscricao/0/campeonato/{{ilCtrl.campeonato.id}}?next={{ilCtrl.location.url()}}" class="mui-btn mui-btn--small mui-btn--primary mui-btn--fab">+</a>
		  </h3>
	  </div>
	  
	  <div class="mui-col-md-4 mui--text-right">
  	  	  <a href="#/jogos/{{ilCtrl.campeonato.id}}" class="mui-btn mui-btn--small">Jogos <small>(Tabela)</small></a>
  	  	  <a href="#/simulacao/{{ilCtrl.campeonato.id}}" class="mui-btn mui-btn--small">Simulação</a>
	  </div>		
	  
	  <br/>	
	  
	  <div class="mui-panel mui-col-md-12 ">
		<span class="mui-col-md-1 mui--text-title mui--text-center">Col.</span> 
		<span class="mui-col-md-3 mui--text-title ">Participante</span> 
		<span class="mui-col-md-1 mui--text-title mui--text-center">Pontos</span> 
		<span class="mui-col-md-1 mui--text-title mui--text-center">J</span> 
		<span class="mui-col-md-1 mui--text-caption mui--text-center">AP8</span> 
		<span class="mui-col-md-1 mui--text-caption mui--text-center">AR5</span> 
		<span class="mui-col-md-1 mui--text-caption mui--text-center">AV3</span> 
		<span class="mui-col-md-1 mui--text-caption mui--text-center">AS1</span> 
		<span class="mui-col-md-1 mui--text-caption mui--text-center">ER0</span> 
		<span class="mui-col-md-1 mui--text-caption mui--text-center">%</span> 
	  </div>	
	  <a href="#/aposta/{{i.id}}" ng-repeat="i in ilCtrl.inscricoes">	
		  <div class="mui-panel mui-col-md-12">  
			<span class="mui-col-md-1 mui--text-headline mui--text-center">{{ i.colocacao > 0 ? i.colocacao : $index+1}}º</span> 
			<span class="mui-col-md-3 mui--text-title ">{{i.participante.nome}}</span> 
			<span class="mui-col-md-1 mui--text-headline mui--text-center">{{ i.pontos }}</span> 
			<span class="mui-col-md-1 mui--text-headline mui--text-center">{{ ilCtrl.countJogos }}</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoPlacar }}</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoVencedorUmResultado }}</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoVencedor }}</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoSomenteUmResultado }}</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.errouTudo }}</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ ilCtrl.calcPercent(i) }}%</span> 
		  </div>	
	  </a>	
	  
</div>
