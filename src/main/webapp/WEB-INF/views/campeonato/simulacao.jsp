<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="SimulacaoCrontroller as siCtrl">
	  <br>
	  <h1>Simulação</h1>
	  <h3>{{siCtrl.campeonato.descricao}} - {{siCtrl.campeonato.nome}}</h3>
	  
	  <div class="mui--text-right">
	  	<button type="button" class="mui-btn {{ siCtrl.zerarVoltar ? 'mui-btn--danger' : 'mui-btn--primary' }}" 
	  			ng-click="siCtrl.zerarVoltarPontucao(!siCtrl.zerarVoltar)">{{ siCtrl.zerarVoltar ? 'Voltar Pontução' : 'Somente Pontos da Simulação'}}</button>
	  </div>
	  
	  <div class="mui--visible-sm mui-row">
		  <div class="mui-panel mui-col-xs-12 mui-col-md-12 mui--text-center">
			<div class="mui-row"> 
				<span class="mui-col-xs-12 mui-col-md-1">
					<span ng-hide="siCtrl.index <= 0">
						<a href ng-click="siCtrl.setIndex(siCtrl.index-1)">Anterior</a>
					</span>
				</span> 
				<span class="mui-col-xs-12 mui-col-md-3 mui--text-display1 mui--text-danger">{{ siCtrl.jogos[siCtrl.index].timeA }}</span> 
				<span class="mui-col-xs-12 mui-col-md-1">
					<input type="number" style="width: 80px; height: 40px; font-size: 25px; text-align: center;" min="0" 
						   ng-model="siCtrl.jogos[siCtrl.index].resultadoA" ng-change="siCtrl.recalcular()"> 
				</span> 
				<span class="mui-col-xs-12 mui-col-md-1"><br/>X</span> 
				<span class="mui-col-xs-12 mui-col-md-1">
					<input type="number" style="width: 80px; height: 40px; font-size: 25px; text-align: center;" min="0" 
						   ng-model="siCtrl.jogos[siCtrl.index].resultadoB" ng-change="siCtrl.recalcular()"> 
				</span> 
				<span class="mui-col-xs-12 mui-col-md-3 mui--text-display1 mui--text-danger">{{ siCtrl.jogos[siCtrl.index].timeB }}</span>
				<span class="mui-col-xs-12 mui-col-md-1 mui--text-right">
					<span ng-hide="siCtrl.index >= siCtrl.jogos.length-1">
						<a href ng-click="siCtrl.setIndex(siCtrl.index+1)">Proximo</a>
					</span>
				</span>
			</div>
		  </div>		   
	  </div>

<!-- 	  <div class="mui--visible-xs mui--hidden-sm mui-row"> -->
<!-- 		  <div class="mui-panel mui-col-xs-12"> -->
<!-- 			<div class="mui-row mui--text-center">  -->
<!-- 				<span class="mui-col-xs-12"> -->
<%-- 					<span ng-hide="siCtrl.index <= 0"> --%>
<!-- 						<a href ng-click="siCtrl.setIndex(siCtrl.index-1)">Anterior</a> -->
<!-- 					</span> -->
<!-- 				</span>  -->
<!-- 			</div> -->
<!-- 			<div class="mui-row">  -->
<!-- 				<span class="mui-col-xs-7 mui--text-display1 mui--text-danger">{{ siCtrl.jogos[siCtrl.index].timeA }}</span>  -->
<!-- 				<span class="mui-col-xs-3"> -->
<!-- 					<input type="number" style="width: 80px; height: 40px; font-size: 25px; text-align: center;" min="0"  -->
<!-- 						   ng-model="siCtrl.jogos[siCtrl.index].resultadoA" ng-change="siCtrl.recalcular()">  -->
<!-- 				</span> -->
<!-- 			</div>  -->
<!-- 			<div class="mui-row">  -->
<!-- 				<span class="mui-col-xs-7 mui--text-display1 mui--text-danger">{{ siCtrl.jogos[siCtrl.index].timeB }}</span> -->
<!-- 				<span class="mui-col-xs-3"> -->
<!-- 					<input type="number" style="width: 80px; height: 40px; font-size: 25px; text-align: center;" min="0"  -->
<!-- 						   ng-model="siCtrl.jogos[siCtrl.index].resultadoB" ng-change="siCtrl.recalcular()">  -->
<!-- 				</span>  -->
<!-- 			</div> -->
<!-- 			<div class="mui-row mui--text-center"> -->
<!-- 				<span class="mui-col-xs-12"> -->
<!-- 					<span ng-hide="siCtrl.index >= siCtrl.jogos.length-1"> -->
<!-- 						<a href ng-click="siCtrl.setIndex(siCtrl.index+1)">Proximo</a> -->
<!-- 					</span> -->
<!-- 				</span> -->
<!-- 			</div> -->
<!-- 		  </div>		    -->
<!-- 	  </div> -->
	  
	  <div class="mui-panel mui-col-xs-12 mui-col-md-12" style="color: green;">
		<span class="mui-col-xs-1 mui-col-md-1 mui--text-caption mui--text-center">Col.</span> 
		<span class="mui-col-xs-3 mui-col-md-2 mui--text-caption ">Participante</span> 
		<span class="mui-col-xs-2 mui-col-md-1 mui--text-caption mui--text-center">Pontos</span> 
