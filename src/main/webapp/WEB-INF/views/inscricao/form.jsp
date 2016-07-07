<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="InscricaoFormController as ifCtrl">
	  <br>
	  <h1>
	  	Inscri��o
	  	<a href="#/participante/0/campeonato/{{ifCtrl.inscricao.campeonato.id}}?next={{ifCtrl.next}}" class="mui-btn mui-btn--small mui-btn--danger mui-btn--fab" title="Novo Participante">+</a>	  	
	  </h1>
	  
	 <form ng-submit="ifCtrl.save(ifCtrl.inscricao)" name="formInscricao">
	  <div class="mui-textfield mui-textfield--float-label" ng-show="ifCtrl.inscricao.id > 0">
	    <input ng-model="ifCtrl.inscricao.id" disabled="disabled">
	    <label>Inscri��o</label>
	  </div>

	  <input type="hidden" ng-model="ifCtrl.inscricao.participante.id" name="participanteId" required="required">
	  
	  <div ng-show="ifCtrl.inscricao.participante">
		  {{ ifCtrl.inscricao.participante | json}}
	  </div>	  	  
	  <div class="mui-textfield mui-textfield--float-label">
		  <label>Participante</label> 
		  <div angucomplete-alt id="txtAutocomplete" placeholder="Participante" pause="100"
						 selected-object="ifCtrl.aposSelecionarParticipante" local-data="ifCtrl.participantes" search-fields="nome"
						 title-field="nome" minlength="1" input-class="form-control" match-class="highlight">	 
		  </div>	  
	  </div> 
	   
	  <button type="submit" class="mui-btn mui-btn--raised mui-btn--primary" 
	  		  ng-disabled="formInscricao.participanteId.$invalid">Salvar</button>
	  <a href="#/inscricoes/por/campeonato/{{ifCtrl.inscricao.campeonato.id}}" class="mui-btn mui-btn--raised">Voltar</a>
	  
	</form>
	