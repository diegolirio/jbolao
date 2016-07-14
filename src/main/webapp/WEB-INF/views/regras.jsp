<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="LoginController as lCtrl">
	  <br>
	  <h1>Regras</h1>
	  <hr/>
	  
	  <span>
	  	Cada participante ter� sua aposta para cada jogo.<br/> 
	  	O bolao ter� um racking de pontos corridos, onde quem fazer maoir n�mero de pontos vence.<br/>
	   	A Pontuacao consiste em:
	  </span>

	  <div class="mui-panel">
			<p><span class="mui--text-title">Acerto o Placar (AP) = <span class="mui--text-danger">8 Pontos</span></span><p>
			<p><span class="mui--text-accent">Exemplo:</span></p>
			<p><span >Sua aposta: Brasil <span class="mui--text-danger">1</span> X <span class="mui--text-danger">7</span> Alemanha</span></p>
			<p><span >Jogo: Brasil <span class="mui--text-danger">1</span> X <span class="mui--text-danger">7</span>  Alemanha</span></p>
			<hr/>
	  </div>
	  
	  <div class="mui-panel">
			<p><span class="mui--text-title">Acertar o Vencedor e resultado de um time (AR) = <span class="mui--text-danger">5 Pontos</span></span><p>
			<p><span class="mui--text-accent">Exemplo:</span></p>
			<p>
				<span >
					Sua aposta: Brasil <span class="mui--text-danger">1</span> X <span class="mui--text-danger">2</span> Alemanha 
					ou 
					Brasil <span class="mui--text-danger">2</span> X <span class="mui--text-danger">7</span> Alemanha
				</span>
			</p>
			<p><span >Jogo: Brasil <span class="mui--text-danger">1</span> X <span class="mui--text-danger">7</span>  Alemanha</span></p>
			<hr/>
	  </div>
	  
	  <div class="mui-panel">
			<p><span class="mui--text-title">Acertar o Vencedor (AV) = <span class="mui--text-danger">4 Pontos</span></span><p>
			<p><span class="mui--text-accent">Exemplo:</span></p>
			<p>
				<span >
					Sua aposta: Brasil <span class="mui--text-danger">0</span> X <span class="mui--text-danger">3</span> Alemanha 
					ou 
					Brasil <span class="mui--text-danger">2</span> X <span class="mui--text-danger">3</span> Alemanha
				</span>
			</p>
			<p><span >Jogo: Brasil <span class="mui--text-danger">1</span> X <span class="mui--text-danger">7</span>  Alemanha</span></p>
			<br/> 
			<br/> 
			<p>
				<span >
					Sua aposta: Brasil <span class="mui--text-danger">1</span> X <span class="mui--text-danger">1</span> Alemanha 
				</span>
			</p>
			<p><span >Jogo: Brasil <span class="mui--text-danger">2</span> X <span class="mui--text-danger">2</span>  Alemanha</span></p>			
			<hr/>
	  </div>
	  
	  <div class="mui-panel">
			<p><span class="mui--text-title">Acertar somente resultado de um time ( AS ) = <span class="mui--text-danger">1 Ponto</span></span><p>
			<p><span class="mui--text-accent">Exemplo:</span></p>
			<p>
				<span >
					Sua aposta: Brasil <span class="mui--text-danger">1</span> X <span class="mui--text-danger">0</span> Alemanha 
				</span>
			</p>
			<p><span >Jogo: Brasil <span class="mui--text-danger">1</span> X <span class="mui--text-danger">7</span>  Alemanha</span></p>
			<hr/>
	  </div>
	  
	  <div class="mui-panel">
			<p><span class="mui--text-title">(Errar Tudo) Errar Vencedor e Resultado dos times ( ER ) = <span class="mui--text-danger">Zero Ponto</span></span><p>
			<p><span class="mui--text-accent">Exemplo:</span></p>
			<p>
				<span >
					Sua aposta: Brasil <span class="mui--text-danger">2</span> X <span class="mui--text-danger">0</span> Alemanha 
				</span>
			</p>
			<p><span >Jogo: Brasil <span class="mui--text-danger">1</span> X <span class="mui--text-danger">7</span>  Alemanha</span></p>
			<hr/>
	  </div>
	  
	  <h4>Crit�rios de desempate:</h4>
	  <div class="mui-panel">
	  		<p><span class="mui--text-title"><span class="mui--text-danger">1�:</span> Maoir n�mero de pontos</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">2�:</span> Maior acertos de Placar(AP)</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">3�:</span> Maior acertos do Vencedor e Resultado de um time (AR)</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">4�:</span> Maior acertos de Vencedor (AV)</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">5�:</span> Maior acertos de Somente Resultado de um time (AS)</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">6�:</span> Par ou Impar</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">7�:</span> Jokenp�</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">8�:</span> Quem j� pegou mais mulher</span><p>
	  </div>
	  
	  
</div>
