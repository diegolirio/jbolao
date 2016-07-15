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
		  	<a ng-show="usuarioLogged" href ng-click="alCtrl.deleteInscricao(alCtrl.inscricao)" class="mui-btn mui-btn--small mui-btn--danger mui-btn--fab">X</a>
		  	<a ng-show="usuarioLogged" href="#/participante/{{alCtrl.inscricao.participante.id}}/campeonato/{{alCtrl.inscricao.campeonato.id}}?next={{alCtrl.nextPage}}"><img src="/jbolao/resources/static/img/edit32X32.png" alt="editar"/> </a>
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
			<span class="mui-col-md-1 mui--text-caption mui--text-center mui--text-danger mui--text-center" title="Rodada {{ a.jogo.rodada }}">{{ a.jogo.rodada }}</span>
			<span class="mui-col-md-2 mui--text-headline ">{{a.jogo.timeA}}</span> 
			<span class="mui-col-md-1"><span ng-hide="a.jogo.status == 'EDICAO'">{{a.jogo.resultadoA}}</span></span> 
			<span class="mui-col-md-1">X</span>  
			<span class="mui-col-md-1"><span ng-hide="a.jogo.status == 'EDICAO'">{{a.jogo.resultadoB}}</span></span> 
			<span class="mui-col-md-2 mui--text-headline">{{a.jogo.timeB}}</span>
			<span class="mui-col-md-1"></span>  
			<span class="mui-col-md-3 mui--text-headline">
				<!-- Nao logado e Em Edicao -->
				<span ng-show="!usuarioLogged || a.jogo.status != 'EDICAO'">
					{{a.resultadoA}} X {{a.resultadoB}}
				</span>
				<!-- Logado e Em Edicao -->
				<span ng-show="usuarioLogged && a.jogo.status == 'EDICAO'">
					<input ng-model="a.resultadoA" type="number" ng-change="alCtrl.saveAposta(a)" 
						   style="width: 50px; height: 30px; font-size: 18px; text-align: center;" min="0" />
					X 
					<input ng-model="a.resultadoB" type="number" ng-change="alCtrl.saveAposta(a)"
						   style="width: 50px; height: 30px; font-size: 18px; text-align: center;" min="0" />
<!-- 					<a href="#/aposta/edit/{{a.id}}"><img src="/jbolao/resources/static/img/edit32X32.png" alt="editar"/> </a>  -->
			    </span>
				<span ng-show="a.jogo.status != 'EDICAO'" class="mui--text-subhead mui--text-accent mui--text-center">+{{ a.pontos }}</span>
			</span>
		</div>
	  </div>	
	  <div class="mui-col-md-12 mui--text-right"  ng-show="usuarioLogged  && usuarioLogged.id == 1 && alCtrl.btnConcluir">
	  	<button type="button" class="mui-btn mui-btn--primary" onclick="alert('Concluido com sucesso'); window.location.reload();">Concluir</button>
	  </div>		  
</div>
