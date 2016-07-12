<!-- Main content goes here -->
<div class="mui--appbar-height"></div>
<div class="mui-container" ng-controller="LoginController as lCtrl">
	  <br>
	  <h1>Login</h1>
	  
	 <form ng-submit="lCtrl.login(lCtrl.usuario)" name="formLogin">
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="lCtrl.usuario.email" required="required" name="email" type="email" id="idLogin">
	    <label>Email</label>
	  </div>
	  <div class="mui-textfield mui-textfield--float-label">
	    <input ng-model="lCtrl.usuario.senha" required="required" name="senha" type="password">
	    <label>Senha</label>
	  </div>
	  <div class="mui-row">
		  <button type="submit" class="mui-btn mui-btn--raised mui-btn--primary" 
		  		  ng-disabled="formLogin.email.$invalid || formLogin.senha.$invalid">Entrar</button>
		  
		  <a ng-href="#/" class="mui-btn mui-btn--raised">Voltar</a>
	  </div>	
	</form>

</div>
