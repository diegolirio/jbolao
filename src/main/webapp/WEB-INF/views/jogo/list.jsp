<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="JogoListController as jCtrl">
	  <h1>{{jCtrl.campeonato.nome}} <small class="mui--text-subhead">( {{jCtrl.campeonato.descricao}} )</small></h1>
	  <h3 class="mui--text-right">
	  	Jogos
	  	<a href="#/jogo/0" class="mui-btn mui-btn--small mui-btn--primary mui-btn--fab">+</a>
	  </h3>
		
	  <div class="mui-panel mui-col-md-6 mui--text-center" ng-repat="j in jCtrl.jogos">
		<span class="mui-col-md-4 mui--text-headline ">{{j.timeA}}</span> 
		<span class="mui-col-md-1">{{j.resultadoA}}</span> 
		<span class="mui-col-md-1">X</span> 
		<span class="mui-col-md-1">{{j.resultadoB}}</span> 
		<span class="mui-col-md-4 mui--text-headline">{{j.timeB}}</span>
	  </div>		
	  
</div>
