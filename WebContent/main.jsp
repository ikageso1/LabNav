<%@ page language="java"
contentType="text/html; charset=utf-8" %>
<% if(request.getSession().getAttribute("userId") != null){ %>
<!DOCTYPE html>
<html lang="jp">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/maguro.png">
    <title>ラボナビ</title>

    <!-- Bootstrap -->
    <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="css/bootstrap.css" rel="stylesheet">
    <link type="text/css" href="css/main.css" rel="stylesheet">
    <link type="text/css" href="css/navBarStyle.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script  type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    
    <script type="text/javascript" src="js/angular.min.js"></script>
    <script type="text/javascript" src="js/ui-bootstrap-tpls-0.10.0.min.js"></script>
    
    <script type="text/javascript" >
      var app = angular.module('PageNavi',['ui.bootstrap']);
      app.controller('MainCtrl',
        function($scope) {
          $scope.isCollapsed = true;
        }
      );
    </script> 
  </head>

<div id="body" ng-app='PageNavi' ng-controller="MainCtrl">

 <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container-fluid">
      
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" ng-click="isCollapsed = !isCollapsed">
            <span class="sr-only">メニューナビゲーション</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="main.jsp">
          <img alt="" src="img/Brand-Image.png" class="img-Brand"></a>
        </div>
        <div collapse="isCollapsed" class="navbar-collapse">
        	<ul class="nav navbar-nav">
        	  <li class="active"><a href="#">メインメニュー</a></li>
			  <li><a href="profile.html">プロフィール</a></li>
			  <li><a href="desired_lab_rank.html">ランキング</a></li>
			  <li><a href="#">ログアウト</a></li>
			</ul>
          
        </div>
      </div>
      
    </nav> 

<div class="row">

 <div class="col-xs-6 col-md-3">
  	<a href="lab_moriyama.html" class="thumbnail">電子商取引研究室
		<img src="https://www.kindai.ac.jp/data/images/professor/242.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
	</a>
 </div>

 <div class="col-xs-6 col-md-3">
 	<a href="lab_tsunoda.html" class="thumbnail">ソフトウェア工学研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/469.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
 <div class="col-xs-6 col-md-3">
 	<a href="lab_tada.html" class="thumbnail">交通情報学研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/468.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
	 </a>
 </div>
 
 <div class="col-xs-6 col-md-3">
 	<a href="lab_mizobuchi.html" class="thumbnail">自然言語処理研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/458.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
<div class="col-xs-6 col-md-3">
 	<a href="lab_hamasuna.html" class="thumbnail">知能情報基礎研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/479.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>

 <div class="col-xs-6 col-md-3">
 	<a href="lab_sano.html" class="thumbnail">環境情報科学研究室
		<img src="https://www.kindai.ac.jp/data/images/professor/868.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
	</a>
 </div>
 
 <div class="col-xs-6 col-md-3">
 	<a href="lab_habe.html" class="thumbnail">コンピュータビジョン研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/473.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
 <div class="col-xs-6 col-md-3">
 	<a href="lab_higuchi.html" class="thumbnail">分散処理ソフトウェア研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/443.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>	
 	</a>
 </div>
 
 <div class="col-xs-6 col-md-3">
 	<a href="lab_sasano.html" class="thumbnail">情報通信研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/438.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
<div class="col-xs-6 col-md-3">
 	<a href="lab_tagawa.html" class="thumbnail">数理情報工学研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/439.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
	</a>
 </div>

<div class="col-xs-6 col-md-3">
 	<a href="lab_moriya.html" class="thumbnail">分散アルゴリズム研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/476.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
 <div class="col-xs-6 col-md-3">
 	<a href="lab_ishimizu.html" class="thumbnail">情報論理工学研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/461.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
 <div class="col-xs-6 col-md-3">
	<a href="lab_yamamoto.html" class="thumbnail">音声言語研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/449.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
<div class="col-xs-6 col-md-3">
 	<a href="lab_iguchi.html" class="thumbnail">ネットワーク研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/238.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>

<div class="col-xs-6 col-md-3">
 	<a href="lab_takada.html" class="thumbnail">マルチエージェント研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/1169.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
 <div class="col-xs-6 col-md-3">
 	<a href="lab_abe.html" class="thumbnail">人間情報科学研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/450.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
 <div class="col-xs-6 col-md-3">
 	<a href="lab_kato.html" class="thumbnail">並行計算理論研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/519.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
<div class="col-xs-6 col-md-3">
 	<a href="lab_handa.html" class="thumbnail">計算知能研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/456.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>

<div class="col-xs-6 col-md-3">
 	<a href="lab_hironaga.html" class="thumbnail">画像処理研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/480.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
 <div class="col-xs-6 col-md-3">
 	<a href="lab_oboshi.html" class="thumbnail">医療情報学研究室
 		<img src="http://profsci.kudos.kindai.ac.jp/moodle/file.php/2/moddata/data/1/18/162/%E6%83%85%E5%A0%B1%E5%AD%A6%E7%A7%91%E5%A4%A7%E6%98%9F_fmt.jpeg" alt="" width="160">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>
 
 <div class="col-xs-6 col-md-3">
 	<a href="lab_taniguchi.html" class="thumbnail">知的通信網研究室
 		<img src="https://www.kindai.ac.jp/data/images/professor/1230.jpg" alt="">
		<div class="rating" ><p>平均評価を表示</p></div>
 	</a>
 </div>



 </div>
 </div>

</div>

<div class="col-md-6 col-md-offset-5" id="CopyRight">
	&copy; 2014 B14 Group. All Rights Reserved.
</div>
</div>
<% } %>
</html>
