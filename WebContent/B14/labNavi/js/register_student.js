function addList(){

<div class="dropdown">
	<!-- ここが表示されるボタン <a>タグでもOK -->
		<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			Dropdown
			<span class="caret"></span>
		</button>
		<!-- ボタンここまで -->

		<!-- ここはボタンを押すと表示されるリスト -->
		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
			<li role="presentation" class="divider"></li>
			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
		</ul>
		<!-- リストここまで -->
	</div>




	var labElement = document.getElementById("labList");
	var isAssigned = document.getElementById("assigned").checked;
	var i;
	if(isAssigned){
		var labList = ["自然言語処理研究室","交通情報学研究室","知能情報基礎研究室"];
		var selectElement = document.createElement("select");
		for( i=0;i<labList.length;i++){
			selectElement.setAttribute("name","研究室"); 
			var inputElement = document.createElement("option");
			inputElement.setAttribute("value",String(i));
			inputElement.innerHTML = labList[i];
			selectElement.appendChild(inputElement);
		}
		labElement.appendChild(selectElement);
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
