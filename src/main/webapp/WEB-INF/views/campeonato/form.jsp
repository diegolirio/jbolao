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
	    <label>Descri��o</label>
	  </div>
<!-- 	  <div class="mui-textfield mui-textfield--float-label"> -->
<!-- 	    <textarea></textarea> -->
<!-- 	    <label>Observa��o</label> -->
<!-- 	  </div> -->
	  
	  <button type="submit" class="mui-btn mui-btn--raised mui-btn--primary">Salvar</button>
	  <a href="#/campeonatos" class="mui-btn mui-btn--raised">Voltar</a>
	</form>

</div>
