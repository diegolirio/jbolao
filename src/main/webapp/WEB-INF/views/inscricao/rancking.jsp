<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="InscricaoRanckingController as irCtrl">
	
	<div ng-show="irCtrl.filter == 'CLEAR' || !irCtrl.filter">
			
			  <h1>
			  	{{irCtrl.campeonato.nome}} 
			  	<small class="mui--text-subhead">( {{irCtrl.campeonato.descricao}} )</small>
			  </h1>
			  <hr/>	
			  
			  <div class="mui-col-md-7">
				  <h3 class="mui--text-danger">
				  	Classificação
				  	<a ng-show="usuarioLogged" href="#/inscricao/0/campeonato/{{irCtrl.campeonato.id}}?next={{irCtrl.location.url()}}" class="mui-btn mui-btn--small mui-btn--primary mui-btn--fab">+</a>
				  </h3>
			  </div>
			  
			  <div class="mui-col-md-5 mui--text-right">
		  	  	  <a href="#/jogos/{{irCtrl.campeonato.id}}" class="mui-btn mui-btn--small">Jogos <small>(Tabela)</small></a>
		  	  	  <a ng-click="irCtrl.filter = 'FILTER'" class="mui-btn mui-btn--small">Filtro </a>
		  	  	  <a href="#/simulacao/{{irCtrl.campeonato.id}}" class="mui-btn mui-btn--small">Simulação</a>
			  </div>		
			  
			  <br/>	
			  
			  <div class="mui-panel mui-col-md-12 ">
				<span class="mui-col-md-1 mui--text-title mui--text-center">Col.</span> 
				<span class="mui-col-md-3 mui--text-title ">Participante</span> 
				<span class="mui-col-md-1 mui--text-title mui--text-center">Pontos</span> 
				<span class="mui-col-md-1 mui--text-title mui--text-center">J</span> 
				<span class="mui-col-md-1 mui--text-caption mui--text-center">AP</span> 
				<span class="mui-col-md-1 mui--text-caption mui--text-center">AR</span> 
				<span class="mui-col-md-1 mui--text-caption mui--text-center">AV</span> 
				<span class="mui-col-md-1 mui--text-caption mui--text-center">AS</span> 
				<span class="mui-col-md-1 mui--text-caption mui--text-center">ER</span> 
				<span class="mui-col-md-1 mui--text-caption mui--text-center">%</span> 
			  </div>	
			  <a href="#/aposta/{{i.id}}" ng-repeat="i in irCtrl.inscricoes">	
				  <div class="mui-panel mui-col-md-12">  
					<span class="mui-col-md-1 mui--text-headline mui--text-center">{{ i.colocacao > 0 ? i.colocacao : $index+1}}º</span> 
					<span class="mui-col-md-3 mui--text-title ">{{i.participante.nome}}</span> 
					<span class="mui-col-md-1 mui--text-headline mui--text-center">{{ i.pontos }}</span> 
					<span class="mui-col-md-1 mui--text-headline mui--text-center">{{ irCtrl.countJogos }}</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoPlacar }}</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoVencedorUmResultado }}</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoVencedor }}</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoSomenteUmResultado }}</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.errouTudo }}</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ irCtrl.calcPercent(i) | number:1 }}%</span> 
				  </div>	
			  </a>	
	</div>
	<div ng-show="irCtrl.filter == 'FILTER'">
		  <div class="mui-panel mui-col-md-12 ">
			 <button class="mui-btn" ng-click="irCtrl.filter = 'CLEAR'">Voltar</button> 
			 <a ng-click="irCtrl.filter = 'CLEAR'" class="mui-btn mui-btn--small">Limpar Filtro </a>
		  </div>	
		  
		  <div class="mui-panel mui-col-md-12 ">
			  <div class="mui-textfield mui-textfield--float-label">
			    <input ng-model="irCtrl.filtro.rodada">
			    <label>Rodada</label>
			  </div>		  	 
			  <button class="mui-btn" ng-click="irCtrl.executaFiltro(irCtrl.filtro)">Concluir</button> 
		  </div>		  
	
	</div>
	<div ng-show="irCtrl.filter == 'RANCKING_FILTER'">
		  <div class="mui-panel mui-col-md-12 ">
			 <h1>Rancking Filtro</h1>
			 <div class="mui--text-right">
			 	<a ng-click="irCtrl.filter = 'FILTER'" class="mui-btn mui-btn--small">Filtro </a>
			 	<a ng-click="irCtrl.filter = 'CLEAR'" class="mui-btn mui-btn--small">Limpar Filtro </a>
			 </div> 
		  </div>	
		  	
		  <div class="mui-panel mui-col-md-12 "> 
			<span class="mui-col-md-1 mui--text-title mui--text-center">Col.</span> 
			<span class="mui-col-md-5 mui--text-title ">Participante</span> 
			<span class="mui-col-md-1 mui--text-title mui--text-center">Pontos</span> 
<!-- 			<span class="mui-col-md-1 mui--text-title mui--text-center">J</span>  -->
			<span class="mui-col-md-1 mui--text-caption mui--text-center">AP</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center">AR</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center">AV</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center">AS</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center">ER</span> 
<!-- 			<span class="mui-col-md-1 mui--text-caption mui--text-center">%</span>  -->
		  </div>	
		  <a href="#/aposta/{{i.id}}" ng-repeat="i in irCtrl.inscricoesFilter">	
			  <div class="mui-panel mui-col-md-12">  
				<span class="mui-col-md-1 mui--text-headline mui--text-center">{{ i.colocacao > 0 ? i.colocacao : $index+1}}º</span> 
				<span class="mui-col-md-5 mui--text-title ">{{i.participante.nome}}</span> 
				<span class="mui-col-md-1 mui--text-headline mui--text-center">{{ i.pontos }}</span> 
<!-- 				<span class="mui-col-md-1 mui--text-headline mui--text-center">{{ irCtrl.countJogos }}</span>  -->
				<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoPlacar }}</span> 
				<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoVencedorUmResultado }}</span> 
				<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoVencedor }}</span> 
				<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoSomenteUmResultado }}</span> 
				<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.errouTudo }}</span> 
<!-- 				<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ irCtrl.calcPercent(i) | number:1 }}%</span>  -->
			  </div>	
		  </a>	
	</div>
	  
</div>
