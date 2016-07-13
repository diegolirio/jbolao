<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="CampeonatoDashboardCrontroller as dashCtrl">
	  <br>
	  <h1>
<!-- 	  	Ligas -->
	  	<a ng-show="usuarioLogged  && usuarioLogged.id == 1" href="#/campeonato/0?next=/" class="mui-btn mui-btn--small mui-btn--primary mui-btn--fab">+</a>
	  </h1>
	  
	  <div class="mui-panel mui-col-md-12 mui-col-xs-12 mui-row" ng-repeat="c in dashCtrl.campeonatos" ng-show="(usuarioLogged  && usuarioLogged.id == 1) || c.status != 'EDICAO'">
	  	<div class="mui-col-md-1 mui-col-xs-3">
	  		<a ng-click="dashCtrl.enterCampeonato(c)" href>
	  			<img alt="" src="${pageContext.request.contextPath}/resources/static/img/bola_grama.gif" height="50" class="img-responsive" />
	  		</a>
	  	</div>
	  	<div class="mui-col-md-7 mui-col-xs-7">
	  		<a ng-click="dashCtrl.enterCampeonato(c)" href>
		  		<span class="mui--text-display1">
		  			{{ c.descricao }} 
		  			<small> / {{ c.nome }} </small>
		  		</span>
		  	</a>
		</div>
	  	<div class="mui-col-md-4 mui-col-xs-12">
  			<a ng-show="usuarioLogged  && usuarioLogged.id == 1" href="#/campeonato/{{c.id}}?next=/">
  				<img src="/jbolao/resources/static/img/edit24X24.png" alt="editar"/> 
  			</a> &nbsp; &nbsp;&nbsp;	  	
	  		<a ng-show="usuarioLogged  && usuarioLogged.id == 1" href="#/jogos/{{c.id}}" class="mui-btn mui-btn--small mui-btn--danger">Jogos</a>
	  	</div>
	  </div>
	   
	  <h4 ng-show="dashCtrl.campeonatos.length <= 0">Não há ligas cadastradas</h4>
	  		
</div>
