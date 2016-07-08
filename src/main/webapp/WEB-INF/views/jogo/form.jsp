<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="JogoFormController as jfCtrl">
	  <br>
	  <h1>Jogo</h1>
	  
	  <h3 style="color: green;">{{jfCtrl.getStatusDescription(jfCtrl.jogo.status)}}</h3>
	
	 <form ng-submit="jfCtrl.save(jfCtrl.jogo)" name="formJogo">
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="jfCtrl.jogo.timeA" required="required" name="timeA" id="idTimeA">
	    <label>Time A</label>
	  </div>
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="jfCtrl.jogo.timeB" required="required" name="timeB">
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
	  
	  
	  <div class="mui-row">
		 
		  <button type="button" class="mui-btn mui-btn--raised mui-btn--primary" ng-click="jfCtrl.saveAndAddOther(jfCtrl.jogo)"
		  		  ng-disabled="formJogo.timeA.$invalid || formJogo.timeB.$invalid">Salvar e Adicionar Outro</button>
		 
		  <button type="submit" class="mui-btn mui-btn--raised mui-btn--primary" 
		  		  ng-disabled="formJogo.timeA.$invalid || formJogo.timeB.$invalid">Salvar</button>
		  
		  <a ng-href="#/jogos/{{jfCtrl.jogo.campeonato.id}}" class="mui-btn mui-btn--raised">Voltar</a>
		  
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
		</div>	
	</form>

</div>
