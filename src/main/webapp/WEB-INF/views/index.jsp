<!doctype html>
<html ng-app="app">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- load Angular -->
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-route.js"></script>
    <link href="${pageContext.request.contextPath}/resources/static/mui-0.6.5/css/mui.min.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/resources/static/mui-0.6.5/js/mui.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/static/mui-0.6.5/angular/mui-angular.js"></script>
    <script src="${pageContext.request.contextPath}/resources/static/mui-0.6.5/angular/mui-angular.min.js"></script>

	<!-- angucomplete-alt -->
	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/static/autocomplete-alt/angucomplete-alt.css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/resources/static/autocomplete-alt/angucomplete-alt.js"></script>
	<style type="text/css">
		.angucomplete-dropdown {
			overflow-y: auto;
			max-height: 200px; 
		}
	</style>
	<!-- /angucomplete-alt -->
	
    <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
    <style>
     	/* Tutorial CSS goes here */
		/**
		 * Body CSS
		 */
		html,
		body {
		  height: 100%;
		  background-color: #eee;
		}
		
		html,
		body,
		input,
		textarea,
		buttons {
		  -webkit-font-smoothing: antialiased;
		  -moz-osx-font-smoothing: grayscale;
		  text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.004);
		}
		
		
		/**
		 * Layout CSS
		 */
		#header {
		  position: fixed;
		  top: 0;
		  right: 0;
		  left: 0;
		  z-index: 2;
		  transition: left 0.2s;
		}
		
		#sidedrawer {
		  position: fixed;
		  top: 0;
		  bottom: 0;
		  width: 200px;
		  left: -200px;
		  overflow: auto;
		  z-index: 2;
		  background-color: #fff;
		  transition: transform 0.2s;
		}
		
		#content-wrapper {
		  min-height: 100%;
		  overflow-x: hidden;
		  margin-left: 0px;
		  transition: margin-left 0.2s;
		
		  /* sticky bottom */
		  margin-bottom: -160px;
		  padding-bottom: 160px;
		}
		
		#footer {
		  height: 160px;
		  margin-left: 0px;
		  transition: margin-left 0.2s;
		}
		
		@media (min-width: 768px) {
		  #header {
		    left: 200px;
		  }
		
		  #sidedrawer {
		    transform: translate(200px);
		  }
		
		  #content-wrapper {
		    margin-left: 200px;
		  }
		
		  #footer {
		    margin-left: 200px;
		  }
		
		  body.hide-sidedrawer #header {
		    left: 0;
		  }
		
		  body.hide-sidedrawer #sidedrawer {
		    transform: translate(0px);
		  }
		
		  body.hide-sidedrawer #content-wrapper {
		    margin-left: 0;
		  }
		
		  body.hide-sidedrawer #footer {
		    margin-left: 0;
		  }
		}
		
		
		/**
		 * Toggle Side drawer
		 */
		#sidedrawer.active {
		  transform: translate(200px);
		}
		
		
		/**
		 * Header CSS
		 */
		.sidedrawer-toggle {
		  color: #fff;
		  cursor: pointer;
		  font-size: 20px;
		  line-height: 20px;
		  margin-right: 10px;
		}
		
		.sidedrawer-toggle:hover {
		  color: #fff;
		  text-decoration: none;
		}
		
		
		/**
		 * Footer CSS
		 */
		#footer {
		  background-color: #0288D1;
		  color: #fff;
		}
		
		#footer a {
		  color: #fff;
		  text-decoration: underline;
		}     	
		
		
		/**
		 * Side drawer CSS
		 */
		#sidedrawer-brand {
		  padding-left: 20px;
		}
		
		#sidedrawer ul {
		  list-style: none;
		}
		
		#sidedrawer > ul {
		  padding-left: 0px;
		}
		
		#sidedrawer > ul > li:first-child {
		  padding-top: 15px;
		}
		
		#sidedrawer strong {
		  display: block;
		  padding: 15px 22px;
		  cursor: pointer;
		}
		
		#sidedrawer strong:hover {
		  background-color: #E0E0E0;
		}
		
		#sidedrawer strong + ul > li {
		  padding: 6px 0px;
		}		
		
    </style>
    <script>
     	/* Tutorial JavaScript goes here */
		jQuery(function($) {
		  var $bodyEl = $('body'),
		      $sidedrawerEl = $('#sidedrawer');
		
		
		  function showSidedrawer() {
		    // show overlay
		    var options = {
		      onclose: function() {
		        $sidedrawerEl
		          .removeClass('active')
		          .appendTo(document.body);
		      }
		    };
		
		    var $overlayEl = $(mui.overlay('on', options));
		
		    // show element
		    $sidedrawerEl.appendTo($overlayEl);
		    setTimeout(function() {
		      $sidedrawerEl.addClass('active');
		    }, 20);
		  }
		
		
		  function hideSidedrawer() {
		    $bodyEl.toggleClass('hide-sidedrawer');
		  }
		
		
		  $('.js-show-sidedrawer').on('click', showSidedrawer);
		  $('.js-hide-sidedrawer').on('click', hideSidedrawer);
		});     	
     	
     	
		var $titleEls = $('strong', $sidedrawerEl);

		$titleEls
		  .next()
		  .hide();

		$titleEls.on('click', function() {
		  $(this).next().slideToggle(200);
		});
     	 
    </script>
  </head>
  <body>
	    <div id="sidedrawer" class="mui--no-user-select">
	      <div id="sidedrawer-brand" class="mui--appbar-line-height">Brand.io</div>
	      <div class="mui-divider"></div>
	      <ul>
	      	<li><strong><a href="#/campeonatos">Campeonatos</a></strong></li>
	        <!-- 
	        <li>
	          <strong>Category 1</strong>
	          <ul>
	            <li><a href>Item 1</a></li>
	            <li><a href>Item 2</a></li>
	            <li><a href>Item 3</a></li>
	          </ul>
	        </li>
	        <li>
	          <strong>Category 2</strong>
	          <ul>
	            <li><a href="#">Item 1</a></li>
	            <li><a href="#">Item 2</a></li>
	            <li><a href="#">Item 3</a></li>
	          </ul>
	        </li>
	        <li>
	          <strong>Category 3</strong>
	          <ul>
	            <li><a href="#">Item 1</a></li>
	            <li><a href="#">Item 2</a></li>
	            <li><a href="#">Item 3</a></li>
	          </ul>
	        </li>
	        -->
	      </ul>
	    </div>
			<header id="header">
			  <div class="mui-appbar mui--appbar-line-height">
			    <div class="mui-container-fluid">
			      <a class="sidedrawer-toggle mui--visible-xs-inline-block js-show-sidedrawer">###</a>
			      <a class="sidedrawer-toggle mui--hidden-xs js-hide-sidedrawer">###</a>
			      <span class="mui--text-title mui--visible-xs-inline-block">Brand.io</span>
			    </div>
			  </div>
			</header> 
			<div id="content-wrapper">

				<div ng-view></div>

			</div>
			<footer id="footer">
			  <div class="mui-container-fluid">
			    <br>
			    Made with ### by <a href="https://www.muicss.com">MUI</a>
			  </div>
			</footer>
  </body>
  
  <script src="${pageContext.request.contextPath}/resources/static/core/app.js"></script>
  <!-- Controllers -->  
  <script src="${pageContext.request.contextPath}/resources/static/core/controllers/campeonato-list-controller-1.0.0.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/static/core/controllers/campeonato-form-controller-1.0.0.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/static/core/controllers/jogo-list-controller-1.0.1.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/static/core/controllers/jogo-form-controller-1.0.1.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/static/core/controllers/inscricao-list-controller-1.0.0.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/static/core/controllers/inscricao-form-controller-1.0.0.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/static/core/controllers/participante-form-controller-1.0.1.js"></script>  
	<!-- Services -->
  <script src="${pageContext.request.contextPath}/resources/static/core/services/campeonato-service-1.0.0.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/static/core/services/jogo-service-1.0.0.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/static/core/services/inscricao-service-1.0.1.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/static/core/services/participante-service-1.0.0.js"></script>  
  
</html>