<!-- 		<span class="mui--hidden-xs mui-col-md-1 mui--text-caption mui--text-center">J</span>  -->
		<span class="mui--hidden-xs mui-col-md-1 mui--text-caption mui--text-center"></span> 
		<span class="mui--hidden-xs mui-col-md-1 mui--text-caption mui--text-center"></span> 
		<span class="mui--hidden-xs mui-col-md-1 mui--text-caption mui--text-center"></span> 
		<span class="mui--hidden-xs mui-col-md-1 mui--text-caption mui--text-center"></span> 
		<span class="mui-col-xs-2 mui-col-md-1 mui--text-caption mui--text-center">{{ siCtrl.jogos[siCtrl.index].timeA }}</span> 
		<span class="mui-col-xs-1 mui-col-md-1 mui--text-caption mui--text-center">X</span> 
		<span class="mui-col-xs-2 mui-col-md-1 mui--text-caption mui--text-center">{{ siCtrl.jogos[siCtrl.index].timeB }}</span> 
	  </div>	
	  
	  <div class="mui-panel mui-col-xs-12 mui-col-md-12" ng-repeat="i in siCtrl.inscricoes">  
		<span class="mui-col-xs-1 mui-col-md-1 mui--text-subhead mui--text-center">{{ i.colocacao > 0 ? i.colocacao : $index+1}}º</span> 
		<span class="mui-col-xs-4 mui-col-md-2 mui--text-caption ">{{i.participante.nome}}</span> 
		<span class="mui-col-xs-2 mui-col-md-1 mui--text-subhead mui--text-center">
			<b>{{ i.pontos }}</b> 
			<span class="mui--text-caption mui--text-accent-hint">{{ '+'+(i.pontosSomados) }}</span> 
		</span> 
<!-- 	<span class="mui-col-md-1 mui--text-subhead mui--text-center">{{ siCtrl.countJogos }}</span>  -->
		<span class="mui--hidden-xs mui-col-md-1"></span><!--<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoPlacar }}</span>  -->
		<span class="mui--hidden-xs mui-col-md-1"></span><!--<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoVencedorUmResultado }}</span>  -->
		<span class="mui--hidden-xs mui-col-md-1"></span><!--<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoVencedor }}</span>  -->
		<span class="mui--hidden-xs mui-col-md-1"></span><!--<span class="mui-col-md-1 mui--text-caption mui--text-center">{{ i.acertoSomenteUmResultado }}</span>  -->
		<span class="mui-col-xs-1 mui-col-md-1 mui--text-title mui--text-center mui--text-danger">{{ i.jogoResultadoA }}</span> 
		<span class="mui-col-xs-1 mui-col-md-1 mui--text-caption mui--text-center">X</span> 
		<span class="mui-col-xs-1 mui-col-md-1 mui--text-title mui--text-center mui--text-danger">{{ i.jogoResultadoB }}</span> 
	  </div>	
	  
	  		
</div>
