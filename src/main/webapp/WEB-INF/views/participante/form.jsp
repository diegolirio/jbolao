<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="ParticipanteFormController as pfCtrl">
	  <br>
	  <h1>Participante</h1>
	  
	 <form ng-submit="pfCtrl.save(pfCtrl.participante)" name="formPart">
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="pfCtrl.participante.nome" name="nome" required="required">
	    <label>Nome</label>
	  </div>
	  	  
	  <button type="submit" class="mui-btn mui-btn--raised mui-btn--primary" ng-disabled="formPart.nome.$invalid">Salvar</button>
	  <a href="{{pfCtrl.next}}"  class="mui-btn mui-btn--raised">Voltar</a>
	  
	</form>

</div>
