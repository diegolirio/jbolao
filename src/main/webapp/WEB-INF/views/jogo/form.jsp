<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="JogoFormController as jfCtrl">
	  <br>
	  <h1>Jogo</h1>
	  
	  <h3 style="color: green;">{{jfCtrl.jogo.status}}</h3>
	
	 <form ng-submit="jfCtrl.save(jfCtrl.jogo)">
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="jfCtrl.jogo.timeA">
	    <label>Time A</label>
	  </div>
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="jfCtrl.jogo.timeB">
	    <label>Time B</label>
	  </div>
	  <div class="mui-textfield mui-textfield--float-label" 
	  	   ng-show="jfCtrl.jogo.status == 'EM_ANDAMENTO' && jfCtrl.jogo.campeonato.status == 'EM_ANDAMENTO'">
	    <input ng-model="jfCtrl.jogo.resultadoA">
	    <label>Resultado A</label>
	  </div>
	  <div class="mui-textfield mui-textfield--float-label" 
	  	   ng-show="jfCtrl.jogo.status == 'EM_ANDAMENTO' && jfCtrl.jogo.campeonato.status == 'EM_ANDAMENTO'">
	    <input ng-model="jfCtrl.jogo.resultadoB">
	    <label>Resultado B</label>
	  </div>
	  
	  <button type="submit" class="mui-btn mui-btn--raised mui-btn--primary">Salvar</button>
	  <a href="#/jogos/por/campeonato/{{jfCtrl.jogo.campeonato.id}}" class="mui-btn mui-btn--raised">Voltar</a>
	  
	  <a class="mui-btn mui-btn--raised mui-btn--danger" ng-click="jfCtrl.start(jfCtrl.jogo)" 
	  		ng-show="jfCtrl.jogo.status == 'EDICAO' && jfCtrl.jogo.campeonato.status == 'EM_ANDAMENTO'">
	  			Mudar Jogo para em Andamento
	  </a>
	  
	  <a class="mui-btn mui-btn--raised mui-btn--danger" ng-click="jfCtrl.backToEdit(jfCtrl.jogo)"
	          ng-show="jfCtrl.jogo.status == 'EM_ANDAMENTO' && jfCtrl.jogo.campeonato.status == 'EM_ANDAMENTO'">
	          	Voltar Jogo para Pendente
	  </a>
	  
	  <a class="mui-btn mui-btn--raised mui-btn--danger" ng-click="jfCtrl.finalize(jfCtrl.jogo)"
	  		  ng-show="jfCtrl.jogo.status == 'EM_ANDAMENTO' && jfCtrl.jogo.campeonato.status == 'EM_ANDAMENTO'">
	  		  	Finalizar Jogo
	  </a>

	  <a class="mui-btn mui-btn--raised mui-btn--danger" ng-click="jfCtrl.backToInProccess(jfCtrl.jogo)"
	  		  ng-show="jfCtrl.jogo.status == 'FINALIZADO' && jfCtrl.jogo.campeonato.status == 'EM_ANDAMENTO'">
	  		  	Voltar Jogo para Em Andamento
	  </a>
	
	</form>

</div>
