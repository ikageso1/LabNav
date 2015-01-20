function addList(){
	var labElement = document.getElementById("labList");
	var isAssigned = document.getElementById("assigned").checked;
	var i;
	if(isAssigned){
		var labList = ["電子商取引研究室","ソフトウェア工学研究室","交通情報学研究室",
					"自然言語処理研究室","知能情報基礎研究室",
					"環境情報科学研究室",
					"コンピュータビジョン研究室",
					"分散処理ソフトウェア研究室",
					"情報通信研究室",
					"数理情報工学研究室",
					"分散アルゴリズム研究室",
					"情報論理工学研究室",
					"音声源研究室",
					"ネットワーク研究室",
					"マルチエージェント研究室",
					"人間情報科学研究室",
					"並行計算論理研究室",
					"計算知能研究室",
					"画像処理研究室",
					"医療情報学研究室",
					"知的通信網研究室"];
	  
		
		var name = ["moriyama","tsunoda","tada","mizobuchi","hamasuna",
			"sano","habe","higuchi","sasano","tagawa","moriya",
			"ishimizu","yamamoto","iguchi","takata","abe",
			"kato","handa","hironaga","oboshi","taniguchi"];



		var str = "<label class='col-sm-2 control-label'></label>"
			+ "<div class='col-sm-10'>"
		  + "<select class='form-control' name='assignedLab'>";
		for( i=0;i<labList.length;i++){
			str += "<option value="+String(i)+">"+labList[i]+"</option>";
		}
		 str += "</select>" + "</div>";
	   labElement.innerHTML = str;
	}
	else{
		var child = labElement.childNodes;
		var i;
		for(i=0;i<child.length;i++){
			labElement.removeChild(child[i+1]);
		}
	}
}

window.addEventListener("load",function(){
				var check = document.getElementById("assigned");
				check.addEventListener("click",addList,false);
},false);
