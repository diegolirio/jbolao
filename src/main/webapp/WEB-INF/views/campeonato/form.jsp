<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container-fluid" ng-controller="CampeonatoFormController as cfCtrl">
	  <br>
	  <h1>Campeonato</h1>
	
	  <form ng-submit="cfCtrl.save(cfCtrl.campeonato)">
		  <legend>Nome</legend>
		  <div class="mui-textfield">
		    <input ng-model="cfCtrl.campeonato.nome">
		  </div>
		  <button type="submit" class="mui-btn mui-btn--raised">Salvar</button>
	  </form>	  

</div>
