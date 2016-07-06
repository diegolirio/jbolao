<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container-fluid" ng-controller="CampeonatoListController as clCtrl">
	  <br>
	  <h1>
	  	Lista de Campeonato
	  	<a href="#/campeonato/0" class="mui-btn mui-btn--small mui-btn--primary mui-btn--fab">+</a>
	  </h1>
	  
	  <table class="mui-table mui-table--bordered">
		  <thead>
		    <tr>
		      <th>Nome</th>
		      <th>Descrição</th>
		      <th>Status</th>
		      <th></th>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr ng-repeat="c in clCtrl.campeonatos">
		      <td>{{ c.nome }}</td>
		      <td>{{ c.descricao }}</td>
		      <td>{{ c.status }}</td>
			  <td><a href="#/jogos/por/campeonato/{{c.id}}" class="mui-btn mui-btn--raised">Jogos</a></td>
		      <td>
		      	<a href="#/campeonato/{{c.id}}" class="mui-btn mui-btn--small mui-btn--danger mui-btn--fab">
					<img src="https://justineisartsy.files.wordpress.com/2015/10/edit.png"/>
				</a>
		      	<button class="mui-btn mui-btn--small mui-btn--danger mui-btn--fab" ng-click="clCtrl.deleteCampeonato(c)">
					<img src="http://acomacgo.com.br/public/imagem/layout/delete.png"/>
		      	</button>
		      </td>
		    </tr>
		  </tbody>
	   </table>	 

</div>
