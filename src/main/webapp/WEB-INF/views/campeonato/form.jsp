<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="CampeonatoFormController as cfCtrl">
	  <br>
	  <h1>Campeonato</h1>
	  
	  <h3 style="color: green;">{{cfCtrl.campeonato.status}}</h3>
	
	 <form ng-submit="cfCtrl.save(cfCtrl.campeonato)">
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="cfCtrl.campeonato.nome">
	    <label>Nome do Campenato</label>
	  </div>
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="cfCtrl.campeonato.descricao" placeholder="Ex: Amigos do boteco">
	    <label>Descrição</label>
	  </div>
<!-- 	  <div class="mui-textfield mui-textfield--float-label"> -->
<!-- 	    <textarea></textarea> -->
<!-- 	    <label>Observação</label> -->
<!-- 	  </div> --> 
	   
	  <button type="submit" class="mui-btn mui-btn--raised mui-btn--primary">Salvar</button>
	  <a href="{{cfCtrl.previousPage}}" class="mui-btn mui-btn--raised">Voltar</a>
	  <button type="button" class="mui-btn mui-btn--raised mui-btn--danger"
	  		  ng-click="cfCtrl.deleteCampeonato(cfCtrl.campeonato)" ng-show="usuarioLogged && cfCtrl.campeonato.id > 0">Excluir</button>
	</form>

</div>
