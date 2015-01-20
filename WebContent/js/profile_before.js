function addList(){
	var labElement = document.getElementById("labList");
	var isAssigned = document.getElementById("assigned").checked;
	var lab2Element = document.getElementById("satisfied");
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

	var i;
	var hope1Element = document.getElementById("hope1");
	var hope2Element = document.getElementById("hope2");
	var hope3Element = document.getElementById("hope3");
	var hopestr = "<label class='col-sm-2 control-label'></label>"
		+ "<div class='col-sm-10'>"
		+ "<select class='form-control' name='hope1'>";
	for( i=0;i<labList.length;i++){
		hopestr += "<option value="+name[i]+">"+labList[i]+"</option>";
	}
	hopestr += "</select>" + "</div>";
	hope1Element.innerHTML = hopestr;

	var hopestr2 = "<label class='col-sm-2 control-label'></label>"
		+ "<div class='col-sm-10'>"
		+ "<select class='form-control' name='hope2'>";
	for( i=0;i<labList.length;i++){
		hopestr2 += "<option value="+name[i]+">"+labList[i]+"</option>";
	}
	hopestr2 += "</select>" + "</div>";
	hope2Element.innerHTML = hopestr2;

	var hopestr3 = "<label class='col-sm-2 control-label'></label>"
		+ "<div class='col-sm-10'>"
		+ "<select class='form-control' name='hope3'>";
	for( i=0;i<labList.length;i++){
		hopestr3 += "<option value="+name[i]+">"+labList[i]+"</option>";
	}
	hopestr3 += "</select>" + "</div>";
	hope3Element.innerHTML = hopestr3;


	if(isAssigned){
		var str = "<label class='col-sm-2 control-label'></label>"
			+ "<div class='col-sm-10'>"
			+ "<select class='form-control' name='assignedLab'>";
		for( i=0;i<labList.length;i++){
			str += "<option value="+name[i]+">"+labList[i]+"</option>";
		}
		str += "</select>" + "</div>";
		labElement.innerHTML = str;

		var str2 = "<label class='col-sm-2 control-label'></label>"
			+ "<div class='col-sm-10'>";
		str2 += "<input type ='radio' name='satisfy' value='true'>Yes";
		str2 += "<input type = 'radio' name='satisfy' value ='false'>No";
		str2 += "</div>";
		lab2Element.innerHTML = str2;

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
	addList();
	var check = document.getElementById("assigned");
	check.addEventListener("click",addList,false);
},false);
