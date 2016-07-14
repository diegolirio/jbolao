<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="LoginController as lCtrl">
	  <br>
	  <h1>Regras</h1>
	  <hr/>
	  
	  <span>
	  	Cada participante terá sua aposta para cada jogo.<br/> 
	  	O bolao terá um racking de pontos corridos, onde quem fazer maoir número de pontos vence.<br/>
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
	  
	  <h4>Critérios de desempate:</h4>
	  <div class="mui-panel">
	  		<p><span class="mui--text-title"><span class="mui--text-danger">1º:</span> Maoir número de pontos</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">2º:</span> Maior acertos de Placar(AP)</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">3º:</span> Maior acertos do Vencedor e Resultado de um time (AR)</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">4º:</span> Maior acertos de Vencedor (AV)</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">5º:</span> Maior acertos de Somente Resultado de um time (AS)</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">6º:</span> Par ou Impar</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">7º:</span> Jokenpô</span><p>
			<p><span class="mui--text-title"><span class="mui--text-danger">8º:</span> Quem já pegou mais mulher</span><p>
	  </div>
	  
	  
</div>
