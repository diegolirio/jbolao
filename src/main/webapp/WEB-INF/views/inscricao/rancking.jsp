<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="InscricaoRanckingController as irCtrl">
	
	<div ng-show="irCtrl.filter == 'CLEAR' || !irCtrl.filter">
		
			  <h1>
			  	{{irCtrl.campeonato.nome}} 
			  	<small class="mui--text-subhead" title="{{irCtrl.campeonato.status}}">( {{irCtrl.campeonato.descricao}} )</small>
			  	
			  	<button class="mui-btn mui-btn--small mui-btn--danger" 
			  			ng-click="irCtrl.iniciar(irCtrl.campeonato)"
			  			ng-show="(usuarioLogged.id == 1 || usuarioLogged.id == irCtrl.campeonato.presidente.id) && irCtrl.campeonato.status == 'EDICAO'">
			  		Iniciar
			  	</button>
			  	
			  	<button class="mui-btn mui-btn--small mui-btn--danger" 
			  			ng-click="irCtrl.voltarPendente(irCtrl.campeonato)"
			  			ng-show="(usuarioLogged.id == 1 || usuarioLogged.id == irCtrl.campeonato.presidente.id) && (irCtrl.campeonato.status == 'EM_ANDAMENTO' || irCtrl.campeonato.status == 'CALCULANDO')">Voltar para Pendente</button>			  	
			  	
			  	<button class="mui-btn mui-btn--small" 
			  			ng-click="irCtrl.sendEmailApostasForParticipantes(irCtrl.campeonato)"
			  			ng-show="(usuarioLogged.id == 1 || usuarioLogged.id == irCtrl.campeonato.presidente.id) && (irCtrl.campeonato.status == 'EDICAO' || irCtrl.campeonato.alteraApostaAntesJogo == true)">
			  				Enviar Formulário de Apostas para Participantes
			  	</button>			  	
			  	<button class="mui-btn mui-btn--small" 
			  			ng-click="irCtrl.sendEmailRancking(irCtrl.campeonato)"
			  			ng-show="(usuarioLogged.id == 1 || usuarioLogged.id == irCtrl.campeonato.presidente.id) && (irCtrl.campeonato.status == 'EM_ANDAMENTO')">
			  				Enviar Email do Rancking
			  	</button>			  	
			  </h1>
			  <hr/>	
			  
			  <div class="mui-row">
				  
				  <div class="mui-col-xs-12 mui-col-md-7">
					  <h3 class="mui--text-danger">
					  	Classificação
					  	<a ng-show="(usuarioLogged.id == 1 || usuarioLogged.id == irCtrl.campeonato.presidente.id)" href="#/inscricao/0/campeonato/{{irCtrl.campeonato.id}}?next={{irCtrl.location.url()}}" class="mui-btn mui-btn--small mui-btn--primary mui-btn--fab">+</a>
					  </h3>
				  </div>
				  
				  <div class="mui-col-xs-12 mui-col-md-5">
			  	  	  <a href="#/jogos/{{irCtrl.campeonato.id}}" class="mui-btn mui-btn--small">Jogos <small>(Tabela)</small></a>
			  	  	  <a ng-click="irCtrl.setFilter('FILTER')" ng-show="irCtrl.campeonato.status != 'EDICAO'" class="mui-btn mui-btn--small">Filtro </a>
			  	  	  <a href="#/simulacao/{{irCtrl.campeonato.id}}" ng-show="irCtrl.campeonato.status != 'EDICAO'" class="mui-btn mui-btn--small">Simulação</a>
				  </div>		
			  </div>
			  <br/>	
			  <div class="mui-row">
				  
				  <div class="mui-panel mui-col-xs-12 mui-col-md-12">
					<span class="mui-col-xs-2 mui-col-md-1 mui--text-title mui--text-center">Col.</span> 
					<span class="mui-col-xs-7 mui-col-md-3 mui--text-title mui--text-center">Participante</span> 
	<!-- 				<span class="mui-col-md-1 mui--text-caption mui--text-center" title="Inscrição">Insc.</span>  -->
					<span class="mui-col-xs-3 mui-col-md-1 mui--text-title mui--text-center">Pontos</span> 
					<span class="mui-col-md-1 mui--text-title mui--text-center mui--hidden-xs" title="Quantidade de Jogos Realizados">J</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs" title="Acertou o Placar (+8)">AP</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs" title="Acertou o Vencedor e o Resultado de um Time (+5)">AR</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs" title="Acertou o Vencedor (+4)">AV</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs" title="Acertou Somente o Resultado de um Time (+1)">AS</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs" title="Errou Tudo (+0)">ER</span> 
					<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs" title="% de Aproveitamento">%</span> 
				  </div>	
				  <a href="#/aposta/{{i.id}}" ng-repeat="i in irCtrl.inscricoes" title="{{i.participante.nome}} - Inscrição: {{i.id}}">	
					  <div class="mui-panel mui-col-md-12">  
						<span class="mui-col-xs-2 mui-col-md-1 mui--text-subhead mui--text-center"><b>{{ i.colocacao > 0 ? i.colocacao : $index+1}}º</b></span> 
						<span class="mui-col-xs-7 mui-col-md-3 mui--text-title ">
							<img src="/jbolao/resources/static/img/user_xxx.jpg" height="35"/> &nbsp; {{i.participante.nome}}
						</span>  
	<!-- 					<span class="mui-col-md-1 mui--text-caption mui--text-center mui--text-dark">{{ i.id }}</span>  -->
						<span class="mui-col-xs-3 mui-col-md-1 mui--text-headline mui--text-center"><b>{{ i.pontos }}</b></span> 
						<span class="mui-col-md-1 mui--text-subhead mui--text-center mui--hidden-xs">{{ irCtrl.countJogos }}</span> 
						<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs">{{ i.acertoPlacar }}</span> 
						<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs">{{ i.acertoVencedorUmResultado }}</span> 
						<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs">{{ i.acertoVencedor }}</span> 
						<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs">{{ i.acertoSomenteUmResultado }}</span> 
						<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs">{{ i.errouTudo }}</span> 
						<span class="mui-col-md-1 mui--text-caption mui--text-center mui--hidden-xs">{{ irCtrl.calcPercent(i) | number:1 }}%</span> 
					  </div>	
				  </a>
		      </div>	
	</div>
	
	<div ng-show="irCtrl.filter == 'FILTER'">
		  <div class="mui-panel mui-col-md-12 ">
		  	 <button class="mui-btn" ng-click="irCtrl.setFilter('CLEAR')">Voltar</button> 
			 <a ng-click="irCtrl.filter('CLEAR')" class="mui-btn mui-btn--small">Limpar Filtro </a>
		  </div>	
		   
		  <div class="mui-panel mui-col-md-12 ">
			  <div class="mui-textfield mui-col-md-12 " >
			 	<h4>Rodadas</h4>
			    <button class="mui-btn {{ irCtrl.rodadasSelecionadas.indexOf(rodada) > -1 ? 'mui-btn--accent' : 'mui-btn--primary' }}" 
			    		ng-repeat="rodada in irCtrl.rodadas" 
			    		ng-click="irCtrl.selecionarRodada(rodada)">{{rodada}}</button>
			  </div>		  	  
			  <div class="mui-textfield mui-col-md-12 mui--text-right" > 
				  <button class="mui-btn mui-btn--danger " ng-click="irCtrl.executaFiltro(irCtrl.rodadasSelecionadas)">Concluir</button>
			  </div> 
		  </div>		  
	
	</div>
	
	<div ng-show="irCtrl.filter == 'RANCKING_FILTER'">
		  <div class="mui-panel mui-col-md-12 ">
			 <h1>Rancking Filtro</h1>
			 <div class="mui--text-right">
			 	<a ng-click="irCtrl.setFilter('FILTER')" class="mui-btn mui-btn--small">Filtro </a>
			 	<a ng-click="irCtrl.setFilter('CLEAR')" class="mui-btn mui-btn--small">Limpar Filtro </a>
			 </div> 
		  </div>	
		  	
		  <div class="mui-panel mui-col-md-12 "> 
			<span class="mui-col-md-1 mui--text-title mui--text-center">Col.</span> 
			<span class="mui-col-md-5 mui--text-title ">Participante</span> 
			<span class="mui-col-md-1 mui--text-title mui--text-center">Pontos</span> 
<!-- 			<span class="mui-col-md-1 mui--text-title mui--text-center" title="Quantidade de Jogos Realizados">J</span>  -->
			<span class="mui-col-md-1 mui--text-caption mui--text-center" title="Acertou o Placar (+8)">AP</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center" title="Acertou o Vencedor e o Resultado de um Time (+5)">AR</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center" title="Acertou o Vencedor (+4)">AV</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center" title="Acertou Somente o Resultado de um Time (+1)">AS</span> 
			<span class="mui-col-md-1 mui--text-caption mui--text-center" title="Errou Tudo (+0)">ER</span> 
<!-- 			<span class="mui-col-md-1 mui--text-caption mui--text-center" title="% de Aproveitamento">%</span>  -->
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
