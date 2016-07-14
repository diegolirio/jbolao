<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="ApostaMyEditController as ameCtrl">
	
	  <h1>
	  	{{ameCtrl.inscricao.campeonato.descricao}} 
	  	<small class="mui--text-subhead">( {{ameCtrl.inscricao.campeonato.nome}} )</small>
	  </h1>
	  <hr/>	
	  
	  <div class="mui-col-md-8">
		  <h3>
		  	Aposta: {{ameCtrl.inscricao.participante.nome}} <span class="mui--text-danger">(Página exclusiva do Usuário)</span>
		  </h3>
	  </div>
	  <div class="mui-col-md-4 mui--text-right">
  	  	  <a href="#/classificacao/{{ameCtrl.inscricao.campeonato.id}}" class="mui-btn mui-btn--small">Classificação</a>
	  </div>		
	  <br/>	

	  <div class="mui-panel mui-col-md-12 mui--text-center">
		<div class="mui-row">
			<span class="mui-col-md-9 mui--text-title ">Jogo</span> 
			<span class="mui-col-md-3 mui--text-title">Aposta</span>
		</div>		
	  </div>	  
	  	
	  <div class="mui-panel mui-col-md-12 mui--text-center" ng-repeat="a in ameCtrl.apostas">
		<div class="mui-row">
			<span class="mui-col-md-1 mui--text-caption mui--text-center mui--text-danger mui--text-center" title="Rodada {{ a.jogo.rodada }}">{{ a.jogo.rodada }}</span>
			<span class="mui-col-md-2 mui--text-headline ">{{a.jogo.timeA}}</span> 
			<span class="mui-col-md-1"><span ng-hide="a.jogo.status == 'EDICAO'">{{a.jogo.resultadoA}}</span></span> 
			<span class="mui-col-md-1">X</span>  
			<span class="mui-col-md-1"><span ng-hide="a.jogo.status == 'EDICAO'">{{a.jogo.resultadoB}}</span></span> 
			<span class="mui-col-md-2 mui--text-headline">{{a.jogo.timeB}}</span>
			<span class="mui-col-md-1"></span>  
			<span class="mui-col-md-3 mui--text-headline">
				<!-- Logado e Em Edicao -->
				<span ng-show="a.jogo.status == 'EDICAO'">
					<input ng-model="a.resultadoA" type="number" ng-change="ameCtrl.saveAposta(a)" 
						   style="width: 50px; height: 30px; font-size: 18px; text-align: center;" min="0" />
					X 
					<input ng-model="a.resultadoB" type="number" ng-change="ameCtrl.saveAposta(a)"
						   style="width: 50px; height: 30px; font-size: 18px; text-align: center;" min="0" />
			    </span>
				<span ng-show="a.jogo.status != 'EDICAO'" class="mui--text-subhead mui--text-accent mui--text-center">+{{ a.pontos }}</span>
			</span>
		</div>
	  </div>
	  <div class="mui-col-md-12 mui--text-right">
	  	<button type="button" class="mui-btn mui-btn--primary" ng-click="ameCtrl.concluirAposta(ameCtrl.inscricao)">Concluir</button>
	  </div>	
</div>
