<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="ApostaFormController as afCtrl">
	  <br>
	  <h2>Alterar Aposta</h2>
	  <hr/>
	  
	  <div class="mui-row">
		  <div class="mui-panel mui-col-md-12 mui--text-center">
			<div class="mui-row"> 
				<span class="mui-col-md-4 mui--text-headline ">{{afCtrl.aposta.jogo.timeA}}</span> 
				<span class="mui-col-md-1" ng-hide="j.status == 'EDICAO'">{{afCtrl.aposta.jogo.resultadoA}}</span> 
				<span class="mui-col-md-1">X</span> 
				<span class="mui-col-md-1" ng-hide="j.status == 'EDICAO'">{{afCtrl.aposta.jogo.resultadoB}}</span> 
				<span class="mui-col-md-4 mui--text-headline">{{afCtrl.aposta.jogo.timeB}}</span>
			</div>
		  </div>		  
	  </div>
	
	  <div class="mui-row">
		 <form ng-submit="afCtrl.save(afCtrl.aposta)">
		  <div class="mui-textfield mui-textfield--float-label">
		    <input ng-model="afCtrl.aposta.resultadoA">
		    <label>{{afCtrl.aposta.jogo.timeA}}</label>
		  </div>
		  <div class="mui-textfield mui-textfield--float-label">
		    <input ng-model="afCtrl.aposta.resultadoB">
		    <label>{{afCtrl.aposta.jogo.timeB}}</label>
		  </div>
		  <button type="button" class="mui-btn mui-btn--raised mui-btn--primary" ng-click="afCtrl.saveAndContinue(afCtrl.aposta)">Salvar e Continuar</button>
		  <button type="submit" class="mui-btn mui-btn--raised mui-btn--primary">Salvar</button>
		  <a href="#/aposta/{{afCtrl.aposta.inscricao.id}}" class="mui-btn mui-btn--raised">Voltar</a>
		</form>
	  </div>
	 
</div>
