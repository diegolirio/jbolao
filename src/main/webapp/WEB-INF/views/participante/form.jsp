<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="ParticipanteFormController as pfCtrl">
	  <br>
	  <h1>Participante</h1>
	  
	 <form ng-submit="pfCtrl.save(pfCtrl.participante)" name="formPart">
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="pfCtrl.participante.nome" name="nome" required="required" id="idNome">
	    <label>Nome</label>
	  </div>
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="pfCtrl.participante.email" name="email" type="email">
	    <label>E-mail</label>
	  </div>
	  	    
	  <button type="button" ng-click="pfCtrl.saveAndAddNew(pfCtrl.participante)" class="mui-btn mui-btn--raised mui-btn--primary" ng-disabled="formPart.nome.$invalid">Salvar e Adicionar Novo</button>
	  <button type="submit" class="mui-btn mui-btn--raised mui-btn--primary" ng-disabled="formPart.nome.$invalid">Salvar</button>
	  <a ng-href="{{pfCtrl.previousPage}}"  class="mui-btn mui-btn--raised">Voltar</a>
	  
	</form>

</div>
